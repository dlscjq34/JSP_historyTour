<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/include/head.jsp" />
    <link rel="stylesheet" href="css/ticket.css">
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
            <h1>나의 예약 내역</h1>            
            <div class="detail">
                <ol>
                    <li>테마 : 임진왜란</li>
                    <li>사건 : 제1차 진주성 전투</li>
                    <li>장소 : 진주</li>
                    <li>시간 : 2020.12.31</li>
                    <li>교통 : 관광버스 대절</li>
                </ol>
            </div>
            <form action="">
                <input type="button" value="예약 취소">
            </form>               
        </article>
    </div>
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

    
</body>
</html>