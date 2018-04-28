package com.zty.ddshop.web;

import com.zty.ddshop.common.dto.TreeNode;
import com.zty.ddshop.pojo.po.TbItem;
import com.zty.ddshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TbItemCatAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/itemCats")
    @ResponseBody
    public List<TreeNode> listItemCatsByPid(@RequestParam("parentId") Long parentId){
        List<TreeNode>  treeNodeList = null;
        try{
            treeNodeList = itemCatService.listItemCatsByPid(parentId);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return treeNodeList;
    }


}
