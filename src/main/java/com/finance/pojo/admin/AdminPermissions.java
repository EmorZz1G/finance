package com.finance.pojo.admin;

public class AdminPermissions {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permissions.id
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permissions.adminId
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    private Integer adminId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permissions.permissionId
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    private Integer permissionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permissions.id
     *
     * @return the value of admin_permissions.id
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permissions.id
     *
     * @param id the value for admin_permissions.id
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permissions.adminId
     *
     * @return the value of admin_permissions.adminId
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permissions.adminId
     *
     * @param adminId the value for admin_permissions.adminId
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permissions.permissionId
     *
     * @return the value of admin_permissions.permissionId
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permissions.permissionId
     *
     * @param permissionId the value for admin_permissions.permissionId
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}