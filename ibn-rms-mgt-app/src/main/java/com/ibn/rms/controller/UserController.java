package com.ibn.rms.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
public class UserController {
    @GetMapping("index")
    public String index() {
        return "Hello User ~";
    }
}
