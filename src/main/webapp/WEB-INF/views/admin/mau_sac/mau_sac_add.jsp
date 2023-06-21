<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="container">

<form action="add" method="post">
    <div class="form-group">
        Tên màu:<input type="text" name="ten" class="form-control">
    </div>

    <div class="form-group">
        Giá trị:<input type="text" name="giaTri" class="form-control">
    </div>

    <div class="form-check">
        Trạng thái:
        <div>
            <input type="radio" name="trangThai" value="true" class="form-check-input"> Đang hoạt động
        </div>
        <div>
            <input type="radio" name="trangThai" value="false" class="form-check-input"> Ngưng hoạt động
        </div>
    </div>
    <button class="btn btn-success">Thêm</button>
</form>

<table class="table">
    <tr>
        <td>Tên màu sắc</td>
        <td>Giá trị</td>
        <td>Trạng thái</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${listMauSac}" var="ms">
        <tr>
            <td>${ms.ten}</td>
            <td>${ms.giaTri}</td>
            <td>${ms.trangThai}</td>
            <td>
                <a href="/mau-sac/detail/${ms.id}" class="btn btn-success">Detail</a>
                <a href="/mau-sac/delete/${ms.id}" class="btn btn-danger"
                   onclick="return confirm('Bạn chắc chắn có muốn xóa??')">Remove</a>
                <a href="/mau-sac/update-view/${ms.id}" class="btn btn-warning">Update</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>