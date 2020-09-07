package com.ibn.rms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.dao.CatalogBaseDao;
import com.ibn.rms.domain.CatalogBaseDTO;
import com.ibn.rms.entity.CatalogBaseDO;
import com.ibn.rms.enumer.ExceptionEnum;
import com.ibn.rms.exception.IbnException;
import com.ibn.rms.service.CatalogBaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.service.impl
 * @author： RenBin
 * @createTime：2020/8/10 10:01
 */
@Service("catalogBaseService")
public class CatalogBaseServiceImpl implements CatalogBaseService {
    @Autowired
    private CatalogBaseDao catalogBaseDao;

    @Override
    public long save(CatalogBaseDTO catalogBaseDTO) throws IbnException {
        if (null == catalogBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        CatalogBaseDO catalogBaseDO = new CatalogBaseDO();
        BeanUtils.copyProperties(catalogBaseDTO, catalogBaseDO);
        catalogBaseDao.save(catalogBaseDO);
        return catalogBaseDO.getId();
    }

    @Override
    public long saveBatch(List<CatalogBaseDTO> catalogBaseDTOList) throws IbnException {
        if (CollectionUtils.isEmpty(catalogBaseDTOList)) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        List<CatalogBaseDO> catalogBaseDOList = catalogBaseDTOList.stream().map(catalogBaseDTO -> {
            CatalogBaseDO catalogBaseDO = new CatalogBaseDO();
            BeanUtils.copyProperties(catalogBaseDTO, catalogBaseDO);
            return catalogBaseDO;
        }).collect(Collectors.toList());
        return catalogBaseDao.saveBatch(catalogBaseDOList);
    }

    @Override
    public int remove(Long id) throws IbnException {
        if (null == id) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        return catalogBaseDao.remove(id);
    }

    @Override
    public int removeBatch(Set<Long> idSet) throws IbnException {
        if (CollectionUtils.isEmpty(idSet)) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        return catalogBaseDao.removeBatch(idSet);
    }

    @Override
    public int modify(CatalogBaseDTO catalogBaseDTO) throws IbnException {
        if (null == catalogBaseDTO || null == catalogBaseDTO.getId()) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        CatalogBaseDO catalogBaseDO = new CatalogBaseDO();
        BeanUtils.copyProperties(catalogBaseDTO, catalogBaseDO);
        return catalogBaseDao.modify(catalogBaseDO);
    }

    @Override
    public CatalogBaseDTO query(Long id) throws IbnException {
        if (null == id) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        CatalogBaseDO catalogBaseResultDO = catalogBaseDao.query(id);
        if (null == catalogBaseResultDO) {
            return null;
        }
        CatalogBaseDTO catalogBaseDTO = new CatalogBaseDTO();
        BeanUtils.copyProperties(catalogBaseResultDO, catalogBaseDTO);
        return catalogBaseDTO;
    }

    @Override
    public List<CatalogBaseDTO> queryList(CatalogBaseDTO catalogBaseDTO) throws IbnException {
        if (null == catalogBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        CatalogBaseDO catalogBaseDO = new CatalogBaseDO();
        BeanUtils.copyProperties(catalogBaseDTO, catalogBaseDO);
        List<CatalogBaseDO> catalogBaseDOList = catalogBaseDao.queryList(catalogBaseDO);
        if (CollectionUtils.isEmpty(catalogBaseDOList)) {
            return Lists.newArrayList();
        }
        List<CatalogBaseDTO> catalogBaseDTOList = catalogBaseDOList.stream().map(curCatalogBaseDO -> {
            CatalogBaseDTO curCatalogBaseDTO = new CatalogBaseDTO();
            BeanUtils.copyProperties(curCatalogBaseDO, curCatalogBaseDTO);
            return curCatalogBaseDTO;
        }).collect(Collectors.toList());
        return catalogBaseDTOList;
    }

    @Override
    public Pagination<CatalogBaseDTO> queryPage(CatalogBaseDTO catalogBaseDTO, PageInfo pageInfo) throws IbnException {
        if (null == pageInfo || null == catalogBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        CatalogBaseDO catalogBaseDO = new CatalogBaseDO();
        BeanUtils.copyProperties(catalogBaseDTO, catalogBaseDO);
        Page<CatalogBaseDO> catalogBaseDOPage = catalogBaseDao.queryPage(catalogBaseDO);
        if (CollectionUtils.isEmpty(catalogBaseDOPage)) {
            return new Pagination<>(0,0,0,0);
        }
        Pagination<CatalogBaseDTO> catalogBaseDTOPagination = new Pagination<>(catalogBaseDOPage.getPageNum(),
                catalogBaseDOPage.getPageSize(),catalogBaseDOPage.getTotal(),catalogBaseDOPage.getPages());

        List<CatalogBaseDTO> catalogBaseDTOList = catalogBaseDOPage.stream().map(curCatalogBaseDO -> {
            CatalogBaseDTO curCatalogBaseDTO = new CatalogBaseDTO();
            BeanUtils.copyProperties(curCatalogBaseDO, curCatalogBaseDTO);
            return curCatalogBaseDTO;
        }).collect(Collectors.toList());
        catalogBaseDTOPagination.setList(catalogBaseDTOList);
        return catalogBaseDTOPagination;
    }
}
