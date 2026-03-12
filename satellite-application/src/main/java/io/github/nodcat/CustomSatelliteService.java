package io.github.nodcat;

import java.util.List;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/24 上午8:18
 */
public interface CustomSatelliteService {
    /**
     * 获取卫星扫描数据
     * @return 获取卫星扫描数据
     */
    List<SatelliteScanData> getSatelliteData();
}
