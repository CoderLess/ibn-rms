package com.ibn.rms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.dao.FileBaseDao;
import com.ibn.rms.domain.FileBaseDTO;
import com.ibn.rms.entity.FileBaseDO;
import com.ibn.rms.enumer.ExceptionEnum;
import com.ibn.rms.exception.IbnException;
import com.ibn.rms.service.FileBaseService;
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
@Service("fileBaseService")
public class FileBaseServiceImpl implements FileBaseService {
    @Autowired
    private FileBaseDao fileBaseDao;

    @Override
    public long save(FileBaseDTO fileBaseDTO) throws IbnException {
        if (null == fileBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        FileBaseDO fileBaseDO = new FileBaseDO();
        BeanUtils.copyProperties(fileBaseDTO, fileBaseDO);
        fileBaseDao.save(fileBaseDO);
        return fileBaseDO.getId();
    }

    @Override
    public long saveBatch(List<FileBaseDTO> fileBaseDTOList) throws IbnException {
        if (CollectionUtils.isEmpty(fileBaseDTOList)) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        List<FileBaseDO> fileBaseDOList = fileBaseDTOList.stream().map(fileBaseDTO -> {
            FileBaseDO fileBaseDO = new FileBaseDO();
            BeanUtils.copyProperties(fileBaseDTO, fileBaseDO);
            return fileBaseDO;
        }).collect(Collectors.toList());
        return fileBaseDao.saveBatch(fileBaseDOList);
    }

    @Override
    public int remove(Long id) throws IbnException {
        if (null == id) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        return fileBaseDao.remove(id);
    }

    @Override
    public int removeBatch(Set<Long> idSet) throws IbnException {
        if (CollectionUtils.isEmpty(idSet)) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        return fileBaseDao.removeBatch(idSet);
    }

    @Override
    public int modify(FileBaseDTO fileBaseDTO) throws IbnException {
        if (null == fileBaseDTO || null == fileBaseDTO.getId()) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        FileBaseDO fileBaseDO = new FileBaseDO();
        BeanUtils.copyProperties(fileBaseDTO, fileBaseDO);
        return fileBaseDao.modify(fileBaseDO);
    }

    @Override
    public FileBaseDTO query(Long id) throws IbnException {
        if (null == id) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        FileBaseDO fileBaseResultDO = fileBaseDao.query(id);
        if (null == fileBaseResultDO) {
            return null;
        }
        FileBaseDTO fileBaseDTO = new FileBaseDTO();
        BeanUtils.copyProperties(fileBaseResultDO, fileBaseDTO);
        return fileBaseDTO;
    }

    @Override
    public List<FileBaseDTO> queryList(FileBaseDTO fileBaseDTO) throws IbnException {
        if (null == fileBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        FileBaseDO fileBaseDO = new FileBaseDO();
        BeanUtils.copyProperties(fileBaseDTO, fileBaseDO);
        List<FileBaseDO> fileBaseDOList = fileBaseDao.queryList(fileBaseDO);
        if (CollectionUtils.isEmpty(fileBaseDOList)) {
            return Lists.newArrayList();
        }
        List<FileBaseDTO> fileBaseDTOList = fileBaseDOList.stream().map(curFileBaseDO -> {
            FileBaseDTO curFileBaseDTO = new FileBaseDTO();
            BeanUtils.copyProperties(curFileBaseDO, curFileBaseDTO);
            return curFileBaseDTO;
        }).collect(Collectors.toList());
        return fileBaseDTOList;
    }

    @Override
    public Pagination<FileBaseDTO> queryPage(FileBaseDTO fileBaseDTO, PageInfo pageInfo) throws IbnException {
        if (null == pageInfo || null == fileBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        FileBaseDO fileBaseDO = new FileBaseDO();
        BeanUtils.copyProperties(fileBaseDTO, fileBaseDO);
        Page<FileBaseDO> fileBaseDOPage = fileBaseDao.queryPage(fileBaseDO);
        if (CollectionUtils.isEmpty(fileBaseDOPage)) {
            return new Pagination<>(0,0,0,0);
        }
        Pagination<FileBaseDTO> fileBaseDTOPagination = new Pagination<>(fileBaseDOPage.getPageNum(),
                fileBaseDOPage.getPageSize(),fileBaseDOPage.getTotal(),fileBaseDOPage.getPages());

        List<FileBaseDTO> fileBaseDTOList = fileBaseDOPage.stream().map(curFileBaseDO -> {
            FileBaseDTO curFileBaseDTO = new FileBaseDTO();
            BeanUtils.copyProperties(curFileBaseDO, curFileBaseDTO);
            return curFileBaseDTO;
        }).collect(Collectors.toList());
        fileBaseDTOPagination.setList(fileBaseDTOList);
        return fileBaseDTOPagination;
    }
}
