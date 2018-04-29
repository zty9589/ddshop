package com.zty.ddshop.dao;

import com.zty.ddshop.pojo.po.TbUser;

import java.util.List;

public interface TbUserParamMapper {
    List<TbUser> selectTbUserByParams(TbUser tbUser);

    Integer insertTbUser(TbUser tbUser);
}
