<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<h1>Resturant Review</h1>
<div class="container">

<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr><th>ReviewId</th><th>DateVisited</th><th>Rating</th><th>CustomerName<th></tr>
    </thead>
    <tbody>
    
    <c:forEach var="post" items="${posts}">
    
       <tr>
        <td><c:out value="${post.reviewid}"/></td>
        <td><c:out value="${post.datevisited}" /></td>
        <td><c:out value="${post.rating}" /></td>
         <td><c:out value="${post.customer.customername}" /></td>
        </tr>
      
    </c:forEach>
    
    
    </tbody>
    </table>

</div>

</body>
</html>