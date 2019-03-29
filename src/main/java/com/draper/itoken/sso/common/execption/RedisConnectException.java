package com.draper.itoken.sso.common.execption;

/**
 * @author draper_hxy
 */
public class RedisConnectException extends Exception {

    private static final long serialVersionUID = 1L;

    public RedisConnectException(String message) {
        super(message);
    }

}