package com.draper.itoken.sso.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author draper_hxy
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RsaServiceTest {

    @Autowired
    private RsaService rsaService;

    @Test
    public void getPublicKey() {
        Assert.assertEquals("RSA", rsaService.getPublicKey().getAlgorithm());
    }

    @Test
    public void getPrivateKey() {
        Assert.assertEquals("RSA", rsaService.getPrivateKey().getAlgorithm());
    }

    @Test
    public void testGetPublicKeyStr() {
        log.error(rsaService.getPublicKeyStr());
    }

    @Test
    public void testGetPrivateKeyStr() {
        log.error(rsaService.getPrivateKeyStr());
    }

}