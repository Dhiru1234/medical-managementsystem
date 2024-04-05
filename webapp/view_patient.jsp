<%@page import="com.dao.UserDao"%>
<%@page import="com.entity.User"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.dto.AppointmentInfoDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DbConnection"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Information</title>
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

	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body" style="background-color: #FFEFDB;">
						<p  style="background-color: #CD2626;" class="fs-4 fw-bold text-center text-success">Appointment
							Information</p>



						Patient name :- ${appoinmentDetails.userName} <br>
						Appointment Date :- ${appoinmentDetails.appoinDate} <br>
						Patient Gender:- ${appoinmentDetails.gender} <br> Patient
						Mobile Number:- ${appoinmentDetails.mobNo} <br> Patient Email
						:- ${appoinmentDetails.userEmail} <br> Patient Diseases :-
						${appoinmentDetails.diseases} <br> Doctor Name :-
						${appoinmentDetails.doctorName} <br> Hospital Name :-
						${appoinmentDetails.hospitalName} <br> Doctor Specialist :-
						${appoinmentDetails.specialist} <br> 
						Status :-
						${appoinmentDetails.status} <br> 
						
						<a class="fcc-btn" href="medicine_index.jsp">Patient Medical receipt</a><br>  
						
 					<a class="fcc-btn" href="appointments?mode=updateStatus&id=${appoinmentDetails.apId}">CheckUp Completed</a>  
 					
					</div>
				</div>
			</div>

			<div class="col-md-3 p-3">
				<img alt="" src="image/check2.jpg">
			</div>
		</div>
	</div>


</body>
</html>