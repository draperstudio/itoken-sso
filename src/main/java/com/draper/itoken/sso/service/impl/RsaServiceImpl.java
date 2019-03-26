package com.draper.itoken.sso.service.impl;

import com.draper.itoken.core.util.RSAUtil;
import com.draper.itoken.sso.dao.RsaMapper;
import com.draper.itoken.sso.domain.Rsa;
import com.draper.itoken.sso.service.RsaService;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author draper_hxy
 */
@Slf4j
@Service
public class RsaServiceImpl implements RsaService {

    @Resource
    private RsaMapper rsaMapper;

    private static KeyPair keyPair;

    @Override
    public PublicKey getPublicKey() {
        if (keyPair == null) {
            keyPair = selectKeyPairFromDb(1L);
            return keyPair.getPublic();
        } else {
            return keyPair.getPublic();
        }
    }

    @Override
    public PrivateKey getPrivateKey() {
        if (keyPair == null) {
            keyPair = selectKeyPairFromDb(1L);
            return keyPair.getPrivate();
        } else {
            return keyPair.getPrivate();
        }
    }

    public String getPublicKeyStr() {
        if (keyPair == null){
            keyPair = selectKeyPairFromDb(1L);
            return keyToString(keyPair.getPublic());
        } else {
            return keyToString(keyPair.getPublic());
        }
    }

    public String getPrivateKeyStr() {
        if (keyPair == null){
            keyPair = selectKeyPairFromDb(1L);
            return keyToString(keyPair.getPrivate());
        } else {
            return keyToString(keyPair.getPrivate());
        }
    }

    @Override
    public Boolean modifyPublicKey(PublicKey publicKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Boolean modifyPrivateKey(PrivateKey privateKey) {
        throw new UnsupportedOperationException();
    }

    private KeyPair selectKeyPairFromDb(Long id) {
        log.trace("select keypair from db, id = {}", id);
        Rsa rsa = rsaMapper.selectById(id);
        byte[] publicBytes = Base64.decode(rsa.getPublicKeyStr().getBytes());
        byte[] privateBytes = Base64.decode(rsa.getPrivateKeyStr().getBytes());
        PublicKey publicKey = RSAUtil.getPublicKey(publicBytes);
        PrivateKey privateKey = RSAUtil.getPrivateKey(privateBytes);
        keyPair = new KeyPair(publicKey, privateKey);
        return keyPair;
    }

    private String keyToString(Key key){
        byte[] keyBytes = key.getEncoded();
        return new String(Base64.encode(keyBytes));
    }

}
