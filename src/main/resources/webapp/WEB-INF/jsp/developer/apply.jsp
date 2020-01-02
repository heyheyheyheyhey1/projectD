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
            <h2>新增版本信息</h2>
            <ul class="nav navbar-right panel_toolbox">
              <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
              </li>
            </ul>
          <div class="clearfix"></div>
        </div>
        <div class="x_content" style="display: block;">
         <br>
        <form class="form-horizontal form-label-left" action="appversionadd" method="post" enctype="multipart/form-data">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">版本号 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="versionNo" class="form-control col-md-7 col-xs-12" 
               data-validate-length-range="20" data-validate-words="1" name="versionNo"  
               placeholder="请输入版本号" type="text"  required="required">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">版本大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="versionSize" name="versionSize"  required="required"
              data-validate-minmax="10,500"  placeholder="请输入版本大小，单位为Mb" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
       
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">发布状态 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" name="publishStatus" id="publishStatus" value="10">预发布
            </div>
          </div>
        
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">版本简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="versionInfo" name="versionInfo" required="required"
              placeholder="请输入本版本的相关信息，本信息作为该版本的详细信息进行版本介绍。" class="form-control col-md-7 col-xs-12"></textarea>
            </div>
          </div>
           <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">apk文件 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            <input type="file" class="form-control col-md-7 col-xs-12" name="a_downloadLink" id="a_downloadLink"  required="required"/>
            ${fileUploadError }
            </div>
          </div>
          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
            </div>
          </div>
        </form>
        </div>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/appversionadd.js"></script>