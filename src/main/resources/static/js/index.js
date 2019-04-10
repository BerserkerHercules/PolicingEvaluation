$(document).ready(function () {

    $.ajax({
        url : "/student/getMyName",     //后台请求的数据
        dataType : "json",              //数据格式 
        type : "post",                  //请求方式
        async : true,                   //是否异步请求
        success : function(data) {      //如果请求成功，返回数据。
            $("#myMsg").text(data.userName);
        },
    });

    document.getElementsByTagName('body')[0].style.height = window.innerHeight+'px';

});
