package com.draper.itoken.sso.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.draper.itoken.sso.domain.User;

/**
 * @author draper_hxy
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByUserName(String userName);

}
