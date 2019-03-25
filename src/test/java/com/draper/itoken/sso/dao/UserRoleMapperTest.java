package com.draper.itoken.sso.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.draper.itoken.sso.domain.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author draper_hxy
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleMapperTest {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Test
    public void testSelectList() {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(UserRole::getUserId, 2L);
        List<UserRole> userRoleList = userRoleMapper.selectList(queryWrapper);
        for (UserRole userRole : userRoleList) {
            log.error(userRole.getRoleId() + "");
        }
    }

}