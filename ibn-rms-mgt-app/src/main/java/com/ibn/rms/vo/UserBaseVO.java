package com.ibn.rms.vo;

import com.ibn.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * @version 1.0
 * @description: 用户基本信息表 vo
 * @projectName：ibn-rms
 * @see: com.ibn.rms.vo
 * @author： RenBin
 * @createTime：2020/8/11 21:45
 */
@Data
@ApiModel(description = "用户基本信息表 vo")
public class UserBaseVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    @ApiModelProperty(value = "用户登录名")
    @NotNull(message = "用户名不能为空")
    @Pattern(regexp = "^1[3456789][0-9]{9}$", message = "用户名为手机号")
    private String username;
    @NotNull(message = "密码不能为空")
    @ApiModelProperty(value = "登录密码")
    private String password;
    @ApiModelProperty(value = "注册方式")
    private Integer regType;
    @ApiModelProperty(value = "注册时间")
    private Long regTime;
    @ApiModelProperty(value = "最后登入时间")
    private Long lastLoginTime;
}