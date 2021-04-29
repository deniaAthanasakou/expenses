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
                <a class="navbar-brand" href="/">ExpensesApp</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
                <li><a href="/categories">Categories</a></li>
                <li><a href="/expenses">Expenses</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">

        <div class="starter-template">
            <h1>${message}</h1>
            <br>
            <p>This is an app for your expenses report. You can create and view categories, as well as add and view your expenses.</p>
            <p>Have fun!</p>
        </div>
    </div>
</body>

</html>