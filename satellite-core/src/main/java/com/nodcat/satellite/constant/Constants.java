package com.nodcat.satellite.constant;

/**
 * 常量封装
 * @author nodcat
 * @version 1.0
 * @since 2026/2/12 下午2:40
 */
public interface Constants {
    /**
     * 请求接口地址
     */
    String BASE_URL = "https://firms.modaps.eosdis.nasa.gov";

    /**
     * 站点
     */
    String SITE = "firms";

    /**
     * 获取MAP_KEY时响应,表示已经进行过发送
     */
    String OPTIONS = "options";
    /**
     * 成功获取MAP_KEY,表示已发送KEY给用户
     */
    String SEND_SUCCESS = "Map key sent to your email.";
}
