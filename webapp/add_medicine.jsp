<!DOCTYPE html>
<html>
<head>
<title>Add Medicine</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body style="background-repeat: no-repeat; background-size: 100% 400%; background-image:url(image/m2.jpg)">


<body>

	<form action="medical" method="post">

		<div class="container">
			<h2 style="background-color: yellow;" align="center">Add Medicine</h2>
			<div class="form-group">
				<form name="add_name" id="add_name">

					<div class="table-responsive">
						<table class="table table-bordered" id="dynamic_field">
							<tr>
							
							    <td><input type="text" name="diseasesname[]"
									placeholder="Diseases Name" class="form-control name_list"
									required/></td>
									
									 <td><input type="text" name="symptomname[]"
									placeholder="Symptom Name" class="form-control name_list"
									required/></td>
								
							
								<td><input type="text" name="medicinename[]"
									placeholder="Medicine Name" class="form-control name_list"
									required/></td>
									
								<td><input type="number" name="quantity[]" placeholder="Quantity"
									class="form-control name_list" required/></td>

								<td><input type="text" name="cost[]"
									placeholder="Cost Medicine" class="form-control name_list"
									required/></td>
									
									<td><input type="text" name="available[]"
									placeholder="Available Medicine" class="form-control name_list"
									required/></td>

								<td><button type="button" name="add" id="add"
										class="btn btn-success">Add More</button></td>
							</tr>
						</table>
				<center> <button style="width: 200px; height: 50px;" type="submit" class="btn bg-success text-white col-md-12">Submit</button> 	 </center> 
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript">
			$(document)
					.ready(
							function() {
								var postURL = "/addmore.php";
								var i = 1;

								$('#add')
										.click(
												function() {
													i++;
													$('#dynamic_field')
															.append(
																	'<tr id="row'+i+'" class="dynamic-added"><td><input type="text" name="diseasesname[]" placeholder="Diseases Name" class="form-control name_list" required /></td><td><input type="text" name="symptomname[]" placeholder="Symptom Name" class="form-control name_list" required /></td><td><input type="text" name="medicinename[]" placeholder="Medicine Name" class="form-control name_list" required /></td><td><input type="number" name="quantity[]" placeholder="Quantity" class="form-control name_list" required /></td><td><input type="text" name="cost[]" placeholder="Cost Medicine" class="form-control name_list" required /> </td> <td><input type="text" name="available[]" placeholder="Available Medicine" class="form-control name_list" required /></td> <td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>');
												});

								$(document)
										.on(
												'click',
												'.btn_remove',
												function() {
													var button_id = $(this)
															.attr("id");
													$('#row' + button_id + '')
															.remove();
												});

								$('#submit')
										.click(
												function() {
													$
															.ajax({
																url : postURL,
																method : "POST",
																data : $(
																		'#add_name')
																		.serialize(),
																type : 'json',
																success : function(
																		data) {
																	i = 1;
																	$(
																			'.dynamic-added')
																			.remove();
																	$('#add_name')[0]
																			.reset();
																	alert('Record Inserted Successfully.');
																}
															});
												});
							});
		</script>
</body>
</html>
