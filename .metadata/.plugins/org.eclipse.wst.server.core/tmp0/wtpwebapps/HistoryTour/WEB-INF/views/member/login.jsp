<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/include/head.jsp" />
    <link rel="stylesheet" href="css/common.css">
</head>
<body>
    <!-- <header> -->
    <jsp:include page="/WEB-INF/views/include/header.jsp" />


    <!-- center = <aside> + <article> -->
    <div class="center">
        <jsp:include page="/WEB-INF/views/include/aside.jsp" />
        
        <article>
            <h1>로그인</h1>            
            <form action="loginPro.do" method="post">
                아이디 : &nbsp;&nbsp;<input type="text" name="id" id="id"><br>
                패스워드 : <input type="password" name="pswd" id="pwswd"><br>
                <input type="submit" value="로그인"><br>
                <input type="checkbox" name="keepLogin">로그인 유지
            </form>  
            <br><hr><br>       
            아직 회원이 아니신가요? <input type="button" onclick="location.href='joinMember.do'" value="회원가입">
        </article>
    </div>
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

    
</body>
</html>