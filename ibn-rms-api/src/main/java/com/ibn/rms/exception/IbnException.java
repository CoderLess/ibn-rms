package com.ibn.rms.exception;

import com.ibn.rms.enumer.ExceptionEnum;
import lombok.Data;

/**
 * @version 1.0
 * @description: 自定义异常
 * @projectName：ibn-rms
 * @see: com.ibn.rms.exception
 * @author： RenBin
 * @createTime：2020/8/10 10:09
 */
@Data
public class IbnException extends Exception {
    /**
     * @description: 错误信息
     * @author：RenBin
     * @createTime：2020/8/10 10:11
     */
    private String msg;
    /**
     * @description: 错误代码
     * @author：RenBin
     * @createTime：2020/8/10 10:11
     */
    private String code;

    public IbnException(String msg, String code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public IbnException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.msg = exceptionEnum.getMsg();
        this.code = exceptionEnum.getCode();
    }
}
