<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url value="/views/web/static" var="url"></c:url>
<div class="topbar-v3">
    <div class="search-open">
        <div class="container">
            <input type="text" class="form-control" placeholder="Search">
            <div class="search-close">
                <i class="icon-close"></i>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <!-- Topbar Navigation -->
<%--                <ul class="left-topbar">--%>
<%--                    <li><a>Currency (USD)</a>--%>
<%--                        <ul class="currency">--%>
<%--                            <li class="active"><a href="#">USD <i--%>
<%--                                    class="fa fa-check"></i></a></li>--%>
<%--                            <li><a href="#">Euro</a></li>--%>
<%--                            <li><a href="#">Pound</a></li>--%>
<%--                        </ul></li>--%>
<%--                    <li><a>Language (EN)</a>--%>
<%--                        <ul class="language">--%>
<%--                            <li class="active"><a href="#">English (EN)<i--%>
<%--                                    class="fa fa-check"></i></a></li>--%>
<%--                            <li><a href="#">Spanish (SPN)</a></li>--%>
<%--                            <li><a href="#">Russian (RUS)</a></li>--%>
<%--                            <li><a href="#">German (GRM)</a></li>--%>
<%--                        </ul></li>--%>
<%--                </ul>--%>
                <!--/end left-topbar-->
            </div>
            <c:choose>
                <c:when test="${sessionScope.account == null}">
                    <div class="col-sm-6">
                        <ul class="list-inline right-topbar pull-right">
                            <li><a href="${pageContext.request.contextPath }/login">Đăng nhập</a>
                                | <a href="${pageContext.request.contextPath }/register">Đăng ký</a></li>
                            <li><i class="search fa fa-search search-button"></i></li>
                        </ul>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="col-sm-6">
                        <ul class="list-inline right-topbar pull-right">
<%--                            <li><a href="${pageContext.request.contextPath }/member/myaccount">Xin chào, ${account.getName()}</a>--%>
                                <li><a href="#">Xin chào, ${account.getName()}</a>
                                |
                                <a href="${pageContext.request.contextPath }/logout">Đăng xuất</a>
                            </li>
                            <li><i class="search fa fa-search search-button"></i></li>
                        </ul>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <!--/container-->
</div>
