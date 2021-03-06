package com.finance.mapper.user;

import com.finance.pojo.user.UserPermissions;
import com.finance.pojo.user.UserPermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPermissionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_permissions
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int countByExample(UserPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_permissions
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int deleteByExample(UserPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_permissions
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_permissions
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int insert(UserPermissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_permissions
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int insertSelective(UserPermissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_permissions
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    List<UserPermissions> selectByExample(UserPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_permissions
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    UserPermissions selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_permissions
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserPermissions record, @Param("example") UserPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_permissions
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int updateByExample(@Param("record") UserPermissions record, @Param("example") UserPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_permissions
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int updateByPrimaryKeySelective(UserPermissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_permissions
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int updateByPrimaryKey(UserPermissions record);
}