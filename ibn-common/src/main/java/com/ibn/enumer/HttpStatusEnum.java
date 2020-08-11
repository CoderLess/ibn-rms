package com.ibn.enumer;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.enumer
 * @author： RenBin
 * @createTime：2020/8/11 14:33
 */
public enum HttpStatusEnum {
    OK("200", "OK"),
    INTERNAL_SERVER_ERROR("500", "Internal Server Error");
    /**
     * @description: 状态码
     * @author：RenBin
     * @createTime：2020/8/11 14:33
     */
    private String code;
    /**
     * @description: 描述
     * @author：RenBin
     * @createTime：2020/8/11 14:33
     */
    private String desc;

    HttpStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
