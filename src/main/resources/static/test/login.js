function login(){
       alert("1");
       var username=$("#username").val();
       var password=$("#password").val();


       if (username!=""&password!="") {

              alert(username);
              alert(password);

       $.ajax({
              url:"/login",
              type:"post",
              data:{
                     username:username,
                     password:password
              },
              dataType: "json",
              success:function(){

              },
              error:function(){
                     alert("请求失败!!!");
              }

       });

       }else{

              alert("账号密码不能为空");
              window.location.reload();
       }

}



