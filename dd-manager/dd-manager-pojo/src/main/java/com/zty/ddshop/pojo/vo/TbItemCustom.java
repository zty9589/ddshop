package com.zty.ddshop.pojo.vo;

import com.zty.ddshop.pojo.po.TbItem;

public class TbItemCustom extends TbItem {
    //商品分类名称
    private String catName;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
