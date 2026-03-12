package com.nodcat.satellite;

import io.github.nodcat.enums.*;
import io.github.nodcat.error.SatelliteClientException;
import io.github.nodcat.*;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/12 下午4:58
 */
public class SatelliteClientTest {

    //实例化客户端
    static final SatelliteClient client = new SatelliteClientImpl(
            new SatelliteClientProperties(
                    "35ece758e7525ad595b401b65fa1c83b",
                    "116.2,34.5,122,38"
            ));

    // 测试1：匹配“发送成功”的msg
    @Test
    public void testGetByMsg_Success() {
        // 准备测试数据
        String successMsg = "Map key sent to your email.";
        // 调用被测试方法
        ResponseStatus result = ResponseStatus.getByMsg(successMsg);
        // 断言结果：预期是 SEND_SUCCESS
        assertEquals("匹配发送成功状态失败", ResponseStatus.SEND_SUCCESS, result);
    }
    //测试2: 测试发送MapKey接口
    @Test
    public void sendSatelliteMapKey(){
        //测试数据
        String email = "17561663880@139.com";
        //发送数据
        ResponseStatus responseStatus = client.sendSatelliteMapKey(email);
        //断言结果：预期是 ALREADY_SENT
        assertEquals("匹配发送状态失败", ResponseStatus.ALREADY_SENT, responseStatus);
    }

    //测试3：测试获取卫星数据
    @Test
    public void getSatelliteScanData(){
        String area = "116.2,34.5,122,38";

        String mapKey = "35ece758e7525ad595b401b65fa1c83b";

        String dayRange = "2";

        String date = "2026-02-06";

        List<SatelliteScanData> satelliteScanData = client.getSatelliteScanData(Satellite.VIIRS_SNPP_NRT,mapKey, area, dayRange, date);
        for (SatelliteScanData data : satelliteScanData) {
            System.err.println(data);
        }
    }
    //测试4 ：测试卫星数据有效性获取
    @Test
    public void getSatelliteAvailability() throws SatelliteClientException {
        String mapKey = "35ece758e7525ad595b401b65fa1c83b";
        List<SatelliteAvailability> satelliteAvailability = client.getSatelliteAvailability(Satellite.ALL, mapKey);
        for (SatelliteAvailability data :satelliteAvailability){
            System.err.println(data);
        }
    }
    //测试5 ：测试卫星有效性获取，通过配置文件
    @Test
    public void getSatelliteAvailabilityForConfig() throws SatelliteClientException {
        List<SatelliteAvailability> satelliteAvailability = client.getSatelliteAvailability(Satellite.MODIS_SP);
        for (SatelliteAvailability data :satelliteAvailability){
            System.err.println(data);
        }
    }
    //测试6 ：获取卫星数据的kml数据
    @Test
    public void getFireFootprints() throws SatelliteClientException, IOException {
        byte[] kml_bytes = client.getFireFootprints(Region.CANADA, DateSpan.H24, Sensor.LANDSAT);
        //测试存储为kmz文件
        File file = new File("./test.kmz");
        FileOutputStream fileOutputStream =new FileOutputStream(file);
        fileOutputStream.write(kml_bytes);
        fileOutputStream.close();
    }
}
