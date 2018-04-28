package com.zty.ddshop.service.impl;


/*import com.zty.ddshop.common.jedis.JedisClient;*/

import com.zty.ddshop.common.jedis.JedisClient;
import com.zty.ddshop.pojo.po.TbContent;
import com.zty.ddshop.pojo.po.TbContentExample;
import com.zty.ddshop.common.util.JsonUtils;
import com.zty.ddshop.dao.TbContentMapper;


import com.zty.ddshop.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbContentMapper tbContentMapper;
    @Autowired
    JedisClient jedisClient;

    @Override
    public List<TbContent> listContentsByCid(Long id) {
        List<TbContent> list = null;
        //查询缓存的部分
        try {
            String json = jedisClient.hget("CONTENT_LIST", id + "");
            if (StringUtils.isNotBlank(json)) {
                list = JsonUtils.jsonToList(json, TbContent.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        //主体业务部分
        //创建模板
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(id);
        //执行查询
        list = tbContentMapper.selectByExample(example);

        //存入缓存部分
        try {
            jedisClient.hset("CONTENT_LIST", id + "", JsonUtils.objectToJson(list));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return list;
    }
}
