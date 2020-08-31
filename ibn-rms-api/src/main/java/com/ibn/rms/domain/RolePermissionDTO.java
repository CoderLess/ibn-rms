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
public class RolePermissionDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private Long id;
    /**
     * @description: 角色id
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private Long roleId;
    /**
     * @description: 权限id
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private Long permissionId;
}