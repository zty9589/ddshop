package com.zty.ddshop.service;

import com.zty.ddshop.common.dto.Page;
import com.zty.ddshop.common.dto.Result;
import com.zty.ddshop.pojo.po.TbItemParam;
import com.zty.ddshop.pojo.vo.TbItemParamCustom;

public interface ItemParamService {
    Result<TbItemParamCustom> listItemParamByPage(Page page);


    TbItemParam getItemParamByCid(Long cid);
}
