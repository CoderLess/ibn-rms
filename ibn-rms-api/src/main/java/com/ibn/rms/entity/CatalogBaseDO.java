package com.ibn.rms.entity;

import com.ibn.entity.BaseDO;
import lombok.Data;

/**
 * @version 1.0
 * @description: 
 * @projectName：ibn-rms
 * @see: com.ibn.rms.entity
 * @author： RenBin
 * @createTime：2020/8/5 13:45
 */
@Data
public class CatalogBaseDO extends BaseDO {

	private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private Long id;
    /**
     * @description: 目录名
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private String name;
    /**
     * @description: 父级id
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private Long parentId;
    /**
     * @description: 用户id
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private Long userId;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private Long createTime;
}