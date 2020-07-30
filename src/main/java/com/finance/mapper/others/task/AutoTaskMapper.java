package com.finance.mapper.others.task;

import com.finance.pojo.others.task.AutoTask;
import com.finance.pojo.others.task.AutoTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoTaskMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_task
     *
     * @mbg.generated Mon Jul 20 13:13:58 CST 2020
     */
    long countByExample(AutoTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_task
     *
     * @mbg.generated Mon Jul 20 13:13:58 CST 2020
     */
    int deleteByExample(AutoTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_task
     *
     * @mbg.generated Mon Jul 20 13:13:58 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_task
     *
     * @mbg.generated Mon Jul 20 13:13:58 CST 2020
     */
    int insert(AutoTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_task
     *
     * @mbg.generated Mon Jul 20 13:13:58 CST 2020
     */
    int insertSelective(AutoTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_task
     *
     * @mbg.generated Mon Jul 20 13:13:58 CST 2020
     */
    List<AutoTask> selectByExample(AutoTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_task
     *
     * @mbg.generated Mon Jul 20 13:13:58 CST 2020
     */
    AutoTask selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_task
     *
     * @mbg.generated Mon Jul 20 13:13:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") AutoTask record, @Param("example") AutoTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_task
     *
     * @mbg.generated Mon Jul 20 13:13:58 CST 2020
     */
    int updateByExample(@Param("record") AutoTask record, @Param("example") AutoTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_task
     *
     * @mbg.generated Mon Jul 20 13:13:58 CST 2020
     */
    int updateByPrimaryKeySelective(AutoTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_task
     *
     * @mbg.generated Mon Jul 20 13:13:58 CST 2020
     */
    int updateByPrimaryKey(AutoTask record);
}