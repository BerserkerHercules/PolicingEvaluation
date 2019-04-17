var add_pageNum = 1, pageSize = 10, add_pages = 0;

$(document).ready(function () {
    init();
});

/**
 * 初始化函数
 */
function init() {
    addPoint();
}

//****************************************************************************************************

/**
 * 区队信息
 */
function addPoint() {

    var data = {
        "pageSize": pageSize,
        "pageNum": add_pageNum,
        "qdmc": $("#qdmc").val(),
        "qdbm": $("#qdbm").val(),
    };

    $.ajax({
        url: "/student/getTeamList",     //后台请求的数据
        data: data,
        type: "post",                  //请求方式
        async: true,                   //是否异步请求
        success: function (data) {      //如果请求成功，返回数据。
            $("#table_add tbody").html("");
            add_pages = data.pages;
            var list_ = data.list;
            for (var i = 1; i < list_.length + 1; i++) {
                var content = list_[i - 1];
                var trHTML = "<tr><td>" + i + "</td>"
                    + "<td>" + content.qdbm + "</td>"
                    + "<td>" + content.qdmc + "</td>"
                    + "<td>" + content.qdms + "</td>"
                    + "<td>" + content.qdkh + "</td>"
                    + "<td>" + content.qdkp + "</td>"
                    + "<td>" + content.qdrs + "</td></tr>";
                $("#table_add tbody").append(trHTML);//在table最后面添加一行
            }
        },
    });
}

/**
 * 区队信息表翻页
 */
$(".add").click(function () {
    var data = $(this).html();
    switch (data) {
        case "首页":
            if (add_pageNum == 1) {
                break;
            }
            add_pageNum = 1;
            addPoint();
            break;
        case "上一页":
            if (add_pageNum == 1) {
                break;
            }
            add_pageNum--;
            addPoint();
            break;
        case "下一页":
            if (add_pageNum == add_pages) {
                break;
            }
            add_pageNum++;
            addPoint();
            break;
        case "尾页":
            if (add_pageNum == add_pages) {
                break;
            }
            add_pageNum = add_pages;
            addPoint();
            break;
    }
});

$("#search").click(function () {
    addPoint();
});
