package com.nodcat.satellite.enums;

/**
 * URL枚举
 * @author nodcat
 * @version 1.0
 * @since 2026/2/12 下午1:48
 */
public enum UrlType {
    /**
     * 区域接口
     */
    AREA("area","/api/area/csv/%s/%s/%s/%s/%s"),
    /**
     * 数据可用性
     */
    AVAILABILITY("availability","/api/data_availability/csv/%s/%s"),

    /**
     * 过火范围
     */
    FOOTPRINTS("footprints","/api/kml_fire_footprints/%s/%s/%s"),

    /**
     * 密钥
     */
    MAP_KEY("map_key","/api/map_key_setup/");

    /**
     *  名称
     */
    private final String name;
    /**
     * 路径前缀
     */
    private final String prefix;

    UrlType(String name, String prefix){
        this.name = name;
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getName() {
        return name;
    }
}
