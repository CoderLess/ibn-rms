package com.ibn.rms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.dao.RolePermissionDao;
import com.ibn.rms.domain.RolePermissionDTO;
import com.ibn.rms.entity.RolePermissionDO;
import com.ibn.rms.service.RolePermissionService;
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
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    public long save(RolePermissionDTO rolePermissionDTO) {
        RolePermissionDO rolePermissionDO = new RolePermissionDO();
        BeanUtils.copyProperties(rolePermissionDTO, rolePermissionDO);
        rolePermissionDao.save(rolePermissionDO);
        return rolePermissionDO.getId();
    }

    @Override
    public long saveBatch(List<RolePermissionDTO> rolePermissionDTOList) {
        List<RolePermissionDO> rolePermissionDOList = rolePermissionDTOList.stream().map(rolePermissionDTO -> {
            RolePermissionDO rolePermissionDO = new RolePermissionDO();
            BeanUtils.copyProperties(rolePermissionDTO, rolePermissionDO);
            return rolePermissionDO;
        }).collect(Collectors.toList());
        return rolePermissionDao.saveBatch(rolePermissionDOList);
    }

    @Override
    public int remove(Long id) {
        return rolePermissionDao.remove(id);
    }

    @Override
    public int removeBatch(Set<Long> idSet) {
        return rolePermissionDao.removeBatch(idSet);
    }

    @Override
    public int modify(RolePermissionDTO rolePermissionDTO) {
        RolePermissionDO rolePermissionDO = new RolePermissionDO();
        BeanUtils.copyProperties(rolePermissionDTO, rolePermissionDO);
        return rolePermissionDao.modify(rolePermissionDO);
    }

    @Override
    public RolePermissionDTO query(Long id) {
        RolePermissionDO rolePermissionResultDO = rolePermissionDao.query(id);
        if (null == rolePermissionResultDO) {
            return null;
        }
        RolePermissionDTO rolePermissionDTO = new RolePermissionDTO();
        BeanUtils.copyProperties(rolePermissionResultDO, rolePermissionDTO);
        return rolePermissionDTO;
    }

    @Override
    public List<RolePermissionDTO> queryList(RolePermissionDTO rolePermissionDTO) {
        RolePermissionDO rolePermissionDO = new RolePermissionDO();
        BeanUtils.copyProperties(rolePermissionDTO, rolePermissionDO);
        List<RolePermissionDO> rolePermissionDOList = rolePermissionDao.queryList(rolePermissionDO);
        if (CollectionUtils.isEmpty(rolePermissionDOList)) {
            return Lists.newArrayList();
        }
        List<RolePermissionDTO> rolePermissionDTOList = rolePermissionDOList.stream().map(curRolePermissionDO -> {
            RolePermissionDTO curRolePermissionDTO = new RolePermissionDTO();
            BeanUtils.copyProperties(curRolePermissionDO, curRolePermissionDTO);
            return curRolePermissionDTO;
        }).collect(Collectors.toList());
        return rolePermissionDTOList;
    }

    @Override
    public Pagination<RolePermissionDTO> queryPage(RolePermissionDTO rolePermissionDTO, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RolePermissionDO rolePermissionDO = new RolePermissionDO();
        BeanUtils.copyProperties(rolePermissionDTO, rolePermissionDO);
        Page<RolePermissionDO> rolePermissionDOPage = rolePermissionDao.queryPage(rolePermissionDO);
        if (CollectionUtils.isEmpty(rolePermissionDOPage)) {
            return new Pagination<>(0,0,0,0);
        }
        Pagination<RolePermissionDTO> rolePermissionDTOPagination = new Pagination<>(rolePermissionDOPage.getPageNum(),
                rolePermissionDOPage.getPageSize(),rolePermissionDOPage.getTotal(),rolePermissionDOPage.getPages());

        List<RolePermissionDTO> rolePermissionDTOList = rolePermissionDOPage.stream().map(curRolePermissionDO -> {
            RolePermissionDTO curRolePermissionDTO = new RolePermissionDTO();
            BeanUtils.copyProperties(curRolePermissionDO, curRolePermissionDTO);
            return curRolePermissionDTO;
        }).collect(Collectors.toList());
        rolePermissionDTOPagination.setList(rolePermissionDTOList);
        return rolePermissionDTOPagination;
    }
}
