package com.draper.itoken.sso.dao;

import com.draper.itoken.sso.domain.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
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
public class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testSelectListByUserId(){
        List<Role> roleList = roleMapper.selectListByUserId(2L);
        Assert.assertEquals(2, roleList.size());
    }

}