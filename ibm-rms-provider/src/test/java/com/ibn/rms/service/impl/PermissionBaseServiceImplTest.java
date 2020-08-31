package com.ibn.rms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.domain.PermissionBaseDTO;
import com.ibn.rms.service.PermissionBaseService;
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
public class PermissionBaseServiceImplTest {

    @Autowired
    private PermissionBaseService permissionBaseService;

    @Test
    public void save() throws Exception{
        PermissionBaseDTO permissionBaseDTO = new PermissionBaseDTO();
        permissionBaseDTO.setPermission ("Permission");
        permissionBaseDTO.setParenId (0L);
        permissionBaseDTO.setUrl ("Url");
        permissionBaseDTO.setDescription ("Description");
        permissionBaseService.save(permissionBaseDTO);
    }

    @Test
    public void saveBatch() throws Exception{
        PermissionBaseDTO permissionBaseDTO;
        List<PermissionBaseDTO> permissionBaseDTOList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            permissionBaseDTO= new PermissionBaseDTO();
            permissionBaseDTO.setPermission ("Permission"+i);
            permissionBaseDTO.setParenId (0L);
            permissionBaseDTO.setUrl ("Url"+i);
            permissionBaseDTO.setDescription ("Description"+i);
            permissionBaseDTOList.add(permissionBaseDTO);
        }

        permissionBaseService.saveBatch(permissionBaseDTOList);
    }

    @Test
    public void modify() throws Exception{
        PermissionBaseDTO permissionBaseDTO = new PermissionBaseDTO();
        permissionBaseDTO.setPermission ("modify");
        permissionBaseDTO.setParenId (2L);
        permissionBaseDTO.setUrl ("modify");
        permissionBaseDTO.setDescription ("modify");

        permissionBaseDTO.setId (10L);
        permissionBaseService.modify(permissionBaseDTO);
    }

    @Test
    public void remove()throws Exception {
        permissionBaseService.remove(1L);
    }

    @Test
    public void removeBatch() throws Exception{
        Set<Long> idset = Sets.newHashSet();
        for (Long i = 2L; i < 6L; i++) {
            idset.add(i);
        }
        permissionBaseService.removeBatch(idset);
    }

    @Test
    public void query() throws Exception{
        PermissionBaseDTO permissionBaseDTO = permissionBaseService.query(6L);
        System.out.println(JSONObject.toJSONString(permissionBaseDTO));
    }

    @Test
    public void queryPage() throws Exception{
        PermissionBaseDTO permissionBaseDTO = new PermissionBaseDTO();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(5);
        Pagination permissionBaseDTOPagination = permissionBaseService.queryPage(permissionBaseDTO, pageInfo);
        System.out.println(JSONObject.toJSONString(permissionBaseDTOPagination));
    }

    @Test
    public void queryList() throws Exception{
        PermissionBaseDTO permissionBaseDTO = new PermissionBaseDTO();
        List<PermissionBaseDTO> permissionBaseDTOList = permissionBaseService.queryList(permissionBaseDTO);
        System.out.println(JSONObject.toJSONString(permissionBaseDTOList));
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