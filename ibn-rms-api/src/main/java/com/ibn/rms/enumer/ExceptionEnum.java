package com.ibn.rms.enumer;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.enumer
 * @author： RenBin
 * @createTime：2020/8/10 10:13
 */
public enum ExceptionEnum {
    NUll_PARAM("参数为空","10001"),
    ERROR_PARAM("参数异常","10002"),
    QUERY_DATA("查询数据库异常","20001");
    /**
     * @description: 消息
     * @author：RenBin
     * @createTime：2020/8/10 10:14
     */
    private String msg;
    /**
     * @description: 错误代码
     * @author：RenBin
     * @createTime：2020/8/10 10:14
     */
    private String code;

    ExceptionEnum(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
