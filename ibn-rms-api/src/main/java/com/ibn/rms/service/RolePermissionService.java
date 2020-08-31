package com.ibn.rms.service;

import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.domain.RolePermissionDTO;

import java.util.List;
import java.util.Set;
/**
 * @version 1.0
 * @description:  service
 * @projectName：ibn-rms
 * @see: com.ibn.rms.service
 * @author： RenBin
 * @createTime：2020/8/11 21:45
 */
public interface RolePermissionService{
    /**
     * @description: 添加信息
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    long save(RolePermissionDTO rolePermissionDTO);

    /**
     * @description: 批量添加
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    long saveBatch(List<RolePermissionDTO> rolePermissionDTOList);

    /**
     * @description: 根据ID删除
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    int remove(Long id);

    /**
     * @description: 根据ID批量删除
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    int removeBatch(Set<Long> idSet);

    /**
     * @description: 根据ID更新
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    int modify(RolePermissionDTO rolePermissionDTO);

    /**
     * @description: 根据条件查询
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    RolePermissionDTO query(Long id);

    /**
     * @description: 查询多个
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    List<RolePermissionDTO> queryList(RolePermissionDTO rolePermissionDTO);

    /**
     * @description: 分页查询
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    Pagination<RolePermissionDTO> queryPage(RolePermissionDTO rolePermissionDTO, PageInfo pageInfo);
}
