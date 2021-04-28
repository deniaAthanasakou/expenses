<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <link href="/css/categories.css" rel="stylesheet" />
    <link href="css/main.css" rel="stylesheet" />

</head>
<body>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">Expenses App</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li class="active"><a href="/categories">Categories</a></li>
                <li><a href="/expenses">Expenses</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">

        <h1>Categories are:</h1>
        <div class="container">
            <c:set var="columnCounter" value="0" />
            <c:forEach items="${categories}" var="category">
                <c:choose>
                    <c:when test = "${columnCounter % 3 == 0}">
                        <div class="row">
                    </c:when>
                </c:choose>
                <div class="col-sm-4 center-block">
                    <div class="categoryCircle">
                        ${category.categoryName}
                            <c:set var="imageUrl" value="/expensesViewForm?categoryName=${category.categoryName}" />
                            <a href="${imageUrl}"><img src="/images/addAmountImg.png"  width="30" height="30"/></a>
                    </div>
                </div>
                 <c:choose>
                      <c:when test = "${columnCounter % 3 == 2}">
                        </div>
                      </c:when>
                 </c:choose>

                <c:set var="columnCounter" value="${columnCounter + 1}" />
            </c:forEach>
        </div>

    </div>



</body>

</html>