package com.ibn.rms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.dao.FileDataDao;
import com.ibn.rms.domain.FileDataDTO;
import com.ibn.rms.entity.FileDataDO;
import com.ibn.rms.enumer.ExceptionEnum;
import com.ibn.rms.exception.IbnException;
import com.ibn.rms.service.FileDataService;
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
@Service("fileDataService")
public class FileDataServiceImpl implements FileDataService {
    @Autowired
    private FileDataDao fileDataDao;

    @Override
    public long save(FileDataDTO fileDataDTO) throws IbnException {
        if (null == fileDataDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        FileDataDO fileDataDO = new FileDataDO();
        BeanUtils.copyProperties(fileDataDTO, fileDataDO);
        fileDataDao.save(fileDataDO);
        return fileDataDO.getId();
    }

    @Override
    public long saveBatch(List<FileDataDTO> fileDataDTOList) throws IbnException {
        if (CollectionUtils.isEmpty(fileDataDTOList)) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        List<FileDataDO> fileDataDOList = fileDataDTOList.stream().map(fileDataDTO -> {
            FileDataDO fileDataDO = new FileDataDO();
            BeanUtils.copyProperties(fileDataDTO, fileDataDO);
            return fileDataDO;
        }).collect(Collectors.toList());
        return fileDataDao.saveBatch(fileDataDOList);
    }

    @Override
    public int remove(Long id) throws IbnException {
        if (null == id) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        return fileDataDao.remove(id);
    }

    @Override
    public int removeBatch(Set<Long> idSet) throws IbnException {
        if (CollectionUtils.isEmpty(idSet)) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        return fileDataDao.removeBatch(idSet);
    }

    @Override
    public int modify(FileDataDTO fileDataDTO) throws IbnException {
        if (null == fileDataDTO || null == fileDataDTO.getId()) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        FileDataDO fileDataDO = new FileDataDO();
        BeanUtils.copyProperties(fileDataDTO, fileDataDO);
        return fileDataDao.modify(fileDataDO);
    }

    @Override
    public FileDataDTO query(Long id) throws IbnException {
        if (null == id) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        FileDataDO fileDataResultDO = fileDataDao.query(id);
        if (null == fileDataResultDO) {
            return null;
        }
        FileDataDTO fileDataDTO = new FileDataDTO();
        BeanUtils.copyProperties(fileDataResultDO, fileDataDTO);
        return fileDataDTO;
    }

    @Override
    public List<FileDataDTO> queryList(FileDataDTO fileDataDTO) throws IbnException {
        if (null == fileDataDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        FileDataDO fileDataDO = new FileDataDO();
        BeanUtils.copyProperties(fileDataDTO, fileDataDO);
        List<FileDataDO> fileDataDOList = fileDataDao.queryList(fileDataDO);
        if (CollectionUtils.isEmpty(fileDataDOList)) {
            return Lists.newArrayList();
        }
        List<FileDataDTO> fileDataDTOList = fileDataDOList.stream().map(curFileDataDO -> {
            FileDataDTO curFileDataDTO = new FileDataDTO();
            BeanUtils.copyProperties(curFileDataDO, curFileDataDTO);
            return curFileDataDTO;
        }).collect(Collectors.toList());
        return fileDataDTOList;
    }

    @Override
    public Pagination<FileDataDTO> queryPage(FileDataDTO fileDataDTO, PageInfo pageInfo) throws IbnException {
        if (null == pageInfo || null == fileDataDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        FileDataDO fileDataDO = new FileDataDO();
        BeanUtils.copyProperties(fileDataDTO, fileDataDO);
        Page<FileDataDO> fileDataDOPage = fileDataDao.queryPage(fileDataDO);
        if (CollectionUtils.isEmpty(fileDataDOPage)) {
            return new Pagination<>(0,0,0,0);
        }
        Pagination<FileDataDTO> fileDataDTOPagination = new Pagination<>(fileDataDOPage.getPageNum(),
                fileDataDOPage.getPageSize(),fileDataDOPage.getTotal(),fileDataDOPage.getPages());

        List<FileDataDTO> fileDataDTOList = fileDataDOPage.stream().map(curFileDataDO -> {
            FileDataDTO curFileDataDTO = new FileDataDTO();
            BeanUtils.copyProperties(curFileDataDO, curFileDataDTO);
            return curFileDataDTO;
        }).collect(Collectors.toList());
        fileDataDTOPagination.setList(fileDataDTOList);
        return fileDataDTOPagination;
    }
}
