package com.ibn.rms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.dao.RoleBaseDao;
import com.ibn.rms.domain.RoleBaseDTO;
import com.ibn.rms.entity.RoleBaseDO;
import com.ibn.rms.service.RoleBaseService;
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
@Service("roleBaseService")
public class RoleBaseServiceImpl implements RoleBaseService {
    @Autowired
    private RoleBaseDao roleBaseDao;

    @Override
    public long save(RoleBaseDTO roleBaseDTO) {
        RoleBaseDO roleBaseDO = new RoleBaseDO();
        BeanUtils.copyProperties(roleBaseDTO, roleBaseDO);
        roleBaseDao.save(roleBaseDO);
        return roleBaseDO.getId();
    }

    @Override
    public long saveBatch(List<RoleBaseDTO> roleBaseDTOList) {
        List<RoleBaseDO> roleBaseDOList = roleBaseDTOList.stream().map(roleBaseDTO -> {
            RoleBaseDO roleBaseDO = new RoleBaseDO();
            BeanUtils.copyProperties(roleBaseDTO, roleBaseDO);
            return roleBaseDO;
        }).collect(Collectors.toList());
        return roleBaseDao.saveBatch(roleBaseDOList);
    }

    @Override
    public int remove(Long id) {
        return roleBaseDao.remove(id);
    }

    @Override
    public int removeBatch(Set<Long> idSet) {
        return roleBaseDao.removeBatch(idSet);
    }

    @Override
    public int modify(RoleBaseDTO roleBaseDTO) {
        RoleBaseDO roleBaseDO = new RoleBaseDO();
        BeanUtils.copyProperties(roleBaseDTO, roleBaseDO);
        return roleBaseDao.modify(roleBaseDO);
    }

    @Override
    public RoleBaseDTO query(Long id) {
        RoleBaseDO roleBaseResultDO = roleBaseDao.query(id);
        if (null == roleBaseResultDO) {
            return null;
        }
        RoleBaseDTO roleBaseDTO = new RoleBaseDTO();
        BeanUtils.copyProperties(roleBaseResultDO, roleBaseDTO);
        return roleBaseDTO;
    }

    @Override
    public List<RoleBaseDTO> queryList(RoleBaseDTO roleBaseDTO) {
        RoleBaseDO roleBaseDO = new RoleBaseDO();
        BeanUtils.copyProperties(roleBaseDTO, roleBaseDO);
        List<RoleBaseDO> roleBaseDOList = roleBaseDao.queryList(roleBaseDO);
        if (CollectionUtils.isEmpty(roleBaseDOList)) {
            return Lists.newArrayList();
        }
        List<RoleBaseDTO> roleBaseDTOList = roleBaseDOList.stream().map(curRoleBaseDO -> {
            RoleBaseDTO curRoleBaseDTO = new RoleBaseDTO();
            BeanUtils.copyProperties(curRoleBaseDO, curRoleBaseDTO);
            return curRoleBaseDTO;
        }).collect(Collectors.toList());
        return roleBaseDTOList;
    }

    @Override
    public Pagination<RoleBaseDTO> queryPage(RoleBaseDTO roleBaseDTO, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RoleBaseDO roleBaseDO = new RoleBaseDO();
        BeanUtils.copyProperties(roleBaseDTO, roleBaseDO);
        Page<RoleBaseDO> roleBaseDOPage = roleBaseDao.queryPage(roleBaseDO);
        if (CollectionUtils.isEmpty(roleBaseDOPage)) {
            return new Pagination<>(0,0,0,0);
        }
        Pagination<RoleBaseDTO> roleBaseDTOPagination = new Pagination<>(roleBaseDOPage.getPageNum(),
                roleBaseDOPage.getPageSize(),roleBaseDOPage.getTotal(),roleBaseDOPage.getPages());

        List<RoleBaseDTO> roleBaseDTOList = roleBaseDOPage.stream().map(curRoleBaseDO -> {
            RoleBaseDTO curRoleBaseDTO = new RoleBaseDTO();
            BeanUtils.copyProperties(curRoleBaseDO, curRoleBaseDTO);
            return curRoleBaseDTO;
        }).collect(Collectors.toList());
        roleBaseDTOPagination.setList(roleBaseDTOList);
        return roleBaseDTOPagination;
    }
}
