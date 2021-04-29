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

    <script data-require="jquery@*" data-semver="3.0.0" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.js"></script>
    <link data-require="datatables@*" data-semver="1.10.12" rel="stylesheet" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" />
    <link data-require="datatables@*" data-semver="1.10.12" rel="stylesheet" href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css" />
    <script data-require="datatables@*" data-semver="1.10.12" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
    <script src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
    <script src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
    <script src="//cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>

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

    <form action="/viewExpensesTable" method="post">
        <h5><b>Categories:</b></h5>
        <div class="form-group">
            <c:forEach items="${categories}" var="category">
                <div class="checkbox">
                    <label><input type="checkbox" name="${category.categoryName}" value="${category.id}">${category.categoryName}</label>
                </div>
            </c:forEach>
            <div class="checkbox">
                <label><input type="checkbox" value="" onclick="toggle(this);">Select All</label>
            </div>
        </div>

        <div class="form-group required"> <!-- From Date input -->
            <div class="input-group datepick">
                <input type="text" class="form-control" placeholder="YYYY/MM/DD" name="fromDate" id="fromDate" required readonly>
                <div class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </div>
            </div>
        </div>

        <div class="form-group required"> <!-- From To input -->
            <div class="input-group datepick">
                <input type="text" class="form-control" placeholder="YYYY/MM/DD" name="toDate" id="toDate" required readonly>
                <div class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </div>
            </div>
        </div>

        <div class="form-group"> <!-- Submit button -->
            <button class="btn btn-primary " name="submit" type="submit">View my expenses</button>
        </div>
    </form>

    <br>

    <c:choose>
        <c:when test = "${showTable == true}">

            <div id="exTab2" class="container">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a  href="#1" data-toggle="tab">Full Report</a>
                    </li>
                    <li>
                        <a href="#2" data-toggle="tab">Category Sums</a>
                    </li>
                </ul>

                <div class="tab-content ">
                    <div class="tab-pane active" id="1">
                        <h2>Expenses report:</h2>
                        <br>
                        <table class="table table-striped" id="fullReportTable">
                            <thead>
                            <tr>
                                <th>Category</th>
                                <th>Amount</th>
                                <th>Description</th>
                                <th>Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${amountList}" var="item">
                                <tr>
                                    <td>${item.categoryName}</td>
                                    <td>${item.amount}</td>
                                    <td>${item.description}</td>
                                    <td>${item.dateAdded}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div class="tab-pane" id="2">
                        <h2>Summed up report:</h2>
                        <br>
                        <table class="table table-striped" id="summarizedReportTable">
                            <thead>
                            <tr>
                                <th>Category</th>
                                <th>Amount</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${sumList}" var="item">
                                <tr>
                                    <td>${item.categoryName}</td>
                                    <td>${item.sum}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </c:when>
    </c:choose>


</div>



</body>

</html>