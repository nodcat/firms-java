package io.github.nodcat;

import java.io.Serializable;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/13 下午2:11
 */
public class SatelliteScanData implements Serializable {

    /**
     * Hex Id
     */
    private String id;

    private static final long serialVersionUID = 1L;
    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 4微米波段亮度温度（K）
     */
    private Double brightTi4;

    /**
     * 扫描像素数
     */
    private Double scan;

    /**
     * 轨迹像素数
     */
    private Double track;

    /**
     * 获取日期（格式：YYYY-MM-DD）
     */
    private String acqDate;

    /**
     * 获取时间（格式：HHMM）
     */
    private String acqTime;

    /**
     * 卫星名称
     */
    private String satellite;

    /**
     * 仪器类型
     */
    private String instrument;

    /**
     * 置信度（低/中/高：low/medium/high）
     */
    private String confidence;

    /**
     * 数据版本
     */
    private String version;

    /**
     * 5微米波段亮度温度（K）
     */
    private Double brightTi5;

    /**
     * 火辐射功率（MW）
     */
    private Double frp;

    /**
     * 昼夜标识（日：D，夜：N）
     */
    private String dayNight;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getBrightTi4() {
        return brightTi4;
    }

    public void setBrightTi4(Double brightTi4) {
        this.brightTi4 = brightTi4;
    }

    public Double getScan() {
        return scan;
    }

    public void setScan(Double scan) {
        this.scan = scan;
    }

    public Double getTrack() {
        return track;
    }

    public void setTrack(Double track) {
        this.track = track;
    }

    public String getAcqDate() {
        return acqDate;
    }

    public void setAcqDate(String acqDate) {
        this.acqDate = acqDate;
    }

    public String getAcqTime() {
        return acqTime;
    }

    public void setAcqTime(String acqTime) {
        this.acqTime = acqTime;
    }

    public String getSatellite() {
        return satellite;
    }

    public void setSatellite(String satellite) {
        this.satellite = satellite;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Double getBrightTi5() {
        return brightTi5;
    }

    public void setBrightTi5(Double brightTi5) {
        this.brightTi5 = brightTi5;
    }

    public Double getFrp() {
        return frp;
    }

    public void setFrp(Double frp) {
        this.frp = frp;
    }

    public String getDayNight() {
        return dayNight;
    }

    public void setDayNight(String dayNight) {
        this.dayNight = dayNight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SatelliteScanData{" +
                "id='" + id + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", brightTi4=" + brightTi4 +
                ", scan=" + scan +
                ", track=" + track +
                ", acqDate='" + acqDate + '\'' +
                ", acqTime='" + acqTime + '\'' +
                ", satellite='" + satellite + '\'' +
                ", instrument='" + instrument + '\'' +
                ", confidence='" + confidence + '\'' +
                ", version='" + version + '\'' +
                ", brightTi5=" + brightTi5 +
                ", frp=" + frp +
                ", dayNight='" + dayNight + '\'' +
                '}';
    }
}
