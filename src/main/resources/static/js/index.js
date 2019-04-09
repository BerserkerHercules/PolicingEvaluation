$(document).ready(function () {
    /*$("#myMsg").text()*/
    $.ajax({
        url : "/student/getMyName",     //后台请求的数据
        dataType : "json",              //数据格式 
        type : "post",                  //请求方式
        async : true,                   //是否异步请求
        success : function(data) {      //如果请求成功，返回数据。
            var userName = data.userName;
            $("#myMsg").text(userName);
        },
    });
    /*function setIframeHeight(iframe) {
        if (iframe) {
            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
            if (iframeWin.document.body) {
                iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
            }
        }
    };
    setIframeHeight(document.getElementById('iframe'));*/
    document.getElementsByTagName('body')[0].style.height = window.innerHeight+'px';

});
