<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<c:url value="/views/admin/static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Product Management</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="${url}/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${url}/css/font-awesome.css" rel="stylesheet" />
    <!-- MORRIS CHART STYLES-->

    <!-- CUSTOM STYLES-->
    <link href="${url}/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans'
          rel='stylesheet' type='text/css' />
    <!-- TABLE STYLES-->
    <link href="${url}/js/dataTables/dataTables.bootstrap.css"
          rel="stylesheet" />
</head>
<body>
<div id="wrapper">

    <jsp:include page="/common/admin/nav-bar.jsp"></jsp:include>

    <!-- /. NAV TOP  -->
    <jsp:include page="/common/admin/slide-bar.jsp"></jsp:include>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2>All Product</h2>
                    <h5>You can management product in here</h5>

                </div>
            </div>
            <!-- /. ROW  -->
            <hr />

            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <p>Advanced Tables | <a href="<c:url value="/admin/products/add"/>">Add New Product</a></p>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover"
                                       id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>ID </th>
                                        <th>Image</th>
                                        <th>Name</th>
                                        <th>Price(Đ)</th>
                                        <th>Category</th>
                                        <th>Description</th>
                                        <th>Action </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${products }" var="pro" >
                                        <tr class="odd gradeX">
                                            <td>${pro.getId() }</td>
                                            <c:url value="${pro.image}" var="imgUrl"></c:url>
                                            <td>
                                                <a href="/product/detail?id=${pro.getId() }">
                                                <img height="200" width="200" src="${imgUrl}" />
                                                </a>
                                            </td>

                                            <td>${pro.getName() }</td>
                                            <td>${pro.getPrice() }</td>
                                            <td>${pro.getCategory()}</td>
                                            <td>${pro.getShortDes() } </td>
                                            <td><a href="<c:url value='/product/detail?id=${pro.getId() }'/>"
                                                    class="center">Detail</a>
                                                <a href="<c:url value='/admin/products/edit?id=${pro.getId() }'/>"
                                                    class="center">Edit</a>
                                                <a href="<c:url value='/admin/products/delete?id=${pro.getId() }'/>"
                                                   class="center">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>


                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>

        </div>

    </div>
    <!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="${url}/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="${url}/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="${url}/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="${url}/js/dataTables/jquery.dataTables.js"></script>
<script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
</script>
<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>

</body>
</html>