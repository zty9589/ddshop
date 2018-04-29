package com.zty.protal.web;

import com.zty.ddshop.pojo.po.TbUser;
import com.zty.ddshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

@Controller
public class UserAction {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/configAccount" , method = RequestMethod.POST)
    @ResponseBody
    public String configAccount(HttpServletRequest request){
        String username = request.getParameter("username");
        //设置tbUser
        TbUser tbUser = new TbUser();
        tbUser.setUsername(username);
        Integer flag = userService.selectTbUserByParams(tbUser);
        return flag+"";
    }

    @RequestMapping(value = "/registerAccount" , method = RequestMethod.POST)
    @ResponseBody
    public String registerAccount(HttpServletRequest request) throws ParseException {
        //得到用户名，密码，手机号码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        //定义TbUser
        TbUser tbUser = new TbUser();
        tbUser.setUsername(username);
        tbUser.setPassword(password);
        tbUser.setPhone(phone);
        //保存对象
        Integer flag = userService.insertTbUser(tbUser);
        return flag+"";
    }

    @RequestMapping(value = "/configPhone" , method = RequestMethod.POST)
    @ResponseBody
    public String configPhone(HttpServletRequest request){
        //得到用户名，密码，手机号码
        String phone = request.getParameter("phone");
        //设置tbUser
        TbUser tbUser = new TbUser();
        tbUser.setPhone(phone);
        Integer flag = userService.selectTbUserByParams(tbUser);
        return flag+"";
    }
}
