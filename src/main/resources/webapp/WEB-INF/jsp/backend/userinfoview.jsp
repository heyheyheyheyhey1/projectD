<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>查看开发者信息 <i class="fa fa-user"></i><small>${userSession.userName}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_title">
            <h2>开发者基础信息</h2>
          <div class="clearfix"></div>
      </div>
      <div class="x_content1">
        <form class="form-horizontal form-label-left" >
          <input type="hidden" name="id" value="${devTemp.id}">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">开发者名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" value="${devTemp.devName}"
              type="text" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">开发者邮箱 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" class="form-control col-md-7 col-xs-12"
              value="${devTemp.devEmail}" readonly="readonly">
            </div>
          </div>

            <div class="item form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">开发者状态 <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" class="form-control col-md-7 col-xs-12"
                           value="${devTemp.statusName}" readonly="readonly">
                </div>
            </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">开发者简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" readonly="readonly"
              	value="${devTemp.devInfo}" type="text">
            </div>
          </div>
        <div class="clearfix"></div>
        <div class="x_title">
            <h2>申请记录列表</h2>
            <ul class="nav navbar-right panel_toolbox">
              <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
              </li>
            </ul>
          <div class="clearfix"></div>
        </div>
        <div class="x_content" style="display: block;">
         <br>
        <div id="datatable-responsive_wrapper"
			class="dataTables_wrapper form-inline dt-bootstrap no-footer">
			<div class="row">
				<div class="col-sm-12">
					<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
						cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
						<thead>
							<tr role="row">
								<th class="sorting_asc" tabindex="0"
									aria-controls="datatable-responsive" rowspan="1" colspan="1"
									style="width: 70px;" aria-label="First name: activate to sort column descending"
									aria-sort="ascending">开发者名称</th>
								<th class="sorting" tabindex="0"
									aria-controls="datatable-responsive" rowspan="1" colspan="1"
									style="width: 50px;"
									aria-label="Last name: activate to sort column ascending">
									申请状态</th>
								<th class="sorting" tabindex="0"
									aria-controls="datatable-responsive" rowspan="1" colspan="1"
									style="width: 50px;"
									aria-label="Last name: activate to sort column ascending">
									申请理由</th>
								<th class="sorting" tabindex="0"
									aria-controls="datatable-responsive" rowspan="1" colspan="1"
									style="width: 50px;"
									aria-label="Last name: activate to sort column ascending">
									最新更新时间</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="devTemp" items="${devTempList }" varStatus="status">
								<tr role="row" class="odd">
									<td tabindex="0" class="sorting_1">${devTemp.devName}</td>
									<td>${devTemp.statusName }</td>
									<td>${devTemp.applyInfo }</td>
									<td><fmt:formatDate value="${devTemp.modifyDate }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
      </div>
    </div>
     <div class="form-group">
        <div class="col-md-6 col-md-offset-3">
          <button type="button" class="btn btn-primary" id="back">返回</button>
        </div>
      </div>
    <div class="clearfix"></div>
    <br/><br/>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/userinfoview.js"></script>