$(document).ready(function () {
    var userId=$("#userId").val();
    var userName=$("#userName").val();

    $("#change_msg").attr("href","/student/change_msg?userId="+userId+"&userName="+userName);
    $("#myKp").attr("href","/student/myKp?userId="+userId);

});
