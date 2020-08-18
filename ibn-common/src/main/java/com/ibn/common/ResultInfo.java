package com.ibn.common;

import com.ibn.enumer.HttpStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.config.common
 * @author： RenBin
 * @createTime：2020/8/11 11:50
 */
@Data
public class ResultInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String message;
    private T data;

    @SuppressWarnings("rawtypes")
    public ResultInfo success() {
        this.status = HttpStatusEnum.OK.getCode();
        this.message = "OK";
        return this;
    }

    @SuppressWarnings("rawtypes")
    public ResultInfo success(Integer status, String message) {
        this.status = status;
        this.message = message;
        return this;
    }
    public ResultInfo success(Integer status, String message, List<String> errorMessageList) {
        this.status = status;
        this.message = message;
        this.data = (T) errorMessageList;
        return this;
    }

    public ResultInfo<T> success(T data) {
        this.status = HttpStatusEnum.OK.getCode();
        this.message ="OK";
        this.data = data;
        return this;
    }

    public ResultInfo<T> success(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        return this;
    }

    @SuppressWarnings("rawtypes")
    public ResultInfo error(String message) {
        this.status = HttpStatusEnum.INTERNAL_SERVER_ERROR.getCode();
        this.message = message;
        return this;
    }

    @SuppressWarnings("rawtypes")
    public ResultInfo error(Integer status, String message) {
        this.status = status;
        this.message = message;
        return this;
    }

}
