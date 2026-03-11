package com.nodcat.satellite;

import com.alibaba.fastjson.JSON;
import com.nodcat.satellite.constant.Constants;
import com.nodcat.satellite.enums.*;
import com.nodcat.satellite.error.SatelliteClientException;
import com.nodcat.satellite.util.CsvDataUtil;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 客户端实现类
 * @author nodcat
 * @version 1.0
 * @since 2026/2/12 下午2:11
 */

public class SatelliteClientImpl implements SatelliteClient {

    private final SatelliteClientProperties properties;

    public SatelliteClientImpl(SatelliteClientProperties properties) {
        this.properties = properties;
    }

    public  final Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * 基础的请求接口地址
     */
    static URL REQUEST_URL;

    /*
      地址封装
     */
    static {
        try {
            REQUEST_URL = new URL(Constants.BASE_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 发送卫星密钥
     *
     * @param email 邮箱地址
     * @return 发送状态
     */
    @Override
    public ResponseStatus sendSatelliteMapKey(String email) {
        ResponseStatus sendStatus;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            //构建URL
            URL url = new URL(REQUEST_URL, UrlType.MAP_KEY.getPrefix());
            //构建 POST 请求对象
            HttpPost httpPost = new HttpPost(url.toString());
            //构建请求对象
            MapKeyClientReq mapKeyClientReq = new MapKeyClientReq();
            mapKeyClientReq.setEmail(email);
            String requestBody = JSON.toJSONString(mapKeyClientReq);
            HttpEntity requestEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
            //添加请求体
            httpPost.setEntity(requestEntity);
            sendStatus = httpClient.execute(httpPost, response -> {
                String body = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                return ResponseStatus.getByMsg(body);
            });
        }catch (Exception e){
            return ResponseStatus.ERROR;
        }
        return sendStatus;
    }

    /**
     * 获取火点数据
     *
     * @param satellite 卫星枚举
     * @param mapKey        密钥
     * @param area          面积
     * @param dayRange      日期范围
     * @param date          日期
     * @return 火点数据
     */
    @Override
    public List<SatelliteScanData> getSatelliteScanData(Satellite satellite, String mapKey, String area, String dayRange, String date) {

        List<SatelliteScanData> resultList;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String prefix = UrlType.AREA.getPrefix();
            String fullUrl = String.format(prefix, mapKey, satellite.getCode(), area, dayRange, date);
            System.err.println(fullUrl);
            //构建URL.b.b//b
            URL url = new URL(REQUEST_URL,fullUrl);
            //构建Get对象
            HttpGet httpGet = new HttpGet(url.toString());
            //执行请求并封装数据
            resultList = httpClient.execute(httpGet,response->{
                List<SatelliteScanData> satelliteScanData;
                String body = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                try {
                  satelliteScanData = CsvDataUtil.covCsvDataToEntity(body,SatelliteScanData.class);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
                return satelliteScanData;
            });

        }catch (Exception e){
            return new ArrayList<>();
        }
        return resultList;
    }

    /**
     * 获取火点数据 - 通过配置类文件配置
     * @param satellite 卫星枚举
     * @param dayRange 日期范围
     * @param date 日期
     * @return 卫星数据
     */
    @Override
    public List<SatelliteScanData> getSatelliteScanData(Satellite satellite, String dayRange, String date) {
       return this.getSatelliteScanData(satellite, properties.getMapKey(), properties.getArea(),dayRange,date);
    }

    /**
     * 获取卫星数据可用性
     *
     * @param satellite 卫星数据枚举
     * @param mapKey 密钥
     * @return 可用性数据列表
     */
    @Override
    public List<SatelliteAvailability> getSatelliteAvailability(Satellite satellite, String mapKey) throws SatelliteClientException {
        List<SatelliteAvailability> resultList;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String prefix = UrlType.AVAILABILITY.getPrefix();
            String fullUrl = String.format(prefix, mapKey,satellite.getCode());
            //构建URL.b.b//b
            URL url = new URL(REQUEST_URL,fullUrl);
            //构建Get对象
            HttpGet httpGet = new HttpGet(url.toString());
            //执行请求并封装数据
            resultList = httpClient.execute(httpGet,response->{
                List<SatelliteAvailability> satelliteAvailabilities;
                String body = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                try {
                    satelliteAvailabilities = CsvDataUtil.covCsvDataToEntity(body, SatelliteAvailability.class);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
                return satelliteAvailabilities;
            });
        }catch (IOException e){
            throw new SatelliteClientException(ClientError.INIT_HTTP_ERROR,e);
        }
        return resultList;
    }

    /**
     * 获取卫星数据可用性
     *
     * @param satellite 卫星数据枚举
     * @return 可用性数据列表
     */
    @Override
    public List<SatelliteAvailability> getSatelliteAvailability(Satellite satellite) throws SatelliteClientException {
        return this.getSatelliteAvailability(satellite,properties.getMapKey());
    }

    /**
     * 获取时间范围内的区域的传感器点集合
     *
     * @param region   区域
     * @param dateSpan 时间范围
     * @param sensor   传感器
     */
    @Override
    public byte[] getFireFootprints(Region region, DateSpan dateSpan, Sensor sensor) throws SatelliteClientException {
        byte[] data;
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String prefix = UrlType.FOOTPRINTS.getPrefix();
            String fullUrl = String.format(prefix, region.getCode(), dateSpan.getCode(), sensor.getCode());
            //构建URL.b.b//b
            URL url;
            try {
                url = new URL(REQUEST_URL, fullUrl);
            } catch (MalformedURLException e) {
                throw new SatelliteClientException(ClientError.URL_INVALID, e);
            }
            //构建Get对象
            HttpGet httpGet = new HttpGet(url.toString());
            //执行请求并封装数据
            try {
                data = httpClient.execute(httpGet, response -> EntityUtils.toByteArray(response.getEntity()));
            } catch (IOException e) {
                throw new SatelliteClientException(ClientError.NETWORK_ERROR, e);
            }
            return data;
        } catch (IOException e){
            throw new SatelliteClientException(ClientError.INIT_HTTP_ERROR, e);
        }
    }
}
