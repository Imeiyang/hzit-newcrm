package com.hzitshop.web.controllers;

import com.hzitshop.entity.EmployeeInfo;
import com.hzitshop.util.ErrorFieldUtill;
import com.hzitshop.vo.EmployeeInfoVo;
import com.hzitshop.vo.StatusVO;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xianyaoji on 2017/7/14.
 */
@Controller
public class AccountController {

    @CrossOrigin("*")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public StatusVO login(@Validated  EmployeeInfoVo ei, BindingResult result){
        /*if()
        return null;*/
        StatusVO sv = new StatusVO();
        if(result.hasFieldErrors()){
            sv.setCode(700);
            sv.setMsg(ErrorFieldUtill.error(result.getFieldErrors()));
        }else {
            AuthenticationToken token = new UsernamePasswordToken(ei.getName(),ei.getPassword());
           try{
               SecurityUtils.getSubject().login(token);
               sv.setCode(600);
               sv.setMsg("登录成功!");
           }catch (Exception e){
                  sv.setCode(700);
                  sv.setMsg("登录失败!");
           }
        }
        return sv;
    }
}
