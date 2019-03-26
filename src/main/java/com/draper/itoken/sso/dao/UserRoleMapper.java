package com.draper.itoken.sso.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.draper.itoken.sso.domain.Role;
import com.draper.itoken.sso.domain.UserRole;

import java.util.List;

/**
 * @author draper_hxy
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<Role> selectListByUserId(Long userId);

}
