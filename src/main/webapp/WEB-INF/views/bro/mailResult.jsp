<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<body>

    <c:if test="${check==1}">
     <h1>이메일로전송된 인증번호를 입력해주세요 </h1><p>
     <input type="text" id="temp" />
     <c:set var="tempPassword" value="${tempPassword}"></c:set>
     
   <%--   <c:if test="${tempPassword==temp }"></c:if> --%>
     <div id="temp_check"></div>
         
    
    
    
    
    </c:if>
    
    
    <c:if test="${check!=1}">메일전송이 실패되었습니다</c:if>
    <c:if test="${check==null}">              </c:if>
</body>
<script type="text/javascript">
$("#temp").blur(function() {

	// id = "id_reg" / name = "userId"
	// 입력 인증번호
	var temp = $('#temp').val();
	var ContPassword = ${tempPassword};
	
			if (ContPassword = temp) {
					
					$("#temp_check").text("인증번호가 일치합니다.");
					$("#temp_check").css("color", "red");
					$("#reg_submit").attr("disabled", true);
				}
			else{
					$("#temp_check").text("인증번호가 다릅니다.");
					$("#temp_check").css("color", "red");
					$("#reg_submit").attr("disabled", true);
					
				} 
		}
			
);
	 

</script>
</html>