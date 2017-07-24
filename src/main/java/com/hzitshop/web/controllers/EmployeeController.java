package com.hzitshop.web.controllers;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hzitshop.entity.EmployeeInfo;
import com.hzitshop.entity.TbDict;
import com.hzitshop.service.IEmployeeInfoService;
import com.hzitshop.service.ITbDictService;
import com.hzitshop.util.Md5Util;
import com.hzitshop.vo.StatusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xianyaoji on 2017/6/28.
 */
@CrossOrigin(maxAge = 3600)
@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeInfoService ei;
    @Autowired
    private ITbDictService ds;
    /**
     * 用户数据分页
     * @param limit 传入第几页数据
     * @param size 每页多少条数据
     * @return  返回的是分页结果
     */
    @CrossOrigin("*")
    @RequestMapping("/employee/getEmployeeList")
    @ResponseBody
    public Page<EmployeeInfo> getEmployeeList(int limit,int size){
        Page<EmployeeInfo> page=  ei.selectPage(new Page<>(limit,size));
        return page;
    }

    /**
     * 根据用户编号删除数据
     * @param userId
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping("/employee/removeEmployee")
    @ResponseBody
    public StatusVO removeEmployee(int userId){
        boolean result = ei.deleteById(userId);
        if(result){
            return new StatusVO(600,"删除成功!");
        }else{
            return new StatusVO(700,"删除失败!");
        }
    }

    /**
     * 处理添加用户表单
     * @param employeeInfo
     * @return
     * @throws Exception
     */
    @CrossOrigin("*")
    @RequestMapping("/employee/addEmployee")
    @ResponseBody
    public  StatusVO  addEmployee(EmployeeInfo employeeInfo) throws Exception {
        employeeInfo.setPassword(Md5Util.getMD5(Md5Util.getMD5("hzit#123456")));
        boolean  result = ei.insert(employeeInfo);
        if(result){
            return new StatusVO(600,"添加成功!");
        }else{
            return new StatusVO(700,"添加失败!");
        }
    }

    /**
     * 获取公司信息
     * @return返回json格式的所有公司的数据
     */
    @CrossOrigin("*")
    @RequestMapping("/employee/getCompany")
    @ResponseBody
    public List<TbDict> getCompany(){
        List<TbDict> tbDictList  = ds.selectList(new EntityWrapper<TbDict>().where("pid =35"));
        return tbDictList;
    }

    /**
     * 获取部门信息
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping("/employee/getDept")
    @ResponseBody
    public List<TbDict> getDept(){
        List<TbDict>tbDictList = ds.selectList(new EntityWrapper<TbDict>().where("pid=53"));
        return tbDictList;
    }

    /**
     * 根据id获取要修改的数据
     * @param userId
     * @return
     */
   @CrossOrigin("*")
   @RequestMapping(value = "/employee/editEmployee",method = RequestMethod.GET)
   @ResponseBody
    public EmployeeInfo editEmplpoyee(int userId){
       EmployeeInfo employeeInfo = ei.selectById(userId);
       employeeInfo.setCreateTime(null);
       employeeInfo.setUpdateTime(null);
       employeeInfo.setPassword(null);
       return employeeInfo;
    }

    /**
     * 保存要修改的数据
     * @param employeeInfo
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value="/employee/editEmployee",method = RequestMethod.POST)
    @ResponseBody
     public  StatusVO editEmployee(EmployeeInfo employeeInfo){
        boolean result = ei.updateById(employeeInfo);
        if(result){
            return new StatusVO(600,"修改成功!");
        }else{
            return new StatusVO(700,"修改失败!");
        }
     }
}
