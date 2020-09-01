package com.ibn.rms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.domain.MenuBaseDTO;
import com.ibn.rms.service.MenuBaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuBaseServiceImplTest {

    @Autowired
    private MenuBaseService menuBaseService;

    @Test
    public void save() throws Exception{
        MenuBaseDTO menuBaseDTO = new MenuBaseDTO();
        menuBaseDTO.setParentId (0L);
        menuBaseDTO.setPath ("Path");
        menuBaseDTO.setTitle ("Title");
        menuBaseDTO.setIcon ("Icon");
        menuBaseDTO.setHidden ("Hidden");
        menuBaseService.save(menuBaseDTO);
    }

    @Test
    public void saveBatch() throws Exception{
        MenuBaseDTO menuBaseDTO;
        List<MenuBaseDTO> menuBaseDTOList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            menuBaseDTO= new MenuBaseDTO();
            menuBaseDTO.setParentId (0L);
            menuBaseDTO.setPath ("Path"+i);
            menuBaseDTO.setTitle ("Title"+i);
            menuBaseDTO.setIcon ("Icon"+i);
            menuBaseDTO.setHidden ("Hidden"+i);
            menuBaseDTOList.add(menuBaseDTO);
        }

        menuBaseService.saveBatch(menuBaseDTOList);
    }

    @Test
    public void modify() throws Exception{
        MenuBaseDTO menuBaseDTO = new MenuBaseDTO();
        menuBaseDTO.setParentId (2L);
        menuBaseDTO.setPath ("modify");
        menuBaseDTO.setTitle ("modify");
        menuBaseDTO.setIcon ("modify");
        menuBaseDTO.setHidden ("modify");

        menuBaseDTO.setId (10L);
        menuBaseService.modify(menuBaseDTO);
    }

    @Test
    public void remove()throws Exception {
        menuBaseService.remove(1L);
    }

    @Test
    public void removeBatch() throws Exception{
        Set<Long> idset = Sets.newHashSet();
        for (Long i = 2L; i < 6L; i++) {
            idset.add(i);
        }
        menuBaseService.removeBatch(idset);
    }

    @Test
    public void query() throws Exception{
        MenuBaseDTO menuBaseDTO = menuBaseService.query(6L);
        System.out.println(JSONObject.toJSONString(menuBaseDTO));
    }

    @Test
    public void queryPage() throws Exception{
        MenuBaseDTO menuBaseDTO = new MenuBaseDTO();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(5);
        Pagination<MenuBaseDTO> menuBaseDTOPagination = menuBaseService.queryPage(menuBaseDTO, pageInfo);
        System.out.println(JSONObject.toJSONString(menuBaseDTOPagination));
    }

    @Test
    public void queryList() throws Exception{
        MenuBaseDTO menuBaseDTO = new MenuBaseDTO();
        menuBaseDTO.setId(1L);
        List<MenuBaseDTO> menuBaseDTOList = menuBaseService.queryList(menuBaseDTO);
        System.out.println(JSONObject.toJSONString(menuBaseDTOList));
    }
}