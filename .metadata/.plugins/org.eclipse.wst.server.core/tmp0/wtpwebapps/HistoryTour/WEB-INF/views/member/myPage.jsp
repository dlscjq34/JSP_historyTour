<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/include/head.jsp" />
    <link rel="stylesheet" href="css/myPage.css">
</head>
<body>
    <!-- <header> -->
    <jsp:include page="/WEB-INF/views/include/header.jsp" />


    <!-- center = <aside> + <article> -->
    <div class="center">
        <aside>
            <p><a href="ticket.do">예약 내역</a></p>         
            <p><a href="editMember.do">회원 정보 수정</a></p>
        </aside>
        
        <article>
            <h1>마이 페이지</h1>            
           
        </article>
    </div>
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

    
</body>
</html>