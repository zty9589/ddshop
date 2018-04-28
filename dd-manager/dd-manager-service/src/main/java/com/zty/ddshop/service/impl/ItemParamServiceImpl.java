package com.zty.ddshop.service.impl;

import com.zty.ddshop.common.dto.Page;
import com.zty.ddshop.common.dto.Result;
import com.zty.ddshop.dao.TbItemParamCustomMapper;
import com.zty.ddshop.dao.TbItemParamMapper;
import com.zty.ddshop.pojo.po.TbItemParam;
import com.zty.ddshop.pojo.po.TbItemParamExample;
import com.zty.ddshop.pojo.vo.TbItemParamCustom;
import com.zty.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemParamServiceImpl implements ItemParamService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemParamCustomMapper tbItemParamCustomMapper;
    @Autowired
    private TbItemParamMapper itemParamMapper;

    @Override
    public Result<TbItemParamCustom> listItemParamByPage(Page page) {
        Result<TbItemParamCustom> result = null;
        try {
            //Dao层接口多个参数解决方案之一
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);
            //取出tb_item_param这张表记录条数
            int count = tbItemParamCustomMapper.countItemParams();
            //取出对应页码记录集合
            List<TbItemParamCustom> list = tbItemParamCustomMapper.listItemParamByPage(map);

            result = new Result<>();
            result.setTotal(count);
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public TbItemParam getItemParamByCid(Long cid) {
        TbItemParam tbItemParam = null;
        try {
            //创建查询模板
            TbItemParamExample example = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = example.createCriteria();
            criteria.andItemCatIdEqualTo(cid);
            //执行查询
            List<TbItemParam> tbItemParams = itemParamMapper.selectByExampleWithBLOBs(example);
            if(tbItemParams != null && tbItemParams.size()>0){
                tbItemParam = tbItemParams.get(0);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return tbItemParam;
    }
}

