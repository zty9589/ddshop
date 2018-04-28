package com.zty.ddshop.service.impl;

import com.zty.ddshop.common.dto.TreeNode;
import com.zty.ddshop.dao.TbItemCatMapper;
import com.zty.ddshop.pojo.po.TbItemCat;
import com.zty.ddshop.pojo.po.TbItemCatExample;
import com.zty.ddshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TreeNode> listItemCatsByPid(Long parentId) {
        List<TreeNode> treeNodeList = null;
        try {
            //创建查询模板
            TbItemCatExample example = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            //执行查询
            List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
            //要序列化成json字符串的对象
            treeNodeList = new ArrayList<>();
            //遍历原有列表生成新列表
            for (int i = 0; i < tbItemCats.size(); i++) {
                TbItemCat tbItemCat = tbItemCats.get(i);
                TreeNode treeNode = new TreeNode();
                treeNode.setId(tbItemCat.getId());
                treeNode.setText(tbItemCat.getName());
                treeNode.setState(tbItemCat.getIsParent()? "closed":"open");

                treeNodeList.add(treeNode);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return treeNodeList;
    }
}
