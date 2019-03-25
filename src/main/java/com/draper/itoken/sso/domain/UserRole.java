package com.draper.itoken.sso.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author draper_hxy
 */
@Data
public class UserRole {

    @TableField("role_id")
    private Long roleId;

    @TableField("user_id")
    private Long userId;

}
