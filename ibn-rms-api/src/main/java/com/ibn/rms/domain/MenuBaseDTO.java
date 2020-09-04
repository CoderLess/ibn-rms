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
public class MenuBaseDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private Long id;
    /**
     * @description: 父级id
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private Long parentId;
    /**
     * @description: 路径
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private String path;
    /**
     * @description: 标题
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private String title;
    /**
     * @description: 图标
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private String icon;
    /**
     * @description: 隐藏 0:否，1:是
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private Integer hidden;
    /**
     * @description: 子节点
     * @author：RenBin
     * @createTime：2020/9/4 20:55
     */
    private List<MenuBaseDTO> children;
}