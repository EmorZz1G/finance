package com.finance.pojo.user;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Emor
 * @since 2020-08-12
 */
public class UserAvatar implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "uuid",type = IdType.INPUT)
    private String uuid;

    @TableField("userId")
    private Integer userId;

    private String avatar;

    @TableField("createTime")
    private LocalDateTime createTime;

    @TableField("lastUseTime")
    private LocalDateTime lastUseTime;

    private String status;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastUseTime() {
        return lastUseTime;
    }

    public void setLastUseTime(LocalDateTime lastUseTime) {
        this.lastUseTime = lastUseTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserAvatar{" +
        "uuid=" + uuid +
        ", userId=" + userId +
        ", avatar=" + avatar +
        ", createTime=" + createTime +
        ", lastUseTime=" + lastUseTime +
        ", status=" + status +
        "}";
    }
}
