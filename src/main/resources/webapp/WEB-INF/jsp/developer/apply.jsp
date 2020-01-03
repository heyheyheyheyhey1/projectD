<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_content1">
      <div class="clearfix"></div>
	  <p class="text-muted font-13 m-b-30"></p>
        <div class="clearfix"></div>
        <div class="x_title">
            <h2>新增申请信息</h2>
            <ul class="nav navbar-right panel_toolbox">
              <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
              </li>
            </ul>
          <div class="clearfix"></div>
        </div>
        <div class="x_content" style="display: block;">
         <br>
        <form class="form-horizontal form-label-left" action="devApply" method="post" enctype="multipart/form-data">

          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">简要介绍<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="applyInfo" name="applyInfo" required="required"
              placeholder="输入有关与你的申请介绍" class="form-control col-md-7 col-xs-12"></textarea>
            </div>
          </div>
          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button id="send" type="submit" class="btn btn-success">确认</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
            </div>
          </div>
        </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script>
  document.getElementById("back").onclick=()=>{
    history.go(-1);
  }
</script>
<%@include file="common/footer.jsp"%>