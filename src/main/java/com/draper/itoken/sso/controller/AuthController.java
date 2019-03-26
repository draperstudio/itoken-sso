package com.draper.itoken.sso.controller;

import com.draper.itoken.core.entity.dto.Response;
import com.draper.itoken.core.util.JWTUtil;
import com.draper.itoken.sso.domain.User;
import com.draper.itoken.sso.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author draper_hxy
 */
@Slf4j
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/api/sso/login", method = RequestMethod.POST)
    public Response login(@RequestBody User user) {
        log.error("/api/sso/login POST username = {}", user.getUsername());
        String token = authService.login(user);
        return new Response(200, "OK", token);
    }

    @RequestMapping(value = "/api/sso/verify", method = RequestMethod.POST)
    public Response verify() {
        return new Response(200, "OK", null);
    }

    @RequestMapping(value = "/login/{account}", method = RequestMethod.POST)
    public Response login(@PathVariable String account, @RequestBody String password) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", account);
        String jwts = JWTUtil.buildJwts(claims, System.currentTimeMillis() + 1000 * 60 * 60);
        return new Response(200, "OK", jwts);
    }

}
