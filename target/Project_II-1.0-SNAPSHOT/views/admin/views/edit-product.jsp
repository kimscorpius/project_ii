<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<c:url value="/views/admin/static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
    <script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit Product</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="${url}/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${url}/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLES-->
    <link href="${url}/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans'
          rel='stylesheet' type='text/css' />
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
                    <h2>Edit product</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <hr />
            <div class="row">
                <div class="col-md-12">
                    <!-- Form Elements -->
                    <div class="panel panel-default">
                        <div class="panel-heading">Edit Product</div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <h3>Info Product:</h3>

                                    <c:url value="/admin/products/edit" var="edit"></c:url>
                                    <form role="form" action="${edit }" method="post"
                                          enctype="multipart/form-data" accept-charset="UTF-8">
                                        <input name="id" value="${product.id }" hidden="">
                                        <div class="form-group">
                                            <label>Name:</label>
                                            <input class="form-control"
                                                   placeholder="please enter Product Name" name="name" value="${product.name}" />
                                        </div>

                                        <div class="form-group">
                                            <label>Price (đ)</label>
                                            <input class="form-control"
                                                   placeholder="please enter Price" type="number" name="price" value="${product.price}" />
                                        </div>

                                        <div class="form-group">
                                            <label>Image</label>
                                            <input class="form-control"
                                                   placeholder="please enter link to Image" name="image" value="${product.image}" />
                                        </div>

                                        <div class="form-group">
                                            <label>Description </label>
                                            <br>
                                            <textarea rows="4" cols="50" name="des" id="editer">${product.des}</textarea>
                                        </div>

                                        <div class="form-group">
                                            <label>Short Description</label>
                                            <input class="form-control"
                                                   placeholder="please enter Short Description" name="shortDes" value="${product.shortDes}" />
                                        </div>

                                        <div class="form-group">
                                            <label>Ram</label>
                                            <input class="form-control"
                                                   placeholder="please enter Ram" name="ram" value="${product.ram}" />
                                        </div>

                                        <div class="form-group">
                                            <label>CPU</label>
                                            <input class="form-control"
                                                   placeholder="please enter CPU" name="cpu" value="${product.cpu}"/>
                                        </div>

                                        <div class="form-group">
                                            <label>Screen</label>
                                            <input class="form-control"
                                                   placeholder="please enter Screen" name="screen" value="${product.screen}"/>
                                        </div>

                                        <div class="form-group">
                                            <label>Hard Drive</label>
                                            <input class="form-control"
                                                   placeholder="please enter Hard Drive" name="hardDrive" value="${product.hardDrive}"/>
                                        </div>

                                        <div class="form-group">
                                            <label>Graphics Card</label>
                                            <input class="form-control"
                                                   placeholder="please enter Graphics Card" name="graphicsCard" value="${product.graphicsCard}" />
                                        </div>

                                        <div class="form-group">
                                            <label>Trade Mark</label>
                                            <input class="form-control"
                                                   placeholder="please enter Trade Mark" name="tradeMark" value="${product.tradeMark}"/>
                                        </div>

                                        <div class="form-group">
                                            <label>Connector</label>
                                            <input class="form-control"
                                                   placeholder="please enter Connector" name="connector" value="${product.connectors}"/>
                                        </div>

                                        <div class="form-group">
                                            <label>Pin</label>
                                            <input class="form-control"
                                                   placeholder="please enter Monitor Card" name="pin" value="${product.pin}"/>
                                        </div>

                                        <div class="form-group">
                                            <label>Weight</label>
                                            <input class="form-control"
                                                   placeholder="please enter Weight" name="weight" value="${product.weight}"/>
                                        </div>

                                        <div class="form-group">
                                            <label>Size</label>
                                            <input class="form-control"
                                                   placeholder="please enter Size" name="size" value="${product.size}"/>
                                        </div>

                                        <div class="form-group">
                                            <label>Category</label>
                                            <input class="form-control"
                                                   placeholder="please enter Category" name="category" value="${product.category}" />
                                        </div>

                                        <button type="submit" class="btn btn-default">Edit</button>
                                        <button type="reset" class="btn btn-primary">Reset</button>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End Form Elements -->
                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <div class="col-md-12"></div>
            </div>
            <!-- /. ROW  -->
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="${url}/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="${url}/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="${url}/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>
<script type="text/javascript" language="javascript">
    CKEDITOR.replace('editer', {width: '700px',height: '300px'});
</script>
</body>
</html>