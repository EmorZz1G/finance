package com.finance.mapper.ext.others;

import com.finance.mapper.others.BankcardMapper;
import com.finance.pojo.others.Bankcard;
import com.finance.pojo.user.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BankcardMapperExt extends BankcardMapper {


    @Select("SELECT\n" +
            "\tid, cardBank, type, cardNum, userId \n" +
            "FROM\n" +
            "\tbankcard \n" +
            "WHERE\n" +
            "\tEXISTS ( SELECT * FROM `user` WHERE `user`.username LIKE concat('%',#{username},'%') AND `user`.id = bankcard.userId ) \n" +
            "\tAND bankcard.cardBank LIKE concat('%',#{cardBank},'%')")
    @Results(id = "bankMapperhehe", value = {
            @Result(column = "userId",
                    javaType = User.class,
                    property = "user",
            one = @One(select = "com.finance.mapper.user.UserMapper.selectByPrimaryKey"))
    })
    List<Bankcard> selectBankcardsFuzzy(String username, String cardBank);
}
