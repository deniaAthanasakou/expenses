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

    <!--  jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

    <!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

    <!-- Bootstrap Date-Picker Plugin -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    <link href="/css/categories.css" rel="stylesheet" />
    <link href="css/main.css" rel="stylesheet" />

    <script type="text/javascript" src="js/expensesView.js"></script>


</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">ExpensesApp</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/">Home</a></li>
            <li><a href="/categories">Categories</a></li>
            <li class="active"><a href="/expenses">Expenses</a></li>
        </ul>
    </div>
</nav>

<div class="container">

    <h2>Select the info you want to view in your expenses report</h2>
    <br>

    <form action="/" method="post">
        <h4><b>Categories:</b></h4>
        <div class="form-group">
            <c:forEach items="${categories}" var="category">
                <div class="checkbox">
                    <label><input type="checkbox" value="${category.id}">${category.categoryName}</label>
                </div>
            </c:forEach>
            <div class="checkbox">
                <label><input type="checkbox" value="" onclick="toggle(this);">Select All</label>
            </div>
        </div>

        <div class="form-group"> <!-- From Date input -->
            <label class="control-label" for="fromDate">From:</label>
            <input class="form-control" id="fromDate" name="fromDate" placeholder="DD/MM/YYYY" type="text"/>
        </div>

        <div class="form-group"> <!-- To Date input -->
            <label class="control-label" for="toDate">To:</label>
            <input class="form-control" id="toDate" name="fromDate" placeholder="DD/MM/YYYY" type="text"/>
        </div>

        <div class="form-group"> <!-- Submit button -->
            <button class="btn btn-primary " name="submit" type="submit">View my expenses</button>
        </div>
    </form>


</div>



</body>

</html>