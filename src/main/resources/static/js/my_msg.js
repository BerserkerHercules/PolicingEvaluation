$(document).ready(function () {

    $.ajax({
        url : "/student/getMyName",     //后台请求的数据
        dataType : "json",              //数据格式 
        type : "post",                  //请求方式
        async : true,                   //是否异步请求
        success : function(data) {      //如果请求成功，返回数据。
            $("#userName").append(data.userName);
            $("#xb").append(data.xb);
            $("#phone").append(data.phone);
            $("#email").append(data.email);
            $("#id").append(data.userId);
            $("#pwd").append(data.pwd);
            $("#kpfs").append(data.kpfs);
            $("#qdbm").append(data.qdbm);
            $("#qshm").append(data.qshm);
        },
    });

});
