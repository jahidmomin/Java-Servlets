<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<style>
.flexBox{
	display: flex;
	justify-content: center;
	align-items:center; 
	flex-direction: column;
}
input[type=text],input[type=email],input[type=number],input[type=password]{
	width:200px; 
	margin: 10PX;
	border-top:0px;
	border-left:0px;
	border-right:0px;
	outline:none;
	border-bottom:3px solid;
}
.loader{
	display:none;
}
</style>
</head>
<body>
	<div class="flexBox">
		<h1>Signup</h1>
		<div id="msg">
			
		</div>
		<form action="Signup" method="post" id="myform">
			<div>
				<label>Enter a Username</label>
				<input type="text" name="username"/>
			</div>
			<div>
				<label>Enter a Email </label>
				<input type="email" name="email"/>
			</div>
			<div>
				<label>Enter a Mobile No</label>
				<input type="number" name="mobno"/>
			</div>
			<div>
				<label>Enter a Password</label>
				<input type="password" name="pass"/>
			</div>
			<div>
				<label>Upload Profle Pic</label>
				<input type="file" name="profile"/>
			</div>
			<div>
				<input type="submit" name="submit"/>
			</div>	
		</form>
		
		<div class="loader" >
				Loading...
		</div>
	</div>
	<script src="Jquery.js"></script>
	<script type="text/javascript">
		console.log($(".loader").html());
		
		$(document).ready(function(){
			console.log("Page is Ready");
			$('#myform').on('submit',function(e){
				e.preventDefault();
				
				//if image then change FormData() object
				//let f=$(this).serialize();
				//console.log($(this));
				
				let f=new FormData(this);
				console.log(f);
				
				$(".loader").show();
				$('#myform').hide();
				
				$.ajax({
						url:'Signup',
						data:f,
						type:"POST",
						success:function(data,status,jqXHR){
							console.log(data);
							console.log("success");
							$(".loader").hide();
							$('#myform').show();
							
							if (data.trim() === "success") {
								$("#msg").html("Successfully Registered")
							} else {
								$("#msg").html("Something went wrong on server");
							}
							
						},
						error:function(err){
							console.log(err);	
							console.log("error");
							$(".loader").hide();
							$('#myform').show();
							$("#msg").html("Something went wrong on server");
						},
						processData:false,
						contentType:false
					});
				
			})
		});
	</script>
</body>
</html>