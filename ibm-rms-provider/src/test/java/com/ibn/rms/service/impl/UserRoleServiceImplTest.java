package com.ibn.rms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.domain.UserRoleDTO;
import com.ibn.rms.service.UserRoleService;
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
public class UserRoleServiceImplTest {

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void save() throws Exception{
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        userRoleDTO.setUserId (0L);
        userRoleDTO.setRoleId (0L);
        userRoleService.save(userRoleDTO);
    }

    @Test
    public void saveBatch() throws Exception{
        UserRoleDTO userRoleDTO;
        List<UserRoleDTO> userRoleDTOList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            userRoleDTO= new UserRoleDTO();
            userRoleDTO.setUserId (0L);
            userRoleDTO.setRoleId (0L);
            userRoleDTOList.add(userRoleDTO);
        }

        userRoleService.saveBatch(userRoleDTOList);
    }

    @Test
    public void modify() throws Exception{
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        userRoleDTO.setUserId (2L);
        userRoleDTO.setRoleId (2L);

        userRoleDTO.setId (10L);
        userRoleService.modify(userRoleDTO);
    }

    @Test
    public void remove()throws Exception {
        userRoleService.remove(1L);
    }

    @Test
    public void removeBatch() throws Exception{
        Set<Long> idset = Sets.newHashSet();
        for (Long i = 2L; i < 6L; i++) {
            idset.add(i);
        }
        userRoleService.removeBatch(idset);
    }

    @Test
    public void query() throws Exception{
        UserRoleDTO userRoleDTO = userRoleService.query(6L);
        System.out.println(JSONObject.toJSONString(userRoleDTO));
    }

    @Test
    public void queryPage() throws Exception{
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(5);
        Pagination userRoleDTOPagination = userRoleService.queryPage(userRoleDTO, pageInfo);
        System.out.println(JSONObject.toJSONString(userRoleDTOPagination));
    }

    @Test
    public void queryList() throws Exception{
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        List<UserRoleDTO> userRoleDTOList = userRoleService.queryList(userRoleDTO);
        System.out.println(JSONObject.toJSONString(userRoleDTOList));
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