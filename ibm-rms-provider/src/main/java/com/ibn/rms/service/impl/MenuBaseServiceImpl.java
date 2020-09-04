package com.ibn.rms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.dao.MenuBaseDao;
import com.ibn.rms.domain.MenuBaseDTO;
import com.ibn.rms.entity.MenuBaseDO;
import com.ibn.rms.enumer.ExceptionEnum;
import com.ibn.rms.exception.IbnException;
import com.ibn.rms.service.MenuBaseService;
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
@Service("menuBaseService")
public class MenuBaseServiceImpl implements MenuBaseService {
    @Autowired
    private MenuBaseDao menuBaseDao;

    @Override
    public long save(MenuBaseDTO menuBaseDTO) throws IbnException {
        if (null == menuBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        MenuBaseDO menuBaseDO = new MenuBaseDO();
        BeanUtils.copyProperties(menuBaseDTO, menuBaseDO);
        menuBaseDao.save(menuBaseDO);
        return menuBaseDTO.getId();
    }

    @Override
    public long saveBatch(List<MenuBaseDTO> menuBaseDTOList) throws IbnException {
        if (CollectionUtils.isEmpty(menuBaseDTOList)) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        List<MenuBaseDO> menuBaseDOList = menuBaseDTOList.stream().map(menuBaseDTO -> {
            MenuBaseDO menuBaseDO = new MenuBaseDO();
            BeanUtils.copyProperties(menuBaseDTO, menuBaseDO);
            return menuBaseDO;
        }).collect(Collectors.toList());
        return menuBaseDao.saveBatch(menuBaseDOList);
    }

    @Override
    public int remove(Long id) throws IbnException {
        if (null == id) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        return menuBaseDao.remove(id);
    }

    @Override
    public int removeBatch(Set<Long> idSet) throws IbnException {
        if (CollectionUtils.isEmpty(idSet)) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        return menuBaseDao.removeBatch(idSet);
    }

    @Override
    public int modify(MenuBaseDTO menuBaseDTO) throws IbnException {
        if (null == menuBaseDTO || null == menuBaseDTO.getId()) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        MenuBaseDO menuBaseDO = new MenuBaseDO();
        BeanUtils.copyProperties(menuBaseDTO, menuBaseDO);
        return menuBaseDao.modify(menuBaseDO);
    }

    @Override
    public MenuBaseDTO query(Long id) throws IbnException {
        if (null == id) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        MenuBaseDO menuBaseResultDO = menuBaseDao.query(id);
        if (null == menuBaseResultDO) {
            return null;
        }
        MenuBaseDTO menuBaseDTO = new MenuBaseDTO();
        BeanUtils.copyProperties(menuBaseResultDO, menuBaseDTO);
        return menuBaseDTO;
    }

    @Override
    public List<MenuBaseDTO> queryList(MenuBaseDTO menuBaseDTO) throws IbnException {
        if (null == menuBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        MenuBaseDO menuBaseDO = new MenuBaseDO();
        BeanUtils.copyProperties(menuBaseDTO, menuBaseDO);
        List<MenuBaseDO> menuBaseDOList = menuBaseDao.queryList(menuBaseDO);
        if (CollectionUtils.isEmpty(menuBaseDOList)) {
            return Lists.newArrayList();
        }
        List<MenuBaseDTO> menuBaseDTOList = menuBaseDOList.stream().map(curMenuBaseDO -> {
            MenuBaseDTO curMenuBaseDTO = new MenuBaseDTO();
            BeanUtils.copyProperties(curMenuBaseDO, curMenuBaseDTO);
            return curMenuBaseDTO;
        }).collect(Collectors.toList());
        return menuBaseDTOList;
    }

    @Override
    public Pagination<MenuBaseDTO> queryPage(MenuBaseDTO menuBaseDTO, PageInfo pageInfo) throws IbnException {
        if (null == pageInfo || null == menuBaseDTO) {
            throw new IbnException(ExceptionEnum.NUll_PARAM);
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        MenuBaseDO menuBaseDO = new MenuBaseDO();
        BeanUtils.copyProperties(menuBaseDTO, menuBaseDO);
        Page<MenuBaseDO> menuBaseDOPage = menuBaseDao.queryPage(menuBaseDO);
        if (CollectionUtils.isEmpty(menuBaseDOPage)) {
            return new Pagination<>(0,0,0,0);
        }
        Pagination<MenuBaseDTO> menuBaseDTOPagination = new Pagination<>(menuBaseDOPage.getPageNum(),
                menuBaseDOPage.getPageSize(),menuBaseDOPage.getTotal(),menuBaseDOPage.getPages());

        List<MenuBaseDTO> menuBaseDTOList = menuBaseDOPage.stream().map(curMenuBaseDO -> {
            MenuBaseDTO curMenuBaseDTO = new MenuBaseDTO();
            BeanUtils.copyProperties(curMenuBaseDO, curMenuBaseDTO);
            return curMenuBaseDTO;
        }).collect(Collectors.toList());
        menuBaseDTOPagination.setList(menuBaseDTOList);
        return menuBaseDTOPagination;
    }

    @Override
    public List<MenuBaseDTO> queryList() throws IbnException {
        MenuBaseDO menuBaseDO = new MenuBaseDO();
        menuBaseDO.setParentId(0L);
        List<MenuBaseDO> menuBaseDOList = menuBaseDao.queryList(menuBaseDO);
        if (CollectionUtils.isEmpty(menuBaseDOList)) {
            return Lists.newArrayList();
        }
        List<MenuBaseDTO> menuBaseDTOList = Lists.newArrayList();
        MenuBaseDTO menuBaseDTO;
        for (MenuBaseDO curMenuBaseDO : menuBaseDOList) {
            menuBaseDTO = new MenuBaseDTO();
            BeanUtils.copyProperties(curMenuBaseDO, menuBaseDTO);
            menuBaseDTOList.add(this.getMenu(menuBaseDTO));
        }
        return menuBaseDTOList;
    }
    /**
     * @description: 递归获取菜单
     * @author：RenBin
     * @createTime：2020/9/4 21:20
     */
    private MenuBaseDTO getMenu(MenuBaseDTO menuBaseDTO) throws IbnException {
        MenuBaseDTO menuBaseQueryDTO = new MenuBaseDTO();
        menuBaseQueryDTO.setParentId(menuBaseDTO.getId());
        List<MenuBaseDTO> menuBaseDTOList = this.queryList(menuBaseQueryDTO);
        if (CollectionUtils.isEmpty(menuBaseDTOList)) {
            menuBaseDTO.setChildren(Lists.newArrayList());
            return menuBaseDTO;
        }
        menuBaseDTO.setChildren(menuBaseDTOList);
        for (MenuBaseDTO curMenuBaseDTO : menuBaseDTOList) {
            this.getMenu(curMenuBaseDTO);
        }
        return menuBaseDTO;
    }
}
