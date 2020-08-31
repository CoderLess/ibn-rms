package com.ibn.rms.domain;

import com.ibn.domain.BaseDTO;
import lombok.Data;

/**
 * @version 1.0
 * @description:  dto
 * @projectName：ibn-rms
 * @see: com.ibn.rms.domain
 * @author： RenBin
 * @createTime：2020/8/11 21:45
 */
@Data
public class PermissionBaseDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private Long id;
    /**
     * @description: 权限名称
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private String permission;
    /**
     * @description: 父级权限id
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private Long parenId;
    /**
     * @description: 权限对应的url路径
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private String url;
    /**
     * @description: 权限描述信息
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private String description;
}