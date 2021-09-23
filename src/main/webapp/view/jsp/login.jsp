<%--
  Created by IntelliJ IDEA.
  User: denia
  Date: 23/9/21
  Time: 7:40 μ.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  <link href="css/main.css" rel="stylesheet" />
  <link href="css/login.css" rel="stylesheet" />

</head>
<body>
  <div class="container">
    <div id="login">
      <h3 class="text-center text-white pt-5">Login form</h3>
      <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
          <div id="login-column" class="col-md-6">
            <div id="login-box" class="col-md-12">
              <form id="login-form" class="form" action="/login" method="post">
                <h3 class="text-center text-info">Login</h3>
                <div class="form-group">
                  <label for="username" class="text-info">Username:</label><br>
                  <input type="text" name="username" id="username" class="form-control">
                </div>
                <div class="form-group">
                  <label for="password" class="text-info">Password:</label><br>
                  <input type="text" name="password" id="password" class="form-control">
                </div>
                <div class="form-group">
                  <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>