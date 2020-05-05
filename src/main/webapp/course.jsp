<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Notes Boxx - Application</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="${contextPath}/resources/css/materialize.css"
	type="text/css" rel="stylesheet" media="screen,projection" />
<link href="${contextPath}/resources/css/style.css" type="text/css"
	rel="stylesheet" media="screen,projection" />
</head>
<body>
	<nav class="white" role="navigation">
		<div class="nav-wrapper container">
			<img style="height: 60px;"
				src=${contextPath}/resources/images/psna-log0.jpg
				id="logo-container">

			<ul class="right hide-on-med-and-down">
				<li>
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form> <a onclick="document.forms['logoutForm'].submit()">Logout</a>
				</li>
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
			<a href="#" data-target="nav-mobile" class="sidenav-trigger"><i
				class="material-icons">menu</i></a>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<h5>Course Details:</h5>
			<div class="divider"></div>
			<div class="section">
				<ul class="collection with-header">
					<li class="collection-item">Course Name : ${course.courseName}</li>
					<li class="collection-item">Year : ${course.year}</li>
					<li class="collection-item">Semester : ${course.semester}</li>
					<li class="collection-item">Department : ${course.department}</li>
					<li class="collection-item">Faculty Name :
						${course.facultyName}</li>
				</ul>
			</div>
			<div class="section">
				<ul class="collection with-header">
					<li class="collection-item header">Notes:</li>
					<c:forEach items="${notes}" var="note" varStatus="loop">
						<a href="/download/${note.fileName}" class="collection-item">${note.fileName}</a>
					</c:forEach>
				</ul>
			</div>
			<c:if test="${admin}">
				<div class="divider"></div>
				<div class="row">
					<div class="col s9">
						<div class="input-field col s6">
							<form id="fileUploader" method="POST" action="/course/upload"
								enctype="multipart/form-data">
								<input type="file" name="file" /> <input type="hidden"
									name="coursename" value="${course.id}"> <input
									type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</div>
						<div class="input-field col s3">
							<a id="fileupload" class="waves-effect waves-light btn"><i
								class="material-icons left">cloud</i>Upload</a>
						</div>
					</div>
				</div>
			</c:if>
		</div>
	</div>
	<c:if test="${not admin}">
		<div class="fixed-action-btn">
			<a class="btn-floating btn-large teal-lighten-1 modal-trigger"
				href="#request"> <i class="large material-icons">chat</i>
			</a>
		</div>
	</c:if>

	<div id="request" class="modal">
		<div class="modal-content">
			<div class="row">
				<form id="requestForm" method="POST" action="/post" class="col s12">
					<h4>Request Notes:</h4>
					<div class="row">
						<div class="input-field col s12">
							<textarea id="request" name="details"
								class="materialize-textarea"></textarea>
						</div>
					</div>
					<input type=hidden name=course_id value="${course.id}" /> <input
						type=hidden name=course_staff value="${course.facultyName}" /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<a href="#!" id="submit_request"
						class="modal-close waves-effect waves-teal btn"
						style="float: right;"> <i class="material-icons right">send</i>Submit
					</a>
				</form>
			</div>
		</div>
	</div>

	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="${contextPath}/resources/js/home.js"></script>
	<script src="${contextPath}/resources/js/materialize.js"></script>
	<script src="${contextPath}/resources/js/init.js"></script>

</body>
</html>
