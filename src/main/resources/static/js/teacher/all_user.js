
var add_pageNum=1, pageSize=10, add_pages=0;

$(document).ready(function () {
    init();
});
/**
 * 初始化函数
 */
function init(){
    addPoint();
}


function addPoint(){
    $.ajax({
        url : "/teacher/getUserList",     //后台请求的数据
        data: {
            "pageSize":pageSize,
            "pageNum":add_pageNum
        },
        type : "post",                  //请求方式
        async : true,                   //是否异步请求
        success : function(data) {      //如果请求成功，返回数据。
            $("#table_add tbody").html("");
            add_pages = data.pages;
            var list_ = data.list;
            for(var i=1;i<list_.length+1;i++){
                var content = list_[i-1];
                var trHTML = "<tr><td>"+i+"</td>"
                    +"<td>"+content.userId+"</td>"
                    +"<td>"+content.userName+"</td>"
                    +"<td>"+content.xb+"</td>"
                    +"<td>"+content.qdbm+"</td>"
                    +"<td>"+content.phone+"</td>"
                    +"<td>"+content.kpfs+"</td>"
                    +"<td><a href='/teacher/getUser?userId="+content.userId+"'>详情</a></td>"
                    + "</tr>";
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
        case "下一页":if(add_pageNum==add_pages){break;}add_pageNum++;addPoint();break;
        case "尾页":if(add_pageNum==add_pages){break;}add_pageNum=add_pages;addPoint();break;
    }
});
