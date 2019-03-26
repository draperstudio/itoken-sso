package com.draper.itoken.sso.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.draper.itoken.sso.domain.Role;

import java.util.List;

/**
 * @author draper_hxy
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectListByUserId(Long userId);

}
