package com.ibn.rms.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @description: 登入失败异常
 * @author：RenBin
 * @createTime：2020/8/14 10:35
 */
public class LoginFailedException extends AuthenticationException {
    public LoginFailedException(String detail) {
        super(detail);
    }
}
