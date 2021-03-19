<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/include/head.jsp" />  
    <link rel="stylesheet" href="css/index.css">
    
</head>
<body>
    <!-- <header> -->
    <jsp:include page="/WEB-INF/views/include/header.jsp" />

    <!-- <aside> <article> -->
    <div class="center">
        <jsp:include page="/WEB-INF/views/include/aside.jsp" />
    
        <article>
            <h1> 사이트에 오신 것을 환영합니다.</h1>            
            <div class="menu">
                <div class="schedule">
                    <div>일정 임박</div>
                    <div>내용</div>
                </div>
                <div class="recent">
                    <div>최신글</div>
                    <div>내용</div>
                </div>
                <div class="news">
                    <div>뉴스</div>
                    <div>내용</div>
                </div>            
            </div>
        </article>
    </div>
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

    
</body>
</html>