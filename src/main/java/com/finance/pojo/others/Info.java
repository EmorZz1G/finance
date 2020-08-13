package com.finance.pojo.others;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.user.User;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Emor
 * @since 2020-08-12
 */
public class Info implements Serializable {

    private static final long serialVersionUID=1L;
    @TableField(exist = false)
    private Admin admin;

    @Override
    public String toString() {
        return "Info{" +
                "admin=" + admin +
                ", id=" + id +
                ", sendId=" + sendId +
                ", receiveId=" + receiveId +
                ", createTime=" + createTime +
                ", title='" + title + '\'' +
                ", infoDesc='" + infoDesc + '\'' +
                ", status=" + status +
                ", infocol='" + infocol + '\'' +
                '}';
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


    /**
     * 消息编号 主键自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 消息发送者id（admin）
     */
    @TableField("sendId")
    private Integer sendId;

    /**
     * 消息接收者id（user）
     */
    @TableField("receiveId")
    private Integer receiveId;

    /**
     * 消息创建时间
     */
    @TableField("createTime")
    private LocalDate createTime;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    @TableField("infoDesc")
    private String infoDesc;

    /**
     * 消息状态（0：未读  1：已读 2：假删除）
     */
    private Integer status;

    private String infocol;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfoDesc() {
        return infoDesc;
    }

    public void setInfoDesc(String infoDesc) {
        this.infoDesc = infoDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInfocol() {
        return infocol;
    }

    public void setInfocol(String infocol) {
        this.infocol = infocol;
    }

}
