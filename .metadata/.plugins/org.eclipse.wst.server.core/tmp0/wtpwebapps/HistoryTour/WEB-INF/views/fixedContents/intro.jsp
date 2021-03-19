<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/include/head.jsp" />
    <link rel="stylesheet" href="css/intro.css">
</head>
<body>
    <!-- <header> -->
    <jsp:include page="/WEB-INF/views/include/header.jsp" />

    <!-- <aside> <article> -->
    <div class="center">
	    <jsp:include page="/WEB-INF/views/include/aside.jsp" />
      
    
        <article>
            <h1>한국역사탐방 사이트를 소개합니다.</h1>        
            <div>
                <div class="intro">                
                        <img src="images/경복궁.png" alt="intro">
                </div>
                <p>역사적 소양을 쌓고 견문을 넓히는 곳입니다.</p>
            </div>

            
        </article>
    </div>
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

    
</body>
</html>