package com.finance.pojo.perms;

import java.io.Serializable;

public class UserPermsView implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_perms_view.id
     *
     * @mbg.generated Thu Jul 16 18:32:04 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_perms_view.userId
     *
     * @mbg.generated Thu Jul 16 18:32:04 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_perms_view.permission
     *
     * @mbg.generated Thu Jul 16 18:32:04 CST 2020
     */
    private String permission;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_perms_view.id
     *
     * @return the value of user_perms_view.id
     *
     * @mbg.generated Thu Jul 16 18:32:04 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_perms_view.id
     *
     * @param id the value for user_perms_view.id
     *
     * @mbg.generated Thu Jul 16 18:32:04 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_perms_view.userId
     *
     * @return the value of user_perms_view.userId
     *
     * @mbg.generated Thu Jul 16 18:32:04 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_perms_view.userId
     *
     * @param userId the value for user_perms_view.userId
     *
     * @mbg.generated Thu Jul 16 18:32:04 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_perms_view.permission
     *
     * @return the value of user_perms_view.permission
     *
     * @mbg.generated Thu Jul 16 18:32:04 CST 2020
     */
    public String getPermission() {
        return permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_perms_view.permission
     *
     * @param permission the value for user_perms_view.permission
     *
     * @mbg.generated Thu Jul 16 18:32:04 CST 2020
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }
}