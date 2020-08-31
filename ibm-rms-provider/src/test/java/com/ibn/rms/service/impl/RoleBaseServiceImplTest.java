package com.ibn.rms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.domain.RoleBaseDTO;
import com.ibn.rms.service.RoleBaseService;
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
public class RoleBaseServiceImplTest {

    @Autowired
    private RoleBaseService roleBaseService;

    @Test
    public void save() throws Exception{
        RoleBaseDTO roleBaseDTO = new RoleBaseDTO();
        roleBaseDTO.setRole ("Role");
        roleBaseDTO.setRemark ("Remark");
        roleBaseService.save(roleBaseDTO);
    }

    @Test
    public void saveBatch() throws Exception{
        RoleBaseDTO roleBaseDTO;
        List<RoleBaseDTO> roleBaseDTOList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            roleBaseDTO= new RoleBaseDTO();
            roleBaseDTO.setRole ("Role"+i);
            roleBaseDTO.setRemark ("Remark"+i);
            roleBaseDTOList.add(roleBaseDTO);
        }

        roleBaseService.saveBatch(roleBaseDTOList);
    }

    @Test
    public void modify() throws Exception{
        RoleBaseDTO roleBaseDTO = new RoleBaseDTO();
        roleBaseDTO.setRole ("modify");
        roleBaseDTO.setRemark ("modify");

        roleBaseDTO.setId (10L);
        roleBaseService.modify(roleBaseDTO);
    }

    @Test
    public void remove()throws Exception {
        roleBaseService.remove(1L);
    }

    @Test
    public void removeBatch() throws Exception{
        Set<Long> idset = Sets.newHashSet();
        for (Long i = 2L; i < 6L; i++) {
            idset.add(i);
        }
        roleBaseService.removeBatch(idset);
    }

    @Test
    public void query() throws Exception{
        RoleBaseDTO roleBaseDTO = roleBaseService.query(6L);
        System.out.println(JSONObject.toJSONString(roleBaseDTO));
    }

    @Test
    public void queryPage() throws Exception{
        RoleBaseDTO roleBaseDTO = new RoleBaseDTO();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(5);
        Pagination roleBaseDTOPagination = roleBaseService.queryPage(roleBaseDTO, pageInfo);
        System.out.println(JSONObject.toJSONString(roleBaseDTOPagination));
    }

    @Test
    public void queryList() throws Exception{
        RoleBaseDTO roleBaseDTO = new RoleBaseDTO();
        List<RoleBaseDTO> roleBaseDTOList = roleBaseService.queryList(roleBaseDTO);
        System.out.println(JSONObject.toJSONString(roleBaseDTOList));
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