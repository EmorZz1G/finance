package com.finance.mapper.others;

import com.finance.pojo.others.Bank;
import com.finance.pojo.others.BankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int countByExample(BankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int deleteByExample(BankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int insert(Bank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int insertSelective(Bank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    List<Bank> selectByExample(BankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    Bank selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int updateByExampleSelective(@Param("record") Bank record, @Param("example") BankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int updateByExample(@Param("record") Bank record, @Param("example") BankExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int updateByPrimaryKeySelective(Bank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bank
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int updateByPrimaryKey(Bank record);
}