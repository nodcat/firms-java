package io.github.nodcat.enums;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/27 下午3:38
 */
public enum Sensor {

    /**
     * MODIS 近实时、实时和超实时
     */
    C61("c6.1"),

    /**
     * LANDSAT 近实时、实时和超实时
     */
    LANDSAT("landsat"),

    /**
     * VIIRS Suomi-NPP 近实时、实时和超实时
     */
    SUOMI_NPP_VIIRS_C2("suomi-npp-viirs-c2"),

    /**
     * VIIRS NOAA-20 近实时、实时和超实时
     */
    NOAA_20_VIIRS_C2("noaa-20-viirs-c2"),

    /**
     * VIIRS NOAA-21 近实时、实时和超实时
     */
    NOAA_21_VIIRS_C2("noaa-21-viirs-c2");

    public String code;

    Sensor(String code){
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
