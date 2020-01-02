console.log("fffffffuckufkcckkckck")
$(".checkUser").on("click",function(){
    var obj = $(this);
    var status = obj.attr("status");
    var did = obj.attr("devtmpid");
    if(status == "21" && did != "" && did != null){//待审核状态下才可以进行审核操作
        window.location.href="usercheck?did="+ obj.attr("devtmpid");
    }else if(status == "22"){
        alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能进行审核操作！");
    }
});