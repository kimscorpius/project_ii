<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url value="/views/web/static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sản phẩm theo mức giá</title>
    <link rel='stylesheet' type='text/css'
          href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

    <!-- CSS Global Compulsory -->
    <link rel="stylesheet"
          href="${url}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${url}/css/shop.style.css">

    <!-- CSS Header and Footer -->
    <link rel="stylesheet" href="${url}/css/headers/header-v5.css">
    <link rel="stylesheet" href="${url}/css/footers/footer-v4.css">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="${url}/plugins/animate.css">
    <link rel="stylesheet" href="${url}/plugins/line-icons/line-icons.css">
    <link rel="stylesheet"
          href="${url}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${url}/plugins/scrollbar/css/jquery.mCustomScrollbar.css">
    <link rel="stylesheet"
          href="${url}/plugins/owl-carousel/owl-carousel/owl.carousel.css">
    <link rel="stylesheet"
          href="${url}/plugins/revolution-slider/rs-plugin/css/settings.css">

    <!-- CSS Theme -->
    <link rel="stylesheet" href="${url}/css/theme-colors/default.css"
          id="style_color">

    <!-- CSS Customization -->
    <link rel="stylesheet" href="${url}/css/custom.css">
</head>
<body>
<!-- Subiz -->
<script>
    (function(s, u, b, i, z) {
        u[i] = u[i] || function() {
            u[i].t = +new Date();
            (u[i].q = u[i].q || []).push(arguments);
        };
        z = s.createElement('script');
        var zz = s.getElementsByTagName('script')[0];
        z.async = 1;
        z.src = b;
        z.id = 'subiz-script';
        zz.parentNode.insertBefore(z, zz);
    })(document, window, 'https://widgetv4.subiz.com/static/js/app.js',
        'subiz');
    subiz('setAccount', 'acqetkhujxyunuatbxzw');
</script>
<!-- End Subiz -->
<body class="header-fixed">
<div class="wrapper">
    <!--=== Header v5 ===-->
    <div class="header-v5 header-static">
        <!-- Topbar v3 -->
        <jsp:include page="/common/web/topbar.jsp"></jsp:include>
        <!-- End Topbar v3 -->

        <!-- Navbar -->
        <jsp:include page="/common/web/navbar.jsp"></jsp:include>
        <!-- End Navbar -->
    </div>
    <!--=== End Header v5 ===-->

    <!--=== Slider ===-->
    <jsp:include page="/common/web/slidebar.jsp"></jsp:include>
    <!--=== End Slider ===-->

    <!--=== Product Content ===-->
    <div class="container content-md">

        <div class="heading heading-v1 margin-bottom-40">
            <h2>DANH SÁCH</h2>
        </div>

        <!--=== Illustration v1 ===-->
        <div class="row illustration-v2">

            <c:forEach items="${products }" var="p">
                <c:url value="${p.image }" var="imgUrl"></c:url>

                <div class="col-md-3 col-sm-6 md-margin-bottom-30">
                    <div class="product-img">
                        <a href="${pageContext.request.contextPath }/product/detail?id=${p.id}">
                            <img width="280" height="280" src="${imgUrl }"
                                 alt="">
                        </a>
                        <a class="product-review"
                           href="${pageContext.request.contextPath }/product/detail?id=${p.id}">
                            Xem chi tiết sản phẩm
                        </a>
                        <a class="add-to-cart"
                           href="${pageContext.request.contextPath }/product/detail?id=${p.id}">
                            <i class="fa fa-shopping-cart"></i>Thêm vào đơn hàng
                        </a>
                    </div>
                    <div class="product-description product-description-brd">
                        <div class="overflow-h margin-bottom-5">
                            <div class="pull-left">
                                <h4 class="title-price">
                                    <a
                                            href="${pageContext.request.contextPath }/product/detail?id=${p.id}">${p.name }
                                    </a>
                                </h4>
                                <span class="gender">${p.shortDes }</span>

                            </div>
                            <div class="product-price">
                                <span class="title-price">${p.price }Đ</span>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
        <!--=== End Illustration v1 ===-->
    </div>
    <!--=== End Product Content ===-->

    <!--=== Shop Suvbscribe ===-->
    <div class="shop-subscribe">
        <div class="container">
            <div class="row">
                <div class="col-md-8 md-margin-bottom-20">
                    <strong>
                        <h3>
                            KÊNH THÔNG TIN
                        </h3>
                        <p>Mời bạn nhập email để nhận những thông tin khuyến mại mới nhất từ Laptop</p>
                    </strong>
                </div>
                <div class="col-md-4">
                    <div class="input-group">
                        <input type="text" class="form-control"
                               placeholder="Nhập email của bạn..."> <span
                            class="input-group-btn">
								<button class="btn" type="button">
									<i class="fa fa-envelope-o"></i>
								</button>
							</span>
                    </div>
                </div>
            </div>
        </div>
        <!--/end container-->
    </div>
    <!--=== End Shop Suvbscribe ===-->

    <!--=== Footer v4 ===-->
    <jsp:include page="/common/web/footer.jsp"></jsp:include>
    <!--=== End Footer v4 ===-->
</div>
<!--/wrapper-->

<!-- JS Global Compulsory -->
<script src="${url}/plugins/jquery/jquery.min.js"></script>
<script src="${url}/plugins/jquery/jquery-migrate.min.js"></script>
<script src="${url}/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- JS Implementing Plugins -->
<script src="${url}/plugins/back-to-top.js"></script>
<script src="${url}/plugins/smoothScroll.js"></script>
<script src="${url}/plugins/jquery.parallax.js"></script>
<script src="${url}/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
<script
        src="${url}/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script
        src="${url}/plugins/revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
<script
        src="${url}/plugins/revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
<!-- JS Customization -->
<script src="${url}/js/custom.js"></script>
<!-- JS Page Level -->
<script src="${url}/js/shop.app.js"></script>
<script src="${url}/js/plugins/owl-carousel.js"></script>
<script src="${url}/js/plugins/revolution-slider.js"></script>
<script>
    jQuery(document).ready(function() {
        App.init();
        App.initScrollBar();
        App.initParallaxBg();
        OwlCarousel.initOwlCarousel();
        RevolutionSlider.initRSfullWidth();
    });
</script>
<!--[if lt IE 9]>
    <script src="${url}/plugins/respond.js"></script>
    <script src="${url}/plugins/html5shiv.js"></script>
    <script src="${url}/js/plugins/placeholder-IE-fixes.js"></script>
<![endif]-->

</body>
</body>
</html>