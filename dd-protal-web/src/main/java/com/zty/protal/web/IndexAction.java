package com.zty.protal.web;

import com.zty.ddshop.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexAction {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/")
    public String portalIndex(Model model){
      /*  //第一步：使用service去查，根据tb_content_category的ID去查
        Long id = PropKit.use("ftp.properties").getLong("ftp.gallery");
        List<TbContent> list = contentService.listContentsByCid(id);
        //第二步：存放到model中
        model.addAttribute("list",list);
        //第三步，返回首页*/
        return "index";
    }
    @RequestMapping(value = "/register")
    public String register(){
        System.out.print("register");
        return "register";
    }
    @RequestMapping(value = "/login")
    public String login(){
        System.out.print("login");
        return "login";
    }
    @RequestMapping(value = "/demo")
    public String fogetPassword(){
        return "demo";
    }

    @RequestMapping(value = "/registersuccessful")
    public String registersuccessful(){
        return "registersuccessful";
    }

    @RequestMapping(value = "/index")
    public String index(){
        System.out.print("index");
        return "index";
    }

    @RequestMapping(value = "/removeSession")
    public String removeSession(HttpServletRequest request){
        System.out.print("removeSession");
        request.getSession().invalidate();
        return "login";
    }
    @RequestMapping(value="/col")
    public String pageJump(HttpServletRequest request){
        String id = request.getParameter("id");
        System.out.print(id);
        return "col";
    }
}
