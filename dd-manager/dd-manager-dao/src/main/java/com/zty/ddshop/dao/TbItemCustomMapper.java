package com.zty.ddshop.dao;

import com.zty.ddshop.pojo.po.TbItem;

import java.util.List;
import java.util.Map;

public interface TbItemCustomMapper {
    //每页显示的记录数封装成的集合
    List<TbItem> listByPage(Map<String, Object> map);
    //总记录数
    Integer selectAll(Map<String, Object> map);
}
