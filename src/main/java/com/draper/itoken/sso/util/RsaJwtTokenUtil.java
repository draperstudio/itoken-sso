package com.draper.itoken.sso.util;

import com.draper.itoken.core.util.RSAJWTUtil;
import com.draper.itoken.sso.domain.Const;
import com.draper.itoken.sso.domain.User;
import com.draper.itoken.sso.service.RsaService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.impl.DefaultClaims;

import java.util.Date;

/**
 * @author draper_hxy
 */
@Component
public class RsaJwtTokenUtil {

    private static final long serialVersionUID = -5625635588908941275L;

    @Autowired
    private RsaService rsaService;

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    public String getSubject(String token) {
        Jws<Claims> claims = getClaimsFromToken(token);
        return claims.getBody().getSubject();
    }

    /**
     * 获取 Token 创建时间
     */
    public Date getCreatedDateFromToken(String token) {
        Jws<Claims> claims = getClaimsFromToken(token);
        return (Date) claims.getBody().get(CLAIM_KEY_CREATED);
    }

    /**
     * 获取 Token 过期时间
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token).getBody().getExpiration();
    }

    private Jws<Claims> getClaimsFromToken(String token) {
        return RSAJWTUtil.parse(token, rsaService.getPublicKey());
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + Const.EXPIRATION_TIME * 1000);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 创建时间是否在最后一次修改密码时间之前
     */
    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public String generateToken(UserDetails userDetails) {
        Claims claims = new DefaultClaims();
        claims.setSubject(userDetails.getUsername());           // token 主体
        claims.put(CLAIM_KEY_CREATED, new Date());              // token 创建时间
        claims.setExpiration(generateExpirationDate());         // token 过期时间
        String token = RSAJWTUtil.build(claims, rsaService.getPrivateKey());
        return token;
    }


    /**
     * 是否刷新 token
     */
    public Boolean canTokenBeRefreshed(String token) {
        return !isTokenExpired(token);
    }

    public String refreshToken(String token) {
        Jws<Claims> claims = getClaimsFromToken(token);
        User user = new User();
        user.setUsername(claims.getBody().getSubject());
        String refreshedToken = generateToken(user);
        return refreshedToken;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        final String username = getSubject(token);
        return (
                username.equals(user.getUsername())
                        && !isTokenExpired(token)
        );
    }

    public Boolean validateToken(String token) {
        return isTokenExpired(token);
    }

}
