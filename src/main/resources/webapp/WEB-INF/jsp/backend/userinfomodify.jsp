<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>修改开发者基础信息 <i class="fa fa-user"></i><small>${userSession.userName}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
        <form class="form-horizontal form-label-left" action="userinfomodifysave" method="post" enctype="multipart/form-data">
          <input type="hidden" name="querydevId" id="id" value="${devInfo.id}">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">开发者用户名 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="devName" class="form-control col-md-7 col-xs-12"
               data-validate-length-range="20" data-validate-words="1"
               name="querydevName" value="${devInfo.devName}" required="required"
               placeholder="请输入开发者用户名" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">开发者邮箱 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="devEmail" type="text" class="form-control col-md-7 col-xs-12"
              name="querydevEmail" value="${devInfo.devEmail}" required="required"
                     placeholder="请输入开发者邮箱" type="text">
            </div>
          </div>

          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">开发者状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="statusName" type="text" class="form-control col-md-7 col-xs-12"
                     name="statusName" value="${devInfo.statusName}" readonly="readonly">
              <input name="status" value="${devInfo.status}" type="hidden" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">开发者简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="devInfo" name="querydevInfo" required="required"
                        placeholder="请输入开发者的相关信息，本信息作为审核开发者的重要参考资料。" class="form-control col-md-7 col-xs-12">
                ${devInfo.devInfo}</textarea>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
            	<c:if test="${devInfo.status == 23}">
            	 	<button id="send" type="submit" name="status" value="1" class="btn btn-success">保存并再次提交审核</button>
            	</c:if>
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/userinfomodify.js"></script>