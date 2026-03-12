package io.github.nodcat.enums;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/27 下午3:32
 */
public enum DateSpan {

    /**
     * 24小时
     */
    H24("24h"),

    /**
     * 48小时
     */
    H48("48h"),

    /**
     * 72小时
     */
    H72("72h"),

    /**
     * 7天
     */
    D7("7d");

    /**
     * 编码
     */
    public  String code;
    DateSpan(String code){
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
