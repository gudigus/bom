<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String context = request.getContextPath();
%>
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
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>
<script src="/js/bootstrap.bundle.js"></script>
<style>
.dropdown-toggle.caret-off::after {
	display: none;
}
</style>
<style>
#bearsize {
	width: 550px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	text-align: left;
}

.dropdown-toggle.caret-off::after {
	display: none;
}

a:hover {
	text-decoration: none;
	cursor: pointer;
}

.card-text:hover {
	color: black;
	text-decoration: none;
}
</style>
<style>
.dropdown-toggle.caret-off::after {
	display: none;
	resize: none;
}

div#writeTextarea {
	min-height: 50px;
	border: none;
	resize: none;
}

div#writeTextarea:focus {
	outline: none;
	box-shadow: none;
	-webkit-box-shadow: none;
}

select.custom-select {
	margin-top: 10px;
}

select.custom-select:focus {
	outline: none;
	box-shadow: none;
	-webkit-box-shadow: none;
}
/*placeholder 설정하기*/
[contenteditable=true]:empty:before {
	content: attr(placeholder);
	display: block; /* For Firefox */
}

input[type="file"] {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

label {
	margin: 0px;
}

.nav-tabs .nav-link:not(.active) {
	border-color: transparent !important;
	color: #28a745;
}
</style>
</head>
<script type="text/javascript">
//팔로우 하는 로직
	function followchk(number){
		
		//name 에 k + number 쓰는 태그를찾아서 text변경
		var textareaVal = $("button[name=k"+number+"]").text();
		console.log("textareaVal + textareaVal" + textareaVal)
		
		var msg = { uopcode :number};
		$.ajax({
			url: '<%=context%>/bear/followchk',
			data: msg,
			type: "post",

			success: function (res) {
				console.log("저장성공 - > " +res)
				
				if(res == "1"){
					console.log("저장성공")
					  $("button[name=k"+number+"]").text("팔로잉");
					  $("button[name=k"+number+"]").attr("class","btn btn-success btn-sm float-right");
			
				}else 
					{console.log("저장실패")}
					
				 
			}
	});	 
	}
	
	function closemodal(){
		location.reload();
	}
</script>
<body>

	<div class="d-flex" id="wrapper">

				<!-- Sidebar -->
		<div class="border-right sidebar-fixed-top" id="sidebar-wrapper">
			<div class="sidebar-heading" align="center">
				<img src="/img/logo2.jpg" width="150" height="150">
			</div>
			<div class="list-group list-group-flush">
				<a href="/iron/timeline"
					class="list-group-item list-group-item-action"> <img
					src="/img/home.svg" width="15" height="15"> 타임라인
				</a> <a href="/hoon/explore"
					class="list-group-item list-group-item-action"> <img
					src="/img/search.svg" width="15" height="15"> 검색하기
				</a> 				<!-- <a href="alarm" class="list-group-item list-group-item-action">
					<img src="/img/bell.svg" width="15" height="15"> 알림 <span
					class="badge badge-success">1</span>
				</a> -->
				<!-- bear1 -->
				<a href="/bear/chat" class="list-group-item list-group-item-action">
					<img src="/img/send.svg" width="15" height="15"> 쪽지
				</a> <a href="/yeah/bookmark"
					class="list-group-item list-group-item-action"> <img
					src="/img/bookmark.svg" width="15" height="15"> 북마크
				</a> <a href="/iron/profile/uatid=${user.uatid }"
					class="list-group-item list-group-item-action"> <img
					src="/img/user.svg" width="15" height="15"> 프로필
				</a> <a href="/right/moreSee"
					class="list-group-item list-group-item-action"> <img
					src="/img/more.svg" width="15" height="15"> 더보기
				</a>
				<!-- <a href="#" class="list-group-item list-group-item-action">
					<button type="button" class="btn btn-outline-success">
						<img src="/img/write.svg" width="15" height="15"> 글 쓰기
					</button>
				</a> -->
				<div class="card">
					<div class="card-body">
						<img src="<%=context %>/profile_image/${user.uimage }"
							class="rounded-circle" width="50" width="50"> <a
							class="card-title text-dark" style="font-size: 0.8em">${user.unickName }</a><br>
						<a class="card-subtitle mb-2 text-muted" style="font-size: 0.8em">@${user.uatid }</a>
					</div>
					<button type="button" class="btn btn-success">로그아웃</button>
				</div>
		</div>
	</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
				<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
					<button class="btn btn-success" id="menu-toggle" onclick="location.href='moreSee'">←</button>
				</nav>
			<div class="container-fluid">
				<div class="card">
					<div align="center">
						<div>
						<p>
						<h1 style="font-weight:bold; color:#086701;">전체 봄 통계</h1>
						<h4 style="font-weight:bold; color:#2F9D27;">연령별 검색어 순위</h4>
						<div class="form-row" align="center">
						<div class="card col-3 mx-auto mr-1 border-white" style="float:left;">
						<h5>10대 검색어 순위</h5>
							<c:forEach var="list1" items="${aList1}" varStatus="status">
							<c:if test="${status.count <=3 }">
								<span>${list1.rank}위. </span>
								<a href="/hoon/searchView?search=%23${list1.search}">
								 <span style="font-weight:bold;">#${list1.search}</span></a><br>
							</c:if>
							</c:forEach>
						</div>
						<div class="card col-3 mx-auto border-white" style="float:left;">
						<h5>20대 검색어 순위</h5>
							<c:forEach var="list2" items="${aList2}" varStatus="status">
							<c:if test="${status.count <=3 }">
								<span>${list2.rank}위. </span>  <a href="/hoon/searchView?search=%23${list2.search}"><span style="font-weight:bold;">#${list2.search}</span><br></a>
							</c:if>
							</c:forEach>
						</div>
						<div class="card col-3 mx-auto border-white" style="float:right;">
						<h5>30대 검색어 순위</h5>
							<c:forEach var="list3" items="${aList3}" varStatus="status">
							<c:if test="${status.count <=3 }">
								<span>${list3.rank}위. </span>
								<a href="/hoon/searchView?search=%23${list3.search}">
								<span style="font-weight:bold;">#${list3.search}</span><br></a>
							</c:if>
							</c:forEach>
						</div>
						</div><br>
						<h4 style="font-weight:bold; color:#2F9D27;">성별 검색어 순위</h4>
						<div class="form-row" align="center">
						<div class="card col-5 mx-auto border-white" style="float:left;">
						<h5>남성 검색어 순위</h5>
							<c:forEach var="listm" items="${gListm}" varStatus="status">
							<c:if test="${status.count <=3 }">
								<span>${listm.rank}위. </span>
								<a href="/hoon/searchView?search=%23${listm.search}">
								<span style="font-weight:bold;">#${listm.search}</span></a><br>
							</c:if>
							</c:forEach>
						</div>
						<div class="card col-5 mx-auto border-white" style="float:right;">
						<h5>여성 검색어 순위</h5>
							<c:forEach var="listw" items="${gListw}" varStatus="status">
							<c:if test="${status.count <=3 }">
								<span>${listw.rank}위. </span> 
								<a href="/hoon/searchView?search=%23${listw.search}">
								<span style="font-weight:bold;">#${listw.search}</span></a><br>
							</c:if>
							</c:forEach>
						</div>
						</div>
					</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

		<!-- 오른쪽 사이드바 -->
		<div class="bg-light border-left" id="sidebar-wrapper2">
			<div class="list-group list-group-flush">
				<div class="list-group-item list-group-item-action bg-light">
					<div id="drop_the_text">
						<!-- 엔터치면 searchData() 실행 -->
						<input class="form-control" id="search" placeholder="봄 검색"
							onkeypress="if( event.keyCode == 13 ){searchData();}">
					</div>
				</div>
				<div class="list-group-item list-group-item-action bg-light"
					style="padding: 5px;">
					<div class="card bg-light mb-3">
						<div class="card-header">팔로우 추천</div>
						<div class="card-body" style="padding: 5px;">
							<c:if test="${suggestFlist2_size>0 }">
								<c:forEach var="justFollowMe" items="${suggestFlist2 }"
									begin="0" end="2">
									<div class="card">
										<div class="card-body"
											style="font-size: 0.8rem; padding: 10px;">
											<img src="<%=context %>/profile_image/${justFollowMe.uimage}"
												class="rounded-circle" width="20" height="20"> <a
												class="card-title text-dark">${justFollowMe.unickName}</a> <a
												class="card-subtitle mb-2 text-muted">@${justFollowMe.uatid}</a>
											<button type="button"
												class="btn btn-outline-success btn-sm float-right"
												style="font-size: 0.8rem;"
												onclick="followchk(${justFollowMe.uucode})"
												name=k${justFollowMe.uucode}>팔로우</button>
										</div>
									</div>
								</c:forEach>
							</c:if>
							<!-- 팔로우하는 유저가 없을 경우 관심항목이 비슷한 사람을 추천 -->
							<c:if test="${suggestFlist2_size<1 }">
								<c:forEach var="justFollowMe" items="${suggestFlist2 }">
									<div class="card">
										<div class="card-body"
											style="font-size: 0.8rem; padding: 10px;">
											<img
												src="${resourcePath }/profile_image/${justFollowMe.uimage}"
												class="rounded-circle" width="20" height="20"> <a
												class="card-title text-dark">${justFollowMe.unickName}</a> <a
												class="card-subtitle mb-2 text-muted">@${justFollowMe.uatid}</a>
											<button type="button"
												class="btn btn-outline-success btn-sm float-right"
												style="font-size: 0.8rem;">팔로우</button>
										</div>
									</div>
								</c:forEach>
							</c:if>
						</div>
						<c:if test="${suggestFlist2_size>0 }">
							<button type="button" class="btn btn-outline-success"
								id="writeBtn" data-toggle="modal" data-target="#morebtn">더보기
							</button>
						</c:if>
					</div>
				</div>
				<div class="list-group-item list-group-item-action bg-light"
					style="padding: 5px;">
					<div class="card bg-light mb-3">
						<div class="card-header">실시간 트랜드</div>
						<div class="card-body" style="padding: 5px;">
							<div class="card">
								<div class="card-body" style="font-size: 0.8rem; padding: 10px;">
									1위
									<div>
										<a href="#">#사랑해티모</a> <span class="float-right">11,333
											봄</span>
									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-body" style="font-size: 0.8rem; padding: 10px;">
									2위
									<div>
										<a href="#">#티세구</a> <span class="float-right">2,301 봄</span>
									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-body" style="font-size: 0.8rem; padding: 10px;">
									3위
									<div>
										<a href="#">#롤하고싶다</a> <span class="float-right">1,300
											봄</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="list-group-item list-group-item-action bg-light"
					style="padding: 5px; font-size: 0.8rem;">
					<div class="card">
						<div class="card-body">
							<a href="#">이용약관</a> <a href="#">개인정보처리방침</a> <a href="#">운영정책</a>
							Copyright © Bom Corp. All rights reserved.
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 오른쪽 사이드바 끝 -->
	<!--BEAR 더보기 창  -->
		<div class="modal fade" id="morebtn" data-backdrop="static"
			data-keyboard="false" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<div class="modal-body col-12">
							<div class="card-header">
								<h4 style="text-align: center;">
									팔로우 추천
									<button style="float: right;" onclick="closemodal()">x</button>
								</h4>
								<div class="card-body" style="padding: 5px;">
									<div class="card">
										<div class="card-body"
											style="font-size: 0.8rem; padding: 10px;">
											<c:forEach var="justFollowMe1" items="${suggestFlist2 }">
												<div class="card">
													<div class="card-body"
														style="font-size: 0.8rem; padding: 10px;">
														<img
															src="<%=context %>/profile_image/${justFollowMe1.uimage}"
															class="rounded-circle" width="40" height="40"> <a
															class="card-title text-dark">${justFollowMe1.unickName}</a>
														<a class="card-subtitle mb-2 text-muted">@${justFollowMe1.uatid}</a>
														<c:if test="${justFollowMe1.uonline eq 1 }">
															<img src="<%=context%>/image/online.png" width="20"
																height="20">
														</c:if>
														<div>
															<button type="button"
																class="btn btn-outline-success btn-sm float-right"
																style="font-size: 1.2rem;"
																onclick="followchk(${justFollowMe1.uucode})"
																name="k${justFollowMe1.uucode}">팔로우</button>

														</div>
														<h3 id="bearsize" style="padding-left: 40px">&nbsp&nbsp${justFollowMe1.uintro}</h3>

													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<!-- /#wrapper -->
</body>

</html>