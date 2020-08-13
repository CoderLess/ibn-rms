package com.ibn.rms.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.controller
 * @author： RenBin
 * @createTime：2020/8/13 13:58
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    @GetMapping("index")
    public String index() {
        return "Hello Admin ~";
    }

    @GetMapping("/info")
    public String productInfo() {
        String currentUser = "";
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principl instanceof UserDetails) {
            currentUser = ((UserDetails) principl).getUsername();
        } else {
            currentUser = principl.toString();
        }
        return " some product info,currentUser is: " + currentUser;
    }
}
