package com.ibn.rms.ao.impl;

import com.google.common.collect.Lists;
import com.ibn.rms.ao.UserBaseAO;
import com.ibn.rms.domain.UserBaseDTO;
import com.ibn.rms.domain.UserRoleDTO;
import com.ibn.rms.service.UserBaseService;
import com.ibn.rms.service.UserRoleService;
import com.ibn.rms.util.JwtTokenUtil;
import com.ibn.rms.vo.UserBaseVO;
import com.ibn.rms.vo.UserDetailVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @description: 用户基本信息表 ao实现
 * @projectName：ibn-rms
 * @see: com.ibn.rms.ao.impl
 * @author： RenBin
 * @createTime：2020/8/11 21:45
 */
@Service("userBaseAO")
public class UserBaseAOImpl implements UserBaseAO {
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private static final Logger logger = LoggerFactory.getLogger(UserBaseAOImpl.class);
    /**
     * 登录认证换取JWT令牌
     * @return JWT
     * @param userBaseVO
     */
    public String login(UserBaseVO userBaseVO) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userBaseVO.getUsername(), userBaseVO.getPassword());
        // 校验用户名密码是否匹配
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 利用用户信息生成token
        UserDetails userDetails = userDetailsService.loadUserByUsername(userBaseVO.getUsername());
        return jwtTokenUtil.generateToken((UserDetailVO) userDetails);
    }
    /**
     * @description: 获取用户的角色信息
     * @author：RenBin
     * @createTime：2020/8/29 12:12
     */
    @Override
    public List<Long> userRole(Long userId) {
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        userRoleDTO.setUserId(userId);
        List<UserRoleDTO> userRoleDTOList = userRoleService.queryList(userRoleDTO);
        if (CollectionUtils.isEmpty(userRoleDTOList)) {
            return Lists.newArrayList();
        }
        return userRoleDTOList.stream().map(curUserRoleDTO -> curUserRoleDTO.getId()).collect(Collectors.toList());
    }
    /**
     * @description: 根据userId获取用户信息
     * @author：RenBin
     * @createTime：2020/8/29 12:32
     */
    @Override
    public UserBaseDTO queryUser(Long userId) {
        return userBaseService.query(userId);
    }

    /**
     * @description: 保存用户基本信息
     * @author：RenBin
     * @createTime：2020/8/29 12:11
     */
    @Override
    public long save(UserBaseVO userBaseVO) {
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        return userBaseService.save(userBaseDTO);
    }

    /**
     * @description: spring security校验用户
     * @author：RenBin
     * @createTime：2020/8/29 11:37
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBaseDTO userBaseDTO = userBaseService.queryByUserName(username);
        if (null == userBaseDTO) {
            throw new UsernameNotFoundException("没有找到指定用户");
        }
        return new UserDetailVO(userBaseDTO);
    }
}
