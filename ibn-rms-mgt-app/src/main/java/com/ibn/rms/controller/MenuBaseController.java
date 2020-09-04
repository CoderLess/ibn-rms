package com.ibn.rms.controller;

import com.ibn.common.ResultInfo;
import com.ibn.rms.ao.MenuBaseAO;
import com.ibn.rms.domain.MenuBaseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.controller
 * @author： RenBin
 * @createTime：2020/9/1 11:51
 */
@RestController
@Api(tags = "菜单基本信息表操作接口")
@RequestMapping("menu")
public class MenuBaseController extends BaseController {
    @Autowired
    private MenuBaseAO menuBaseAO;

    @ApiOperation(value = "获取菜单接口", notes = "获取菜单接口")
    @GetMapping("list")
    public ResultInfo<Object> queryMenu() {
        MenuBaseDTO menuBaseDTO = new MenuBaseDTO();
        menuBaseDTO.setHidden(0);
        List<MenuBaseDTO> menuBaseDTOList = menuBaseAO.queryMenuBaseList();
        return new ResultInfo<>().success(menuBaseDTOList);
    }
}
