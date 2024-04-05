<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin login page</title>
<%@include file="../component/allcss.jsp"%>

<style type="text/css">	
.paint-card
{
	box-shadow:0 0 10px 0 rgba(0,0,0,0.3);
}
</style>


</head>

<body style="background-repeat: no-repeat; background-size: 100% 160%; background-image:url(image/1.jpg)">

<body>
	<%@include file="../component/navbar.jsp"%>

<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-4">
				<div class="card paint-card">
					<div class="card-body" style="background-color: #EED2EE;">
						<p style="background-color: yellow;" class="fs-3 text-center">ADMIN LOGIN</p>
						
						<c:if test="${not empty sucMsg}">
							<p class="text-center text-success fs-3">${succMsg}</p>
							<c:remove var="sucMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg}">
							<p class="text-center text-danger fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						
						<form action="adminLogin" method="post">
							<div class="mb-3">
								<label class="form-label">Email address</label> <input required
									name="email" type="email" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>
						<center>	<button type="submit" class="btn bg-success text-white col-md-12" style="width: 200px; height: 50px;">Login</button></center>
						</form>
					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>