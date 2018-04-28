package com.zty.ddshop.service.impl;

import com.zty.ddshop.common.util.FtpUtils;
import com.zty.ddshop.common.util.IDUtils;
import com.zty.ddshop.common.util.PropKit;
import com.zty.ddshop.service.FileService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public Map<String, Object> upload(MultipartFile multipartFile) {
        Map<String, Object> map = new HashMap<>();
        String name = "ftp.properties";
        String host = PropKit.use(name).get("ftp.address");
        int port = PropKit.use(name).getInt("ftp.port");
        String username = PropKit.use(name).get("ftp.username");
        String password = PropKit.use(name).get("ftp.password");
        String basePath = PropKit.use(name).get("ftp.basePath");
        //创建文件路径：基础路径+文件路径+文件名+扩展名
        String filePath = new DateTime().toString("/yyyy/MM/dd");
        //获取原有的文件名，包含扩展名
        String originalFilename = multipartFile.getOriginalFilename();
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        String sb =  IDUtils.genImageName()+fileType;
        InputStream is = null;
        try{
            is =  multipartFile.getInputStream();
        }catch(Exception e){
            e.printStackTrace();
        }
        //执行上传操作，返回布尔值
        boolean bool = FtpUtils.uploadFile(host, port, username, password, basePath, filePath,sb,is);
        if (bool) {
            map.put("state","success");
            map.put("title",sb);
            map.put("original",originalFilename);
            map.put("type",fileType);
            map.put("url",basePath+filePath+"/"+sb);
            map.put("size",multipartFile.getSize());
        }
        return map;
    }
}
