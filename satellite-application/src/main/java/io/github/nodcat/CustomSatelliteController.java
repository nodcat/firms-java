package io.github.nodcat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/24 上午8:22
 */
@RestController
@RequestMapping("/custom")
public class CustomSatelliteController {

    @Autowired
    CustomSatelliteService customSatelliteService;

    @GetMapping("/data")
    List<SatelliteScanData> getSatelliteData(){
        return customSatelliteService.getSatelliteData();
    }
}
