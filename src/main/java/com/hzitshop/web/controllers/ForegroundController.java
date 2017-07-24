package com.hzitshop.web.controllers;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hzitshop.entity.CustomerInfo;
import com.hzitshop.entity.EmployeeInfo;
import com.hzitshop.entity.TbDict;
import com.hzitshop.service.ICustomerInfoService;
import com.hzitshop.service.IEmployeeInfoService;
import com.hzitshop.service.ITbDictService;
import com.hzitshop.vo.CustomerInfoVo;
import com.hzitshop.vo.EmployeeInfoVo;
import com.hzitshop.vo.StatusVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     前台控制器
 * </p>
 * Created by xianyaoji on 2017/3/2.
 */
@CrossOrigin(maxAge = 3600)
@Controller
public class ForegroundController {

    @Autowired
    private IEmployeeInfoService iEmployeeInfoService;
    @Autowired
    private ICustomerInfoService iCustomerInfoService;

    @Autowired
    private ITbDictService iTbDictService;

    private Logger logger = LoggerFactory.getLogger(ForegroundController.class);


    /**
     * 获取咨询师数据
     * 接受请求参数:companyId
     * 根据id获取咨询师数据
     * @return
     */

    @CrossOrigin("*")
    @RequestMapping("/foreground/consultantData")
    @ResponseBody
    protected List<EmployeeInfoVo> consultantData(EmployeeInfo employeeInfo){
       List<EmployeeInfoVo> bt = iEmployeeInfoService.consultantData(employeeInfo);
        return bt;
    }

    /**
     * 前台保存数据
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/foreground/saveUser",method = RequestMethod.POST)
    @ResponseBody
    public StatusVO saveUser(CustomerInfo customerInfo){
        customerInfo.setCreateTime(new Date());
        boolean result= iCustomerInfoService.insert(customerInfo);
        if(result){
            return new StatusVO(600,"数据保存成功");
        }else{
           return new StatusVO(700,"数据保存失败");
        }
    }

    /**
     * 获取当天学员等待信息
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value="/forground/getCurrentData",method = RequestMethod.GET)
    @ResponseBody
    public  List<CustomerInfoVo> getCurentData(CustomerInfo ci,EmployeeInfo ei){
        List<CustomerInfoVo> customerInfoVoList = iCustomerInfoService.customerInfoWaitList(ci,ei);
        return customerInfoVoList;
    }

    /**
     * 前台修改学员信息
     * 根据用户名和当前日期到数据库中查询数据
     * 返回这个面试者的信息
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/forground/editCustomer",method = RequestMethod.GET)
    @ResponseBody
    public  CustomerInfo editCustomerInfo(String realName){
        CustomerInfo ci  = iCustomerInfoService.selectOne(new EntityWrapper<CustomerInfo>().where("real_name='"+realName+"'")
        .and(" to_days(create_time)= to_days(now())"));
        return ci;
    }

    /**
     * 保存修改的面试者信息
     * @param ci   需要传入面试者姓名,性别,手机号码,咨询师id
     * @return 返回修改的结果
     */
    @RequestMapping(value="/forground/editCustomer",method=RequestMethod.POST)
    @ResponseBody
    public StatusVO  editCustomerInfo(CustomerInfo ci){
        boolean result = iCustomerInfoService.updateById(ci);
        if(result){
            return new StatusVO(600,"修改成功!");
        } else{
            return new StatusVO(700,"修改失败!");
        }
    }


    
    

    

   


    
}
