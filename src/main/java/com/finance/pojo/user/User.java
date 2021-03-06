package com.finance.pojo.user;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.realname
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    private String realname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.IDcard
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    private String IDcard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", IDcard='" + IDcard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", paypwd=" + paypwd +
                ", status=" + status +
                ", reputation='" + reputation + '\'' +
                '}';
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.paypwd
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    private Integer paypwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.status
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.reputation
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    private String reputation;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.realname
     *
     * @return the value of user.realname
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.realname
     *
     * @param realname the value for user.realname
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.IDcard
     *
     * @return the value of user.IDcard
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public String getIDcard() {
        return IDcard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.IDcard
     *
     * @param IDcard the value for user.IDcard
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone
     *
     * @return the value of user.phone
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone
     *
     * @param phone the value for user.phone
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.paypwd
     *
     * @return the value of user.paypwd
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public Integer getPaypwd() {
        return paypwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.paypwd
     *
     * @param paypwd the value for user.paypwd
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public void setPaypwd(Integer paypwd) {
        this.paypwd = paypwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.status
     *
     * @return the value of user.status
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.status
     *
     * @param status the value for user.status
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.reputation
     *
     * @return the value of user.reputation
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public String getReputation() {
        return reputation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.reputation
     *
     * @param reputation the value for user.reputation
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    public void setReputation(String reputation) {
        this.reputation = reputation;
    }
}