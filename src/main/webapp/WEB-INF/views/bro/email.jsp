<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
        <form action="emailAu" method="post">
            <h2>비밀번호 찾기</h2>
            <p>
                아래 이메일주소를 입력하시면,<br> 입력하신 이메일로 새암호를 보내드립니다<br>
                <br>
            <div>
                <input type="text" name="uEmail" placeholder="이메일주소">
                <p>'@'포함한 이메일주소를 정확히 입력해주세요.</p>
            </div>
 
            <div>
                <button type="submit">비밀번호찾기</button>
            </div>
        </form>
    </div>
</body>
</html>