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
public class AdminPermsView implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 权限id 主键自增
     */
    private Integer id;

    /**
     * 管理员id
     */
    @TableField("adminId")
    private Integer adminId;

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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "AdminPermsView{" +
        "id=" + id +
        ", adminId=" + adminId +
        ", permission=" + permission +
        "}";
    }
}
