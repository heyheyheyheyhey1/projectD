<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>
<div class="clearfix"></div>
<div class="col-md-12">
    <div class="x_panel">
        <div class="x_title">
            <h2>
                开发者用户 信息管理维护 <i class="fa fa-user"></i><small>${userSession.userName}
                - 您可以通过搜索或者其他的筛选项对开发者用户的信息进行修改、删除等管理操作。^_^</small>
            </h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <form method="post" action="listinfo">
                <input type="hidden" name="pageIndex" value="1"/>
                <ul>

                    <li>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">开发者名称</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input name="queryDevName" type="text" class="form-control col-md-7 col-xs-12"
                                       value="${pageInfo.queryDevName}">
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">开发者邮箱</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input name="queryDevEmail" type="text" class="form-control col-md-7 cDol-xs-12"
                                       value="${pageInfo.queryDevEmail}">
                            </div>
                        </div>
                    </li>
                    <br/>
                    <li>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">开发者状态</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select name="queryStatusId" class="form-control">
                                    <c:if test="${statusList != null }">
                                        <option value="">--请选择--</option>
                                        <c:forEach var="op" items="${statusList}">
                                            <option
                                                    <c:if test="${pageInfo.queryStatusId!=null&&op.id == pageInfo.queryStatusId }">selected="selected"</c:if>
                                                    value="${op.id}">${op.typeName}</option>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </div>
                        </div>
                    </li>

                    <li>
                        <button type="submit" class="btn btn-primary" id="btn_search"> 查询</button>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_content">
            <p class="text-muted font-13 m-b-30"></p>
            <div id="datatable-responsive_wrapper"
                 class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                <div class="row">
                    <div class="col-sm-12">
                        <table id="datatable-responsive"
                               class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
                               cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info"
                               style="width: 100%;">
                            <thead>
                            <tr role="row">
                                <th class="sorting_asc" tabindex="0"
                                    aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                    style="width: 70px;" aria-label="First name: activate to sort column descending"
                                    aria-sort="ascending">开发者用户名称
                                </th>
                                <th class="sorting" tabindex="0"
                                    aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                    style="width: 10px;"
                                    aria-label="Last name: activate to sort column ascending">
                                    邮箱
                                </th>
                                <th class="sorting" tabindex="0"
                                    aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                    style="width: 30px;"
                                    aria-label="Last name: activate to sort column ascending">
                                    状态
                                </th>
                                <th class="sorting" tabindex="0"
                                    aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                    style="width: 30px;"
                                    aria-label="Last name: activate to sort column ascending">
                                    操作
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="devList" items="${devTemp }" varStatus="status">
                                <tr role="row" class="odd">
                                    <td tabindex="0" class="sorting_1">${devList.devName }</td>
                                    <td>${devList.devEmail }</td>
                                    <td>${devList.statusName }</td>
                                    <td>


                                        <div class="btn-group">
                                            <button type="button" class="btn btn-danger">点击操作</button>
                                            <button type="button" class="btn btn-danger dropdown-toggle"
                                                    data-toggle="dropdown" aria-expanded="false">
                                                <span class="caret"></span>
                                                <span class="sr-only">Toggle Dropdown</span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a class="addVersion" devid="${devList.id }" data-toggle="tooltip"
                                                       data-placement="top" title="" data-original-title="新增开发者信息">新增开发者信息</a>
                                                </li>

                                                <li><a class="modifyUserInfo"
                                                       devid="${devList.id }" devname="${devList.devName }"
                                                       devemail="${devList.devEmail }"
                                                       statusname="${devList.statusName }" devinfo="${devList.devInfo }"
                                                       status="${devList.status}"
                                                       data-toggle="tooltip" data-placement="top"
                                                       data-original-title="修改开发者信息">修改开发者信息</a>
                                                </li>
                                                <li><a  class="viewUser" devid=${devList.id }  data-toggle="tooltip" data-placement="top" title="" data-original-title="查看开发者基础信息以及全部申请记录">查看</a></li>

                                                <li><a class="deleteApp" devid='${devList.id}'
                                                       devname="${devList.devName }" data-toggle="tooltip"
                                                       data-placement="top"
                                                       data-original-title="删除开发者基本信息"  onclick="delDevUser(${devList.id})"  >删除</a>
                                                </li>

                                                <c:if test="${devList.status==22}">
                                                    <li><a class="deleteApp" devid='${devList.id}'
                                                           data-toggle="tooltip"
                                                           data-placement="top"
                                                           data-original-title="禁用" id="btn_devUser_disable" onclick="disableUser()">禁用</a>
                                                    </li>
                                                </c:if>
                                                <c:if test="${devList.status==24}">
                                                    <li><a class="deleteApp" devid='${devList.id}'
                                                           data-toggle="tooltip"
                                                           data-placement="top"
                                                           data-original-title="启用" id="btn_devUser_enable" onclick="enableUser()" >启用</a>
                                                    </li>
                                                </c:if>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-5">
                        <div class="dataTables_info" id="datatable-responsive_info"
                             role="status" aria-live="polite">共${pages.totalCount }条记录
                            <c:if test="${pages.totalPageCount == 0}">
                                0/${pages.totalPageCount }页
                            </c:if>
                            <c:if test="${pages.totalPageCount > 0}">
                                ${pages.currentPageNo }/${pages.totalPageCount }页
                            </c:if>
                        </div>
                        <div class="col-sm-7">
                            <div class="dataTables_paginate paging_simple_numbers"
                                 id="datatable-responsive_paginate">
                                <ul class="pagination">
                                    <c:if test="${pages.currentPageNo > 1}">
                                        <li class="paginate_button previous"><a
                                                href="javascript:page_nav(document.forms[0],1);"
                                                aria-controls="datatable-responsive" data-dt-idx="0"
                                                tabindex="0">首页</a>
                                        </li>
                                        <li class="paginate_button "><a
                                                href="javascript:page_nav(document.forms[0],${pages.currentPageNo-1});"
                                                aria-controls="datatable-responsive" data-dt-idx="1"
                                                tabindex="0">上一页</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${pages.currentPageNo < pages.totalPageCount }">
                                        <li class="paginate_button "><a
                                                href="javascript:page_nav(document.forms[0],${pages.currentPageNo+1 });"
                                                aria-controls="datatable-responsive" data-dt-idx="1"
                                                tabindex="0">下一页</a>
                                        </li>
                                        <li class="paginate_button next"><a
                                                href="javascript:page_nav(document.forms[0],${pages.totalPageCount });"
                                                aria-controls="datatable-responsive" data-dt-idx="7"
                                                tabindex="0">最后一页</a>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp" %>
<script src="${pageContext.request.contextPath }/statics/localjs/rollpage.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/userinfolist.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/axios.js"></script>