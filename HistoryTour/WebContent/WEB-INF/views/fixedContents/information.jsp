<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/include/head.jsp" />
    <link rel="stylesheet" href="css/information.css">
</head>
<body>
    <!-- <header> -->
    <jsp:include page="/WEB-INF/views/include/header.jsp" />

    <!-- <aside> <article> -->
    <div class="center">
       <jsp:include page="/WEB-INF/views/include/aside.jsp" />
    
        <article>
            <h1>역사 정보</h1>        
            <div class="info">
                <div class="intro">                
                    <ul>
                        <li>고조선 :  기원전 2333년 건국</li>
                        <li>삼국시대 : 기원전 1세기</li>
                        <li>고려시대 : 918년 건국</li>
                        <li>조선시대 : 1392년 건국</li>
                        <li>대한제국 : 1897년 건국</li>
                        <li>대한민국 : 1948년 건국</li>
                    </ul>                            
                </div>                
                <div class="pic">                
                    <img src="images/고구려.jpg" alt="intro">                    
                </div>
            </div>

            
        </article>
    </div>
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

    
</body>
</html>