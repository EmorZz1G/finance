package com.finance.controller.admin.finance;

import com.finance.common.Result;
import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.others.FundProduct;
import com.finance.service.admin.finance.FundProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FundProductController {
    @Autowired
    FundProductService fundProductService;

    /**
     * 去基金理财管理页面，查询基金理财信息
     *
     * @param pageNum  页数
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping("/admin/finance/toFundProduct.html")
    public ModelAndView toFundProduct(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "5") int pageSize

    ) {
        ModelAndView modelAndView = new ModelAndView("admin/finance/fundproduct.html");
        PageHelper.startPage(pageNum, pageSize);
        List<FundProduct> financeList = fundProductService.selectFundProductAll();
        PageInfo<FundProduct> pageInfo = new PageInfo<FundProduct>(financeList);
        modelAndView.addObject("financePageInfo", pageInfo);
        modelAndView.addObject("financeList", financeList);

        return modelAndView;

    }

    @PostMapping("/admin/addFundProduct")
    @ResponseBody
    public Result addFundProduct(FundProduct fundProduct) {
        int i = fundProductService.insertFundProduct(fundProduct);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }

    @GetMapping("/admin/getFundProductInfoById/{id}")
    @ResponseBody
    public Result getFundProductById(@PathVariable("id") int id) {
        FundProduct fundProduct = fundProductService.selectFundProductById(id);
        Result result = Result.success().add("fundProduct", fundProduct);
        return result;
    }

    @PutMapping("/admin/updateFundProduct/{id}")
    @ResponseBody
    public Result updateFundProduct(@PathVariable("id") int id, FundProduct fundProduct) {
        fundProduct.setId(id);
        int i = fundProductService.updateFundProduct(fundProduct);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }

    @DeleteMapping("/admin/deleteFundProductById/{id}")
    @ResponseBody
    public Result deleteFundProductById(@PathVariable("id") int id) {
        int i = fundProductService.deleteFundProductById(id);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }
}
