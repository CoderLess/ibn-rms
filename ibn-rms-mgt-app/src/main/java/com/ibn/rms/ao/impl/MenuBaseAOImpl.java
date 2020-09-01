package com.ibn.rms.ao.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ibn.rms.ao.MenuBaseAO;
import com.ibn.rms.domain.MenuBaseDTO;
import com.ibn.rms.exception.IbnException;
import com.ibn.rms.service.MenuBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.ao.impl
 * @author： RenBin
 * @createTime：2020/9/1 11:48
 */
@Service("menuBaseAO")
public class MenuBaseAOImpl implements MenuBaseAO {

    @Autowired
    private MenuBaseService menuBaseService;

    private static final Logger logger = LoggerFactory.getLogger(MenuBaseAOImpl.class);

    @Override
    public List<MenuBaseDTO> queryMenuBaseList(MenuBaseDTO menuBaseDTO) {
        try {
            return menuBaseService.queryList(menuBaseDTO);
        } catch (IbnException e) {
            String msg = String.format("查询菜单相关信息失败：%s", JSONObject.toJSONString(menuBaseDTO));
            logger.error(msg, e);
        }
        return Lists.newArrayList();
    }
}
