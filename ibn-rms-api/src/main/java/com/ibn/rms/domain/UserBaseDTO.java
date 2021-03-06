package com.ibn.rms.domain;

import com.ibn.domain.BaseDTO;
import lombok.Data;

/**
 * @version 1.0
 * @description: 用户基本信息表 dto
 * @projectName：ibn-rms
 * @see: com.ibn.rms.domain
 * @author： RenBin
 * @createTime：2020/8/11 21:45
 */
@Data
public class UserBaseDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private Long id;
    /**
     * @description: 用户登录名
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private String username;
    /**
     * @description: 登录密码
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private String password;
    /**
     * @description: 注册时间
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private Long regTime;
    /**
     * @description: 最后登入时间
     * @author：RenBin
     * @createTime：2020/8/11 21:45
     */
    private Long lastLoginTime;
}