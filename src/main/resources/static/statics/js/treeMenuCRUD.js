function newMenu(){
    $('#dlg').dialog('open').dialog('setTitle','新建菜单');
    $('#fm').form('clear');
}

function saveMenu(){
    var title1=$("#title1").val();
    var icon1=$("#icon1").val();
    var isCurrent1=$("#isCurrent1").val();
    var title2=$("#title2").val();
    var icon2=$("#icon2").val();
    var isCurrent2=$("#isCurrent2").val();
    var title3=$("#title3").val();
    var href=$("#href").val();
    var isCurrent3=$("#isCurrent3").val();

    $.ajax({
        url:"/MenuCreate",
        type:"post",
        data:{
            title1: title1,
            icon1 : icon1,
            isCurrent1: isCurrent1,
            title2: title2,
            icon2 : icon2,
            isCurrent2: isCurrent2,
            title3: title3,
            href : href,
            isCurrent3: isCurrent3
        },
        dataType:"json",
        success:function (result) {
            if (result.status==0){
                $.messager.show({
                    title: 'Error',
                    msg: result.message
                });
            } else {
                alert(result.message);
                $('#dlg').dialog('close');		// close the dialog
                $('#tg').treegrid('reload');	// reload the user data
            }
        },
        error:function () {
            alert("请求失败")
        }
    })


}


function newMenu2(){
    $('#dlg2').dialog('open').dialog('setTitle','新建菜单');
    $('#fm2').form('clear');
}


function saveMenu2(){

    var level=$("#level").val();
    var title=$("#title").val();
    var ptitle=$("#ptitle").val();
    var icon=$("#icon").val();
    var isCurrent=$("#isCurrent").val();
    var href2=$("#href2").val();

    if (level==1){
        if(title!=""&&icon!=""&&isCurrent!=""){
            sM2(level,title,ptitle,icon,isCurrent,href2);
        }else {
            alert("对应表单内容不能为空level1");

        }
    }

    if (level==2){
        if(title!=""&&icon!=""&&ptitle!=""&&isCurrent!=""){
            sM2(level,title,ptitle,icon,isCurrent,href2);
        }else {
            alert("对应表单内容不能为空level2");
        }

    }

    if(level==3){
        if(title!=""&&icon!=""&&ptitle!=""&&href2!=""&&isCurrent!=""){
            sM2(level,title,ptitle,icon,isCurrent,href2);
        }else {
            alert("对应表单内容不能为空level3");
        }

    }

    if (level!=1&&level!=2&&level!=3){
        alert("菜单级别不正确");
    }

}

function sM2(level,title,ptitle,icon,isCurrent,href2) {
    $.ajax({
        url:"/MenuCreate2",
        type:"post",
        data:{
            level: level,
            title: title,
            ptitle: ptitle,
            icon : icon,
            isCurrent: isCurrent,
            href2: href2
        },
        dataType:"json",
        success:function (result) {
            if (result.status==0){
                $.messager.show({
                    title: 'Error',
                    msg: result.message
                });
            } else {
                alert(result.message);
                $('#dlg2').dialog('close');		// close the dialog
                window.location.reload();	// reload the user data
            }
        },
        error:function () {
            alert("请求失败")
        }
    });

}