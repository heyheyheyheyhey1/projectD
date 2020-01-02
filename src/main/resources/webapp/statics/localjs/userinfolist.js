$(".modifyUserInfo").on("click", function () {
    var obj = $(this);
    var status = obj.attr("status");
    if (status == "21" || status == "23") {//待审核、审核未通过状态下才可以进行修改操作
        window.location.href = "userinfomodify?devId=" + obj.attr("devid");
    } else {
        alert("该开发者的状态为：【" + obj.attr("statusname") + "】,不能修改！");
    }
});
function disableUser() {
    let el=document.getElementById("btn_devUser_disable")
    let id = el.getAttribute("devid")
    console.log("disable user"+id)
    axios.get(`disable?devId=${id}`)
        .then(res=>{
            console.log("res"+ res)
            if (res.data.status!="ok"){
                alert("操作失败")
            }
            else {
                alert("操作成功")
            }

            location.reload()
        })
        .catch(err=>{
            alert("请求错误!")
            console.log(err)
        })
}
function enableUser() {
    let el=document.getElementById("btn_devUser_enable")
    let id = el.getAttribute("devid")
    console.log("enable user"+id)
    axios.get(`enable?devId=${id}`)
        .then(res=>{
            console.log("res"+ res)
            if (res.data.status!="ok"){
                alert("操作失败")
            }
            else {
                alert("操作成功")
            }
            location.reload()
        })
        .catch(err=>{
            alert("请求错误!")
            console.log(err)
        })

}
function loadStatusList() {
    let el = document.getElementById("")
    axios.get(`delUser?devId=${id}`)
        .then(res=>{
            console.log("res"+ res)
            if (res.data.status!="ok"){
            }
            else {

            }
        })
        .catch(err=>{
            alert("请求错误!")
            console.log(err)
        })
}