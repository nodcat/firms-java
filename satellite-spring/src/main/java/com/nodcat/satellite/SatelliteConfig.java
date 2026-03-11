package com.nodcat.satellite;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/13 下午4:07
 */
@Configuration
@ConfigurationProperties(prefix = "nasa")
public class SatelliteConfig {
    /**
     * 密钥
     */
    private String mapKey;

    /**
     * 范围
     */
    private String area;

    public void setArea(String area) {
        this.area = area;
    }

    public void setMapKey(String mapKey) {
        this.mapKey = mapKey;
    }

    public String getMapKey() {
        return mapKey;
    }

    public String getArea() {
        return area;
    }
}
