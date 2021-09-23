<%--
  Created by IntelliJ IDEA.
  User: denia
  Date: 23/9/21
  Time: 7:42 μ.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Oops!</title>
  <link rel="stylesheet" th:href="@{/css/login.css}"></link>
</head>

<html>
<div class="errorPage">
  <span class="oops">Oops!</span><br/>
  <img th:src="@{/images/MissingPage.png}"></img>
  <p>There seems to be a problem with the page you requested
    (<span text="${path}">/readingList</span>).</p>
  <p th:text="${'Details: ' + message}"></p>
</div>
</html>

</html>
