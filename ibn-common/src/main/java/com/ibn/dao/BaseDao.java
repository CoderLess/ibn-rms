package com.ibn.dao;

import com.github.pagehelper.Page;

import java.util.List;
import java.util.Set;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.dao
 * @author： RenBin
 * @createTime：2020/8/10 9:30
 */
public interface BaseDao<T> {
    /**
     * @description: 添加信息
     * @author：RenBin
     * @createTime：2020/8/10 9:31
     */
    long save(T t);

    /**
     * @description: 批量添加
     * @author：RenBin
     * @createTime：2020/8/10 9:31
     */
    long saveBatch(List<T> list);

    /**
     * @description: 根据ID删除
     * @author：RenBin
     * @createTime：2020/8/10 9:32
     */
    int remove(Object id);

    /**
     * @description: 根据ID批量删除
     * @author：RenBin
     * @createTime：2020/8/10 9:32
     */
    int removeBatch(Set<Long> id);

    /**
     * @description: 根据ID更新
     * @author：RenBin
     * @createTime：2020/8/10 9:33
     */
    int modify(T t);

    /**
     * @description: 根据条件查询
     * @author：RenBin
     * @createTime：2020/8/10 9:35
     */
    T query(Long id);

    /**
     * @description: 查询多个
     * @author：RenBin
     * @createTime：2020/8/10 9:36
     */
    List<T> queryList(T t);

    /**
     * @description: 分页查询
     * @author：RenBin
     * @createTime：2020/8/10 9:37
     */
    Page<T> queryPage(T t);
}
