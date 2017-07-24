package com.hzitshop.web.controllers;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hzitshop.entity.TbRole;
import com.hzitshop.service.ITbRoleService;
import com.hzitshop.vo.BootstrapTable;
import com.hzitshop.vo.RoleVo;
import com.hzitshop.vo.StatusVO;
import com.hzitshop.vo.TbRoleVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by xianyaoji on 2017/7/8.
 */
@Controller
public class RoleController {
    @Autowired
    private ITbRoleService iTbRoleService;

    /**
     * 获取角色信息
     * @param limit
     * @param size
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping("/role/getRoleList")
    @ResponseBody
    public BootstrapTable<TbRoleVo>  gertRoleList(int limit,int size,String roleName){
        //Page<TbRole> tbRolePage = iTbRoleService.selectPage(new Page<TbRole>(limit,size));
        Wrapper<TbRole> wrapper = null;
        if(StringUtils.isNotEmpty(roleName)){
            wrapper = new EntityWrapper<TbRole>().where("").like("role",roleName, SqlLike.RIGHT);
        }else{
            wrapper = new EntityWrapper<TbRole>();
        }
        BootstrapTable<TbRoleVo> bt = iTbRoleService.ajaxData(new Page<TbRole>(limit,size),
                wrapper);
        return bt;
    }

    /**
     * 添加角色信息
     * @param tbRole
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping("/role/addRole")
    @ResponseBody
    public StatusVO addRole(TbRole tbRole){
        tbRole.setCreateTime(new Date());
        boolean result = iTbRoleService.insert(tbRole);
        if(result){
            return new StatusVO(600,"保存成功!");
        }else{
            return new StatusVO(700,"保存失败!");
        }
    }

    /**
     * 获取编辑数据
     * @param roleId
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/role/editRole",method = RequestMethod.GET)
    @ResponseBody
    public RoleVo editRole(int roleId) throws InvocationTargetException, IllegalAccessException {
        TbRole tbRole = iTbRoleService.selectById(roleId);
        RoleVo roleVo =new RoleVo();
        BeanUtils.copyProperties(roleVo,tbRole);
        return roleVo;
    }

    /**
     * 保存修改的数据
     * @param tbRole
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value ="/role/editRole",method = RequestMethod.POST)
    @ResponseBody
    public StatusVO editRole(TbRole tbRole){
        tbRole.setUpdateTime(new Date());
        boolean result = iTbRoleService.updateById(tbRole);
        if(result){
            return new StatusVO(600,"保存成功!");
        }else{
            return new StatusVO(700,"保存失败!");
        }
    }

    /**
     * 删除数据
     * @param roleId
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping("/role/removeRole")
    @ResponseBody
    public StatusVO removeRole(int roleId){
        boolean result = iTbRoleService.deleteById(roleId);
        if(result){
            return new StatusVO(600,"删除成功!");
        }else{
            return new StatusVO(700,"删除失败!");
        }
    }
    
}
