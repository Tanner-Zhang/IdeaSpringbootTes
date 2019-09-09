$(function (){
    $.ajax({
        url:"/menu",
        type:"post",
        dataType: "json",
        success:function(result){
            alert(result.message);
            console.log(result.data);
            var menu = JSON.stringify(result.data);
            window.sessionStorage.setItem("SystemMenu",menu);
        },
        error:function(){

        }
    });
});