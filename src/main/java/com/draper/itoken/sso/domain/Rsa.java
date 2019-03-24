package com.draper.itoken.sso.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author draper_hxy
 */
@Data
public class Rsa {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("create_at")
    private Long createAt;

    @TableField("update_at")
    private Long updateAt;

    @TableField("public_key_str")
    private String publicKeyStr;

    @TableField("private_key_str")
    private String privateKeyStr;

}
