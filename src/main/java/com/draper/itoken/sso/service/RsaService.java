package com.draper.itoken.sso.service;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author draper_hxy
 */
public interface RsaService {

    PublicKey getPublicKey();

    PrivateKey getPrivateKey();

    String getPublicKeyStr();

    String getPrivateKeyStr();

    Boolean modifyPublicKey(PublicKey publicKey);

    Boolean modifyPrivateKey(PrivateKey privateKey);

}
