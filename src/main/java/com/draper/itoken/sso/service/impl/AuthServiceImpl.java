package com.draper.itoken.sso.service.impl;

import com.draper.itoken.sso.domain.User;
import com.draper.itoken.sso.service.AuthService;
import com.draper.itoken.sso.common.util.RedisUtil;
import com.draper.itoken.sso.common.util.RsaJwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author draper_hxy
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RsaJwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Boolean register(User user) {
        return null;
    }

    @Override
    public String login(User user) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        redisUtil.set(token, "", 1000 * 60 * 60 * 24 * 3);// 三天
        return token;
    }

}
