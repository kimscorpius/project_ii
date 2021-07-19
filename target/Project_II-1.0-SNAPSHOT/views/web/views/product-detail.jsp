<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <c:url value="/views/web/static" var="url"></c:url>
    <meta charset="UTF-8">
    <title>${product.name}</title>
    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">

    <!-- Web Fonts -->
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
          href="${url}/plugins/sky-forms-pro/skyforms/css/sky-forms.css">
    <link rel="stylesheet"
          href="${url}/plugins/sky-forms-pro/skyforms/custom/custom-sky-forms.css">
    <link rel="stylesheet"
          href="${url}/plugins/master-slider/quick-start/masterslider/style/masterslider.css">
    <link rel='stylesheet'
          href="${url}/plugins/master-slider/quick-start/masterslider/skins/default/style.css">

    <!-- Style Switcher -->
    <link rel="stylesheet" href="${url}/css/plugins/style-switcher.css">

    <!-- CSS Theme -->
    <link rel="stylesheet" href="${url}/css/theme-colors/default.css"
          id="style_color">

    <!-- CSS Customization -->
    <link rel="stylesheet" href="${url}/css/custom.css">
</head>
<body>
<body class="header-fixed">
<div class="wrapper">
    <!--=== Header v5 ===-->
    <div class="header-v5 header-static">
        <!-- Topbar v3 -->
        <jsp:include page="../../../common/web/topbar.jsp"></jsp:include>
        <!-- End Topbar v3 -->

        <!-- Navbar -->
        <jsp:include page="../../../common/web/navbar.jsp"></jsp:include>
        <!-- End Navbar -->
    </div>
    <!--=== End Header v5 ===-->

    <!--=== Shop Product ===-->
    <div class="shop-product">
        <!-- Breadcrumbs v5 -->
        <div class="container">
            <ul class="breadcrumb-v5">
                <li><a href="index.html"><i class="fa fa-home"></i></a></li>
                <li><a href="#">Sảm phẩm</a></li>
                <li class="active">Chi tiết</li>
            </ul>
        </div>
        <!-- End Breadcrumbs v5 -->

        <div class="container">
            <div class="row">
                <div class="col-md-6 md-margin-bottom-50">
                    <div class="ms-showcase2-template">
                        <!-- Master Slider -->
                        <div class="master-slider ms-skin-default" id="masterslider">
                            <div class="ms-slide">
                                <c:url value="${product.getImage() }" var="imgUrl"></c:url>
<%--                                <img class="ms-brd" src="${url}/img/blank.gif"--%>
<%--                                     data-src="${imgUrl}" alt="${product.name }">--%>
                                <img class="ms-brd" src="${url}/img/blank.gif"
                                     data-src="${imgUrl}" alt="${product.name }">
                            </div>

                            <br>
                            <div class="shop-product-heading">
                                <h4>Đặc điểm nổi bật</h4>
                            </div>

                            ${product.des}
                        </div>
                        <!-- End Master Slider -->
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="shop-product-heading">
                        <h3>${product.name }</h3>
                    </div>
                    <!--/end shop product social-->

                    <br>
                    <ul class="list-inline shop-product-prices margin-bottom-30">
                        <li class="shop-red">${product.price }Đ</li>
                    </ul>
                    <!--/end shop product prices-->

                    <ul class="list-inline product-size margin-bottom-30">
                        <li>${product.shortDes }Đ</li>
                    </ul>

                    <h3 class="shop-product-title">CPU: ${product.cpu }</h3>

                    <h3 class="shop-product-title">Màn hình: ${product.screen }</h3>

                    <h3 class="shop-product-title">RAM: ${product.ram }</h3>

                    <h3 class="shop-product-title">Ổ cứng: ${product.hardDrive }</h3>

                    <h3 class="shop-product-title">Card đồ họa: ${product.graphicsCard }</h3><br>

                        <form name="f1" class="product-quantity sm-margin-bottom-20"
                              method="get" action="<c:url value="/member/order/add"></c:url>">
                            <input type="text" value="${product.id }" name="pId" hidden="">
                            <button type='button' class="quantity-button" name='subtract'
                                    onclick='javascript: subtractQty();' value='-'>-</button>
                            <input type='text' class="quantity-field" name='quantity'
                                   value="1" id='qty' />
                            <button type='button' class="quantity-button" name='add'
                                    onclick='javascript: document.getElementById("qty").value++;'
                                    value='+'>+</button>
                            <button type="submit" class="btn-u btn-u-sea-shop btn-u-lg">Mua hàng</button>
                        </form>

                    </div>
                    <!--/end product quantity-->
                </div>
            </div>
            <!--/end row-->
        </div>
    </div>
    <!--=== End Shop Product ===-->

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
    <jsp:include page="../../../common/web/footer.jsp"></jsp:include>
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
<script src="${url}/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
<script
        src="${url}/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
<!-- Master Slider -->
<script
        src="${url}/plugins/master-slider/quick-start/masterslider/masterslider.min.js"></script>
<script
        src="${url}/plugins/master-slider/quick-start/masterslider/jquery.easing.min.js"></script>
<!-- JS Customization -->
<script src="${url}/js/custom.js"></script>
<!-- JS Page Level -->
<script src="${url}/js/shop.app.js"></script>
<script src="${url}/js/plugins/owl-carousel.js"></script>
<script src="${url}/js/plugins/master-slider.js"></script>
<script src="${url}/js/forms/product-quantity.js"></script>
<script>
    jQuery(document).ready(function() {
        App.init();
        App.initScrollBar();
        OwlCarousel.initOwlCarousel();
        MasterSliderShowcase2.initMasterSliderShowcase2();
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