package com.ibn.rms.ao;

import com.ibn.rms.domain.CatalogBaseDTO;
import com.ibn.rms.exception.IbnException;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.ao
 * @author： RenBin
 * @createTime：2020/9/7 9:30
 */
public interface CataLogBaseAO {
    /**
     * @description: 查询用户的菜单列表
     * @author：RenBin
     * @createTime：2020/9/7 9:31
     * @param userId
     */
    List<CatalogBaseDTO> queryCatalogBaseList(Long userId) throws IbnException;
}
