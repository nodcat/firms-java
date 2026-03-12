package io.github.nodcat;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/13 下午4:01
 */
public class SatelliteClientProperties {

    /**
     * mapKey 密钥
     */
    private String mapKey;

    /**
     * area 获取数据范围
     */
    private String area;

    public SatelliteClientProperties(String mapKey,String area){
        this.mapKey = mapKey;
        this.area = area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public void setMapKey(String mapKey) {
        this.mapKey = mapKey;
    }

    public String getArea() {
        return area;
    }

    public String getMapKey() {
        return mapKey;
    }
}
