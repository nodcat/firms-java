package com.nodcat.satellite;


import com.nodcat.satellite.enums.*;
import com.nodcat.satellite.error.SatelliteClientException;

import java.util.List;

/**
 * 卫星客户端接口
 * @author nodcat
 * @version 1.0
 * @since 2026/2/12 下午2:10
 */
public interface SatelliteClient {

    //https://firms.modaps.eosdis.nasa.gov/api/kml_fire_footprints/canada/24h/landsat/FirespotArea_canada_landsat_24h.kmz

    /**
     * 请求并获取密钥,若未获取过会发送到您的邮箱
     * @param email 邮箱地址
     * @return 发送状态枚举
     */
    ResponseStatus sendSatelliteMapKey(String email);

    /**
     * 获取火点数据(自定义范围和mapKey)
     * @param satellite 卫星枚举
     * @param mapKey 密钥
     * @param area 面积
     * @param dayRange 日期范围
     * @param date 日期
     * @return 火点数据
     */
    List<SatelliteScanData> getSatelliteScanData(
            Satellite satellite,
            String mapKey,
            String area,
            String dayRange,
            String date
    );
    /**
     * 获取火点数据 - 通过配置类文件配置
     * @param satellite 卫星枚举
     * @param dayRange 日期范围
     * @param date 日期
     * @return 卫星数据
     */
    List<SatelliteScanData> getSatelliteScanData(
            Satellite satellite,
            String dayRange,
            String date
    );

    /**
     * 获取卫星数据可用性
     *
     * @param satellite 卫星数据枚举
     * @param mapKey 密钥
     * @return 可用性数据列表
     */
    List<SatelliteAvailability> getSatelliteAvailability(Satellite satellite, String mapKey) throws SatelliteClientException;


    /**
     * 获取卫星数据可用性
     *
     * @param satellite 卫星数据枚举
     * @return 可用性数据列表
     */
    List<SatelliteAvailability> getSatelliteAvailability(Satellite satellite) throws SatelliteClientException;


    /**
     *
     * 获取时间范围内的区域的火点集合
     * @param region 区域
     * @param dateSpan 时间范围
     * @param sensor 传感器
     * @return  byte[] kmz文件的byte数组,可直接创建kmz文件并写入。
     */
    byte[] getFireFootprints(Region region, DateSpan dateSpan, Sensor sensor) throws SatelliteClientException;
}
