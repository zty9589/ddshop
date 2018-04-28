package com.zty.ddshop.service.impl;

import com.zty.ddshop.common.dto.Order;
import com.zty.ddshop.common.dto.Page;
import com.zty.ddshop.common.dto.Result;
import com.zty.ddshop.common.util.IDUtils;
import com.zty.ddshop.dao.TbItemCustomMapper;
import com.zty.ddshop.dao.TbItemDescMapper;
import com.zty.ddshop.dao.TbItemMapper;
import com.zty.ddshop.dao.TbItemParamItemMapper;
import com.zty.ddshop.pojo.po.TbItemExample;
import com.zty.ddshop.pojo.vo.TbItemQuery;
import com.zty.ddshop.service.ItemService;
import com.zty.ddshop.pojo.po.TbItem;
import com.zty.ddshop.pojo.po.TbItemDesc;
import com.zty.ddshop.pojo.po.TbItemParamItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemCustomMapper tbItemCustomMapper;

    @Autowired
    private TbItemDescMapper itemDescDao;

    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;

    @Override
    public TbItem selectAll(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result<TbItem> listItems(Page page, Order order, TbItemQuery query) {
        Result<TbItem> result = null;
        Map<String,Object> map = null;
        try{
            map = new HashMap<>();
            map.put("page",page);
            map.put("order",order);
            map.put("query",query);
            //1.创建一个参数响应的实体类
            result = new Result<>();
            //2.对total进行设值（符合条件的记录数）
            int total= tbItemCustomMapper.selectAll(map);
            result.setTotal(total);
            //3.对rows进行设值
            List<TbItem> list  = tbItemCustomMapper.listByPage(map);
            result.setRows(list);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return  result;
    }

    @Override
    public int updateBatch(List<Long> ids) {
        int i = 0;
        try{
            //准备商品对象，这个对象包含了状态为3的字段
            TbItem record = new TbItem();
            record.setStatus((byte)3);
            //创建更新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            //执行更新
            i = tbItemMapper.updateByExampleSelective(record,example);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    @Transactional
    @Override
    public int saveItem(TbItem tbItem, String content,String paramData) {
        int i = 0;
        try {
            //这个方法中，要处理两张表格tb_item tb_item_desc
            //调用工具类生成商品的ID
            //处理tb_item
            Long itemId = IDUtils.getItemId();
            tbItem.setId(itemId);
            tbItem.setStatus((byte)2);
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
            i = tbItemMapper.insert(tbItem);

            //处理tb_item_desc
            TbItemDesc desc= new TbItemDesc();
            desc.setItemId(itemId);
            desc.setCreated(new Date());
            desc.setUpdated(new Date());
            desc.setItemDesc(content);
            i  +=itemDescDao.insert(desc);

            //处理tb_item_param_item
            TbItemParamItem tbItemParamItem = new TbItemParamItem();
            tbItemParamItem.setItemId(itemId);
            tbItemParamItem.setCreated(new Date());
            tbItemParamItem.setUpdated(new Date());
            tbItemParamItem.setParamData(paramData);
            i +=tbItemParamItemMapper.insert(tbItemParamItem);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }
}
