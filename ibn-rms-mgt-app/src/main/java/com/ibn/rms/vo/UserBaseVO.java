package com.ibn.rms.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.vo
 * @author： RenBin
 * @createTime：2020/8/11 11:06
 */
@Data
@ApiModel(description="业务员排名对象UserAllotVO")
public class UserBaseVO {
    @ApiModelProperty(value="主键")
    private Long id;
    @ApiModelProperty(value="用户id")
    private Long userId;
    @ApiModelProperty(value="用户名")
    private String username;
    @ApiModelProperty(value="密码")
    private String password;
    @ApiModelProperty(value="注册类型")
    private Integer regType;
    @ApiModelProperty(value="注册时间")
    private Long regTime;
    @ApiModelProperty(value="最新登入时间")
    private Long lastLoginTime;
}
