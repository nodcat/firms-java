package io.github.nodcat.error;


import io.github.nodcat.enums.ClientError;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/28 上午8:49
 */

public class SatelliteClientException extends Exception {
    /**
     * 错误码
     */
    private Integer code;

    public SatelliteClientException(ClientError error, Throwable cause){
        super(error.getMessage(),cause);
        this.code = error.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
