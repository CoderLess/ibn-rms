package com.ibn.rms.page;

import lombok.Data;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.page
 * @author： RenBin
 * @createTime：2020/8/10 10:38
 */
@Data
public class PageInfo {
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
