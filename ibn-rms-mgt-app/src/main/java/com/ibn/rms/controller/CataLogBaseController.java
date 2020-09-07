package com.ibn.rms.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.ibn.common.ResultInfo;
import com.ibn.rms.ao.CataLogBaseAO;
import com.ibn.rms.ao.MenuBaseAO;
import com.ibn.rms.domain.CatalogBaseDTO;
import com.ibn.rms.domain.MenuBaseDTO;
import com.ibn.rms.exception.IbnException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @version 1.0
 * @description: 查询用户对应的目录
 * @projectName：ibn-rms
 * @see: com.ibn.rms.controller
 * @author： RenBin
 * @createTime：2020/9/7 9:23
 */
@RestController
@Api(tags = "上传文件目录基本信息表操作接口")
@RequestMapping("catalog")
public class CataLogBaseController extends BaseController {
    @Autowired
    private CataLogBaseAO cataLogBaseAO;

    @ApiOperation(value = "获取菜单接口", notes = "获取菜单接口")
    @GetMapping("list")
    public ResultInfo<Object> queryMenu(HttpServletRequest request) {
//        Long userId = this.getUserId(request);
        Long userId = 12L;
        List<CatalogBaseDTO> catalogBaseDTOList = null;
        try {
            catalogBaseDTOList = cataLogBaseAO.queryCatalogBaseList(userId);
        } catch (IbnException e) {
            e.printStackTrace();
        }
        return new ResultInfo<>().success(catalogBaseDTOList);
    }
}
