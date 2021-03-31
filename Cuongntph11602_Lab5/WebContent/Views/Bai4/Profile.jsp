<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
crossorigin="anonymous"/>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
 integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
 crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
crossorigin="anonymous"></script>
<style type="text/css">
<%@include file="Profile.css"%>
</style>
</head>
<body>
<div class="container m-2 p-3">
      <div class=" col-xs-12 col-sd-12 col-sm-12 col-lg-12 text-center ">
        <img
          src="https://static.yeah1.com/uploads/editors/27/2020/03/21/JaZBMzV14fzRI4vBWG8jymplSUGSGgimkqtJakOV.jpeg"
          alt="Avatar"
          class="avatar border"
          style="width: 75px; height: 75px;"
        />
        <h6 class="mt-1" style="fontSize: 35px">
        ${user.fullName }
        </h6>
      </div>
      <div class="container row d-flex justify-content-center">
        <div class="col-xs-6 col-sd-6 col-sm-6 col-lg-6 p-3 text-center">
          <p class="profile">UserName:  ${user.fullName }</p>
          <p class="profile">Email:  ${user.email }</p>
          <p class="profile">Admin:  ${user.admin }</p>
        </div>
        <div class="col-xs-6 col-sd-6 col-sm-6 col-lg-6 p-3 text-center">
          <p class="profile">Password:  ${user.passWord } </p>
          <p class="profile">ID:  ${user.id }</p>
          <p class="profile"><a href="/Cuongntph11602_Lab5/Bai4/Show?idUser=${user.id}">Đổi thông tin >></a> </p>
        </div>
        <div class="col-xs-6 col-sd-6 col-sm-6 col-lg-6 p-3 text-center">
          <p class="profile"><a href="<%=request.getContextPath() %>/Views/Bai4/Login.jsp">Sign Out >></a>
          </p>
        </div>
      </div>
    </div>
</body>
</html>