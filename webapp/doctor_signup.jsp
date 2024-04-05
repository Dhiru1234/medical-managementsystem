<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Register page</title>

<%@include file="component/allcss.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body style="background-repeat: no-repeat; background-size: 100% 160%; background-image:url(image/disease6.jpg)">

<body>
	<%@include file="component/navbar.jsp"%>
	<div class="container-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
				
					<div class="card-body" style="background-color: #EED2EE;">
					
					<c:if test="${doctObj != null}">
						<p  style="background-color: yellow;" class="fs-4 text-center">Doctor Update </p>
                    </c:if>
                    
                    <c:if test="${doctObj == null}">
						<p  style="background-color: yellow;" class="fs-4 text-center">Doctor Register</p>
                    </c:if>
						<c:if test="${not empty sucMsg}">
							<p class="text-center text-success fs-3">${sucMsg}</p>
							<c:remove var="sucMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg}">
							<p class="text-center text-danger fs-3">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>

						<form action="doctor_register" method="post">
					<input type="hidden" value="${doctObj.id}" name ="id">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input required
									name="fullname" type="text" value="${doctObj.fullName}" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Hospital Name</label> <input required
									name="hospitalName" type="text" value="${doctObj.hospitalName}"  class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Qualification</label> <input required
									name="qualification" type="text" value="${doctObj.qualification}" class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Specialist</label> <input required
									name="specialist" type="text" value="${doctObj.specialist}" class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email</label> <input required
									name="email" type="email" value="${doctObj.email}" class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Mobile Number</label> <input required
									name="mobNo" name="telphone" pattern="[0-9]{10}" title="Ten digits code" value="${doctObj.mobNo}" class="form-control">
							</div>
							
							
							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" name="pswd" id="pswd" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}$" title="Use lower and Uppercase letter and digits and special charectors,password should be 8-16 digit" value="${doctObj.password}" class="form-control">
							</div>
							
							
							<c:if test="${doctObj == null}">
						<center>	<button type="submit" class="btn bg-success text-white col-md-12" style="width: 200px; height: 50px;">Register</button></center>
							</c:if>
							
							<c:if test="${doctObj != null}">
						<center>	<button type="submit" class="btn bg-success text-white col-md-12" style="width: 200px; height: 50px;">Update</button> </center>
							</c:if>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</head>
</body>
</html>