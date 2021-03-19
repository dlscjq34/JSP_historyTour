<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/include/head.jsp" />
    <link rel="stylesheet" href="css/detail.css">
</head>
<body>
    <!-- <header> -->
    <jsp:include page="/WEB-INF/views/include/header.jsp" />


    <!-- center = <aside> + <article> -->
    <div class="center">
       <jsp:include page="/WEB-INF/views/include/aside.jsp" />
        
        <article>
            <h1>탐방 일정 상세</h1>            
            <div class="detail">
                <ol>
                    <li>테마 : 임진왜란</li>
                    <li>사건 : 제1차 진주성 전투</li>
                    <li>장소 : 진주</li>
                    <li>시간 : 2020.12.31</li>
                    <li>교통 : 관광버스 대절</li>
                    <li>참가비 : 30,000원</li>
                </ol>
                <div class="pic">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQf_tRulBKA5nZcr-EhdvQzDbl3WagluiXg1w&usqp=CAU" alt="jinju">
                </div>
            </div>
            <form action="">
                <input type="submit" value="예약하기">
            </form>
        </article>
    </div>
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

    
</body>
</html>