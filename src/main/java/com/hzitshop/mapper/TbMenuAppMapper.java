package com.hzitshop.mapper;

import com.hzitshop.entity.TbMenuApp;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hzitshop.vo.menuapp.MenuApp;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author 冼耀基
 * @since 2017-02-12
 */
public interface TbMenuAppMapper extends BaseMapper<TbMenuApp> {
    public List<MenuApp> selectMenuApp();
}