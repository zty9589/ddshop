package com.zty.ddshop.service;

import com.zty.ddshop.common.dto.Order;
import com.zty.ddshop.common.dto.Page;
import com.zty.ddshop.common.dto.Result;
import com.zty.ddshop.pojo.po.TbItem;
import com.zty.ddshop.pojo.vo.TbItemQuery;

import java.util.List;

public interface ItemService {

    TbItem selectAll(Long id);

    Result<TbItem> listItems(Page page, Order order, TbItemQuery query);

    /*
    * 批量修改
    * */
    int updateBatch(List<Long> ids);

    int saveItem(TbItem tbItem, String content, String paramData);
}
