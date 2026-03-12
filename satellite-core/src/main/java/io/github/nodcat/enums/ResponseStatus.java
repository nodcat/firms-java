package io.github.nodcat.enums;

/**
 * 发送邮件响应状态枚举
 * @author nodcat
 * @version 1.0
 * @since 2026/2/12 下午4:18
 */
public enum ResponseStatus {
    /**
     * 发送成功
     */
    SEND_SUCCESS("Map key sent to your email.","邮件发送成功",101),

    /**
     * 已经发送过邮件
     */
    ALREADY_SENT("options","已经发送过邮件",102),

    /**
     * 发送错误
     */
    SEND_ERROR("send email error","发送邮件失败",103),
    /**
     * 发生了错误
     */
    ERROR("error","未知错误",500),

    /**
     * 邮箱为空
     */
    EMAIL_EMPTY("email empty","邮箱为空",501);
    /**
     * 消息
     */
    private final String msg;
    /**
     * 描述
     */
    private final String des;

    /**
     * 状态码
     */
    private final Integer code;

    ResponseStatus(String msg, String des, Integer code){
        this.msg = msg;
        this.des = des;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 根据 msg 匹配对应的枚举
     * @param msg 接口返回的原始消息字符串（可为null）
     * @return 匹配到的枚举，无匹配则返回 null
     */
    public static ResponseStatus getByMsg(String msg) {
        // 空值校验：入参为null/空字符串，直接返回null
        if (msg == null || msg.trim().isEmpty()) {
            return null;
        }
        // 遍历所有枚举项，匹配msg（精准匹配，含空格/大小写）
        String targetMsg = msg.trim();
        for (ResponseStatus status : ResponseStatus.values()) {
            if (targetMsg.equals(status.getMsg())) {
                return status;
            }
        }
        // 无匹配项，返回null（也可自定义一个 UNKNOWN 枚举项兜底）
        return null;
    }
}
