package com.finance.pojo.perms;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Emor
 * @since 2020-08-12
 */
public class UserPermsView implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 权限id 主键自增
     */
    private Integer id;

    /**
     * 用户id
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 权限描述
     */
    private String permission;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "UserPermsView{" +
        "id=" + id +
        ", userId=" + userId +
        ", permission=" + permission +
        "}";
    }
}
