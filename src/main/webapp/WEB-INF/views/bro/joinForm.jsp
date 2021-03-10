<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 입력 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	 $(".alert-success").hide();
	 $(".alert-different").hide();
	 $("input").keyup(function(){
		 var user_password = $("#user_password").val();
	     var user_password1 = $("#user_password1").val();
	     if(user_password != "" || user_password1 != "") {
	    	 if(user_password == user_password1) {
	    		  $(".alert-success").show();
	    		  $(".alert-different").hide();
	    		  $("#submit").removeAttr("disabled");
	    		 
	    	 }else {
	    		 $(".alert-success").hide();
	    		 $(".alert-different").show();
	    		 $("#submit").attr("disabled" , "disabled");
	    		 
	    	 }
	     }
	     
	 }); 
  }); 

</script>

<body>
<div align="center">
	<form action="joinForm" method="get">
	<table border="1">
		<tr>
			<th>이메일</th>
			<td><input type="text" name="uEmail" id="uEmail" required="required"/>
			    <div id="Email_check"></div>
			     
			</td>
		   
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="Date" name="uBirth" required="required" /></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="uNickname" required="required" /></td>
		</tr>
		<tr>
			<th>국가</th>
			<td><select name="uNation">
    <option value="kr" >Korea</option>
    <option value="ad">Andorra</option> 
    <option value="dz">Algeria</option> 
    <option value="ao">Angola</option> 
    <option value="ai">Anguilla</option> 
    <option value="ag">Antigua &amp; Barbuda</option> 
    <option value="ar">Argentina</option> 
    <option value="am">Armenia</option> 
    <option value="aw">Aruba</option> 
    <option value="au">Australia</option> 
    <option value="at">Austria</option> 
    <option value="us">United States</option>
    <option value="at">Austria</option>
    <option value="br">Brazil</option>
    <option value="ca">Canada</option>
    <option value="uy">Uruguay</option>
    <option value="ar">Argentina</option>
    <option value="de">Germany</option>
    <option value="gb">United Kingdom</option>
    <option value="fr">France</option>
    <option value="vi">Dominican Republic &amp; Virgin Islands, US</option>
     </select></td>

		</tr>
		
		<tr>
			<th>성별</th>
			<td><label for="male">남성</label>
                <input id="male" type="radio" name="uGender" value="mail" >
                

                <label for="female">여성</label>
                <input id="female" type="radio" name="uGender" checked value="femail" ></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input class="form-control" type="password"
							id="user_password" name="uPassword" maxlength="10"
							required="required"></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input class="form-control" type="password"
							id="user_password1" name="user_password1" maxlength="10" required="required">
							<div class="alert-success">
						           비밀번호가 일치합니다.
					       </div>
					       <div class="alert-different">
					  	          비밀번호가 불일치합니다.
					       </div>
					       </td>
		</tr>
		<tr>
			<td colspan="2" align="center"> 
				<input type="submit" value="다음" />
				<input type="reset" value="초기화" />
				
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
<script type="text/javascript">
$("#uEmail").blur(function() {

	// id = "id_reg" / name = "userId"
	var uEmail = $('#uEmail').val();
	$.ajax({
		url : '/checkEmail?uEmail='+ uEmail,
		type : 'get',
		success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
					// 1 : 아이디가 중복되는 문구
					$("#Email_check").text("사용중인 아이디입니다 :p");
					$("#Email_check").css("color", "red");
					$("#reg_submit").attr("disabled", true);
				}
			if(data == 0){
					$("#Email_check").text("사용가능한 아이디입니다 :p");
					$("#Email_check").css("color", "red");
					$("#reg_submit").attr("disabled", true);
					
				}
			
			
			else {
					
					if(idJ.test(uEmail)){
						// 0 : 아이디 길이 / 문자열 검사
						$("#Email_check").text("");
						$("#reg_submit").attr("disabled", false);
			
					} else if(uEmail == ""){
						
						$('#Email_check').text('아이디를 입력해주세요 :)');
						$('#Email_check').css('color', 'red');
						$("#reg_submit").attr("disabled", true);				
						
					} else {
						
						$('#uEmail_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다 :) :)");
						$('#uEmail_check').css('color', 'red');
						$("#reg_submit").attr("disabled", true);
					}
				
					
				}
			}, error : function() {
					console.log("실패");
			}
		});
	});  

</script>
</html>