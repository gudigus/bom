<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script src="/js/bootstrap.bundle.min.js"></script>
<script src="/js/bootstrap.bundle.js"></script>
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
	*/
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
    color : #28a745;
}
</style>


<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	window.onload = function(){
		clickWriteBtn();
		clickSaveBtn();
	}
</script>
</head>
<body>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar -->
		<div class="border-right sidebar-fixed-top" id="sidebar-wrapper">
			<div class="sidebar-heading" align="center">
				<img src="/img/logo2.jpg" width="150" height="150">
			</div>
			<div class="list-group list-group-flush">
				<a href="#" class="list-group-item list-group-item-action"> <img
					src="/img/home.svg" width="15" height="15"> 타임라인
				</a> <a href="#" class="list-group-item list-group-item-action"> <img
					src="/img/search.svg" width="15" height="15"> 검색하기
				</a> <a href="#" class="list-group-item list-group-item-action"> <img
					src="/img/bell.svg" width="15" height="15"> 알림 <span
					class="badge badge-success">1</span>
				</a> <a href="#" class="list-group-item list-group-item-action"> <img
					src="/img/send.svg" width="15" height="15"> 쪽지
				</a> <a href="#" class="list-group-item list-group-item-action"> <img
					src="/img/bookmark.svg" width="15" height="15"> 북마크
				</a> <a href="#" class="list-group-item list-group-item-action"> <img
					src="/img/user.svg" width="15" height="15"> 프로필
				</a> <a href="#" class="list-group-item list-group-item-action"> <img
					src="/img/more.svg" width="15" height="15"> 더보기
				</a>
				<div class="list-group-item list-group-item-action">
					<!--주혜 -->
					<button type="button" class="btn btn-outline-success" id="writeBtn"
						data-toggle="modal" data-target="#writeForm">
						<img src="/img/write.svg" width="15" height="15"> 글 쓰기
					</button>
				</div>
				<div class="card">
					<div class="card-body">
						<div class="form-row">
							<img src="/img/teemo.jpg" class="rounded-circle" width="50"
								width="50">
							<div class="form-col ml-2">
								<a class="card-title text-dark" style="font-size: 0.8em">${user.getUnickname() }</a><br>
								<a class="card-subtitle mb-2 text-muted"
									style="font-size: 0.8em">@${user.getUatid() }</a>
							</div>
						</div>
					</div>
					<button type="button" class="btn btn-success">로그아웃</button>
				</div>
			</div>
		</div>
		<!--글쓰기 팝업-->
		<form action="../god/write" method="post" enctype="Multipart/form-data" onsubmit="return checkWrite()">
		<!--실제 값을 보내는곳 -->
		<input type="hidden" name="ucode" value="${user.getUcode() }">
		<input type="hidden" name="savebcode">
		<input type="hidden" name="bcontent">
		<input type="hidden" name="bregdate">
		<input type="hidden" name="btype">
		<input type="hidden" name="banchor" value="0">
		<input type="hidden" name="image">
		<input type="hidden" name="video">
		<input type="hidden" name="vote">
		<input type="hidden" name="save">
		<input type="hidden" name="bsaveorrsvd">
		<!--실제 값을 보내는곳 끝 -->
		<div class="modal fade" id="writeForm" data-backdrop="static"
			data-keyboard="false" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<fieldset class="w-100">
							<button type="button" id="realCloseWrite" class="close" data-dismiss="modal" style="display:none;"></button>
							<button type="button" id="closeWrite" class="close" style="float: right;"
								data-toggle="modal" data-target="#saveModal"
								 aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<a
								style="float: right; color: black; text-decoration: none;"
								data-toggle="modal" data-target="#tempForm">임시 저장한 봄 <span
								class="badge badge-success" id="sumNum"></span>
							</a>
						</fieldset>
					</div>
					<div class="modal-body col-12">
						<img src="/img/teemo.jpg" class="rounded-circle col-1 float-left"
							style="padding: 0px;" width="50" width="50">
						<div contentEditable="true" id="writeTextarea"
							class="col-11 float-left" placeholder="당신의 이야기를 들려주세요." autofocus></div>
						<!--투표-->
						<div class="card" id="vote_form" style="display: none;">
							<ul class="list-group list-group-flush">
								<li class="list-group-item">
									<div class="form-group">
										<input type="text" name="vselect1" class="form-control"
											placeholder="선택1">
									</div>
									<div class="form-group">
										<input type="text" name="vselect2" class="form-control" placeholder="선택2">
									</div>
									<div class="form-group" id="pick3" style="display: none;">
										<input type="text" name="vselect3" class="form-control"
											placeholder="선택3(선택 사항)">
									</div>
									<div class="form-group" id="pick4" style="display: none;">
										<input type="text" name="vselect4" class="form-control"
											placeholder="선택4(선택 사항)">
									</div>
									<button type="button" id="plusSelect"
										class="btn btn-outline-secondary btn-sm">+</button>
								</li>
								<li class="list-group-item">
								<!--복수선택 on / null 로 전달 -->
									<div class="form-check">
      									<input class="form-check-input" type="checkbox" id="multipleChk" name="multipleChk">
      									<label class="form-check-label" for="multipleChk">
        									중복 투표
      									</label>
    									</div>
								</li>
								<li class="list-group-item">
									<h5 class="card-title">투표 기간</h5>
									<div class="form-row">
										<label for="day" class="col-md-3 mr-5 ml-2">일</label> <label
											for="hour" class="col-md-3 mr-5">시</label> <label for="min"
											class="col-md-3">분</label>
									</div>
									<div class="form-row">
										<select id="date" name="date" class="form-control col-md-3 mr-5 ml-2"
											required="required">
											<c:forEach var="i" begin="0" end="7" step="1">
												<c:if test="${i eq '1'}">
													<option selected="selected">${i}</option>
												</c:if>
												<c:if test="${i ne '1'}">
													<option>${i}</option>
												</c:if>
											</c:forEach>
										</select> <select name="hour" id="hour" class="form-control col-md-3 mr-5"
											required="required">
											<c:forEach var="i" begin="0" end="23" step="1">
												<option>${i}</option>
											</c:forEach>
										</select> <select name="min" id="min" class="form-control col-md-3"
											required="required">
											<c:forEach var="i" begin="0" end="59" step="1">
												<option>${i}</option>
											</c:forEach>
										</select>
									</div>
								</li>
							</ul>
						</div>
						<!--파일첨부 -->
						<div class="select_file">
							<img id="image" src="" class="img-fluid" />
							<div class="embed-responsive embed-responsive-16by9"
								style="display: none;">
								<video id="video">
								</video>
							</div>
						</div>
						<!--예약시간표시 -->
						<div id="setTime" class="text-success" style="font-size: 0.8em">

						</div>
						<!--답글권한 select-->
						<select name="bpermission" class="custom-select custom-select-sm">
							<option value="All" selected>모든 사람이 답글 권한을 가집니다</option>
							<option value="Follower">내가 팔로우하는 사람들만 답글 권한을 가집니다</option>
							<option value="Nobody">아무도 답글 권한이 없습니다</option>
						</select>
					</div>
					<div class="modal-footer">
						<fieldset class="w-100">
							<span class="btn-group" role="group" aria-label="Basic example">
								<button type="button" id="mediaDelete" class="btn btn-danger" style="display:none;">미디어 삭제</button>
								<label id="media" class="btn btn-outline-secondary rounded-left" for="media_file">미디어</label>
								<input name="attach" type="file" class="custom-file-input"
								accept="video/*, image/*" id="media_file">
								<button type="button" id="displayVote"
									class="btn btn-outline-secondary">투표</button>
								<button type="button" id="voteDelete" class="btn btn-danger" style="display:none;">투표 삭제</button>
								<button type="button" class="btn btn-outline-secondary"
									id="reserveBtn" data-toggle="modal" data-target="#reserveForm">예약하기</button>
							</span>
							<button type="submit" id="writeSubmit" class="btn btn-success float-right" disabled>봄</button>
						</fieldset>
					</div>
				</div>
			</div>
		</div>
		<!--글쓰기 팝업 끝-->
		<!--예약 창 시작-->
		<div class="modal" id="reserveForm" data-backdrop="static"
			data-keyboard="false" tabindex="-1"
			aria-labelledby="exampleModalLabel2" aria-hidden="true"
			backdrop="false">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">봄 예약하기</h5>
						<div class="form-row">
						<button type="button" id="reserveDelete"
							class="btn btn-light btn-sm mr-1" style="display:none;">지우기</button>
						<button type="button" id="reserveChk"
							class="btn btn-success btn-sm float-right">예약</button>
						</div>
					</div>
					<div id="checkTime" class="alert alert-danger" role="alert">
						날짜가 맞지 않습니다. 다시 확인해 주세요.</div>
					<div class="modal-body col-12">
						<h5 class="card-title">
							날짜 <span id="alertTime"></span>
						</h5>
						<div class="form-row">
							<label for="year" class="col-md-3 mr-5 ml-2">년</label> <label
								for="month" class="col-md-3 mr-5">월</label> <label for="day2"
								class="col-md-3">일</label>
						</div>
						<div class="form-row">
							<!--올해 계산 -->
							<%
								SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
							Date d = new Date();

							int year = Integer.parseInt(sdf1.format(d));
							%>
							<select name="year" id="year" class="form-control col-md-3 mr-5 ml-2"
								required="required">
								<option value="<%=year%>년" selected="selected"><%=year%></option>
								<option value="<%=year + 1%>년"><%=year + 1%></option>
								<option value="<%=year + 2%>년"><%=year + 2%></option>
							</select> <select name="month" id="month" class="form-control col-md-3 mr-5"
								required="required">
								<option value="01월">1</option>
								<option value="02월">2</option>
								<option value="03월">3</option>
								<option value="04월">4</option>
								<option value="05월">5</option>
								<option value="06월">6</option>
								<option value="07월">7</option>
								<option value="08월">8</option>
								<option value="09월">9</option>
								<option value="10월">10</option>
								<option value="11월">11</option>
								<option value="12월">12</option>
							</select> <select name="day" id="day2" class="form-control col-md-3"
								required="required">
								<option value="01일">1</option>
								<option value="02일">2</option>
								<option value="03일">3</option>
								<option value="04일">4</option>
								<option value="05일">5</option>
								<option value="06일">6</option>
								<option value="07일">7</option>
								<option value="08일">8</option>
								<option value="09일">9</option>
								<option value="10일">10</option>
								<option value="11일">11</option>
								<option value="12일">12</option>
								<option value="13일">13</option>
								<option value="14일">14</option>
								<option value="15일">15</option>
								<option value="16일">16</option>
								<option value="17일">17</option>
								<option value="18일">18</option>
								<option value="19일">19</option>
								<option value="20일">20</option>
								<option value="21일">21</option>
								<option value="22일">22</option>
								<option value="23일">23</option>
								<option value="24일">24</option>
								<option value="25일">25</option>
								<option value="26일">26</option>
								<option value="27일">27</option>
								<option value="28일">28</option>
								<option value="29일">29</option>
								<option value="30일">30</option>
								<option value="31일">31</option>
							</select>
						</div>
						<div class="form-row mt-1">
							<label for="hours" class="col-md-3 mr-5 ml-2">시간</label> <label
								for="minute" class="col-md-3">분</label>
						</div>
						<div class="form-row">
							<select name="hours" id="hours" class="form-control col-md-3 mr-5 ml-2"
								required="required">
								<option value="00시">0</option>
								<option value="01시">1</option>
								<option value="02시">2</option>
								<option value="03시">3</option>
								<option value="04시">4</option>
								<option value="05시">5</option>
								<option value="06시">6</option>
								<option value="07시">7</option>
								<option value="08시">8</option>
								<option value="09시">9</option>
								<option value="10시">10</option>
								<option value="11시">11</option>
								<option value="12시">12</option>
								<option value="13시">13</option>
								<option value="14시">14</option>
								<option value="15시">15</option>
								<option value="16시">16</option>
								<option value="17시">17</option>
								<option value="18시">18</option>
								<option value="19시">19</option>
								<option value="20시">20</option>
								<option value="21시">21</option>
								<option value="22시">22</option>
								<option value="23시">23</option>
							</select> <select name="minute" id="minute" class="form-control col-md-3"
								required="required">
								<option value="00분">0</option>
								<option value="01분">1</option>
								<option value="02분">2</option>
								<option value="03분">3</option>
								<option value="04분">4</option>
								<option value="05분">5</option>
								<option value="06분">6</option>
								<option value="07분">7</option>
								<option value="08분">8</option>
								<option value="09분">9</option>
								<option value="10분">10</option>
								<option value="11분">11</option>
								<option value="12분">12</option>
								<option value="13분">13</option>
								<option value="14분">14</option>
								<option value="15분">15</option>
								<option value="16분">16</option>
								<option value="17분">17</option>
								<option value="18분">18</option>
								<option value="19분">19</option>
								<option value="20분">20</option>
								<option value="21분">21</option>
								<option value="22분">22</option>
								<option value="23분">23</option>
								<option value="24분">24</option>
								<option value="25분">25</option>
								<option value="26분">26</option>
								<option value="27분">27</option>
								<option value="28분">28</option>
								<option value="29분">29</option>
								<option value="30분">30</option>
								<option value="31분">31</option>
								<option value="32분">32</option>
								<option value="33분">33</option>
								<option value="34분">34</option>
								<option value="35분">35</option>
								<option value="36분">36</option>
								<option value="37분">37</option>
								<option value="38분">38</option>
								<option value="39분">39</option>
								<option value="40분">40</option>
								<option value="41분">41</option>
								<option value="42분">42</option>
								<option value="43분">43</option>
								<option value="44분">44</option>
								<option value="45분">45</option>
								<option value="46분">46</option>
								<option value="47분">47</option>
								<option value="48분">48</option>
								<option value="49분">49</option>
								<option value="50분">50</option>
								<option value="51분">51</option>
								<option value="52분">52</option>
								<option value="53분">53</option>
								<option value="54분">54</option>
								<option value="55분">55</option>
								<option value="56분">56</option>
								<option value="57분">57</option>
								<option value="58분">58</option>
								<option value="59분">59</option>
								<option value="60분">60</option>
							</select>
						</div>
					</div>
					<div class="modal-footer">
						
						<button type="button" class="close" id="reserveClose"
							data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!--예약 창 끝-->

		<!--임시저장 창 시작-->
		<div class="modal" id="tempForm" data-backdrop="static"
			data-keyboard="false" tabindex="-1"
			aria-labelledby="exampleModalLabel2" aria-hidden="true"
			backdrop="false">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">임시 저장한 봄</h5>
						<button type="button" id="editSave" class="btn btn-success btn-sm float-right">수정</button>
					</div>
					<div class="modal-body col-12">
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item" role="presentation">
								<a class="nav-link active" id="save-tab" data-toggle="tab" href="#save">저장
								 <span class="badge badge-success" id="saveNum"></span>
								</a>
							</li>
							<li class="nav-item" role="presentation">
								<a class="nav-link" id="reserve-tab" data-toggle="tab" href="#reserve">예약
								 <span class="badge badge-success" id="reserveNum"></span>
								</a>
							</li>
						</ul>
						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade show active" id="save">
								<ul class="list-group" id="saveList">
								</ul>
							</div>
							<div class="tab-pane fade" id="reserve">
								<ul class="list-group" id="reserveList">
								</ul>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="close" id="saveClose"
							data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!--임시저장 창 끝-->
		
		<!--종료 전 저장 묻는 팝업 -->
		<!-- Modal -->
		<div class="modal fade" id="saveModal" tabindex="-1"
			aria-labelledby="saveModal" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						봄을 저장하시겠습니까?
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body text-center">
						이 내용을 저장하시면 <br>
						다음에 이어서 작성하실 수 있습니다.
					</div>
					<div class="modal-footer">
						<button type="button" id="notsaveBtn" class="btn btn-secondary">
							아뇨 괜찮습니다</button>
						<button type="submit" id="saveBtn" class="btn btn-success">저장</button>
					</div>
				</div>
			</div>
		</div>
		<!--저장 팝업 끝-->
		</form>
		<!--(주혜)글쓰기 폼 기능-->
		<%
			String context = request.getContextPath();
		%> 
		<script type="text/javascript">
		/*예약을 해뒀는지(현재시간으로 안바뀌게)*/
		var reserve=0; //0 안함 1 함 -> bregdate 설정
		var btype=0; // 0 = noraml, 1=reply, 2=scrap, 3=quote
		var bvote=0; //0 안함 1 함
		var imgorvideo=0; //0이면 없는거 1이면 image 2이면 video
		var save=0; //0이면 save x, 1이면 save
		<!--글 쓰기전에 값 input에 넣기--> 
		function checkWrite(){
			//bcontent 넣기
			var write=$("#writeTextarea").html();
			if(write.includes("<div>")){
				write=write.replaceAll("<div>","<br>");
				write=write.replaceAll("</div>","");
			}
			if(write.includes('#')){
				write = write.replace(/^#([^\s]+)/g, '<a href="../hoon/searchView?search=%23$1">#$1</a>'); //맨앞에 해시태그 쓴거
				write = write.replace(/\s#([^\s]+)/g, ' <a href="../hoon/searchView?search=%23$1">#$1</a>'); //앞에공백 해시태그
				//write = write.replace(/>#([^\s]+)/g, '><a href="../hoon/searchView?search=%23$1">#$1</a>'); 
			}
			$('input[name=bcontent]').attr('value', write);
			//bregdate 넣기
			if(reserve==0)
				$('input[name=bregdate]').attr('value','0');
			else{
				$('input[name=bregdate]').attr('value','1');
				$('input[name=bsaveorrsvd]').attr('value','1')
			}
			//저장글인지
			if(save==1){
				$('input[name=bregdate]').attr('value','0');
				$('input[name=bsaveorrsvd]').attr('value','0')
			}
			//일반글이면(예약,저장아니면)
			if(reserve==0 && save==0)
				$('input[name=bsaveorrsvd]').attr('value','2')
			
			//btype 넣기
			if(btype==0)
				$('input[name=btype]').attr('value','normal');
			else if(btype==1)
				$('input[name=btype]').attr('value','reply');
			else if(btype==2)
				$('input[name=btype]').attr('value','scrap');
			else if(btype==3)
				$('input[name=btype]').attr('value','quote');
			
			//video인지 image인지 구분
			if(imgorvideo==1)
				$('input[name=image]').attr('value','1');
			else if(imgorvideo==2)
				$('input[name=video]').attr('value','1');
			
			//투표가있는지
			if(bvote==0)
				$('input[name=vote]').attr('value','0');
			else if(bvote==1)
				$('input[name=vote]').attr('value','1');
			
			
			
			return true;
		}
		
		<!--글쓰면 글등록 버튼 활성화 -->
		$("#writeTextarea").on("propertychange change keyup paste input",
				function(event) {
					$('#writeSubmit').attr('disabled', false);
					var write=$("#writeTextarea").html();
					if(write=='' ||write.trim()==''){
						$('#writeSubmit').attr('disabled', true);
					}
		});
		
		/*저장, 예약 목록창에서 수정창 누르면 checkbox띄우기*/
		$("#editSave").click(function(){
			$("input[name=checkedbcode]").css("display","block");
		});
		
		/* 글쓰기 버튼 누르면 임시저장 글 수(저장, 예약) 가져오기 */
		function clickWriteBtn(){
			var sumNum=0;
			
			$.ajax({
				url:"<%=context%>/god/getReserveNum",
			data:{ucode:${user.getUcode()}},  
			dataType:'text',
			async:false,
			success:function(data){
				$('#reserveNum').html(data);
				sumNum=parseInt(data);
			}
		});
		
		$.ajax({
			url:"<%=context%>/god/getSaveNum",
				data:{ucode:${user.getUcode()}},
				dataType:'text',
				async:false,
				success:function(data){
					$('#saveNum').html(data);
					sumNum+=parseInt(data);
				}
			});
			
			$('#sumNum').html(sumNum);
		}
		
		/*저장,예약 글 불러오기*/
		function clickSaveBtn(){
			var str="";
			$.ajax({
				url:"<%=context%>/god/getSaveList",
			data:{ucode:${user.getUcode()}},
			dataType:'json',
			async:false,
			success:function(list){
				for(var i=0; i<list.length; i++){
					str+="<li class='list-group-item list-group-item-action'>"
					+"<input type='checkbox' name='checkedbcode' id='"+list[i].bcode+"' style='display:none;''>"
					+"<a href='javascript:callSave("+list[i].bcode+")'>"
					+list[i].bcontent
					+"</a>"
					+"</li>";
				}
					
				$("#saveList").append(str);
			},
			 error : function(request,status,error) {
			        alert("message:"+request.responseText+"\n"+"Error -> "+error);
			}
		});
		
		str="";
		$.ajax({
			url:"<%=context%>/god/getReserveList", 
				data:{ucode:${user.getUcode()}},  
				dataType:'json',
				async:false,
				success:function(list){
					for(var i=0; i<list.length; i++){
						str+="<input type='checkbox' name='checkedbcode' id='"+list[i].bcode+"' style='display:none;''>"
						+"<li class='list-group-item list-group-item-action' onclick='callSave("+list[i].bcode+")'>"
						+list[i].bcontent+"</li>";
					} 
					$("#reserveList").append(str);
				}, 
				 error : function(request,status,error) {
				        alert("message:"+request.responseText+"\n"+"Error -> "+error);
				}
			});
		}
		
		/*저장글 writeForm에 적용*/
		function callSave(code){
			//writeForm 초기화부터
			reserve=0;
			btype=0;
		 	bvote=0;
			imgorvideo=0;
			save=0;
			$("#writeTextarea").html(""); //글내용 초기화
			$(".img-fluid").attr("src",""); //이미지 초기화
			$(".embed-responsive video").attr("src",""); //동영상 초기화
			$('.embed-responsive').css("display","none"); //동영상 none
			jQuery("#media").css("display","block"); //미디어선택 버튼 활성화
			jQuery("#mediaDelete").css("display","none"); //미디어 삭제 버튼 안보이게
			//예약창 닫고
			$("#tempForm .close").click();
			//아작스로 글불러오기
			$.ajax({
				url:"<%=context%>/god/callSaveBoard",
				data:{bcode: code},
				dataType:'json',
				async:false,
				success:function(data){
					$("input[name=ucode]").attr('value', data.ucode);
					$("input[name=savebcode]").attr('value', data.bcode);
					$("#writeTextarea").html(data.bcontent);	
					//예약글일경우
					if(data.bregdate!=null){
						reserve=1;
						var str="";
						var rsvdyear=(data.bregdate).substring(0,2);
						var rsvdmonth=(data.bregdate).substring(3,5);
						var rsvdday=(data.bregdate).substring(6,8);
						var rsvdhour=(data.bregdate).substring(9,11);
						var rsvdmin=(data.bregdate).substring(12,14);
						str="20"+rsvdyear+"년  "+
							rsvdmonth+"월 "+
							rsvdday+"일 "+
							rsvdhour+"시 "+
							rsvdmin+"분에 글 예약";
						$('#setTime').text(str);
						//예약창 selected 시켜놓기
						$("#year").val("20"+rsvdyear+"년").attr("selected",true);
						$("#month").val(rsvdmonth+"월").attr("selected",true);
						$("#day2").val(rsvdday+"일").attr("selected",true);
						$("#hours").val(rsvdhour+"시").attr("selected",true);
						$("#minute").val(rsvdmin+"분").attr("selected",true);
					}
					//저장글일경우
					else{
						$('#setTime').text("");
					}
					//attach가 이미지일때
					if((data.battach).substring(0,5) == "image"){
						$('.img-fluid').css("display","");
						$('.embed-responsive').css("display","none");
						$(".select_file img").attr("src", "${context}/"+data.battach);
						imgorvideo=1;
						jQuery("#mediaDelete").css("display","block");
						jQuery("#media").css("display","none");
					}
					//attach가 동영상일때
					else if((data.battach).substring(0,5) == "video"){
						$('.img-fluid').css("display","none");
						$('.embed-responsive').css("display","");
						var video = document.getElementById("video");
						video.setAttribute("src", "${context}/"+data.battach); 
						video.play(); 
						imgorvideo=2;
						jQuery("#mediaDelete").css("display","block");
						jQuery("#media").css("display","none");
					}
				},
			error : function(request,status,error) {
			    alert("message:"+request.responseText+"\n"+"Error -> "+error);
			}});
		}
		
		/*글쓰기에서 닫기눌렀을때 글이없으면 저장창 안띄우고 닫기*/
		jQuery("#closeWrite").click(function(){
			var write=$("#writeTextarea").html();
			if(write=='' ||write.trim()==''){
				$("#saveModal .close").click();
				$("#realCloseWrite").click();
				//그리고 메인글로 돌아가
				location.href="../god/main";
			}
		});
		
		/*마지막 저장창에서 저장안해 클릭*/
		jQuery("#notsaveBtn").click(function(){
			//$("#writeForm .close").click();
			$("#saveModal .close").click();
			$("#realCloseWrite").click();
			//그리고 메인글로 돌아가
			location.href="../god/main";
		});
		
		/*마지막 저장창에서 저장해 클릭*/
		jQuery("#saveBtn").click(function(){
			save=1;
		});
		
		<!--예약하기 버튼(월-일맞춰서 경고창띄우기)-->
		jQuery("#reserveChk").click(function(){
			var year=$("#year option:selected").val();
			var month=$("#month option:selected").val();
			var day=$("#day2 option:selected").val()
			var hours=$("#hours option:selected").val();
			var minute=$("#minute option:selected").val();
			if(month=="02월"&&(day=="29일"||day=="30일"||day=="31일"))
				$('#checkTime').show();
			else if((month=="04월"||month=="06월"||month=="09월"||month=="11월")&&day=="31일")
				$('#checkTime').show();
			else{
				reserve=1;
				$('#checkTime').hide(); //알림창 끄고
				$("#reserveForm .close").click(); // 예약창 닫아주고
				$('#setTime').text(year+" "+month+" "+day+" "+hours+" "+minute+"에 글 예약");
				//예약 지우기 버튼 활성화
				$("#reserveDelete").css("display","block");
				//투표 비활성화
				$("#displayVote").attr("disabled","disabled");
				bvote=0;
			}
		 });
		 
		<!--예약창 시간 가져오기-->
		jQuery('#reserveBtn').click(function () { 
			if(reserve==0){
				var timer=new Date();
				var y=timer.getFullYear();
				var m=timer.getMonth()+1;
				var d=timer.getDate();
				var h=timer.getHours();
				var m2=timer.getMinutes();
				if(m<10)
					$("#month").val("0"+m+"월").attr("selected",true);
				else
					$("#month").val(m+"월").attr("selected",true);
				if(d<10)
					$("#day2").val("0"+d+"일").attr("selected",true);
				else
					$("#day2").val(d+"일").attr("selected",true);
				if(h<10)
					$("#hours").val("0"+h+"시").attr("selected",true);
				else
					$("#hours").val(h+"시").attr("selected",true);
				if(m2<10)
					$("#minute").val("0"+m2+"분").attr("selected",true);
				else
					$("#minute").val(m2+"분").attr("selected",true);
				$('#checkTime').hide();
			}
		}); 
		
		<!--예약 시간 지우기-->
		jQuery("#reserveDelete").click(function(){
			$("#reserveDelete").css("display","none");
			$('#setTime').text("");
			$("#reserveForm .close").click(); 
			//투표 활성화
			$("#displayVote").removeAttr("disabled");
			reserve=0;
		});
		
		<!-- 투표 삭제 -->
		jQuery('#voteDelete').click(function () {   
			$('#vote_form').css("display","none");  
			$("#displayVote").css("display","block");
		    $("#voteDelete").css("display","none");
			$("[name=vselect1]").attr("required" , false);
	        $("[name=vselect2]").attr("required" , false);
	        //예약버튼 활성화
	        $("#reserveBtn").attr("disabled",false);
			bvote=0;
		}); 
		
		<!-- 투표 보이기 -->
		jQuery('#displayVote').click(function () {  
		    if($("#vote_form").css("display") == "none"){   
		        $('#vote_form').css("display","");
		        $("[name=vselect1]").attr("required" , true);
		        $("[name=vselect2]").attr("required" , true);
		        $("#displayVote").css("display","none");
		        $("#voteDelete").css("display","block");
		        //예약버튼 비활성화
		        $("#reserveBtn").attr("disabled",true);
		        $('#setTime').text("");
		        $("#reserveDelete").css("display","none");
		        reserve=0;
		    } 
		    bvote=1;
		});  
		
		<!--투표 항목 늘리기-->
		jQuery('#plusSelect').click(function () {  
		    if($("#pick3").css("display") == "none"){   
		        $('#pick3').css("display","");
		    } 
		    else {  
		        $('#pick4').css("display","");
		        $('#plusSelect').css("display","none");
		    }  
		});  
		
		<!--파일 처리(이미지 or 동영상 선택)--> 
		$("#media_file").change(function(){
			if(this.files && this.files[0] && this.files[0].name.match(/\.(jpg|jpeg|png|gif)$/)){
				$(".embed-responsive video").attr("src","");
				if(this.files[0].size>10485760) {
		            alert('File size is larger than 10MB!');
		        }
				else{
					$('.img-fluid').css("display","");
					$('.embed-responsive').css("display","none");
					var reader=new FileReader;
					reader.onload=function(data){
						$(".select_file img").attr("src", data.target.result);
					}
					reader.readAsDataURL(this.files[0]);
					imgorvideo=1;
					jQuery("#mediaDelete").css("display","block");
					jQuery("#media").css("display","none");
				}
			}
			else if(this.files && this.files[0] && this.files[0].name.match(/\.(avi|mpg|mpeg|mp4)$/)){
				$(".img-fluid").attr("src","");
				if(this.files[0].size>104857600) {
		            alert('File size is larger than 100MB!');
		        }
				else{
					$('.img-fluid').css("display","none");
					$('.embed-responsive').css("display","");
					var inputFile = document.getElementById("media_file"); 
					var video = document.getElementById("video"); 
					var files = inputFile.files; 
					var videourl = URL.createObjectURL(inputFile.files[0]); 
					video.setAttribute("src", videourl); 
					video.play(); 
					imgorvideo=2;
					jQuery("#mediaDelete").css("display","block");
					jQuery("#media").css("display","none");
				}
			}
		}); 
		<!--미디어 삭제 버튼 누르면-->
		jQuery('#mediaDelete').click(function (){
			if(imgorvideo==1){
				$(".img-fluid").attr("src","");
			}
			else if(imgorvideo==2){
				$(".embed-responsive video").attr("src","");
				$('.embed-responsive').css("display","none");
			}
			jQuery("#media").css("display","block");
			jQuery("#mediaDelete").css("display","none");
			imgorvideo=0;
		});
		</script>
	<!--글쓰기 폼 끝-->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<button class="btn btn-success" id="menu-toggle">←</button>
			</nav>
			<div class="alert alert-success" role="alert">
				<a href="#" class="alert-link">좋아요</a>를 누르셨습니다.
			</div>
			<div class="container-fluid">
				<p>
				<div class="card">
					<div class="card-header">글쓰기</div>
					<div class="card-body">
						<div class="form-group">
							<textarea class="form-control" id="pageWriteTextarea"
								placeholder="당신의 이야기를 들려주세요."></textarea>
						</div>
						<div class="btn-group" role="group" aria-label="Basic example">
							<button type="button" class="btn btn-outline-secondary">미디어</button>
							<button type="button" class="btn btn-outline-secondary">GIF</button>
							<button type="button" class="btn btn-outline-secondary">투표</button>
							<button type="button" class="btn btn-outline-secondary">예약하기</button>
						</div>
						<button type="submit" class="btn btn-success float-right">등록</button>
					</div>
				</div>
				<!--글 정렬-->
				<c:forEach begin="1" end="10" step="1">
					<div class="card">
						<div class="card-body">
							<button type="button" class="btn btn-light float-right">⋯</button>
							<img src="/img/teemo.jpg" class="rounded-circle" width="50">
							<a class="card-title text-dark">닉네임</a> <a
								class="card-subtitle mb-2 text-muted">@atid</a> <a
								class="card-subtitle mb-2 text-muted">작성시간</a> <a href="#"
								class="card-text" style="margin-top: 10px;">글내용 블라블라글내용
								블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라 글내용 블라블라글내용
								블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라 글내용 블라블라글내용
								블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라 글내용 블라블라글내용
								블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라글내용 블라블라</a>
							<div align="center">
								<div class="btn-group col-md-12" role="group"
									aria-label="Button group with nested dropdown">
									<button type="button" class="btn btn-secondary mr-3 btn-light"
										data-toggle="tooltip" data-placement="top" title="답글">
										<img src="/img/speech-bubble.svg" width="20" height="20">
									</button>
									<button type="button" class="btn btn-secondary btn-light mr-3"
										data-toggle="tooltip" data-placement="top" title="스크랩 or 인용">
										<img src="/img/bring.svg" width="20" height="20">
									</button>
									<button type="button" class="btn btn-secondary btn-light mr-3"
										data-toggle="tooltip" data-placement="top" title="좋아요">
										<img src="/img/heart.svg" width="20" height="20">
									</button>
									<button type="button"
										class="btn btn-secondary btn-light mr-3 dropdown-toggle caret-off"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<img src="/img/share.svg" width="20" height="20">
									</button>
									<div class="dropdown-menu">
										<a class="dropdown-item" href="#">북마크 추가/삭제</a> <a
											class="dropdown-item" href="#">URL담아가기</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
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
							<div class="card">
								<div class="card-body" style="font-size: 0.8rem; padding: 10px;">
									<img src="/img/teemo.jpg" class="rounded-circle" width="20"
										height="20"> <a class="card-title text-dark">닉네임</a> <a
										class="card-subtitle mb-2 text-muted">@atid</a>
									<button type="button"
										class="btn btn-outline-success btn-sm float-right"
										style="font-size: 0.8rem;">팔로우</button>
								</div>
							</div>
							<div class="card">
								<div class="card-body" style="font-size: 0.8rem; padding: 10px;">
									<img src="/img/teemo.jpg" class="rounded-circle" width="20"
										height="20"> <a class="card-title text-dark">닉네임</a> <a
										class="card-subtitle mb-2 text-muted">@atid</a>
									<button type="button"
										class="btn btn-outline-success btn-sm float-right"
										style="font-size: 0.8rem;">팔로우</button>
								</div>
							</div>
							<div class="card">
								<div class="card-body" style="font-size: 0.8rem; padding: 10px;">
									<img src="/img/teemo.jpg" class="rounded-circle" width="20"
										height="20"> <a class="card-title text-dark">닉네임</a> <a
										class="card-subtitle mb-2 text-muted">@atid</a>
									<button type="button"
										class="btn btn-outline-success btn-sm float-right"
										style="font-size: 0.8rem;">팔로우</button>
								</div>
							</div>
						</div>
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
	<!-- /#wrapper -->



</body>

</html>