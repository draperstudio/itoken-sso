package com.draper.itoken.sso.dao;


import com.draper.itoken.sso.domain.Rsa;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;

/**
 * @author draper_hxy
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RsaMapperTest {

    @Autowired
    private RsaMapper rsaMapper;

    @Test
    public void testInsert() {
        Rsa rsa = new Rsa();
        Long dateTime = System.currentTimeMillis();
        rsa.setCreateAt(dateTime);
        rsa.setUpdateAt(dateTime);

        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);

        String publicKeyStr = new String(Base64.encode(keyPair.getPublic().getEncoded()));
        String privateKeyStr = new String(Base64.encode(keyPair.getPrivate().getEncoded()));
        log.error("publicKeyStr length = {}, value = {}", publicKeyStr.length(), publicKeyStr);
        log.error("privateKeyStr length = {}, value = {}", privateKeyStr.length(), privateKeyStr);

        rsa.setPublicKeyStr(publicKeyStr);
        rsa.setPrivateKeyStr(privateKeyStr);

        rsaMapper.insert(rsa);
    }

    @Test
    public void testSelect() {
        Rsa rsa = rsaMapper.selectById(1L);
        String publicKeyStr = rsa.getPublicKeyStr();
        String privateKeyStr = rsa.getPrivateKeyStr();
        log.error("publicKeyStr length = {}, value = {}", publicKeyStr.length(), publicKeyStr);
        log.error("privateKeyStr length = {}, value = {}", privateKeyStr.length(), privateKeyStr);
    }


}