<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DbConnection"%>

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
<body style="background-repeat: no-repeat; background-size: 100% 200%; background-image:url(image/1.jpg)">

<body>
	<%@include file="admin_navbar.jsp"%>
	<div class="container-fluid p-3">
		<div class="row">


			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body" style="background-color: #FFEFDB;">
						<p style="background-color: yellow;" class="fs-3 text-center">Patient Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Age</th>
									<th scope="col">Gender</th>
									<th scope="col">Address</th>
									<th scope="col">Email</th>
									<th scope="col">State</th>
									<th scope="col">Action </th>
									
									
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${users}" var="u">
								<tr>
									
									<td>  ${u.fullname}</td>
									<td>  ${u.age}</td>
									<td>  ${u.gender}</td>
									<td>  ${u.address}</td>
									<td>  ${u.email}</td>
			                        <td>  ${u.states}</td>
			                        
			                        
			                        
			                     
			                <c:if test='${u.states == "Active"}'>
							<td><a style="background-color: #FA8072;" class="fcc-btn" href="userStates?state=Suspend&id=${u.id}">deactive </a></td>
							</c:if>
							
							<c:if test='${u.states == "Suspend"}'>
							<td><a style="background-color: #98FB98;"  class="fcc-btn" href="userStates?state=Active&id=${u.id}">active </a></td>
							</c:if>        
			                        
						
						
						
									
								</tr>
							</c:forEach>

							</tbody>
						</table>

					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>