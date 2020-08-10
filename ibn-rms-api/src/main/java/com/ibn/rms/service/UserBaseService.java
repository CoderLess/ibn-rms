package com.ibn.rms.service;

import com.github.pagehelper.Page;
import com.ibn.rms.domain.UserBaseDTO;
import com.ibn.rms.exception.IbnException;
import com.ibn.rms.page.PageInfo;

import java.util.List;
import java.util.Set;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.service
 * @author： RenBin
 * @createTime：2020/8/10 9:15
 */
public interface UserBaseService {
    /**
     * @description: 添加信息
     * @author：RenBin
     * @createTime：2020/8/10 9:31
     */
    long save(UserBaseDTO userBaseDTO) throws IbnException;

    /**
     * @description: 批量添加
     * @author：RenBin
     * @createTime：2020/8/10 9:31
     */
    long saveBatch(List<UserBaseDTO> userBaseDTO) throws IbnException;

    /**
     * @description: 根据ID删除
     * @author：RenBin
     * @createTime：2020/8/10 9:32
     */
    int remove(Long id) throws IbnException;

    /**
     * @description: 根据ID批量删除
     * @author：RenBin
     * @createTime：2020/8/10 9:32
     */
    int removeBatch(Set<Long> idSet) throws IbnException;

    /**
     * @description: 根据ID更新
     * @author：RenBin
     * @createTime：2020/8/10 9:33
     */
    int modify(UserBaseDTO userBaseDTO) throws IbnException;

    /**
     * @description: 根据条件查询
     * @author：RenBin
     * @createTime：2020/8/10 9:35
     */
    UserBaseDTO query(Long id) throws IbnException;

    /**
     * @description: 查询多个
     * @author：RenBin
     * @createTime：2020/8/10 9:36
     */
    List<UserBaseDTO> queryList(UserBaseDTO userBaseDTO) throws IbnException;

    /**
     * @description: 分页查询
     * @author：RenBin
     * @createTime：2020/8/10 9:37
     */
    Page<UserBaseDTO> queryPage(UserBaseDTO userBaseDTO, PageInfo pageInfo) throws IbnException;
}
