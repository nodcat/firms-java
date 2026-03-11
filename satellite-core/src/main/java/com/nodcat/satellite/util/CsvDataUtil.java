package com.nodcat.satellite.util;

import com.alibaba.fastjson.JSON;

import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Csv数据工具类
 * @author nodcat
 * @version 1.0
 * @since 2026/2/14 上午11:22
 */
public class CsvDataUtil {


    /**
     * CSV字符串转换为SatelliteScanData实体列表
     */
    public static <T> List<T> covCsvDataToEntity(String csvData,Class<T> parse) throws NoSuchAlgorithmException {
        // 纯JDK空值校验（替代StringUtils.isBlank）
        if (csvData == null || csvData.trim().isEmpty()) {
            return Collections.emptyList();
        }

        // 兼容Windows(\r\n)和Linux(\n)换行符，纯JDK实现
        String[] lines = csvData.split("\\r?\\n");
        // 仅表头或空数据，返回空列表（保持原逻辑，如需返回null可修改）
        if (lines.length <= 1) {
            return Collections.emptyList();
        }

        // 预初始化集合容量，避免扩容（性能优化）
        List<T> scanDataEntityList = new ArrayList<>(lines.length - 1);
        String[] headers = lines[0].split(",");

        // 跳过表头，遍历数据行
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            // 纯JDK跳过空行（替代StringUtils.isBlank）
            if (line == null || line.trim().isEmpty()) {
                continue;
            }
            String[] values = line.split(",");
            // 构建单行Map（抽取通用逻辑）
            Map<String, Object> dataMap = buildDataMap(headers, values);
            // 保持原有JSON转换逻辑，功能不变
            T entity = JSON.parseObject(JSON.toJSONString(dataMap), parse);
            scanDataEntityList.add(entity);
        }

        return scanDataEntityList;
    }

    /**
     * 构建单行数据Map（纯JDK实现，抽取通用逻辑）
     * 核心：防止数组越界、无效表头处理
     */
    private static Map<String, Object> buildDataMap(String[] headers, String[] values) throws NoSuchAlgorithmException {
        // 预初始化Map容量，避免扩容（headers.length + 1 预留id字段）
        Map<String, Object> dataMap = new HashMap<>(headers.length + 1);

        // 取最小长度，防止数组越界（核心健壮性优化）
        int minLength = Math.min(headers.length, values.length);
        for (int j = 0; j < minLength; j++) {
            // 纯JDK处理无效表头（去空、跳过空白表头）
            String header = headers[j];
            if (header == null) {
                continue;
            }
            String trimHeader = header.trim();
            if (trimHeader.isEmpty()) {
                continue;
            }
            // 保持原逻辑：表头和值映射
            dataMap.put(trimHeader, values[j]);
        }

        // 保留原有SHA-256 ID生成逻辑
        String id = HexUtil.strToHex(Arrays.toString(values));
        dataMap.put("id", id);

        return dataMap;
    }



}
