package com.draper.itoken.sso.service;

import com.draper.itoken.sso.domain.User;

/**
 * @author draper_hxy
 */
public interface AuthService {

    Boolean register(User user);

    String login(User user);

}
