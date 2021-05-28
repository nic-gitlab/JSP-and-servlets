<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>Doge Friends</h1>

<c:forEach items="${requestScope.dogsJspVariable}" var="individualDog" >
  <h2><c:out value="${individualDog.getFirstName()} ${individualDog.getLastName()}" /></h2>
  <img src=<c:out value="${individualDog.getPhotoUrl()}" /> />
</c:forEach>