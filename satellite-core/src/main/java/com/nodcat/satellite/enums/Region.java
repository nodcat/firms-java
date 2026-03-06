package com.nodcat.satellite.enums;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/27 下午2:15
 */
public enum Region {

    /**
     * 加拿大
     */
    CANADA("canada","加拿大"),

    /**
     * 阿拉斯加
     */
    ALASKA("alaska","阿拉斯加"),

    /**
     * 美国本土夏威夷
     */
    USA_CONTIGUOUS_AND_HAWAII("usa_contiguous_and_hawaii","美国本土夏威夷"),

    /**
     * 中美洲
     */
    CENTRAL_AMERICA("central_america","中美洲"),

    /**
     * 南美洲
     */
    SOUTH_AMERICA("south_america","南美洲"),

    /**
     * 欧洲
     */
    EUROPE("europe","欧洲"),

    /**
     * 北非和中非
     */
    NORTHERN_AND_CENTRAL_AFRICA("northern_and_central_africa","北非和中非"),

    /**
     * 南非
     */
    SOUTHERN_AFRICA("southern_africa","南非"),

    /**
     * 俄罗斯和亚洲
     */
    RUSSIA_ASIA("russia_asia","俄罗斯和亚洲"),

    /**
     * 南亚
     */
    SOUTH_ASIA("south_asia","南亚"),

    /**
     * 东南亚
     */
    SOUTHEAST_ASIA("southeast_asia","东南亚"),

    /**
     * 澳大利亚和新西兰
     */
    AUSTRALIA_NEWZEALAND("australia_newzealand","澳大利亚和新西兰");

    /**
     * 编码
     */
    public String code;

    /**
     * 名称
     */
    public String name;

    Region(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 根据 code 匹配对应的枚举
     * @param code 接口返回的原始消息字符串（可为null）
     * @return 匹配到的枚举，无匹配则返回 null
     */
    public static Region getByCode(String code) {
        // 空值校验：入参为null/空字符串，直接返回null
        if (code == null || code.trim().isEmpty()) {
            return null;
        }
        // 遍历所有枚举项，匹配msg（精准匹配，含空格/大小写）
        String targetCode = code.trim();
        for (Region region : Region.values()) {
            if (targetCode.equals(region.getCode())) {
                return region;
            }
        }
        // 无匹配项，返回null（也可自定义一个 UNKNOWN 枚举项兜底）
        return null;
    }
}
