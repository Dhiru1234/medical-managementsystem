<%@page import="com.db.DbConnection"%>
<%@page import="com.dao.DoctorDao"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.entity.Doctor"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Appointment</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}

</style>
</head>
<body style="background-repeat: no-repeat; background-size: 100% 160%; background-image:url(image/1.jpg)">

<body>
	<%@include file="component/navbar.jsp"%>

	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
<!-- 			<div class="col-md-6 p-5"> -->
<!-- 				<img alt="" src="image/dr0.jpg"> -->
<!-- 			</div> -->

			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body" style="background-color: #EED2EE;">
						<p style="background-color: yellow;" class="text-center fs-3">Add User Appointment</p>


						<form action="appointments?mode=addAppointment" method="post" >
						<div class="col-md-12">
								<label for="inputPassword4" class="form-label">Doctor</label>
								<select class="form-control"  name="doctor_id">
								    <c:forEach items="${doctorList}" var="doctor">
								        <option value="${doctor.id}">Doctor Name- ${doctor.fullName } / Specialist - ${doctor.specialist}/ Hospital Name- ${doctor.hospitalName}</option>
								    </c:forEach>
								</select>
								<br>
									
								<div class="col-md-4">
									<label for="inputEmail4" class="form-label">Appointment_Date</label> 
									<input type="date" class="form-control" required name="appoint_date">
								</div>
								<br>

								<div class="col-md-12">
									<label for="inputEmail4" class="form-label">Diseases</label> <input
										required type="text" class="form-control" name="diseases">
								</div>
							
							<br>
				
								<button class="col-md-2 offset-md-3 btn btn-success">Submit</button>
						
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@include file="component/footer.jsp"%>

</body>
</html>