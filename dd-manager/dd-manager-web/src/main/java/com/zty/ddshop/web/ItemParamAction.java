package com.zty.ddshop.web;

import com.zty.ddshop.common.dto.Page;
import com.zty.ddshop.common.dto.Result;
import com.zty.ddshop.pojo.po.TbItemParam;
import com.zty.ddshop.pojo.vo.TbItemParamCustom;
import com.zty.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemParamAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemParamService itemParamService;


    @RequestMapping("/itemParams")
    @ResponseBody
    public Result<TbItemParamCustom> listItemParams(Page page){
        Result<TbItemParamCustom> result = null;
        try{
            result = itemParamService.listItemParamByPage(page);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/itemParam/query/{cid}")
    @ResponseBody
    public TbItemParam getItemParamByCid(@PathVariable("cid") Long cid){
        TbItemParam tbItemParam = null;
        try{
            tbItemParam = itemParamService.getItemParamByCid(cid);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return tbItemParam;
    }

}
