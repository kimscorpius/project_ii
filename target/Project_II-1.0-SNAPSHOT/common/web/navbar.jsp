<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url value="/views/web/static" var="url"></c:url>

<div class="navbar navbar-default mega-menu" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/home">
                <img id="logo-header" src="${url}/img/logo.png" alt="Logo">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-responsive-collapse">
            <!-- Shopping Cart -->
<%--            <jsp:include page="/view/client/view/cart.jsp"></jsp:include>--%>
            <!-- End Shopping Cart -->

            <!-- Nav Menu -->
            <ul class="nav navbar-nav">
                <!-- Pages -->
                <li class="dropdown active">
                    <a href="<c:url value="/home"/>">
                        Trang chủ
                    </a>
                </li>
                <!-- End Pages -->

                <!-- Promotion -->
                <li class="dropdown">
                    <a href="<c:url value="/member/cart"/>">
                        Giỏ hàng
                    </a>
                </li>
                <!-- End Promotion -->

                <!-- Gifts -->
                <li class="dropdown mega-menu-fullwidth">
                    <a href="<c:url value="/member/ordered"/> ">
                        Đơn hàng
                    </a>
                </li>
                <!-- End Gifts -->

                <!-- Books -->
                <li class="dropdown">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">
                        THƯƠNG HIỆU
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/trade-mark/dell"/>">DELL</a></li>
                        <li><a href="<c:url value="/trade-mark/lenovo"/>">LENOVO</a></li>
                        <li><a href="<c:url value="/trade-mark/acer"/>">ACER</a></li>
                        <li><a href="<c:url value="/trade-mark/hp"/>">HP</a></li>
                    </ul>
                </li>
                <!-- End Books -->

                <!-- Clothes -->
                <li class="dropdown">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown" data-delay="1000">
                        MỨC GIÁ
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/price?max=10000000&min=0"/>">DƯỚI 10 TRIỆU</a></li>
                        <li><a href="<c:url value="/price?max=15000000&min=10000000"/>">10-15 TRIỆU</a></li>
                        <li><a href="<c:url value="/price?max=20000000&min=15000000"/>">15-20 TRIỆU</a></li>
                        <li><a href="<c:url value="/price?max=0&min=20000000"/>">TRÊN 20 TRIỆU</a></li>
                    </ul>
                </li>
                <!-- End Clothes -->

                <!-- Main Demo -->
                <li><a href="${pageContext.request.contextPath }">Demo</a></li>
                <!-- Main Demo -->
            </ul>
            <!-- End Nav Menu -->
        </div>
    </div>
</div>