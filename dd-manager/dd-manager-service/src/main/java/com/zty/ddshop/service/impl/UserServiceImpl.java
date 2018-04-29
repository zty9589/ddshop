package com.zty.ddshop.service.impl;

import com.zty.ddshop.common.util.IDUtils;
import com.zty.ddshop.dao.TbUserMapper;
import com.zty.ddshop.dao.TbUserParamMapper;
import com.zty.ddshop.pojo.po.TbUser;
import com.zty.ddshop.pojo.po.TbUserExample;
import com.zty.ddshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserParamMapper tbUserParamMapper;

    @Override
    public Integer insertTbUser(TbUser tbUser) throws ParseException {
        //得到当前的时间，格式是yyyy-MM-dd hh:mm:ss
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = sdf.parse(sdf.format(new Date()));
        //设置创建时间
        tbUser.setCreated(date);
        //设置更新时间
        tbUser.setUpdated(date);
        //设置用户id
        //随机得到id
        long itemId = IDUtils.getItemId();
        tbUser.setId(itemId);
        Integer integer = tbUserParamMapper.insertTbUser(tbUser);
        return integer;
    }

    @Override
    public Integer selectTbUserByParams(TbUser tbUser) {
        int flag;
        List<TbUser> list = tbUserParamMapper.selectTbUserByParams(tbUser);
        if(CollectionUtils.isEmpty(list)){
            flag = 0;
        }else{
            flag = 1;
        }
        return flag;
    }
}
