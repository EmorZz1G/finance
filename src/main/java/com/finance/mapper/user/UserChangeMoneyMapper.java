package com.finance.mapper.user;

import com.finance.pojo.user.UserChangeMoney;
import com.finance.pojo.user.UserChangeMoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserChangeMoneyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_money
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int countByExample(UserChangeMoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_money
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int deleteByExample(UserChangeMoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_money
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_money
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int insert(UserChangeMoney record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_money
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int insertSelective(UserChangeMoney record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_money
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    List<UserChangeMoney> selectByExample(UserChangeMoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_money
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    UserChangeMoney selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_money
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserChangeMoney record, @Param("example") UserChangeMoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_money
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int updateByExample(@Param("record") UserChangeMoney record, @Param("example") UserChangeMoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_money
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int updateByPrimaryKeySelective(UserChangeMoney record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_money
     *
     * @mbggenerated Wed Jul 15 09:11:46 CST 2020
     */
    int updateByPrimaryKey(UserChangeMoney record);
}