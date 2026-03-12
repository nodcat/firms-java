package io.github.nodcat.enums;

/**
 * Http请求枚举类
 * @author nodcat
 * @version 1.0
 * @since 2026/2/12 下午4:02
 */
public enum HttpMethod {
    // 枚举项：名称（对应值）
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    PATCH("PATCH");

    private final String method;

    HttpMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public static String getPostMethod() {
        return POST.getMethod();
    }
}
