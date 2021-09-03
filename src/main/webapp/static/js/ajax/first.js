$(function (){

    var id = [];
    $.ajax({
        url:"/myWeb/loginAndRegister",
        dataType:"text",
        type:"get",
        success:function (res){
            var $dom = $("#login_register");
            $dom.html(res);
        }
    })

    function request(index){
        var url="goods.jsp?goodsId="+id[index];
        window.open(url);
    }


    function goods_change(res){
        id.splice(0,id.length);
        $(".img_1:first").attr("id",res[0].id);
        $("#goods_img_one").attr("src",res[0].img);
        $("#goods_name_one").text(res[0].name);
        $("#goods_price_one").text(res[0].price);
        $(".img_2:first").attr("id",res[1].id);
        $("#goods_img_two").attr("src",res[1].img);
        $("#goods_name_two").text(res[1].name);
        $("#goods_price_two").text(res[1].price);
        $(".img_1:last").attr("id",res[2].id);
        $("#goods_img_three").attr("src",res[2].img);
        $("#goods_name_three").text(res[2].name);
        $("#goods_price_three").text(res[2].price);
        $(".img_3").attr("id",res[3].id);
        $("#goods_img_four").attr("src",res[3].img);
        $("#goods_name_four").text(res[3].name);
        $("#goods_price_four").text(res[3].price);
        $(".img_2:last").attr("id",res[4].id);
        $("#goods_img_five").attr("src",res[4].img);
        $("#goods_name_five").text(res[4].name);
        $("#goods_price_five").text(res[4].price);
        id.push(res[0].id,res[1].id,res[2].id,res[3].id,res[4].id);
    }

    function ajax(val){
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
    }

    $("#0101").click(function (){
        var val = $(this).attr("id");
        ajax(val);
    })

    $("#0201").click(function (){
        var val = $(this).attr("id");
        ajax(val)
    })

    $("#0301").click(function (){
        var val = $(this).attr("id");
        ajax(val);
    })

    $("#btn_one").click(function (){
        request(1);
    })

    $("#btn_two").click(function (){
        request(2);
    })

    $("#btn_three").click(function (){
        request(3);
    })

    $("#btn_four").click(function (){
        request(4);
    })

    $("#btn_five").click(function (){
        request(5);
    })




})