package com.zty.ddshop.dao;

import com.zty.ddshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map;

public interface TbItemParamCustomMapper {
    int countItemParams();

    List<TbItemParamCustom> listItemParamByPage(Map<String, Object> map);
}
