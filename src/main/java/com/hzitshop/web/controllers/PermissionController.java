package com.hzitshop.web.controllers;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hzitshop.entity.TbMenuApp;
import com.hzitshop.service.ITbMenuAppService;
import com.hzitshop.service.PermissionService;
import com.hzitshop.vo.VueTree;
import com.hzitshop.vo.menuapp.MenuApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianyaoji on 2017/7/9.
 */
@Controller
public class PermissionController {
    @Autowired
    private PermissionService ps;
    @Autowired
    private ITbMenuAppService iTbMenuAppService;
    @CrossOrigin("*")
    @RequestMapping(value = "/permission/getTree")
    @ResponseBody
    public List<VueTree> getTree(){
        VueTree vt = ps.getTree();
        List<VueTree> list = new ArrayList<>();
        list.add(vt);
        return list;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/permission/getMenuApp")
    @ResponseBody
    public List<MenuApp> getMenuApp(){
         List<MenuApp> menuAppList = iTbMenuAppService.selectMenuApp();
         return menuAppList;
    }
    @CrossOrigin("*")
    @RequestMapping("/permission/getSubPermission")
    @ResponseBody
    public List<TbMenuApp> getSubPermission(){
        return iTbMenuAppService.selectList(new EntityWrapper<TbMenuApp>().where("pId=13"));
    }

}
