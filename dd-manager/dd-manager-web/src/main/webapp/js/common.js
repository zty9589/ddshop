
var ddshop = {

    //点击左侧树上的选项卡，添加选项卡
    registerMenuEvent:function(){
        var this_=this;
        //约定大于配置：jquery对象前面加上$，如果是DOM对象不需要加$
        var $tree = $('#menu .easyui-tree');
        //将当前对象打印到控制台
        // console.log($tree);
        $tree.tree({
            onClick:function(node){
                console.log(node);
                var href = node.attributes.href;//item-add
                var text = node.text;
                this_.addTabs(text,href);

            }
        })

    },
    addTabs:function(text,href){
        if($('#tab').tabs('exists',text)){
            $('#tab').tabs('select',text)
        }else{
            $('#tab').tabs('add',{
                title:text,
                href:href,
                closable:true
            });
        }

    }


};



