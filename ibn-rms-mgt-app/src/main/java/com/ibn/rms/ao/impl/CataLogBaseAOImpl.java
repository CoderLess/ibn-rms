package com.ibn.rms.ao.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ibn.rms.ao.CataLogBaseAO;
import com.ibn.rms.domain.CatalogBaseDTO;
import com.ibn.rms.enumer.ExceptionEnum;
import com.ibn.rms.exception.IbnException;
import com.ibn.rms.service.CatalogBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.ao.impl
 * @author： RenBin
 * @createTime：2020/9/7 9:35
 */
@Service("cataLogBaseAO")
public class CataLogBaseAOImpl implements CataLogBaseAO {

    @Autowired
    private CatalogBaseService catalogBaseService;

    private static final Logger logger = LoggerFactory.getLogger(CataLogBaseAOImpl.class);

    @Override
    public List<CatalogBaseDTO> queryCatalogBaseList(Long userId) throws IbnException {
        CatalogBaseDTO catalogBaseDTO = new CatalogBaseDTO();
        catalogBaseDTO.setUserId(userId);
        catalogBaseDTO.setParentId(0L);
        // 一级目录
        List<CatalogBaseDTO> catalogBaseDTOList = catalogBaseService.queryList(catalogBaseDTO);
        if (CollectionUtils.isEmpty(catalogBaseDTOList)) {
            return Lists.newArrayList();
        }
        for (CatalogBaseDTO baseDTO : catalogBaseDTOList) {
            this.getCatalogBaseDTO(baseDTO);
        }
        return catalogBaseDTOList;
    }
    /**
     * @description: 递归查询
     * @author：RenBin
     * @createTime：2020/9/7 10:19
     */
    private CatalogBaseDTO getCatalogBaseDTO(CatalogBaseDTO catalogBaseDTO) throws IbnException {
        if (null == catalogBaseDTO || null == catalogBaseDTO.getId()) {
            return catalogBaseDTO;
        }
        CatalogBaseDTO catalogBaseQueryDTO = new CatalogBaseDTO();
        catalogBaseQueryDTO.setParentId(catalogBaseDTO.getId());
        List<CatalogBaseDTO> catalogBaseDTOList;
        try {
            catalogBaseDTOList = catalogBaseService.queryList(catalogBaseQueryDTO);
        } catch (IbnException e) {
            String msg = String.format("查询目录信息异常：%s", JSONObject.toJSONString(catalogBaseDTO));
            logger.error(msg, e);
            throw new IbnException(ExceptionEnum.QUERY_DATA);
        }
        if (CollectionUtils.isEmpty(catalogBaseDTOList)) {
            catalogBaseDTO.setChildren(Lists.newArrayList());
            return catalogBaseDTO;
        }
        catalogBaseDTO.setChildren(catalogBaseDTOList);
        for (CatalogBaseDTO baseDTO : catalogBaseDTOList) {
            this.getCatalogBaseDTO(baseDTO);
        }
        return catalogBaseDTO;
    }

}
