$(function (){
    $("#register").click(function (){
        var userName = $("#register_userName").val();
        var userEmail = $("#register_userEmail").val();
        var userPassword = $("#register_userPassword").val();
            $.ajax({
                contentType:"application/json",
                dataType:"json",
                url:"/myWeb/register",
                data:{
                    "userName":userName,
                    "userEmail":userEmail,
                    "userPassword":userPassword
                },
                success:function (res){
                    alert(res);
                }
            })

    })
})