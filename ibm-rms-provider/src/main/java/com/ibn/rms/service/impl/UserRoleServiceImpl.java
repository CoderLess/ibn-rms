package com.ibn.rms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.dao.UserRoleDao;
import com.ibn.rms.domain.UserRoleDTO;
import com.ibn.rms.entity.UserRoleDO;
import com.ibn.rms.service.UserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @description:  service实现
 * @projectName：ibn-rms
 * @see: com.ibn.rms.service.impl
 * @author： RenBin
 * @createTime：2020/8/11 21:45
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public long save(UserRoleDTO userRoleDTO) {
        UserRoleDO userRoleDO = new UserRoleDO();
        BeanUtils.copyProperties(userRoleDTO, userRoleDO);
        userRoleDao.save(userRoleDO);
        return userRoleDO.getId();
    }

    @Override
    public long saveBatch(List<UserRoleDTO> userRoleDTOList) {
        List<UserRoleDO> userRoleDOList = userRoleDTOList.stream().map(userRoleDTO -> {
            UserRoleDO userRoleDO = new UserRoleDO();
            BeanUtils.copyProperties(userRoleDTO, userRoleDO);
            return userRoleDO;
        }).collect(Collectors.toList());
        return userRoleDao.saveBatch(userRoleDOList);
    }

    @Override
    public int remove(Long id) {
        return userRoleDao.remove(id);
    }

    @Override
    public int removeBatch(Set<Long> idSet) {
        return userRoleDao.removeBatch(idSet);
    }

    @Override
    public int modify(UserRoleDTO userRoleDTO) {
        UserRoleDO userRoleDO = new UserRoleDO();
        BeanUtils.copyProperties(userRoleDTO, userRoleDO);
        return userRoleDao.modify(userRoleDO);
    }

    @Override
    public UserRoleDTO query(Long id) {
        UserRoleDO userRoleResultDO = userRoleDao.query(id);
        if (null == userRoleResultDO) {
            return null;
        }
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        BeanUtils.copyProperties(userRoleResultDO, userRoleDTO);
        return userRoleDTO;
    }

    @Override
    public List<UserRoleDTO> queryList(UserRoleDTO userRoleDTO) {
        UserRoleDO userRoleDO = new UserRoleDO();
        BeanUtils.copyProperties(userRoleDTO, userRoleDO);
        List<UserRoleDO> userRoleDOList = userRoleDao.queryList(userRoleDO);
        if (CollectionUtils.isEmpty(userRoleDOList)) {
            return Lists.newArrayList();
        }
        List<UserRoleDTO> userRoleDTOList = userRoleDOList.stream().map(curUserRoleDO -> {
            UserRoleDTO curUserRoleDTO = new UserRoleDTO();
            BeanUtils.copyProperties(curUserRoleDO, curUserRoleDTO);
            return curUserRoleDTO;
        }).collect(Collectors.toList());
        return userRoleDTOList;
    }

    @Override
    public Pagination<UserRoleDTO> queryPage(UserRoleDTO userRoleDTO, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        UserRoleDO userRoleDO = new UserRoleDO();
        BeanUtils.copyProperties(userRoleDTO, userRoleDO);
        Page<UserRoleDO> userRoleDOPage = userRoleDao.queryPage(userRoleDO);
        if (CollectionUtils.isEmpty(userRoleDOPage)) {
            return new Pagination<>(0,0,0,0);
        }
        Pagination<UserRoleDTO> userRoleDTOPagination = new Pagination<>(userRoleDOPage.getPageNum(),
                userRoleDOPage.getPageSize(),userRoleDOPage.getTotal(),userRoleDOPage.getPages());

        List<UserRoleDTO> userRoleDTOList = userRoleDOPage.stream().map(curUserRoleDO -> {
            UserRoleDTO curUserRoleDTO = new UserRoleDTO();
            BeanUtils.copyProperties(curUserRoleDO, curUserRoleDTO);
            return curUserRoleDTO;
        }).collect(Collectors.toList());
        userRoleDTOPagination.setList(userRoleDTOList);
        return userRoleDTOPagination;
    }
}
