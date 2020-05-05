<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Digi Learn - Application</title>

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
				<li><a href="#">About Us</a></li>
			</ul>

			<ul id="nav-mobile" class="sidenav">
				<li><a href="#">Navbar Link</a></li>
			</ul>
			<a href="#" data-target="nav-mobile" class="sidenav-trigger"><i
				class="material-icons">menu</i></a>
		</div>
	</nav>

	<div id="index-banner" class="parallax-container">
		<div class="section no-pad-bot">
			<div class="container">
				<br> <br>
				<h1 class="header center teal-text text-lighten-2">Digi - Learn Application</h1>
				<!-- <div class="row center">
          <h5 class="header col s12 light" style="color: navy">An application to bring students and teachers closer.</h5>
        </div>
        <div class="row center">
          <a href="#" id="download-button" class="btn-large waves-effect waves-light teal lighten-1">Login</a>
        </div> -->
				<br> <br>

			</div>
		</div>
		<div class="parallax">
			<img src=${contextPath}/resources/images/psna.png
				alt="Unsplashed background img 1">
		</div>
	</div>


	<div class="container">
		<div class="section">

			<!--   Icon Section   -->
			<div class="row">
				<div id="student" class="col s12 m6">
					<div id="student" class="icon-block">
						<h2 class="center brown-text">
							<i class="material-icons" style="cursor: pointer">local_library</i>
						</h2>
						<h5 class="center">Students</h5>
					</div>
				</div>

				<div class="col s12 m6">
					<div id="faculty" class="icon-block">
						<h2 class="center brown-text">
							<i class="material-icons" style="cursor: pointer">group</i>
						</h2>
						<h5 class="center">Faculty</h5>
					</div>
				</div>
			</div>

		</div>
	</div>


	<footer class="page-footer teal">
		<div class="container">
			<div class="row">
				<div class="col l8 s8">
					<h5 class="white-text">Team Bio</h5>
					<p class="grey-text text-lighten-4">We are a team of college
						students working on this project like it's our full time job.</p>


				</div>
				<div class="col l4 s4">
					<h5 class="white-text">Connect</h5>
					<ul>
						<li><a class="white-text" href="#!">Sharon</a></li>
						<li><a class="white-text" href="#!">Snekka</a></li>
						<li><a class="white-text" href="#!">Shalini</a></li>
						<li><a class="white-text" href="#!">Siva</a></li>
					</ul>
				</div>
			</div>
		</div>
<!-- 		<div class="footer-copyright">
			<div class="container">
				Made by <a class="brown-text text-lighten-3" href="#">FroZen
					FiR3</a>
			</div>
		</div> -->
	</footer>

	<!-- Modal Structure -->
	<div id="login_modal" class="modal col s3">
		<div class="modal-content">
			<h4>Login</h4>
			<form id="login" method="POST" action="${contextPath}/login" class="col s6">
				<div class="row ${error != null ? 'has-error' : ''}">
					<div class="input-field col s6">
						<input id="username" name="username" type="text" class="validate"> <label
							for="username">Username</label> <span>${message}</span>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input id="password" name="password" type="password" class="validate"> <label
							for="password">Password</label> <span>${error}</span> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</div>
				</div>
				<div class="row">
					<div class="col s6">
						<a id ="login_submit"class="waves-effect waves-light btn">Login</a>
					</div>
				</div>
			</form>
		</div>
	</div>


	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="${contextPath}/resources/js/home.js"></script>
	<script src="${contextPath}/resources/js/materialize.js"></script>
	<script src="${contextPath}/resources/js/init.js"></script>

</body>
</html>
