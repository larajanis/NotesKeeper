<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>Digi Learn - Application</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="${contextPath}/resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="${contextPath}/resources/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="${contextPath}/resources/css/home.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
  <nav class="white" role="navigation">
    <div class="nav-wrapper container">
        <img style="height:60px;" src=${contextPath}/resources/images/psna-log0.jpg id="logo-container">
	 
	 <ul class="right hide-on-med-and-down">
        <li>
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <a onclick="document.forms['logoutForm'].submit()">Logout</a></li>
      </ul>
	 
	 <ul class="right hide-on-med-and-down">
        <li><a href="#">Welcome ${user.username}!</a></li>
      </ul>
      
     <ul class="right hide-on-med-and-down">
        <li><a href="#">About Us</a></li>
      </ul>
      
      <ul id="nav-mobile" class="sidenav">
        <li><a href="#">Navbar Link</a></li>
      </ul>
      <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  <div class ="content">
  <div class="row">
  <div class="col s12 content-space">
  <div class="col s3 side-year">
  <ul class="collection with-header">
        <li class="collection-header"><h4>List of courses:</h4></li>
        <c:forEach items="${courses}" var="course" varStatus="loop">
        <a href="/course/${course.id}" class="collection-item">${course.courseName}</a>
        </c:forEach>
      </ul>
  </div>
  
  <div class="col s9 content-right z-depth-1">
 <div class="row">
      <div class="col s6">
   <ul class="collection with-header">
        <li class="collection-header"><h4>Details</h4></li>
        <li class="collection-item">Name : ${user.username}</li>
        <li class="collection-item">Department : ${user.department}</li>
        <li class="collection-item">Email : ${user.email}</li>
      </ul>
          
      </div>
    <div class="col s6">
   <ul class="collection with-header">
        <li class="collection-header"><h4>Requests</h4></li>
        <c:forEach items="${requests}" var="request" varStatus="loop">
        <li class="collection-item">${request.requestDetails}</li>
        </c:forEach>
      </ul>
          
      </div>
  </div>
  
  </div>
  </div>
  </div>
  </div>
  
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="${contextPath}/resources/js/home.js"></script>    
  <script src="${contextPath}/resources/js/materialize.js"></script>
  <script src="${contextPath}/resources/js/init.js"></script>
  
  </body>
  </html>