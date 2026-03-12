package io.github.nodcat.enums;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/28 下午1:43
 */
public enum ClientError {

    /**
     * 网络IO异常
     */
    NETWORK_ERROR(1001,"网络IO异常"),

    /**
     * URL错误
     */
    URL_INVALID(1002,"URL错误"),

    /**
     * HttpClient初始化异常
     */
    INIT_HTTP_ERROR(1003,"HttpClient初始化异常");

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String message;

    ClientError(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
