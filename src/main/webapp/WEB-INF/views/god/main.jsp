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
</style>
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
					<button type="button" class="btn btn-outline-success"
						data-toggle="modal" data-target="#writeForm">
						<img src="/img/write.svg" width="15" height="15"> 글 쓰기
					</button>
				</div>
				<div class="card">
					<div class="card-body">
						<img src="/img/teemo.jpg" class="rounded-circle" width="50"
							width="50"> <a class="card-title text-dark">닉네임</a> <a
							class="card-subtitle mb-2 text-muted">@atid</a>
					</div>
					<button type="button" class="btn btn-success">로그아웃</button>
				</div>
			</div>
		</div>
		<!--글쓰기 팝업-->
		<div class="modal fade" id="writeForm" data-backdrop="static"
			data-keyboard="false" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<fieldset class="w-100">
							<button type="button" class="close" style="float: right;"
								data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<a href='#'
								style="float: right; color: black; text-decoration: none;">임시
								저장한 봄 <span class="badge badge-success">1</span>
							</a>
						</fieldset>
					</div>
					<div class="modal-body col-12">
						<img src="/img/teemo.jpg" class="rounded-circle col-1 float-left"
							style="padding: 0px;" width="50" width="50">
						<div contentEditable="true" id="writeTextarea"
							class="col-11 float-left" placeholder="당신의 이야기를 들려주세요."></div>
						<!--투표-->
						<div class="card" id="vote_form" style="display: none;">
							<ul class="list-group list-group-flush">
								<li class="list-group-item">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="선택1">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" placeholder="선택2">
									</div>
									<div class="form-group" id="pick3" style="display: none;">
										<input type="text" class="form-control"
											placeholder="선택3(선택 사항)">
									</div>
									<div class="form-group" id="pick4" style="display: none;">
										<input type="text" class="form-control"
											placeholder="선택4(선택 사항)">
									</div>
									<button type="button" id="plusSelect"
										class="btn btn-outline-secondary btn-sm">+</button>
								</li>
								<li class="list-group-item">
									<h5 class="card-title">투표 기간</h5>
									<div class="form-row">
										<select id="day" class="form-control col-md-3 mr-5 ml-2"
											required="required">
											<option selected="selected" disabled="disabled">일</option>
											<c:forEach var="i" begin="0" end="7" step="1">
												<option>${i}</option>
											</c:forEach>
										</select> <select id="hour" class="form-control col-md-3 mr-5"
											required="required">
											<option selected="selected" disabled="disabled">시간</option>
											<c:forEach var="i" begin="0" end="23" step="1">
												<option>${i}</option>
											</c:forEach>
										</select> <select id="min" class="form-control col-md-3"
											required="required">
											<option selected="selected" disabled="disabled">분</option>
											<c:forEach var="i" begin="0" end="59" step="1">
												<option>${i}</option>
											</c:forEach>
										</select>
									</div>
								</li>
								<li class="list-group-item text-center"><a href="#"
									id="deleteVote" class="btn btn-outline-danger">투표 삭제</a></li>
							</ul>
						</div>
						<!--파일첨부 -->
						<div class="select_file">
							<img src="" class="img-fluid" />
							<div class="embed-responsive embed-responsive-16by9"
								style="display: none;">
								<video id="video">
								</video>
							</div>
						</div>
						<!-- <textarea class="form-control col-11 float-left"
							id="writeTextarea" placeholder="당신의 이야기를 들려주세요." rows="3"></textarea> -->
						<select class="custom-select custom-select-sm">
							<option value="All" selected>모든 사람이 답글 권한을 가집니다</option>
							<option value="Follower">내가 팔로우하는 사람들만 답글 권한을 가집니다</option>
							<option value="Nobody">아무도 답글 권한이 없습니다</option>
						</select>
					</div>
					<div class="modal-footer">
						<fieldset class="w-100">
							<span class="btn-group" role="group" aria-label="Basic example">
								<label class="btn btn-outline-secondary" for="media_file">미디어</label>
								<input type="file" class="custom-file-input"
								accept="video/*, image/*" id="media_file">
								<button type="button" class="btn btn-outline-secondary">GIF</button>
								<button type="button" id="displayVote"
									class="btn btn-outline-secondary">투표</button>
								<button type="button" class="btn btn-outline-secondary" id="reserveBtn"
									data-toggle="modal" data-target="#reserveForm">예약하기</button>
							</span>
							<button type="button" class="btn btn-success float-right">봄</button>
						</fieldset>
					</div>
				</div>
			</div>
		</div>
		<!--예약 창-->
		<div class="modal fade" id="reserveForm" data-backdrop="static"
			data-keyboard="false" tabindex="-1"
			aria-labelledby="exampleModalLabel2" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">봄 예약하기</h5>
						<button type="button" class="btn btn-success btn-sm float-right">예약</button>
					</div>

					<div class="modal-body col-12">
						<h5 class="card-title">날짜</h5>
						<div class="form-row">
							<select aria-label="년" class="form-control col-md-3 mr-5 ml-2" required="required">
								<option>${year+1 }년</option>
								<option selected="selected">${year }년</option>
								<option>${year-1 }년</option>
							</select> 
							<select aria-label="월" class="form-control col-md-3 mr-5" required="required">
								<option selected="selected">${month }월</option>
								<c:forEach var="i" begin="1" end="12" step="1">
									<c:if test="${i } ne ${month }">
										<option>${i}월</option>
									</c:if>
								</c:forEach>
							</select> 
							<select class="form-control col-md-3" required="required">
								<option selected="selected" disabled="disabled">분</option>
								<c:forEach var="i" begin="0" end="59" step="1">
									<option>${i}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</div>
			</div>
		</div>
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">
		<!--예약창 시간 가져오기-->
		jQuery('#reserveBtn').click(function (){
			let today = new Date(); 
			let year = today.getFullYear(); // 년도
			let month = today.getMonth() + 1;  // 월
			let date = today.getDate();  // 일
			let hours = today.getHours(); // 시
			let minutes = today.getMinutes();  // 분
			
		});
		
		
		<!-- 투표 삭제 -->
		jQuery('#deleteVote').click(function () {   
			$('#vote_form').css("display","none");  
		});  
		<!-- 투표 보이기 -->
		jQuery('#displayVote').click(function () {  
		    if($("#vote_form").css("display") == "none"){   
		        $('#vote_form').css("display","");  
		    } 
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
				}
			}
			else if(this.files && this.files[0] && this.files[0].name.match(/\.(avi|mpg|mpeg|mp4)$/)){
				$(".img-fluid").attr("src","");
				if(this.files[0].size>10485760) {
                    alert('File size is larger than 10MB!');
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
				}
			}
		});
		<!--해시태그 처리 -->
		$("#writeTextarea").on("propertychange change keyup paste input",
				function(event) {
					if (event.keyCode == 32 || event.keyCode == 13) {
						var currentVal = $(this).html();
						if(currentVal.includes('#')){
							var pattern = /#([\p{L}\p{N}]+)/gu;
							currentVal = currentVal.replace(pattern,
								'<a href="/?hashtag=$1">#$1</a>&nbsp');
							$('#writeTextarea').html(currentVal);
						}
							/* var div = document.getElementById('#writeTextarea');
							setTimeout(function() {
							    div.focus();
							}, 0); 

							// See it in action here 
							$(this).focusToEnd("Cursor will be at my tail...");  */
							/* currentVal = $(this).val();
							var splitedArray = currentVal.split(' ');
							var linkedContent = "";
							for ( var word in splitedArray) {
								word = splitedArray[word];
								if (word.indexOf('#') == 0)
									word = '<span class="text-primary">'
											+ word + '</span>';
								linkedContent += word + ' ';
							}
							document.getElementById('writeTextarea').innerHTML = linkedContent; */
						}
					});
			/* function pasteHtmlAtCaret(html) {
				var sel, range;
				if (window.getSelection) {
					// IE9 and non-IE
					sel = window.getSelection();
					if (sel.getRangeAt && sel.rangeCount) {
						range = sel.getRangeAt(0);
						range.deleteContents();

						// Range.createContextualFragment() would be useful here but is
						// non-standard and not supported in all browsers (IE9, for one)
						var el = document.createElement("div");
						el.innerHTML = html;
						var frag = document.createDocumentFragment(), node, lastNode;
						while ((node = el.firstChild)) {
							lastNode = frag.appendChild(node);
						}
						range.insertNode(frag);

						// Preserve the selection
						if (lastNode) {
							range = range.cloneRange();
							range.setStartAfter(lastNode);
							range.collapse(true);
							sel.removeAllRanges();
							sel.addRange(range);
						}
					}
				} else if (document.selection
						&& document.selection.type != "Control") {
					// IE < 9
					document.selection.createRange().pasteHTML(html);
				}
			}  */
			/* function hashtag() {
				var content = document.getElementById('writeTextarea').innerHTML;
				var splitedArray = content.split(' ');
				var linkedContent = "";
				for ( var word in splitedArray) {
					eotf = splitedArray[word];
					if (word.indexOf('#') == 0)
						word = '<span style=\'color:blue;\'>' + word + '</span>';
					linkedContent += word + ' ';
				}
				document.getElementById('writeTextarea').innerHTML = linkedContent;
			} */
			/* function util_convert_to_hash_tag(str) {
				var inputString = str;
				inputString = inputString.replace(/#[^#\s]+|@[^@\s]+/gm,
					function(tag) {
						return (tag.indexOf('#') == 0) ? '<a href="#">' + tag + '</a>' : '<a href="#">' + tag + '</a>';
					});
				return inputString;
			} */
			/* $("#writeTextarea")
				.on(
						"propertychange change keyup paste input",
						function() {
							var currentVal = $(this).val();
							var splitedArray = currentVal.split(' ');
							var linkedContent = "";
							for ( var word in splitedArray) {
								word = splitedArray[word];
								if (word.indexOf('#') == 0)
									word = '<p class="text-primary">'
											+ word + '</p>';
								linkedContent += word + ' ';
							}
							document.getElementById('writeTextarea').innerHTML = linkedContent;
						});  */
		</script>
		<!-- /#sidebar-wrapper -->



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