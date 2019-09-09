//表单验证
function textCheck() {

    var username=$("#username").val();
    var password=$("#password").val();

    if (username==""||password==""){

        $("#d2").remove();

        let divd2=`<div id="d2" class="alert alert-error">
                   <i class="iconfont">&#xe62e;</i>
                   <span id="s2"></span>
                   </div>`;
        $("#d1").after(divd2);

        $("#s2").html("用户名或密码不能为空");
        //document.getElementById("s1").innerHTML = "111111";
    }else{
        $("#d2").remove();
    }

}

//生成验证码
function validateCode(n) {
//验证码中可能包含的字符
    var s="abcdefghijqmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    var ret="";//保存生成的验证码；
    /*利用循环，随机产生验证码中的每个字符*/
    for(var i=0;i<n;i++)
    {
        var index = Math.floor(Math.random()*62);//随机产生一个0~62之间的数
        //将随机产生的数当作字符串的位置下标，在字符串s中取出该字符，并存入ret中
        ret+=s.charAt(index);
    }
    return ret;
}
//显示随机数函数

function show(){
    //在id为msg的对象中显示验证码
    document.getElementById("s3").innerHTML = validateCode(4);
}

$(function () {
    show();
})

//验证码验证
function validateCodeCheck() {
       var inputcode=$("#inputcode").val();
       var validatecode=$("#s3").html();
       if (inputcode!=validatecode){
           alert("验证码错误");
           show();
           return 0;
       }return 1;


}


function login() {
    textCheck();
    var username=$("#username").val();
    var password=$("#password").val();
   var resultcode= validateCodeCheck();
   if(resultcode==1) {
       if (username != "" && password != "") {
           $.ajax({
               url: "/login",
               type: "post",
               data: {
                   username: username,
                   password: password
               },
               dataType: "json",
               success: function (result) {
                   if(result.status==1){
                       alert(result.message);
                       window.location.href = 'main.html';
                       return;
                   }
                   alert(result.message);
               },
               error: function () {
                   alert("请求失败!!!");
               }

           });
       } else {
           alert("账号或密码不能为空")
       }
   }

}
