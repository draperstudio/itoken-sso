package com.draper.itoken.sso.util;

import lombok.extern.slf4j.Slf4j;
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
public class RsaJwtTokenUtilTest {

    private String jwts = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE1NTM2MTAxNzgzNTMsImV4cCI6MTk4NTYxMDE3OH0.qWqaydECXeMnbkYfNPe3DStQ8GOdUUuRB9EJsuTWaS-aVrRNNJW83dZdGRr-kKvyHQihsxPaqKfZZ0muT32jchnaod9UveyB2AjWSq0aueOaR-tja2mleJrbNdzH6GTCSABdovBcFMT_JosmhhZcZyX5IIvfbYZw2jbMPfNN8ZV4gJ_N7LailCLoSowXVPMi749Il616gKsEMGzyn1k4Fq4ZXqyET_oDHvM3bHSUusqUm-iIwO8CqDYh0QR6OSwgyet1fdqSIZ5KgGEkoRF9d_aLjrEzeHJHq2d57tRjuQ7mowxnCRzedcI9Jz4AgKNroq88MIJLIhbIkyP7yTM9uQ";

    @Autowired
    private RsaJwtTokenUtil rsaJwtTokenUtil;

    @Test
    public void testParse() {
        String subject = rsaJwtTokenUtil.getSubject(jwts);
        log.error("subject = {}", subject);
    }

}