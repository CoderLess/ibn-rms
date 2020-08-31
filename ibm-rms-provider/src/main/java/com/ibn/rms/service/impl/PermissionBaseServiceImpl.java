package com.ibn.rms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.dao.PermissionBaseDao;
import com.ibn.rms.domain.PermissionBaseDTO;
import com.ibn.rms.entity.PermissionBaseDO;
import com.ibn.rms.service.PermissionBaseService;
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
@Service("permissionBaseService")
public class PermissionBaseServiceImpl implements PermissionBaseService {
    @Autowired
    private PermissionBaseDao permissionBaseDao;

    @Override
    public long save(PermissionBaseDTO permissionBaseDTO) {
        PermissionBaseDO permissionBaseDO = new PermissionBaseDO();
        BeanUtils.copyProperties(permissionBaseDTO, permissionBaseDO);
        permissionBaseDao.save(permissionBaseDO);
        return permissionBaseDO.getId();
    }

    @Override
    public long saveBatch(List<PermissionBaseDTO> permissionBaseDTOList) {
        List<PermissionBaseDO> permissionBaseDOList = permissionBaseDTOList.stream().map(permissionBaseDTO -> {
            PermissionBaseDO permissionBaseDO = new PermissionBaseDO();
            BeanUtils.copyProperties(permissionBaseDTO, permissionBaseDO);
            return permissionBaseDO;
        }).collect(Collectors.toList());
        return permissionBaseDao.saveBatch(permissionBaseDOList);
    }

    @Override
    public int remove(Long id) {
        return permissionBaseDao.remove(id);
    }

    @Override
    public int removeBatch(Set<Long> idSet) {
        return permissionBaseDao.removeBatch(idSet);
    }

    @Override
    public int modify(PermissionBaseDTO permissionBaseDTO) {
        PermissionBaseDO permissionBaseDO = new PermissionBaseDO();
        BeanUtils.copyProperties(permissionBaseDTO, permissionBaseDO);
        return permissionBaseDao.modify(permissionBaseDO);
    }

    @Override
    public PermissionBaseDTO query(Long id) {
        PermissionBaseDO permissionBaseResultDO = permissionBaseDao.query(id);
        if (null == permissionBaseResultDO) {
            return null;
        }
        PermissionBaseDTO permissionBaseDTO = new PermissionBaseDTO();
        BeanUtils.copyProperties(permissionBaseResultDO, permissionBaseDTO);
        return permissionBaseDTO;
    }

    @Override
    public List<PermissionBaseDTO> queryList(PermissionBaseDTO permissionBaseDTO) {
        PermissionBaseDO permissionBaseDO = new PermissionBaseDO();
        BeanUtils.copyProperties(permissionBaseDTO, permissionBaseDO);
        List<PermissionBaseDO> permissionBaseDOList = permissionBaseDao.queryList(permissionBaseDO);
        if (CollectionUtils.isEmpty(permissionBaseDOList)) {
            return Lists.newArrayList();
        }
        List<PermissionBaseDTO> permissionBaseDTOList = permissionBaseDOList.stream().map(curPermissionBaseDO -> {
            PermissionBaseDTO curPermissionBaseDTO = new PermissionBaseDTO();
            BeanUtils.copyProperties(curPermissionBaseDO, curPermissionBaseDTO);
            return curPermissionBaseDTO;
        }).collect(Collectors.toList());
        return permissionBaseDTOList;
    }

    @Override
    public Pagination<PermissionBaseDTO> queryPage(PermissionBaseDTO permissionBaseDTO, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        PermissionBaseDO permissionBaseDO = new PermissionBaseDO();
        BeanUtils.copyProperties(permissionBaseDTO, permissionBaseDO);
        Page<PermissionBaseDO> permissionBaseDOPage = permissionBaseDao.queryPage(permissionBaseDO);
        if (CollectionUtils.isEmpty(permissionBaseDOPage)) {
            return new Pagination<>(0,0,0,0);
        }
        Pagination<PermissionBaseDTO> permissionBaseDTOPagination = new Pagination<>(permissionBaseDOPage.getPageNum(),
                permissionBaseDOPage.getPageSize(),permissionBaseDOPage.getTotal(),permissionBaseDOPage.getPages());

        List<PermissionBaseDTO> permissionBaseDTOList = permissionBaseDOPage.stream().map(curPermissionBaseDO -> {
            PermissionBaseDTO curPermissionBaseDTO = new PermissionBaseDTO();
            BeanUtils.copyProperties(curPermissionBaseDO, curPermissionBaseDTO);
            return curPermissionBaseDTO;
        }).collect(Collectors.toList());
        permissionBaseDTOPagination.setList(permissionBaseDTOList);
        return permissionBaseDTOPagination;
    }
}
