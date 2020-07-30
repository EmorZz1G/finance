package com.finance.mapper.others;

import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.FlowOfFundsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowOfFundsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_of_funds
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int countByExample(FlowOfFundsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_of_funds
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int deleteByExample(FlowOfFundsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_of_funds
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_of_funds
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int insert(FlowOfFunds record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_of_funds
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int insertSelective(FlowOfFunds record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_of_funds
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    List<FlowOfFunds> selectByExample(FlowOfFundsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_of_funds
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    FlowOfFunds selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_of_funds
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int updateByExampleSelective(@Param("record") FlowOfFunds record, @Param("example") FlowOfFundsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_of_funds
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int updateByExample(@Param("record") FlowOfFunds record, @Param("example") FlowOfFundsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_of_funds
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int updateByPrimaryKeySelective(FlowOfFunds record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_of_funds
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    int updateByPrimaryKey(FlowOfFunds record);
}