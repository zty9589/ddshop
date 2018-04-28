package com.zty.ddshop.web;

/*import com.zty.ddshop.service.FileService;*/
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
public class FileAction {

   /* private FileService fileService;*/
    @ResponseBody
    @RequestMapping(value = "/file/upload", method = RequestMethod.GET)
    public void config(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置请求流和响应流字符集，内容类型
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        String action = request.getParameter("action");
        //初始化
        if ("config".equals(action)) {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("config.json");
            PrintWriter out = response.getWriter();
            IOUtils.copy(is, out,"UTF-8");
        }
    }

   /* @ResponseBody
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile multipartFile){
        return fileService.upload(multipartFile);
    }*/
}
