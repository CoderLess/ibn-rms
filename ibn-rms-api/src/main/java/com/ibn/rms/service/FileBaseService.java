package com.ibn.rms.service;

import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.domain.FileBaseDTO;
import com.ibn.rms.exception.IbnException;

import java.util.List;
import java.util.Set;
/**
 * @version 1.0
 * @description: 
 * @projectName：ibn-rms
 * @see: com.ibn.rms.service
 * @author： RenBin
 * @createTime：2020/8/5 13:45
 */
public interface FileBaseService{
    /**
     * @description: 添加信息
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    long save(FileBaseDTO fileBaseDTO) throws IbnException;

    /**
     * @description: 批量添加
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    long saveBatch(List<FileBaseDTO> fileBaseDTOList) throws IbnException;

    /**
     * @description: 根据ID删除
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    int remove(Long id) throws IbnException;

    /**
     * @description: 根据ID批量删除
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    int removeBatch(Set<Long> idSet) throws IbnException;

    /**
     * @description: 根据ID更新
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    int modify(FileBaseDTO fileBaseDTO) throws IbnException;

    /**
     * @description: 根据条件查询
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    FileBaseDTO query(Long id) throws IbnException;

    /**
     * @description: 查询多个
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    List<FileBaseDTO> queryList(FileBaseDTO fileBaseDTO) throws IbnException;

    /**
     * @description: 分页查询
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    Pagination<FileBaseDTO> queryPage(FileBaseDTO fileBaseDTO, PageInfo pageInfo) throws IbnException;
}
