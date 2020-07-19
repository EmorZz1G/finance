package com.finance.mapper.admin;

import com.finance.pojo.admin.AdminPermissions;
import com.finance.pojo.admin.AdminPermissionsExample;
import java.util.List;

import com.finance.pojo.others.Permissions;
import org.apache.ibatis.annotations.Param;

public interface AdminPermissionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permissions
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    int countByExample(AdminPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permissions
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    int deleteByExample(AdminPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permissions
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permissions
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    int insert(AdminPermissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permissions
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    int insertSelective(AdminPermissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permissions
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     * @param example
     */
    List<AdminPermissions> selectByExample(Permissions example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permissions
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    AdminPermissions selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permissions
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    int updateByExampleSelective(@Param("record") AdminPermissions record, @Param("example") AdminPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permissions
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    int updateByExample(@Param("record") AdminPermissions record, @Param("example") AdminPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permissions
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    int updateByPrimaryKeySelective(AdminPermissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permissions
     *
     * @mbggenerated Wed Jul 15 08:50:20 CST 2020
     */
    int updateByPrimaryKey(AdminPermissions record);
}