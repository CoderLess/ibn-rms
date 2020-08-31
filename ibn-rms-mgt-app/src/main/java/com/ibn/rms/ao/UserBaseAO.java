package com.ibn.rms.ao;

import com.ibn.page.PageInfo;
import com.ibn.page.Pagination;
import com.ibn.rms.domain.UserBaseDTO;
import com.ibn.rms.exception.LoginFailedException;
import com.ibn.rms.vo.UserBaseVO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

/**
 * @version 1.0
 * @description: 用户基本信息表 ao层
 * @projectName：ibn-rms
 * @see: com.ibn.rms.ao
 * @author： RenBin
 * @createTime：2020/8/11 21:45
 */
public interface UserBaseAO extends UserDetailsService {
    /**
     * @description: 添加信息
     * @author：RenBin
     * @createTime：2020/8/10 9:31
     */
    long save(UserBaseVO userBaseVO);

    /**
     * @description: 用户登入
     * @author：RenBin
     * @createTime：2020/8/17 22:34
     * @param userBaseVO
     */
    String login(UserBaseVO userBaseVO);

    /**
     * @description: 获取用户角色信息
     * @author：RenBin
     * @createTime：2020/8/29 12:11
     */
    List<Long> userRole(Long userId);

    /**
     * @description: 根据userid获取用户信息
     * @author：RenBin
     * @createTime：2020/8/29 12:31
     */
    UserBaseDTO queryUser(Long userId);
}
