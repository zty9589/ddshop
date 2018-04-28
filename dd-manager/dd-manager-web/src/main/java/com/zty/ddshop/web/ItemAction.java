package com.zty.ddshop.web;

import com.zty.ddshop.common.dto.Order;
import com.zty.ddshop.common.dto.Page;
import com.zty.ddshop.common.dto.Result;
import com.zty.ddshop.pojo.po.TbItem;
import com.zty.ddshop.pojo.vo.TbItemQuery;
import com.zty.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Scope("prototype")
public class ItemAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemId") Long itemId){
        System.out.print(itemId);
        return itemService.selectAll(itemId);
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable("page") String page){
        System.out.print(page);
        return page;
    }

    @RequestMapping("/items")
    @ResponseBody
    public Result<TbItem> listItems(Page page,Order order,TbItemQuery query){
        Result<TbItem> result = null;
        try{
            result = itemService.listItems(page,order,query);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return  result;
    }

    @ResponseBody
    @RequestMapping("/items/batch")
    public int update(@RequestParam("ids[]") List<Long> ids){
        int i = 0;
        try{
            i = itemService.updateBatch(ids);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping("/item")
    public int saveItem(TbItem tbItem,String content,String paramData) {
        int i = 0;
        try {
            i = itemService.saveItem(tbItem, content,paramData);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return i;
    }

}
