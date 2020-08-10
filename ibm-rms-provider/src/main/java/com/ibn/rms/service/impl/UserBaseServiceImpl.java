package com.ibn.rms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ibn.rms.dao.UserBaseDao;
import com.ibn.rms.domain.UserBaseDTO;
import com.ibn.rms.entity.UserBaseDO;
import com.ibn.rms.enumer.ExceptionEnum;
import com.ibn.rms.exception.IbnException;
import com.ibn.rms.page.PageInfo;
import com.ibn.rms.service.UserBaseService;
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
@Service("userBaseService")
public class UserBaseServiceImpl implements UserBaseService {
    @Autowired
    private UserBaseDao userBaseDao;

    @Override
    public long save(UserBaseDTO userBaseDTO) throws IbnException {
        if (null == userBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        UserBaseDO userBaseDO = new UserBaseDO();
        BeanUtils.copyProperties(userBaseDTO, userBaseDO);
        return userBaseDao.save(userBaseDO);
    }

    @Override
    public long saveBatch(List<UserBaseDTO> userBaseDTOList) throws IbnException {
        if (CollectionUtils.isEmpty(userBaseDTOList)) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        List<UserBaseDO> userBaseDOList = userBaseDTOList.stream().map(userBaseDTO -> {
            UserBaseDO userBaseDO = new UserBaseDO();
            BeanUtils.copyProperties(userBaseDTO, userBaseDO);
            return userBaseDO;
        }).collect(Collectors.toList());
        return userBaseDao.saveBatch(userBaseDOList);
    }

    @Override
    public int remove(Long id) throws IbnException {
        if (null == id) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        return userBaseDao.remove(id);
    }

    @Override
    public int removeBatch(Set<Long> idSet) throws IbnException {
        if (CollectionUtils.isEmpty(idSet)) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        return userBaseDao.removeBatch(idSet);
    }

    @Override
    public int modify(UserBaseDTO userBaseDTO) throws IbnException {
        if (null == userBaseDTO || null == userBaseDTO.getId()) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        UserBaseDO userBaseDO = new UserBaseDO();
        BeanUtils.copyProperties(userBaseDTO, userBaseDO);
        return userBaseDao.modify(userBaseDO);
    }

    @Override
    public UserBaseDTO query(Long id) throws IbnException {
        if (null == id) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        UserBaseDO userBaseResultDO = userBaseDao.query(id);
        if (null == userBaseResultDO) {
            return null;
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseResultDO, userBaseDTO);
        return userBaseDTO;
    }

    @Override
    public List<UserBaseDTO> queryList(UserBaseDTO userBaseDTO) throws IbnException {
        if (null == userBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        UserBaseDO userBaseDO = new UserBaseDO();
        BeanUtils.copyProperties(userBaseDTO, userBaseDO);
        List<UserBaseDO> userBaseDOList = userBaseDao.queryList(userBaseDO);
        if (CollectionUtils.isEmpty(userBaseDOList)) {
            return Lists.newArrayList();
        }
        List<UserBaseDTO> userBaseDTOList = userBaseDOList.stream().map(curUserBaseDO -> {
            UserBaseDTO curUserBaseDTO = new UserBaseDTO();
            BeanUtils.copyProperties(curUserBaseDO, curUserBaseDTO);
            return curUserBaseDTO;
        }).collect(Collectors.toList());
        return userBaseDTOList;
    }

    @Override
    public Page<UserBaseDTO> queryPage(UserBaseDTO userBaseDTO, PageInfo pageInfo) throws IbnException {
        if (null == pageInfo || null == userBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        UserBaseDO userBaseDO = new UserBaseDO();
        BeanUtils.copyProperties(userBaseDTO, userBaseDO);
        Page<UserBaseDO> userBaseDOPage = userBaseDao.queryPage(userBaseDO);
        if (CollectionUtils.isEmpty(userBaseDOPage)) {
            return new Page<>();
        }
        Page<UserBaseDTO> userBaseDTOPage = new Page<>(userBaseDOPage.getPageNum(),userBaseDOPage.getPageSize());
        userBaseDTOPage.setTotal(userBaseDTOPage.getTotal());
        userBaseDOPage.stream().forEach(curUserBaseDO -> {
            UserBaseDTO curUserBaseDTO = new UserBaseDTO();
            BeanUtils.copyProperties(curUserBaseDO, curUserBaseDTO);
            userBaseDTOPage.add(curUserBaseDTO);
        });
        return userBaseDTOPage;
    }
}
