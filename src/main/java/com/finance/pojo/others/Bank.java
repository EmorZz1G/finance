package com.finance.pojo.others;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Emor
 * @since 2020-08-12
 */
public class Bank implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 银行 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 银行名称
     */
    private String name;

    /**
     * 银行类型
     */
    private String type;

    /**
     * 资产
     */
    private String assets;

    /**
     * 银行描述
     */
    @TableField("bankDesc")
    private String bankDesc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }

    public String getBankDesc() {
        return bankDesc;
    }

    public void setBankDesc(String bankDesc) {
        this.bankDesc = bankDesc;
    }

    @Override
    public String toString() {
        return "Bank{" +
        "id=" + id +
        ", name=" + name +
        ", type=" + type +
        ", assets=" + assets +
        ", bankDesc=" + bankDesc +
        "}";
    }
}
