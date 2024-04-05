<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a style="background-color: #DB7093;" class="navbar-brand" href="index.jsp"><i
			class="fas fa-clinic-medical"></i>Medical Management System</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

				<c:if test="${empty user and empty doctObj }">
					
					<li style="background-color: #778899;" class="nav-item"><a class="nav-link active"
						aria-current="page" href="medical_login.jsp"><i
							class="fas fa-sign-in-alt"></i> MEDICAL</a></li>
					
					<li style="background-color: #6495ED;" class="nav-item"><a class="nav-link active"
						aria-current="page" href="admin_login.jsp"><i
							class="fas fa-sign-in-alt"></i> ADMIN</a></li>

					<li  style="background-color: #00BFFF;" class="nav-item"><a class="nav-link active"
						aria-current="page" href="doctor_login.jsp">DOCTOR</a></li>

					<li style="background-color: #00CED1;" class="nav-item"><a class="nav-link active"
						aria-current="page" href="user_login.jsp">PATIENT</a></li>

				</c:if>
				
				<c:if test="${not empty user}">
				
				<li style="background-color: gray;" class="nav-item"><a class="nav-link active"
						aria-current="page" href="medical_index.jsp">MEDICAL</a></li>
				
					<li style="background-color: #00FF7F;" class="nav-item"><a class="nav-link active"
						aria-current="page" href="add_appointment.jsp">ADD APPOINTMENT</a></li>

					<li style="background-color: #FF6A6A;" class="nav-item"><a class="nav-link active"
						aria-current="page" href="appointments?mode=viewAppointments">VIEW
							APPOINTMENT</a></li> 

					<div class="dropdown">
						<button style="background-color: #778899;" class="btn btn-success dropdown-toggle" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">
							<i class="fa-solid fa-circle-user"></i> ${user.fullname }
						</button>
						<ul style="background-color: #6495ED;" class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a style="background-color: #00BFFF;" class="dropdown-item" href="user_signup.jsp">User Update</a></li>
							
							<li><a style="background-color: #8B3A3A;" class="dropdown-item" href="userLogout">Logout</a></li>
							

						</ul>
					</div>
				</c:if>
				<c:if test="${not empty doctObj}">
				
				<li style="background-color: gray;" class="nav-item"><a class="nav-link active"
						aria-current="page" href="medical_index.jsp">MEDICAL</a></li>

					<li style="background-color: #00FF7F;" class="nav-item"><a class="nav-link active"
						aria-current="page" href="appointments?mode=viewDoctorAppointment">VIEW
							APPOINTMENT</a></li>

					<div class="dropdown">
						<button  style="background-color: #FF6A6A;"  class="btn btn-success dropdown-toggle" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">
							<i class="fa-solid fa-circle-user"></i> ${doctObj.fullName }
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a style="background-color: #FFC1C1;" class="dropdown-item" href="doctor_signup.jsp">Doctor
									Update</a></li>
							
							<li><a style="background-color: #FF83FA;" class="dropdown-item" href="userLogout">Logout</a></li>

						</ul>
					</div>
				</c:if>
			</ul>
		</div>
	</div>
</nav>