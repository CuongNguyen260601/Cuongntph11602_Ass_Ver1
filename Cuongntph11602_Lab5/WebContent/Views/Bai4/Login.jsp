<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" 
	crossorigin="anonymous"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" 
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" 
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" 
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" 
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" 
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" 
	integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" 
	crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
	<style type="text/css">
	<%@include file="Login.css"%>
	</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
		<div class="card card0 border-0">
			<div class="row d-flex">
				<div class="col-lg-6 border-line">
					<div class="card2 card border-0 px-4 py-5 ">
						<div class="row mb-4 px-3">
							<h6 class="mb-0 mr-4 mt-2">Sign in with</h6>
							<div class="facebook text-center mr-3">
								<i class="bi bi-facebook"></i>
							</div>
							<div class="twitter text-center mr-3">
								<i class="bi bi-twitter"></i>
							</div>
							<div class="linkedin text-center mr-3">
								<i class="bi bi-instagram"></i>
							</div>
						</div>
						<div class="row px-3 mb-4">
							<div class="line"></div>
							<small class="or text-center">Or</small>
							<div class="line"></div>
						</div>
						<div class="row px-3">
							<form action="/Cuongntph11602_Lab5/Bai4" method="post">
								<label>Email Address</label> <input name="email" type="text"/>
								<label>Password</label> <input type="password" name="pw" />
								<button formaction="/Cuongntph11602_Lab5/Bai4/SignIn" class="btn btn-blue text-center mt-2" type="submit">
									Login</button>
							</form>
						</div>
						<div class="row mb-4 px-3">
							<small class="font-weight-bold"> Don't have an account? <a href="<%=request.getContextPath() %>/Views/Bai4/Info.jsp"
								class="text-danger ">Register</a>
							</small>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="card1 pb-5">
						<div class="row px-3 justify-content-center mt-4 mb-5 ">
							<img
								src="https://onoff.vn/blog/wp-content/uploads/2018/12/converse-real-fake-5.png"
								class="image" alt="anh" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>