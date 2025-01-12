<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamlinh
  Date: 7/10/24
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>HOME</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId"
            aria-controls="collapsibleNavId"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavId">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/category">CATEGORY</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/book">BOOK</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Dropdown</a>
                <div class="dropdown-menu" aria-labelledby="dropdownId">
                    <a class="dropdown-item" href="#">Action 1</a>
                    <a class="dropdown-item" href="#">Action 2</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<f:form action="" method="post" modelAttribute="book" enctype="multipart/form-data">
    <div class="form-group">
        <label >Name</label>
        <f:input path="name" class="form-control"  type = "text" />
    </div>
    <div class="form-group">
        <label >Author</label>
        <f:input path="author" class="form-control"  type = "text" />
    </div>
    <div class="form-group">
        <label >Publisher</label>
        <f:input path="publisher" class="form-control"  type = "text" />
    </div>
    <div class="form-group">
        <label >Price</label>
        <f:input path="price" class="form-control"  type = "text" />
    </div>
    <div class="form-group">
        <label >Image</label>
        <input type="file" class="form-control-file" name="img" />

    </div>

    <div class="form-group">
        <label >Description</label>
        <f:input path="description" class="form-control"  type = "text" />
    </div>
    <div class="form-group">
        <div class="form-check form-check-inline">
            <label class="form-check-label">
                <f:radiobutton path="status" value="1" cssClass="form-check-input"  />Active
            </label>
        </div>

        <div class="form-check form-check-inline">
            <label class="form-check-label">
                <f:radiobutton path="status" value="0" cssClass="form-check-input" />Inactive
            </label>
        </div>
    </div>
<%--    --------%>
    <f:select path="category.id">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </f:select>
<%--    ----------%>
    <button type="submit" class="btn btn-primary">Submit</button>
</f:form>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
