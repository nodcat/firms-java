package io.github.nodcat;

import io.github.nodcat.enums.ResponseStatus;

/**
 * @author nodcat
 * 2025/11/3 14:58
 */
public class JsonData<T> {

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 消息
     */
    private final String msg;

    /**
     * 数据
     */
    private final T data;

    public JsonData(Integer code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    /**
     * 从枚举返回
     */
    public static <T> JsonData<T> buildResult(ResponseStatus responseStatus) {
        return new JsonData<>(responseStatus.getCode(), responseStatus.getDes(), null);
    }
    /**
     * 自定义返回
     */
    public static <T> JsonData<T> buildResult(Integer code,String msg,T data) {
        return new JsonData<>(code,msg,data);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
