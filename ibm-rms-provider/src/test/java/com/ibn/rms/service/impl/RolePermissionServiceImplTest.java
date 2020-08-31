package com.ibn.rms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.domain.RolePermissionDTO;
import com.ibn.rms.service.RolePermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

/**
 * @version 1.0
 * @description:  测试类
 * @projectName：ibn-rms
 * @see: com.ibn.rms.service.impl
 * @author： RenBin
 * @createTime：2020/8/11 21:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RolePermissionServiceImplTest {

    @Autowired
    private RolePermissionService rolePermissionService;

    @Test
    public void save() throws Exception{
        RolePermissionDTO rolePermissionDTO = new RolePermissionDTO();
        rolePermissionDTO.setRoleId (0L);
        rolePermissionDTO.setPermissionId (0L);
        rolePermissionService.save(rolePermissionDTO);
    }

    @Test
    public void saveBatch() throws Exception{
        RolePermissionDTO rolePermissionDTO;
        List<RolePermissionDTO> rolePermissionDTOList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            rolePermissionDTO= new RolePermissionDTO();
            rolePermissionDTO.setRoleId (0L);
            rolePermissionDTO.setPermissionId (0L);
            rolePermissionDTOList.add(rolePermissionDTO);
        }

        rolePermissionService.saveBatch(rolePermissionDTOList);
    }

    @Test
    public void modify() throws Exception{
        RolePermissionDTO rolePermissionDTO = new RolePermissionDTO();
        rolePermissionDTO.setRoleId (2L);
        rolePermissionDTO.setPermissionId (2L);

        rolePermissionDTO.setId (10L);
        rolePermissionService.modify(rolePermissionDTO);
    }

    @Test
    public void remove()throws Exception {
        rolePermissionService.remove(1L);
    }

    @Test
    public void removeBatch() throws Exception{
        Set<Long> idset = Sets.newHashSet();
        for (Long i = 2L; i < 6L; i++) {
            idset.add(i);
        }
        rolePermissionService.removeBatch(idset);
    }

    @Test
    public void query() throws Exception{
        RolePermissionDTO rolePermissionDTO = rolePermissionService.query(6L);
        System.out.println(JSONObject.toJSONString(rolePermissionDTO));
    }

    @Test
    public void queryPage() throws Exception{
        RolePermissionDTO rolePermissionDTO = new RolePermissionDTO();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(5);
        Pagination rolePermissionDTOPagination = rolePermissionService.queryPage(rolePermissionDTO, pageInfo);
        System.out.println(JSONObject.toJSONString(rolePermissionDTOPagination));
    }

    @Test
    public void queryList() throws Exception{
        RolePermissionDTO rolePermissionDTO = new RolePermissionDTO();
        List<RolePermissionDTO> rolePermissionDTOList = rolePermissionService.queryList(rolePermissionDTO);
        System.out.println(JSONObject.toJSONString(rolePermissionDTOList));
    }

    @Test
    public void testAll() throws Exception {
        this.save();
        this.saveBatch();
        this.modify();
        this.remove();
        this.removeBatch();
        this.query();
        this.queryPage();
        this.queryList();
    }
}