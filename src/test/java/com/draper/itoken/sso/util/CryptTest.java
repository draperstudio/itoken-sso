package com.draper.itoken.sso.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author draper_hxy
 */
@Slf4j
public class CryptTest {

    @Test
    public void testGenerate() {
        String password = "user";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        log.info(encodedPassword);
    }

}
