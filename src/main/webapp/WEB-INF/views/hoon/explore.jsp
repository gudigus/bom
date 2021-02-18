<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>repl.it</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
	crossorigin="anonymous"></script>
<script src="script.js"></script>
<style>
@font-face {
    font-family: 'GmarketSansBold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansBold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
.all {
	width:1200px;
}
.navi{
	width:200px;
}
.navi a {
	text-decoration: none;
	color: black;
}

.navi>div {
	text-align: center;
	padding: 15px;
	border-right: 1px solid black;
}

.main_content {
	width: 800px;
	height: 500px;
}

.sub_content {
	width: 200px;
	height: 500px;
	border-left: 1px solid black;
}
.table {
	border: 1px solid black; 
	float: left; 
	width: 33%; 
	padding:10px;
	margin-top: 80px;
}
</style>
<body>
	<div class="all">
		<div class="navi" style="float: left;">
			<div>
				<a href="#">logo</a>
			</div>
			<div>
				<a href="#">Ÿ�Ӷ���</a>
			</div>
			<div>
				<a href="#">Ž���ϱ�</a>
			</div>
			<div>
				<a href="#">�˸�</a>
			</div>
			<div>
				<a href="#">����</a>
			</div>
			<div>
				<a href="#">�ϸ�ũ</a>
			</div>
			<div>
				<a href="#">������</a>
			</div>
			<div>
				<a href="#">������</a>
			</div>
			<div>
				<a href="#">������</a>
			</div>
		</div>
		<div class="main_content" style="float: left; text-align:center; display:block; margin: 0 auto;">
				<form action="search" style="margin-top: 50px;">
					<input type="text" name="search" style="width: 400px;" required="Search">
					<input type="submit" value="�˻�">
				</form>
			<div class="table" style="margin-left: 120px;">
				2�� ù° �� �˻���<br><br>
				1.<a href="#">�˻���</a><br>
				2.<a href="#">�˻���</a><br>
				3.<a href="#">�˻���</a><br>
			</div>
			<div class="table" style="margin-left: 20px;">
				2�� �Ѵ� �˻� ����<br><br>
				1.<a href="#">�˻���</a><br>
				2.<a href="#">�˻���</a><br>
				3.<a href="#">�˻���</a><br>
			</div>
			<div class="table" style="margin-left: 120px; width: 530px; margin-top:30px;">
				��õ �ؽ��±�/������<br><br>
				�ؽ��±�    : <a href="#">�ؽ��±�</a><br>
				�α����� : <a href="#">�����</a><br>
				�α�˻��� : <a href="#">�˻���</a><br>
			</div>
		</div>
		<div class="sub_content" style="float: left;">sub</div>
	</div>

</body>
</html>