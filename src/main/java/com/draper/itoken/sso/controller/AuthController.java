package com.draper.itoken.sso.controller;

import com.draper.itoken.core.entity.dto.Response;
import com.draper.itoken.core.util.JWTUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author draper_hxy
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/api/sso/login", method = RequestMethod.POST)
    public Response login(Map<String, Object> params) {
        String sub = params.get("sub").toString();
        String url = params.get("url").toString();
        Long expireTime = Long.valueOf(params.get("expireTime").toString());

        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", sub);
        claims.put("url", url);
        String jwts = JWTUtil.buildJwts(params, expireTime);
        return new Response(200, "OK", jwts);
    }

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
