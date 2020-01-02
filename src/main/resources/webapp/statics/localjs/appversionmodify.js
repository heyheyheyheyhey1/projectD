function delfile(id){
	$.ajax({
		type:"GET",//请求类型
		url:"delfile",//请求的url
		data:{versionId:id},//请求参数
		success:function(data){//data：返回数据（json对象）
			if(data.status == "ok"){
				alert("删除成功！");
				$("#uploadfile").show();
				$("#apkFile").html('');
			}else {
				alert("删除失败！"+data.info);
			}
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("请求错误！");
		}
	});  
}

$(function(){  
	$("#back").on("click",function(){
		history.back();
	});
	
	//上传APK文件---------------------
	var downloadLink = $("#downloadLink").val();
	var id = $("#id").val();
	var apkFileName = $("#apkFileName").val();
	if(downloadLink == null || downloadLink == "" ){
		$("#uploadfile").show();
	}else{
		$("#apkFile").append("<p>"+apkFileName+
							"&nbsp;&nbsp;<a href=\""+downloadLink+"?m="+Math.random()+"\" >下载</a> &nbsp;&nbsp;" +
							"<a href=\"javascript:;\" onclick=\"delfile('"+id+"');\">删除</a></p>");
	}

});
      
      
      