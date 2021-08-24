$(function (){
    $("#register").click(function (){
        if ($("#register_userName").val() != ""
            && $("#register_userEmail").val() != ""
            && $("#register_userPassword").val() != ""){
            $("#register").get(0).submit();
        }
        else {
            $.ajax({

            })
        }

    })
})