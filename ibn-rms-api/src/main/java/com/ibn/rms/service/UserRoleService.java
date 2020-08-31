package com.ibn.rms.service;

import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.domain.UserRoleDTO;

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
public interface UserRoleService{
    /**
     * @description: 添加信息
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    long save(UserRoleDTO userRoleDTO);

    /**
     * @description: 批量添加
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    long saveBatch(List<UserRoleDTO> userRoleDTOList);

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
    int modify(UserRoleDTO userRoleDTO);

    /**
     * @description: 根据条件查询
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    UserRoleDTO query(Long id);

    /**
     * @description: 查询多个
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    List<UserRoleDTO> queryList(UserRoleDTO userRoleDTO);

    /**
     * @description: 分页查询
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    Pagination<UserRoleDTO> queryPage(UserRoleDTO userRoleDTO, PageInfo pageInfo);
}
