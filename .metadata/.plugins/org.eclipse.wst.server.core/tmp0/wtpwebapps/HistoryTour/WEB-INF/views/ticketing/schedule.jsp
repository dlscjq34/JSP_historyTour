<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/include/head.jsp" />
    <link rel="stylesheet" href="css/schedule.css">
</head>
<body>
    <!-- <header> -->
    <jsp:include page="/WEB-INF/views/include/header.jsp" />


    <!-- <aside> <article> -->
    <div class="center">
       <jsp:include page="/WEB-INF/views/include/aside.jsp" />
    
        <article>
            <h1>역사 탐방 일정(예약)</h1>            
            <div class="board">
                <table border="1">
                    <thead>
                        <tr>
                            <th>순번</th>
                            <th>장소</th>
                            <th>탐방일</th>
                            <th>작성일</th>
                            <th>비고</th>
                        </tr>
                    </thead>
                    <tbody>                        
                        <tr onClick="location.href='detail.do'">
                            <td>글번호1</td>
                            <td>제목1</td>
                            <td>작성자1</td>
                            <td>작성일1</td>
                            <td>조회수1</td>
                        </tr>                        
                    </tbody>
                </table>
            </div>
        </article>
    </div>
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

    
</body>
</html>