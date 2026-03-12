package io.github.nodcat;

import io.github.nodcat.enums.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/24 上午8:19
 */
@Service
public class CustomSatelliteServiceImpl implements CustomSatelliteService {

    @Autowired
    SatelliteClient satelliteClient;

    @Override
    public List<SatelliteScanData> getSatelliteData() {
        return satelliteClient.getSatelliteScanData(
                Satellite.VIIRS_SNPP_NRT,
                "7",
                "2026-01-22");
    }
}
