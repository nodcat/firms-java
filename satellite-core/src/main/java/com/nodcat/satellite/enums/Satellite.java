package com.nodcat.satellite.enums;

/**
 * 卫星型号枚举
 * @author nodcat
 * @version 1.0
 * @since 2026/2/13 下午2:29
 */
public enum Satellite {

    /**
     * VIIRS_SNPP_NRT
     */
    VIIRS_SNPP_NRT("VIIRS_SNPP_NRT"),

    /**
     * VIIRS_NOAA20_NRT
     */
    VIIRS_NOAA20_NRT("VIIRS_NOAA20_NRT"),

    /**
     * MODIS_NRT
     */
    MODIS_NRT("MODIS_NRT"),

    /**
     * MODIS_SP
     */
    MODIS_SP("MODIS_SP"),

    /**
     * VIIRS_NOAA21_NRT
     */
    VIIRS_NOAA21_NRT("VIIRS_NOAA21_NRT"),

    /**
     * VIIRS_SNPP_SP
     */
    VIIRS_SNPP_SP("VIIRS_SNPP_SP"),

    /**
     * LANDSAT_NRT
     */
    LANDSAT_NRT("LANDSAT 8/9"),

    /**
     * ALL
     */
    ALL("ALL");
    /**
     * 代码
     */
    private final String code;


    Satellite(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
