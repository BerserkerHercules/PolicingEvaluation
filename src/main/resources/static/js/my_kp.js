var add_pageNum=1, add_pageSize=5, add_num=0;
var del_pageNum=1, del_pageSize=5, del_num=0;
var jl_pageNum=1, jl_pageSize=5, jl_num=0;
var cf_pageNum=1, cf_pageSize=5, cf_num=0;

$(document).ready(function () {
    init();
});

/**
 * 初始化函数
 */
function init(){
    addPoint();
    delPoint();
}

/**
 * 加分信息
 */
function addPoint(){
    $.ajax({
        url : "/student/getAddPoint",     //后台请求的数据
        data: {
            "pageSize":add_pageSize,
            "pageNum":add_pageNum
        },
        type : "post",                  //请求方式
        async : true,                   //是否异步请求
        success : function(data) {      //如果请求成功，返回数据。
            $("#table_add tbody").html("");
            add_num = data.length/add_pageSize+1;

            for(var i=1;i<data.length+1;i++){
                var content = data[i-1];
                var trHTML = "<tr><td>"+i+"</td>"
                    +"<td>"+content.userName+"</td>"
                    +"<td>"+content.addDesc+"</td>"
                    +"<td>"+content.addPoint+"</td>"
                    +"<td>"+content.time+"</td></tr>";
                $("#table_add tbody").append(trHTML);//在table最后面添加一行
            }
        },
    });
}

/**
 * 加分信息表翻页
 */
$(".add").click(function(){
    var data = $(this).html();
    switch (data) {
        case "首页":if(add_pageNum==1){break;}add_pageNum=1;addPoint();break;
        case "上一页":if(add_pageNum==1){break;}add_pageNum--;addPoint();break;
        case "下一页":if(add_pageNum==add_num){break;}add_pageNum++;addPoint();break;
        case "尾页":if(add_pageNum==add_num){break;}add_pageNum=add_num;addPoint();break;
    }
});

/**
 * 扣分信息
 */
function delPoint(){
    $.ajax({
        url : "/student/getDeletePoint",     //后台请求的数据
        data: {
            "pageSize":del_pageSize,
            "pageNum":del_pageNum
        },
        type : "post",                  //请求方式
        async : true,                   //是否异步请求
        success : function(data) {      //如果请求成功，返回数据。
            $("#table_del tbody").html("");
            del_num = data.length/del_pageSize+1;

            for(var i=1;i<data.length+1;i++){
                var content = data[i-1];
                var trHTML = "<tr><td>"+i+"</td>"
                    +"<td>"+content.userName+"</td>"
                    +"<td>"+content.deleteDesc+"</td>"
                    +"<td>"+content.deletePoint+"</td>"
                    +"<td>"+content.deleteTime+"</td></tr>";
                $("#table_del tbody").append(trHTML);//在table最后面添加一行
            }
        },
    });
}

/**
 * 扣分信息表翻页
 */
$(".del").click(function(){
    var data = $(this).html();
    switch (data) {
        case "首页":if(del_pageNum==1){break;}del_pageNum=1;delPoint();break;
        case "上一页":if(del_pageNum==1){break;}del_pageNum--;delPoint();break;
        case "下一页":if(del_pageNum==del_num){break;}del_pageNum++;delPoint();break;
        case "尾页":if(del_pageNum==del_num){break;}del_pageNum=del_num;delPoint();break;
    }
});
