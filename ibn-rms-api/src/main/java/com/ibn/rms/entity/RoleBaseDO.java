package com.ibn.rms.entity;

import com.ibn.entity.BaseDO;
import lombok.Data;

/**
 * @version 1.0
 * @description:  do
 * @projectName：ibn-rms
 * @see: com.ibn.rms.entity
 * @author： RenBin
 * @createTime：2020/8/11 21:45
 */
@Data
public class RoleBaseDO extends BaseDO {

	private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private Long id;
    /**
     * @description: 角色名称
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private String role;
    /**
     * @description: 备注
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private String remark;
}