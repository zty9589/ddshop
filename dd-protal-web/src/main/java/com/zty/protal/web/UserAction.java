package com.zty.protal.web;

import com.zty.ddshop.pojo.po.TbUser;
import com.zty.ddshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

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

    @RequestMapping(value = "/userLogin" , method = RequestMethod.POST)
    @ResponseBody
    public String userLogin(HttpServletRequest request){
        String flag ="";
        //得到用户名，密码
        String loginname = request.getParameter("loginname");
        String nloginpwd = request.getParameter("nloginpwd");
        //根据用户名查找
        TbUser tbUser = new TbUser();
        tbUser.setUsername(loginname);
        List<TbUser> list = userService.findTbUserByParams(tbUser);
        //得到Session
        HttpSession session = request.getSession();
        if(CollectionUtils.isEmpty(list)){
            flag="3";//该用户未注册
        }else{
            TbUser tb = list.get(0);
            if(nloginpwd.equals(tb.getPassword())){//允许登录
                if("0".equals(tb.getStatus())){
                    session.setAttribute("username",tb.getUsername());
                    flag = "0";//管理员登录
                }else if("1".equals(tb.getStatus())){
                    session.setAttribute("username",tb.getUsername());
                    flag = "1";//会员登录
                }
            }else{//用户名匹配，密码不匹配
                flag = "2";//密码错误
            }
        }
        return flag;
    }
}
