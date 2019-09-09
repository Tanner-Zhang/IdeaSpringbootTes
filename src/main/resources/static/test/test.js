$(function () {
    alert(2);
    $.ajax({
        // async:true,
        url:"/menu",
        type:"get",
        dataType: "json",
        success:function(data1){
            var a=JSON.stringify(data1);
            alert(a+"~~~~ajax");
            window.sessionStorage.setItem("data",a);

        },
        error:function(){
            alert("请求失败!!!");
        }
    });
});


function onSidemenuSelect() {
    
}

