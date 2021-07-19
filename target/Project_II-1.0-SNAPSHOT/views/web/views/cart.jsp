<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Giỏ hàng</title>
    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">
    <c:url value="/views/web/static" var="url"></c:url>

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
          href="${url}/plugins/jquery-steps/css/custom-jquery.steps.css">
    <link rel="stylesheet"
          href="${url}/plugins/scrollbar/css/jquery.mCustomScrollbar.css">

    <!-- Style Switcher -->
    <link rel="stylesheet" href="${url}/css/plugins/style-switcher.css">

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

    <!--=== Breadcrumbs v4 ===-->
    <div class="breadcrumbs-v4">
        <div class="container">
            <h1>
                Welcome!
            </h1>
            <ul class="breadcrumb-v4-in">
                <li><a href="index.html">Trang chủ</a></li>
                <li><a href="">Sản phẩm</a></li>
                <li class="active">Giỏ hàng</li>
            </ul>
        </div>
        <!--/end container-->
    </div>
    <!--=== End Breadcrumbs v4 ===-->

    <!--=== Content Medium Part ===-->
    <div class="content-md margin-bottom-30">
        <div class="container">
            <form class="shopping-cart" action="#">
                <div>
                    <div class="header-tags">
                        <div class="overflow-h">
                            <h2>Giỏ hàng</h2>
                            <i class="rounded-x fa fa-check"></i>
                        </div>
                    </div>
                    <section>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>Sản phầm</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Tổng</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userOrderItemList}" var="orderItem">
                                    <tr>
                                        <td class="product-in-table">
                                            <img
                                                class="img-responsive" src="${orderItem.getProduct().getImage() }" alt="">
                                            <div class="product-it-in">
                                                <h3>${orderItem.getProduct().getName() }</h3>
                                                <span>${orderItem.getProduct().getShortDes() }</span>
                                            </div>
                                        </td>
                                        <td>${orderItem.getProduct().getPrice() }Đ</td>
                                        <td>${orderItem.getQuantity() }</td>
                                        <td class="shop-red">${orderItem.getProduct().getPrice() * orderItem.getQuantity() }Đ</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/member/order/remove?orderItemId=${orderItem.getId()}">
                                                <button type="button" class="close">
                                                    <span>&times;</span><span class="sr-only">Close</span>
                                                </button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </section>

                    <div class="coupon-code">
                        <div class="row">
                            <div class="col-sm-4 sm-margin-bottom-30">
                                <h3>Thêm mã giảm giá</h3><br>
                                <p>Nhập mã giảm giá của bạn</p>
                                <input class="form-control margin-bottom-10" name="code"
                                       type="text">
                                <button type="button" class="btn-u btn-u-sea-shop">
                                    Áp dụng
                                </button>
                            </div>
                            <div class="col-sm-3 col-sm-offset-5">
                                <ul class="list-inline total-result">
                                    <li>
                                        <h4>Tổng giá trị:</h4> <c:set var="total" value="${0}" /> <c:forEach
                                            items="${userOrderItemList}" var="orderItem">
                                        <c:set var="total"
                                               value="${total + orderItem.getQuantity() * orderItem.getProduct().getPrice()}" />
                                    </c:forEach>
                                        <div class="total-result-in">
                                            <span>${total }Đ</span>

                                        </div>
                                    </li>
                                    <li>
                                        <h4>Phí ship:</h4>
                                        <div class="total-result-in">
                                            <span class="text-right">Miễn phí</span>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li class="total-price">
                                        <h4>Tổng số tiền:</h4>
                                        <div class="total-result-in">
                                            <span>${total }Đ</span>

                                        </div>
                                    </li><br>
                                    <li>
                                        <a href="<c:url value="/member/ordering"/> ">
                                            <button type="button" class="btn-u btn-u-sea-shop">
                                                Đặt hàng
                                            </button>
                                        </a>
                                    </li><br>
                                    <li>
                                        <c:if test="${not empty alert}">
                                            Đặt hàng thành công
                                            <a href="<c:url value="/member/ordered"/> ">Xem đơn hàng đã mua?</a>
                                        </c:if>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <!--/end container-->
    </div>
    <!--=== End Content Medium Part ===-->

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
<script src="${url}/plugins/jquery-steps/build/jquery.steps.js"></script>
<script
        src="${url}/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script
        src="${url}/plugins/sky-forms-pro/skyforms/js/jquery.validate.min.js"></script>
<!-- JS Customization -->
<script src="${url}/js/custom.js"></script>
<!-- JS Page Level -->
<script src="${url}/js/shop.app.js"></script>
<script src="${url}/js/forms/page_login.js"></script>
<script src="${url}/js/plugins/stepWizard.js"></script>
<script src="${url}/js/forms/product-quantity.js"></script>
<script>
    jQuery(document).ready(function() {
        App.init();
        Login.initLogin();
        App.initScrollBar();
        StepWizard.initStepWizard();
        StyleSwitcher.initStyleSwitcher();
    });
</script>

<!--[if lt IE 9]>
    <script src="${url}/plugins/respond.js"></script>
    <script src="${url}/plugins/html5shiv.js"></script>
    <script src="${url}/plugins/sky-forms-pro/skyforms/js/sky-forms-ie8.js"></script>
<![endif]-->
<!--[if lt IE 10]>
    <script src="${url}/plugins/sky-forms-pro/skyforms/js/jquery.placeholder.min.js"></script>
<![endif]-->

</body>

</body>
</html>