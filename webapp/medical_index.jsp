<%@page import="com.db.DbConnection"%>
<%@page import="com.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body
	style="background-repeat: no-repeat; background-size: 100% 150%; background-image: url(image/m2.jpg)">
<body>
	<%@include file="medical_navbar.jsp"%>

	<%-- 	<c:if test="${ empty medialObj }"> --%>
	<%-- 		<c:redirect url="../medical_login.jsp"></c:redirect> --%>
	<%-- 	</c:if> --%>

	<div class="container p-5">
		<p style="background-color: yellow;" class="text-center fs-3">Medical
			Dashboard</p>



		<div id="container1">

			<h2>1.)Developing a system for medical research, including data
				collection, analysis, and dissemination, to improve our
				understanding of diseases and their treatment.</h2>
		</div>

		<div id="container1">

			<h2>2.) Developing a system for patients to engage with their
				healthcare providers and access personalized health information and
				tools to improve their health outcomes.</h2>

		</div>

		<div id="container1">

			<h2>3.) Developing a platform for remote patient consultation
				and diagnosis using digital communication tools, including video
				conferencing, messaging, and other remote monitoring tools..</h2>

		</div>

		<div id="container1">

			<h2>4.) Developing a system for managing patient health records
				digitally, securely and efficiently, which can be accessed by
				authorized healthcare providers..</h2>

		</div>


		<style>
#container1 {
	display: flex;
	background-color: lightblue;
	align-content: left;
	justify-content: left;
	margin: 50px;
	width: 100%;
	padding: 10px;
	font-size: 12px;
}

#container1 div {
	background-color: chartreuse;
	align-items: center;
	margin: 50px;
	width: 100%;
	padding: 10px;
}

h2 {
	color: taupe;
	font-family: Arial, sans-serif;
	font-size: 20px;
	line-height: 1.5;
	max-width: 1000px;
	margin: 1 auto;
}
</style>
</body>
</html>

