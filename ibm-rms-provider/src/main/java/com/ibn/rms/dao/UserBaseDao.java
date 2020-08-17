package com.ibn.rms.dao;

import com.ibn.dao.BaseDao;
import com.ibn.rms.entity.UserBaseDO;

/**
 * @version 1.0
 * @description: 用户基本信息表 dao层
 * @projectName：ibn-rms
 * @see: com.ibn.rms.dao
 * @author： RenBin
 * @createTime：2020/8/11 21:45
 */
public interface UserBaseDao extends BaseDao<UserBaseDO> {
    /**
     * @description: 根据用户名查找用户
     * @author：RenBin
     * @createTime：2020/8/14 10:04
     */
    UserBaseDO queryByUserName(String username);
}