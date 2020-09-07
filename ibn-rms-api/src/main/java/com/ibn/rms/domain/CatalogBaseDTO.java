package com.ibn.rms.domain;

import com.ibn.domain.BaseDTO;
import lombok.Data;

import java.util.List;

/**
 * @version 1.0
 * @description: 
 * @projectName：ibn-rms
 * @see: com.ibn.rms.domain
 * @author： RenBin
 * @createTime：2020/8/5 13:45
 */
@Data
public class CatalogBaseDTO extends BaseDTO {

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
    /**
     * @description: 子节点
     * @author：RenBin
     * @createTime：2020/9/7 10:20
     */
    private List<CatalogBaseDTO> children;
}