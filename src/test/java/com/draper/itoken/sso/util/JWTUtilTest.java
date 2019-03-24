package com.draper.itoken.sso.util;

import com.draper.itoken.core.util.JWTUtil;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Assert;
import org.junit.Test;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;


/**
 * @author draper_hxy
 */
@Slf4j
public class JWTUtilTest {

    @Test
    public void testJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", "Draper");
        String jwts = JWTUtil.buildJwts(claims, System.currentTimeMillis() + 1000 * 60 * 60);
        System.out.println(jwts);
        Assert.assertEquals(true, JWTUtil.verifyJwts(jwts));
        Assert.assertEquals("Draper", JWTUtil.get("sub", jwts));
    }

    @Test
    public void testVerify() {
        String jwts = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJEcmFwZXIiLCJleHAiOjE1NTMxMzkzNjR9.ALevZDvXkkxnRokZvzrBsczL3M34z1hqSd7QXx_dYwH8QwVrp4Ozsu5BeC7SL-0PyBTpKoOQzAosVF-gvwTRTg";

        Assert.assertEquals(true, JWTUtil.verifyJwts(jwts));
    }

    @Test
    public void testKey() {
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
        byte[] privateBytes = keyPair.getPrivate().getEncoded();
        System.out.println(new String(Base64.encode(privateBytes)));
        byte[] publicBytes = keyPair.getPublic().getEncoded();
        System.out.println(new String(Base64.encode(publicBytes)));
    }

}