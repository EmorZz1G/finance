package com.finance.service.impl.user.userinfo;

import com.finance.common.utils.FuzzySearchUtils;
import com.finance.mapper.ext.others.BankcardMapperExt;
import com.finance.mapper.others.BankcardMapper;
import com.finance.mapper.user.UserMapper;
import com.finance.pojo.others.Bankcard;
import com.finance.pojo.others.BankcardExample;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.user.userinfo.BankcardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class BankcardServiceImpl implements BankcardService {

    @Resource
    BankcardMapper bankcardMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    BankcardMapperExt bankcardMapperExt;

    @Override
    public List<Bankcard> selectBankCards() {
        return bankcardMapper.selectByExample(null);
    }

    @Override
    public Bankcard getBankCardById(int id) {
        return bankcardMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateBankCard(Bankcard bankcard) {
        return bankcardMapper.updateByPrimaryKeySelective(bankcard);
    }

    @Override
    public int deleteBankCardById(int id) {
        return bankcardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Bankcard> selectUsersByQuery(Map<String, Object> query) {
        try {
            /*BankcardExample example = (BankcardExample) FuzzySearchUtils.autoWrapper(BankcardExample.class, query);
            List<Bankcard> bankcards = bankcardMapper.selectByExample(example);*/
            return bankcardMapperExt.selectBankcardsFuzzy((String)query.get("username"),(String)query.get("cardBank"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User selectUserByUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        if(userList==null||userList.size()<=0){
            return null;
        }else {
            return userList.get(0);
        }
    }
}
