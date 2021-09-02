$(function (){
    $.ajax({
        url:"/myWeb/loginAndRegister",
        dataType:"text",
        type:"get",
        success:function (res){
            $("#login_register").html(res);
        }
    })

    function goods_change(res){
        $("#goods_id_one").attr("id",res[0].id);
        $("#goods_img_one").attr("src",res[0].img);
        $("#goods_name_one").text(res[0].name);
        $("#goods_id_two").attr("id",res[1].id);
        $("#goods_img_two").attr("src",res[1].img);
        $("#goods_name_two").text(res[1].name);
        $("#goods_id_three").attr("id",res[2].id);
        $("#goods_img_three").attr("src",res[2].img);
        $("#goods_name_three").text(res[2].name);
        $("#goods_id_four").attr("id",res[3].id);
        $("#goods_img_four").attr("src",res[3].img);
        $("#goods_name_four").text(res[3].name);
        $("#goods_id_five").attr("id",res[4].id);
        $("#goods_img_five").attr("src",res[4].img);
        $("#goods_name_five").text(res[4].name);
    }

    $("#0101").click(function (){
        var val = $(this).attr("id");
        $.ajax({
            url:"/myWeb/findByNo",
            type: "get",
            contentType:"application/json;charset=utf-8",
            dataType: "json",
            data:{
                typeNo:val
            },
            success:function (res){
                goods_change(res);
            }
        })

    })

    $("#0201").click(function (){
        var val = $(this).attr("id");
        $.ajax({
            url:"/myWeb/findByNo",
            type: "get",
            contentType:"application/json;charset=utf-8",
            dataType: "json",
            data:{
                typeNo:val
            },
            success:function (res){
                goods_change(res);
            }
        })

    })

})