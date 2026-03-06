package com.nodcat.satellite.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/14 上午11:41
 */
public class HexUtil {

    /**
     * 字符串转SHA-256十六进制字符串（纯JDK优化版）
     * 优化点：性能提升、纯JDK空值处理
     */
    public static String strToHex(String data) throws NoSuchAlgorithmException {
        // 纯JDK空值处理
        if (data == null || data.trim().isEmpty()) {
            return "";
        }

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));

        // 预初始化StringBuilder容量，避免扩容（性能优化）
        StringBuilder hexString = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            // 纯JDK实现十六进制转换（替代StringUtils，功能和原逻辑一致）
            int intVal = b & 0xFF;
            if (intVal < 16) {
                hexString.append('0');
            }
            hexString.append(Integer.toHexString(intVal));
        }
        return hexString.toString();
    }
}
