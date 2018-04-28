package com.zty.ddshop.service;

import com.zty.ddshop.pojo.po.TbContent;
import com.zty.ddshop.pojo.po.TbContent;

import java.util.List;

public interface ContentService {
    /*
    * 在tb_content表中根据内容分类编号查询出内容
    * */
    List<TbContent> listContentsByCid(Long id);
}
