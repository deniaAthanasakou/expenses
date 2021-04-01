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

<div class="container">

    <h1>Category: ${category}</h1>
    <form action="/expenses/add">
        <div class="form-group">
            <label for="amount">Amount</label>
            <input type="number" class="form-control" min="0" id="amount" placeholder="Enter amount">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" class="form-control" id="description" placeholder="Enter description">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>



</body>

</html>