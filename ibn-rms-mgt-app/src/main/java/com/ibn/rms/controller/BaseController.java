package com.ibn.rms.controller;

import com.ibn.rms.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.controller
 * @author： RenBin
 * @createTime：2020/8/29 12:04
 */
@Controller
public class BaseController {
    @Value("${jwt.header}")
    private String tokenHeader;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    public Long getUserId(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        if (null == token) {
            return 0L;
        }
        return jwtTokenUtil.getUserId(token);
    }
}
