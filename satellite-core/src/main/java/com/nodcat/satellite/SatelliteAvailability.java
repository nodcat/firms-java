package com.nodcat.satellite;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/26 上午8:41
 */

public class SatelliteAvailability {
    /**
     * 序列
     */
    private static final long serialVersionUID = 1L;
    /**
     * 卫星ID
     */
    private String dataId;

    /**
     * 最小时间
     */
    private String minDate;

    /**
     * 最大时间
     */
    private String maxDate;

    public String getDataId() {
        return dataId;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public String getMinDate() {
        return minDate;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public void setMinDate(String minDate) {
        this.minDate = minDate;
    }

    @Override
    public String toString() {
        return "SatelliteAvailability{" +
                "dataId='" + dataId + '\'' +
                ", minDate='" + minDate + '\'' +
                ", maxDate='" + maxDate + '\'' +
                '}';
    }
}
