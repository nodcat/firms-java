package com.nodcat.satellite;

import com.nodcat.satellite.enums.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/13 上午10:33
 */
@RestController
@RequestMapping("/api")
public class MapKeyController {

    @Autowired
    SatelliteClient satelliteClient;

    /**
     * 获取
     *
     * @param mapKeyReq map_key获取请求
     * @return 请求结果
     */

    @PostMapping("/map_key_setup")
    public JsonData<String> getMapKeySetup(@RequestBody MapKeyReq mapKeyReq){
        String email = mapKeyReq.getEmail();
        if (email.isEmpty()){
            return JsonData.buildResult(ResponseStatus.EMAIL_EMPTY);
        }
        ResponseStatus responseStatus = satelliteClient.sendSatelliteMapKey(email);
        return JsonData.buildResult(responseStatus);
    }

}
