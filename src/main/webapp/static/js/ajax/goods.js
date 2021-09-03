$(function (){
    $.ajax({
        url:"/myWeb/loginAndRegister",
        dataType:"text",
        type:"get",
        success:function (res){
            var $dom = $("#login_register");
            $dom.html(res);
            $dom.attr("href","javascript:void(0)");
        }
    })
})