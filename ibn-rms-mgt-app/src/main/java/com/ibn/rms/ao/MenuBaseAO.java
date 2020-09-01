package com.ibn.rms.ao;

import com.ibn.rms.domain.MenuBaseDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.ao
 * @author： RenBin
 * @createTime：2020/9/1 11:45
 */
public interface MenuBaseAO {
    /**
     * @description: 根据条件查询菜单
     * @author：RenBin
     * @createTime：2020/9/1 11:47
     */
    List<MenuBaseDTO> queryMenuBaseList(MenuBaseDTO menuBaseDTO);
}
