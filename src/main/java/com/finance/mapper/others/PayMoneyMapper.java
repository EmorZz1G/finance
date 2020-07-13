package com.finance.mapper.others;


import java.util.List;

import com.finance.pojo.others.PayMoney;
import com.finance.pojo.others.PayMoneyExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PayMoneyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_money
     *
     * @mbggenerated Mon Jul 13 11:22:28 CST 2020
     */
    int countByExample(PayMoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_money
     *
     * @mbggenerated Mon Jul 13 11:22:28 CST 2020
     */
    int deleteByExample(PayMoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_money
     *
     * @mbggenerated Mon Jul 13 11:22:28 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_money
     *
     * @mbggenerated Mon Jul 13 11:22:28 CST 2020
     */
    int insert(PayMoney record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_money
     *
     * @mbggenerated Mon Jul 13 11:22:28 CST 2020
     */
    int insertSelective(PayMoney record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_money
     *
     * @mbggenerated Mon Jul 13 11:22:28 CST 2020
     */
    List<PayMoney> selectByExample(PayMoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_money
     *
     * @mbggenerated Mon Jul 13 11:22:28 CST 2020
     */
    PayMoney selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_money
     *
     * @mbggenerated Mon Jul 13 11:22:28 CST 2020
     */
    int updateByExampleSelective(@Param("record") PayMoney record, @Param("example") PayMoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_money
     *
     * @mbggenerated Mon Jul 13 11:22:28 CST 2020
     */
    int updateByExample(@Param("record") PayMoney record, @Param("example") PayMoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_money
     *
     * @mbggenerated Mon Jul 13 11:22:28 CST 2020
     */
    int updateByPrimaryKeySelective(PayMoney record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_money
     *
     * @mbggenerated Mon Jul 13 11:22:28 CST 2020
     */
    int updateByPrimaryKey(PayMoney record);
}