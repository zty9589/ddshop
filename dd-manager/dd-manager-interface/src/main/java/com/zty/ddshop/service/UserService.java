package com.zty.ddshop.service;

import com.zty.ddshop.pojo.po.TbUser;

import java.text.ParseException;

public interface UserService {
    Integer selectTbUserByParams(TbUser tbUser);

    Integer insertTbUser(TbUser tbUser) throws ParseException;
}
