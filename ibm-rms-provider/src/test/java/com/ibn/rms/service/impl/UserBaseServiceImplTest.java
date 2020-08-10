package com.ibn.rms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.ibn.rms.domain.UserBaseDTO;
import com.ibn.rms.page.PageInfo;
import com.ibn.rms.service.UserBaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBaseServiceImplTest {

    @Autowired
    private UserBaseService userBaseService;

    @Test
    public void save() throws Exception{
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        userBaseDTO.setUserId (0L);
        userBaseDTO.setUsername ("Username");
        userBaseDTO.setPassword ("Password");
        userBaseDTO.setRegType (1);
        userBaseDTO.setRegTime (0L);
        userBaseDTO.setLastLoginTime (0L);
        userBaseService.save(userBaseDTO);
    }

    @Test
    public void saveBatch() throws Exception{
        UserBaseDTO userBaseDTO;
        List<UserBaseDTO> userBaseDTOList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            userBaseDTO= new UserBaseDTO();
            userBaseDTO.setUserId (0L);
            userBaseDTO.setUsername ("Username"+i);
            userBaseDTO.setPassword ("Password");
            userBaseDTO.setRegType (1);
            userBaseDTO.setRegTime (0L);
            userBaseDTO.setLastLoginTime (0L);
            userBaseDTOList.add(userBaseDTO);
        }

        userBaseService.saveBatch(userBaseDTOList);
    }

    @Test
    public void modify() throws Exception{
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        userBaseDTO.setUserId (2L);
        userBaseDTO.setUsername ("modify");
        userBaseDTO.setPassword ("modify");
        userBaseDTO.setRegType (3);
        userBaseDTO.setRegTime (2L);
        userBaseDTO.setLastLoginTime (2L);

        userBaseDTO.setId (13L);
        userBaseService.modify(userBaseDTO);
    }

    @Test
    public void remove()throws Exception {
        userBaseService.remove(1L);
    }

    @Test
    public void removeBatch() throws Exception{
        Set<Long> idset = Sets.newHashSet();
        for (Long i = 12L; i < 16L; i++) {
            idset.add(i);
        }
        userBaseService.removeBatch(idset);
    }

    @Test
    public void query() throws Exception{
        UserBaseDTO userBaseDTO = userBaseService.query(16L);
        System.out.println(JSONObject.toJSONString(userBaseDTO));
    }

    @Test
    public void queryPage() throws Exception{
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(5);
        Page<UserBaseDTO> userBaseDTOPagination = userBaseService.queryPage(userBaseDTO, pageInfo);
        System.out.println(JSONObject.toJSONString(userBaseDTOPagination));
    }

    @Test
    public void queryList() throws Exception{
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        List<UserBaseDTO> userBaseDTOList = userBaseService.queryList(userBaseDTO);
        System.out.println(JSONObject.toJSONString(userBaseDTOList));
    }
}