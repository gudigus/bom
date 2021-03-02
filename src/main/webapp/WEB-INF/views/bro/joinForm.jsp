<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 입력 화면</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
	<form action="memberInsert.jsp" method="post">
	<table border="1">
		<tr>
			<th>이메일</th>
			<td><input type="text" name="uEmail" required="required" /></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="Date" name="uBirth" required="required" /></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="" required="required" /></td>
		</tr>
		<tr>
			<th>국가</th>
			<td><select>
    <option value="kr">Korea</option>
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
                <input id="male" type="radio"  value="남성" name="ss">

                <label for="female">여성</label>
                <input id="female" type="radio" checked value="여성" name="ss"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input class="form-control" type="password"
							id="user_password" name="user_password" maxlength="10"
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
</html>