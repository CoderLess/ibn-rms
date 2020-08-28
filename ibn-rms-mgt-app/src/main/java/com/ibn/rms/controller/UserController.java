package com.ibn.rms.controller;

import com.ibn.common.ResultInfo;
import com.ibn.rms.ao.UserBaseAO;
import com.ibn.rms.vo.UserBaseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.controller
 * @author： RenBin
 * @createTime：2020/8/13 9:30
 */
@RestController
@Api(tags = "用户基本信息表操作接口")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserBaseAO userBaseAO;

    @GetMapping("index")
    public String index() {
        return "Hello User ~";
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册接口", notes = "用户注册接口")
    public String register(UserBaseVO userBaseVO) {
        userBaseVO.setPassword(passwordEncoder.encode(userBaseVO.getPassword()));
        userBaseAO.save(userBaseVO);
        return "success";
    }
    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口", notes = "用户登录接口")
    public ResultInfo<String> login(@RequestBody UserBaseVO userBaseVO) {
        String token = userBaseAO.login(userBaseVO);
        return new ResultInfo<String>().success(token);
    }

    @GetMapping("/userInfo")
    @ApiOperation(value = "用户相关信息", notes = "用户相关信息")
    public ResultInfo<Object> userInfo(@RequestHeader("${jwt.header}") String token) {

        return new ResultInfo<>().success(token);
    }
}
