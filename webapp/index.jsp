
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
<%@include file="component/allcss.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>


</head>
<body>
	<%@include file="component/navbar.jsp"%>



	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<image src="image/m2.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<image src="image/checking1.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<image src="image/check2.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<div style="background-color: #FFE4E1;" class="container p-3">
		<p style="background-color: yellow;" class="text-center fs-2 ">Key
			Features of our Medical Management System</p>

		<div class="row">
			<div class="col-md-8 p-5">
				<div class="row">
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body" style="background-color: #C1FFC1;">
								<p style="background-color: #00FF00;" class="fs-5">Appointment
									Scheduling:</p>
								<p>A medical management system may include a feature for
									scheduling patient appointments. This feature can be used to
									manage appointments, send reminders to patients, and keep track
									of availability for healthcare providers.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body" style="background-color: #EEEEE0;">
								<p style="background-color: #CDCDB4;" class="fs-5">Prescription
									Management:</p>
								<p>our systems can also manage prescriptions by providing a
									platform for doctors to electronically prescribe medications
									and track patient medication history.it can help reduce errors
									and improve patient safety.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body" style="background-color: #BCD2EE;">
								<p style="background-color: #87CEFF;" class="fs-5">Compliance
									and Security:</p>
								<p>A medical management system should include features to
									ensure compliance with healthcare regulations and maintain the
									security and privacy of patient information. This may include
									HIPAA compliance, data encryption, and access controls.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body" style="background-color: #97FFFF;">
								<p style="background-color: #00E5EE;" class="fs-5">Patient
									Portal:</p>
								<p>Our system provide high-quality patient care,
									prioritizing patient safety and satisfaction.A patient portal
									is a feature that allows patients to access their medical
									records, communicate with healthcare providers, and schedule
									appointments online.</p>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<image alt="" src="image/dr2.jpg">
			</div>

		</div>
	</div>

	<hr>

	<div style="background-color: #FFE4E1;" class="container p-2">
		<p style="background-color: yellow;" class="text-center fs-2 ">Our
			Team</p>

		<div style="background-color: #FFF0F5;" class="row">
			<div class="col-md-3">
				<div class="card paint-card" style="background-color: #FFFACD;">
					<div class="card-body text-center">
						<image src="image/dr1.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr.A</p>
						<p class="fs-7">(CEO & Chairman)</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card" style="background-color: #FFDEAD;">
					<div class="card-body text-center">
						<image src="image/doctor.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr.B</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card" style="background-color: #FFFACD;">
					<div class="card-body text-center">
						<image src="image/dr44.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr.C</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card" style="background-color: #FFDEAD;">
					<div class="card-body text-center">
						<image src="image/drr.jpg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr.D</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>

		</div>

	</div>

	<%@include file="component/footer.jsp"%>

</body>
</html>