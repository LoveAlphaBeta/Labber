<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" class="no-js">

	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Welcome to lαβ!</title>
		<link rel="shortcut icon" href="../imgs/LabLOGO.png">
		<link href="https://fonts.googleapis.com/css?family=Inconsolata:400,700|VT323" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="../assets/css/base.css" />
		<link rel="stylesheet" type="text/css" href="../assets/css/visitStyle.css" />
		<script>
			document.documentElement.className = 'js';
		</script>
	</head>

	<body class="demo-11" onload="hideUserINFO()">
		<svg class="hidden">
			<defs>
				<symbol id="icon-arrow" viewBox="0 0 24 24">
					<title>arrow</title>
					<polygon points="6.3,12.8 20.9,12.8 20.9,11.2 6.3,11.2 10.2,7.2 9,6 3.1,12 9,18 10.2,16.8 " />
				</symbol>
				<symbol id="icon-drop" viewBox="0 0 24 24">
					<title>drop</title>
					<path d="M12,21c-3.6,0-6.6-3-6.6-6.6C5.4,11,10.8,4,11.4,3.2C11.6,3.1,11.8,3,12,3s0.4,0.1,0.6,0.3c0.6,0.8,6.1,7.8,6.1,11.2C18.6,18.1,15.6,21,12,21zM12,4.8c-1.8,2.4-5.2,7.4-5.2,9.6c0,2.9,2.3,5.2,5.2,5.2s5.2-2.3,5.2-5.2C17.2,12.2,13.8,7.3,12,4.8z" />
					<path d="M12,18.2c-0.4,0-0.7-0.3-0.7-0.7s0.3-0.7,0.7-0.7c1.3,0,2.4-1.1,2.4-2.4c0-0.4,0.3-0.7,0.7-0.7c0.4,0,0.7,0.3,0.7,0.7C15.8,16.5,14.1,18.2,12,18.2z" />
				</symbol>

				<symbol id="icon-cross" viewBox="0 0 24 24">
					<title>cross</title>
					<path d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z" />
				</symbol>
			</defs>
		</svg>
		<main class="main-wrap">
			<br /><br/>
			<br/>
			<header class="codrops-header">
				<h1 class="codrops-header__title">Welcome to Lab!</h1>
				<div class="search-wrap">
					<button id="btn-Qcode" class="btn btn--search" ><h1 class="codrops-header__title" style="color: white;font-size: medium;">扫码加入我们</h1><img src="../imgs/qcode.png" width="100" height="100"/></button>
				</div>
			</header>
			<br/>
			<br/><br/>
			<br/><br/>
			<br/><br/>
			<br/>
			<div style="text-align: center;">
				<button id="btn-search" class="btn btn--search"><img src="../imgs/LabLOGO.png" style="width:256px;height:256px;"/></button>
				<c:if test="${banner != null}">
					<p id="WelcomeVisitor" onclick="removeVisitorINFO()">${banner}</p>
				</c:if>
				<c:if test="${visitCounter != null}">
					<p>Visit times today: ${visitCounter}</p>
				</c:if>
			</div>
		</main>
		<!-- /main-wrap -->
		<div class="search">
			<button id="btn-search-close" class="btn btn--search-close" aria-label="Close search form"><svg class="icon icon--cross"><use xlink:href="#icon-cross"></use></svg></button>
			<div class="terminal">
				<p class="terminal__line">Initiating visit...</p>
				<p class="terminal__line">Visit interface completed.</p>
				<p class="terminal__line">Fetching topics...</p>
				<p class="terminal__line">Topics fetched:</p>
				<p class="terminal__line">
					<a href="#">#Drones</a>
				</p>
				<p class="terminal__line">
					<a href="#">#MachineLearning</a>
				</p>
				<p class="terminal__line">
					<a href="#">#CPU</a>
				</p>
				<p class="terminal__line">
					<a href="#">#NueralNetworks</a>
				</p>
				<p class="terminal__line">
					<a href="#">#Coding</a>
				</p>
				<p class="terminal__line">
					<a href="#">#Auto-Driving</a>
				</p>
				<p class="terminal__line">
					<a href="#">#DIY</a>
				</p>
			</div>
			<form class="search__form" action="../Visit.lab" method="post">
				<input class="search__input" name="docID" id="docID" type="text" placeholder="Student Number." autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" />
			</form>
		</div>
		<script type="text/javascript">
			function hideUserINFO(){
				setTimeout("removeVisitorINFO()",4000);		
			}
			function removeVisitorINFO(){
				$("#WelcomeVisitor").remove();
			}
		</script>
		<script type="text/javascript" src="../assets/js/jquery-3.1.1.min.js" ></script>
		<script src="../assets/js/visitJS.js"></script>
	</body>

</html>