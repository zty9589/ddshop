<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" >
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button type="button" onclick="addParam()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button type="button" onclick="editParam()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button type="button" onclick="delParam()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">删除</button>
    </div>
</div>
<table id="table"></table>
<script>
    //新增分组
    function addParam(){
        ddshop.addTabs('新增商品规格模板','item-param-add');
    }
    //初始化数据表格
    $('#table').datagrid({
        title: '商品规格模板列表',
        url:'itemParams',
        fit: true,
        rownumbers: true,
        pagination: true,
        pageSize:20,
        toolbar: '#toolbar',
        columns:[[
            {field:'ck', checkbox: true},
            {field:'id',title:'ID', sortable: true},
            /* {field:'itemCatId',title:'商品类目ID'}, */
            {field:'catName',title:'商品类目'},
            {field:'paramData',title:'规格(只显示分组名称)',formatter:function(value,row,index){
                //value是字符串，字符串转为对象就是反序列化
                var obj = JSON.parse(value);
                //console.log(typeof(obj));
                var array = [];
                $.each( obj, function(i, n){
                    /*console.group()
                    console.log(i);
                    console.log(n);
                    console.groupEnd();*/
                    array.push(n.group);

                });
                return array;
            }},
            {field:'created',title:'创建日期',formatter:function(value,row,index){
                return value;
            }},
            {field:'updated',title:'更新日期',formatter:function(value,row,index){
                return value;
            }}
        ]]
    });



</script>


