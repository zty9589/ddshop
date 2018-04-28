<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="商品规格参数模板详情" data-options="fit:true">

    <form class="form" id="itemParamAddForm" name="itemParamAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">商品类目：</td>
                <td>
                    <input id="cid" name="cid" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">规格参数：</td>
                <td>
                    <button class="easyui-linkbutton" onclick="addGroup()" type="button" data-options="iconCls:'icon-add'">添加分组</button>
                    <ul id="item-param-group">

                    </ul>
                    <ul id="item-param-group-template" style="display:none;">
                        <li>
                            <input name="group">
                            <button title="添加参数" class="easyui-linkbutton" onclick="addParam(this)" type="button" data-options="iconCls:'icon-add'"></button>
                            <button title="删除分组" class="easyui-linkbutton" onclick="delGroup(this)" type="button" data-options="iconCls:'icon-cancel'"></button>
                            <ul class="item-param">
                                <li>
                                    <input name="param">
                                    <button title="删除参数" class="easyui-linkbutton" onclick="delParam(this)" type="button" data-options="iconCls:'icon-cancel'"></button>
                                </li>

                            </ul>
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button class="easyui-linkbutton" onclick="submitForm()" type="button" data-options="iconCls:'icon-ok'">保存</button>
                    <button class="easyui-linkbutton" onclick="clearForm()" type="button" data-options="iconCls:'icon-undo'">重置</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    //加载商品类目的树形下拉框
    $('#cid').combotree({
        url: 'itemCats?parentId=0',
        required: true,
        onBeforeExpand:function(node){
            //获取当前被点击的tree
            var $currentTree = $('#cid').combotree('tree');
            //调用easyui tree组件的options方法
            var option = $currentTree.tree('options');
            //修改option的url属性
            option.url = 'itemCats?parentId='+node.id;
        },
        onBeforeSelect:function (node) {
            //判断选中节点是否为叶子结点，如果是，返回true
            var isLeaf = $('#cid').tree('isLeaf',node.target)
            //如果后台管理员选中的不是叶子结点的话，给出警告框
            if(!isLeaf){
                $.messager.alert('警告','刘淑贤是丑逼！','warning');
                return false;
            }

        }

    })

    //添加分组
    function addGroup(){
        var $templateLi = $('#item-param-group-template li').eq(0).clone();
        $('#item-param-group').append($templateLi);

    }

    //添加参数
    function addParam(ele){
        var $paramLi = $('#item-param-group-template .item-param li').eq(0).clone();
        $(ele).parent().find('.item-param').append($paramLi);

    }

    //删除参数
    function delParam(ele){
       $(ele).parent().remove();
    }

    //删除分组
    function delGroup(ele){
        $(ele).parent().remove();
    }

</script>


