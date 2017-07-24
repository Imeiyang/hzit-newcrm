package com.hzitshop.service.impl2;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hzitshop.entity.TbMenu;
import com.hzitshop.entity.TbMenuApp;
import com.hzitshop.mapper.TbMenuAppMapper;
import com.hzitshop.service.PermissionService;
import com.hzitshop.vo.VueTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianyaoji on 2017/7/9.
 */
@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    private TbMenuAppMapper tbMenuAppMapper;
    @Override
    public VueTree getTree() {
        VueTree vt = new VueTree();
        TbMenuApp tbMenuApp = tbMenuAppMapper.selectById(13);
        vt.setTitle(tbMenuApp.getName());
        List<TbMenuApp> tbMenuAppList =  tbMenuAppMapper.selectList(new EntityWrapper<TbMenuApp>().where("pId=13"));
        VueTree vueTree = null;
        List<VueTree> vueTreeList = new ArrayList<>();
        if(tbMenuAppList!= null && tbMenuAppList.size() >0){
            for(TbMenuApp tmm : tbMenuAppList){
                  vueTree = new VueTree();
                  vueTree.setTitle(tmm.getName());
                  this.subTree(tmm.getId(),vueTree);
                  vueTreeList.add(vueTree);
                  vt.setChildren(vueTreeList);
                  
            }
        }
        return vt;
    }

    /**
     * 获取子节点
     * @param pId
     * @param vueTree
     */
    public void subTree(int pId,VueTree vueTree){
          //获取子节点
        List<TbMenuApp> tbMenuAppList = tbMenuAppMapper.selectList(new EntityWrapper<TbMenuApp>().where("pId="+pId));
        VueTree vt = null;
        List<VueTree> vueTreeList = new ArrayList<>();
        if(tbMenuAppList!= null &&tbMenuAppList.size() >0){
            for(TbMenuApp tma : tbMenuAppList){
                vt = new VueTree();
                vt.setTitle(tma.getName());
                vueTreeList.add(vt);
            }
            vueTree.setChildren(vueTreeList);
        }
    }
}
