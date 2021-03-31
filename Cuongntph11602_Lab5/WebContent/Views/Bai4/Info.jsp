<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
		crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
		crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
		crossorigin="anonymous"></script>
</head>
<body>
<form class="p-5" action="/Bai2" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Id *:</label> <input type="text"
					class="form-control" id="exampleInputEmail1" name="id"
					aria-describedby="emailHelp" placeholder="ID" value="${user.id}">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Username *:</label> <input
					type="text" class="form-control" id="exampleInputPassword1"
					name="fullName" placeholder="User name" value="${user.fullName}">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Password *:</label> <input
					type="password" class="form-control" id="exampleInputEmail1"
					name="passWord" aria-describedby="emailHelp"
					placeholder="Pass word" value="${user.passWord}">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Email *:</label> <input
					type="email" class="form-control" id="exampleInputPassword1"
					name="email" placeholder="Email" value="${user.email}">
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="admin"
				${user.admin ? 'checked':'' }
				
					id="inlineRadio1" value="true"> <label
					class="form-check-label" for="inlineRadio1">Admin</label>
			</div>
			<div class="form-check form-check-inline pb-2">
				<input class="form-check-input" type="radio" name="admin"
					${user.admin ? '':'checked' } id="inlineRadio2" value="false"> <label
					class="form-check-label" for="inlineRadio2" >User</label>
			</div>
			<div>
				<button type="submit" formaction="/Cuongntph11602_Lab5/Bai4/Create"
					class="btn btn-primary">Create</button>
				<button type="submit" formaction="/Cuongntph11602_Lab5/Bai4/Update"
					class="btn btn-primary">Update</button>
				<button type="reset" formaction="/Cuongntph11602_Lab5/Bai4/Reset"
					class="btn btn-primary">Reset</button>
			</div>
		</form>
</body>
</html>