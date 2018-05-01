package com.zty.ddshop.service;

import com.zty.ddshop.pojo.po.TbUser;

import java.text.ParseException;
import java.util.List;

public interface UserService {
    Integer selectTbUserByParams(TbUser tbUser);

    Integer insertTbUser(TbUser tbUser) throws ParseException;

    public List<TbUser> findTbUserByParams(TbUser tbUser);
}
