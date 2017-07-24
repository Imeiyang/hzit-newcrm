package com.hzitshop.web.controllers;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hzitshop.entity.CustomerInfo;
import com.hzitshop.service.ICustomerInfoService;
import com.hzitshop.vo.BootstrapTable;
import com.hzitshop.vo.CustomerInfoVo;
import com.hzitshop.vo.StatusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xianyaoji on 2017/7/16.
 */
@Controller
public class CustomerController {
     @Autowired
     private ICustomerInfoService iCustomerInfoService;
    /**
     * 获取客户信息
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping("/customer/getData")
    @ResponseBody
    public BootstrapTable<CustomerInfoVo> getData(int offset,int limit){
        return iCustomerInfoService.ajaxData(new Page<>(offset,limit),new EntityWrapper<CustomerInfo>().where("isDelete=0"));

    }
    @CrossOrigin("*")
    @RequestMapping("/customer/hideData")
    @ResponseBody
    public StatusVO hidenData(int customerId){
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerId(customerId);
        customerInfo.setIsDelete(1);
        boolean result=iCustomerInfoService.updateById(customerInfo);
        StatusVO statusVO = null;
        if(result){
             statusVO = new StatusVO(600,"删除成功!");
        }else{
            statusVO = new StatusVO(700,"删除失败!");
        }

        return  statusVO;
    }
}
