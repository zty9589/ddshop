package com.zty.ddshop.service;

import com.zty.ddshop.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {

    List<TreeNode> listItemCatsByPid(Long parentId);
}
