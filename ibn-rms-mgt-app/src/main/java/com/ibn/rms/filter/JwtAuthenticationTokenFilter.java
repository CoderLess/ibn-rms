package com.ibn.rms.filter;

import com.ibn.rms.ao.UserBaseAO;
import com.ibn.rms.domain.UserBaseDTO;
import com.ibn.rms.util.JwtTokenUtil;
import com.ibn.rms.vo.UserDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.filter
 * @author： RenBin
 * @createTime：2020/8/17 8:06
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserBaseAO userBaseAO;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = request.getHeader(jwtTokenUtil.getHeader());
        if(!StringUtils.isEmpty(jwtToken)){
            Long userId = jwtTokenUtil.getUserId(jwtToken);
            if(userId != null &&
                    SecurityContextHolder.getContext().getAuthentication() == null){
                UserBaseDTO userBaseDTO = userBaseAO.queryUser(userId);
                UserDetails userDetails = new UserDetailVO(userBaseDTO);
                if(jwtTokenUtil.validateToken(jwtToken,userDetails)){
                    //给使用该JWT令牌的用户进行授权
                    UsernamePasswordAuthenticationToken authenticationToken
                            = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }

        filterChain.doFilter(request,response);
    }
}
