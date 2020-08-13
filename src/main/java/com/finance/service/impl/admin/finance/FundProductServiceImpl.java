package com.finance.service.impl.admin.finance;

import com.finance.mapper.others.ChangeMoneyMapper;
import com.finance.mapper.others.FundProductMapper;
import com.finance.mapper.plus.others.FundProductMapperPlus;
import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.others.FundProduct;
import com.finance.service.admin.finance.FundProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FundProductServiceImpl implements FundProductService {
    @Resource
    private FundProductMapper fundProductMapper;

    @Resource
    private FundProductMapperPlus fundProductMapperPlus;

    /**
     * 查询所有基金理财信息
     *
     * @return
     */
    @Override
    public List<FundProduct> selectFundProductAll() {
        /*return fundProductMapper.selectByExample(null);*/
        return fundProductMapperPlus.selectList(null);
    }

    /**
     * 插入基金理财信息
     *
     * @param fundProduct
     * @return
     */
    @Override
    public int insertFundProduct(FundProduct fundProduct) {
//        return fundProductMapper.insertSelective(fundProduct);/**/
        return fundProductMapperPlus.insert(fundProduct);
    }

    /**
     * 根据基金理财id查询基金理财信息
     *
     * @param id 基金理财id
     * @return
     */
    @Override
    public FundProduct selectFundProductById(int id) {
//        return fundProductMapper.selectByPrimaryKey(id);
        return fundProductMapperPlus.selectById(id);
    }

    /**
     * 更新基金理财信息
     *
     * @param fundProduct 基金理财实体类
     * @return
     */
    @Override
    public int updateFundProduct(FundProduct fundProduct) {
//        return fundProductMapper.updateByPrimaryKeySelective(fundProduct);
        return fundProductMapperPlus.updateById(fundProduct);
    }

    /**
     * 根据基金理财id删除基金理财信息
     *
     * @param id 基金理财id
     * @return
     */
    @Override
    public int deleteFundProductById(int id) {
//        return fundProductMapper.deleteByPrimaryKey(id);
        return fundProductMapperPlus.deleteById(id);
    }
}
