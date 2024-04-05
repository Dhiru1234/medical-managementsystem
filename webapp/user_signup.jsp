<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>

<%@include file="component/allcss.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body style="background-repeat: no-repeat; background-size: 100% 200%; background-image:url(image/disease9.jpg)">

<body>
	<%@include file="component/navbar.jsp"%>
	<div class="container-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body" style="background-color: #FFEFDB;">


						
						<c:if test="${user != null}">
							<p style="background-color: #CD2626;" class="fs-4 text-center">UPDATE</p>
						</c:if>

						<c:if test="${user == null}">
							<p style="background-color: #CD2626;" class="fs-4 text-center">REGISTER</p>
						</c:if>
						<c:if test="${not empty sucMsg}">
							<p class="text-center text-success fs-3">${sucMsg}</p>
							<c:remove var="sucMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg}">
							<p class="text-center text-danger fs-3">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>

						<form action="user_register" method="post">
							<input type="hidden" value="${user.id}" name="uid">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input required
									name="fullname" type="text" value="${user.fullname}"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Age</label> <input required name="age"
									type="text" value="${user.age}" class="form-control">
							</div>

							<label class="form-label">Gender:</label> <select name="gender"
								id="gender" class="form-control">
								<option selected="${isMale}" value="Male">Male</option>
								<option selected="${isFeMale}" value="Female">Female</option>

							</select>

                            <br>
							<div class="mb-3">
								<label class="form-label">Address</label> <input required
									name="address" type="address" value="${user.address}"
									class="form-control">
							</div>
							

							<div class="mb-3">
								<label class="form-label">Email</label> <input required
									name="email" type="email" value="${user.email}"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" name="pswd" id="pswd"
									pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}$"
									title="Use lower and Uppercase letter and digits and special charectors,password should be 8-16 digit"
									value="${user.password}" class="form-control">
							</div>

							<c:if test="${user != null}">
							<center>	<button style="width: 200px; height: 50px;" type="submit"
									class="btn bg-success text-white col-md-12">UPDATE</button> </center>
							</c:if>

							<c:if test="${user == null}">
							<center>	<button style="width: 200px; height: 50px;" type="submit"
									class="btn bg-success text-white col-md-12">REGISTER</button> </center>
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