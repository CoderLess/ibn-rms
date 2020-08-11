package com.ibn.page;

import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.page
 * @author： RenBin
 * @createTime：2020/8/10 10:38
 */
@Data
public class PageInfo implements Serializable {
    /**
     * @description: 当前页数
     * @author：RenBin
     * @createTime：2020/8/10 10:39
     */
    private Integer pageNum;
    /**
     * @description: 每页条数
     * @author：RenBin
     * @createTime：2020/8/10 10:39
     */
    private Integer pageSize;
}
