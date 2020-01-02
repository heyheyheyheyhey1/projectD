$(".modifyUserInfo").on("click",function(){
    var obj = $(this);
    var status = obj.attr("status");
    if(status == "21" || status == "23"){//待审核、审核未通过状态下才可以进行修改操作
        window.location.href="appinfomodify?appId="+ obj.attr("appinfoid");
    }else{
        alert("该开发者的状态为：【"+obj.attr("statusname")+"】,不能修改！");
    }
});