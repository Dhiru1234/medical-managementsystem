<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a style="background-color: #DB7093;" class="navbar-brand" href="index.jsp"><i
			class="fas fa-clinic-medical"></i> Medical Management System</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">

				<li style="background-color: #778899;" class="nav-item"><a class="nav-link active" href="medical_index.jsp">HOME</a></li>
				<li style="background-color: #6495ED;" class="nav-item"><a class="nav-link active" href="add_medicine.jsp">ADD MEDICINE</a></li>
				<li style="background-color: #00BFFF;" class="nav-item"><a class="nav-link active" href="view_added_medicine.jsp">VIEW ADDED MEDICINE</a></li>
				<li style="background-color: #00CED1;" class="nav-item"><a class="nav-link active" href=#>VIEW MEDICINE REQUEST</a></li>

			</ul>

			<form class="d-flex">
				<div class="dropdown">
					<button style="background-color: #EED2EE;" class="btn btn-light dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">Medical</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a style="background-color: #00BFFF;" class="dropdown-item" href="medicalLogout">Logout</a></li>
					</ul>
				</div>
			</form>
		</div>
	</div>
</nav>