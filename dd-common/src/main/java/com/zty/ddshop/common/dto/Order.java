package com.zty.ddshop.common.dto;

import java.util.ArrayList;
import java.util.List;

public class Order {
    /*
    * easyui的datagrid排序通用类
    * */

    //要排序的字段
    private String sort;
    //排序方式
    private String order;

    public List<String> getOrderParams() {
        String[] sorts = sort.split(",");
        String[] orders = order.split(",");
        List<String> list = new ArrayList<>();
        for(int i= 0;i<sorts.length;i++){
            String temp = sorts[i]+" "+orders[i];
            list.add(temp);
        }
        return list;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
