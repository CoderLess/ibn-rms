package com.ibn.rms.controller;

import com.ibn.rms.ao.UserBaseAO;
import com.ibn.rms.vo.UserBaseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.controller
 * @author： RenBin
 * @createTime：2020/8/13 9:30
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户基本信息表操作接口")
public class UserController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserBaseAO userBaseAO;
    @GetMapping("index")
    public String index() {
        return "Hello User ~";
    }
    @PostMapping("/register")
    @ApiOperation(value = "用戶註冊接口", notes = "用戶註冊接口")
    public String registerUser(UserBaseVO userBaseVO){
        userBaseVO.setPassword(bCryptPasswordEncoder.encode(userBaseVO.getPassword()));
        userBaseAO.save(userBaseVO);
        return "success";
    }
}
