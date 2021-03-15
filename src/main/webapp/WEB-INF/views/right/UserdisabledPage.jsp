<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>BOM</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/simple-sidebar.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>
<script src="/js/bootstrap.bundle.js"></script>
<style>
.dropdown-toggle.caret-off::after {
	display: none;
}
</style>
</head>

<body>
<div class="d-flex" id="wrapper">
	<div class="container-fluid">
		<div class="card">
			<div align="center">
				<div class="card align-middle" style="width:20rem; border-radius:20px;">
					<div class="card-title" style="margin-top:30px;">
						<h2 class="card-title text-center" style="color:green;">Welcome Back!</h2>
					</div>
					<div class="card-body">
			      <form class="form-signin" method="POST" onSubmit="logincall();return false">
			        <h5 class="form-signin-heading">탈퇴한 회원입니다. 계정을 복구하시겠습니까?</h5>
				        <p>
						<p>
			        <div class="checkbox">
			        </div>
			        <input type="hidden" value="${ui.uCode }">
			        <button type="button" class="btn btn-outline-success" onclick="location.href='/right/userAble?ucode=${ui.uCode }'" style="margin-right:0.5%">복구</button> 
			        <button type="button" class="btn btn-outline-secondary" onclick="location.href='bro/login'">취소</button>
			      </form>
			   </div>
			</div>
		</div>
	</div>
</div>

	<div class="modal">
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    </div>
  </body>

</html>