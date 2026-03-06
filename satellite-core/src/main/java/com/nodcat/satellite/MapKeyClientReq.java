package com.nodcat.satellite;

import com.alibaba.fastjson.annotation.JSONField;
import com.nodcat.satellite.constant.Constants;
import com.nodcat.satellite.enums.HttpMethod;

/**
 * MapKey请求Body封装类
 * @author nodcat
 * @version 1.0
 * @since 2026/2/12 下午3:51
 */

public class MapKeyClientReq {

    /**
     * 邮件地址
     */
    @JSONField(ordinal = 0)
    private String email;

    /**
     * 网站
     */
    @JSONField(ordinal = 1)
    private String site;

    /**
     * 请求操作
     */
    @JSONField(ordinal = 2)
    private String action;

    public String getAction() {
        return HttpMethod.POST.getMethod();
    }

    public String getSite() {
        return Constants.SITE;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
}
