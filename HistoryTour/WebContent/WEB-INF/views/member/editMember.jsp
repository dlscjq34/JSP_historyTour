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
        <aside>
            <p><a href="ticket.do">예약 내역</a></p>         
            <p><a href="editMember.do">회원 정보 수정</a></p>
        </aside>
        
        <article>            
            <h1>나의 정보 수정</h1>            
                <form action="">
                    <fieldset>
                        <legend>수정할 데이터 입력</legend>
                        <label>아이디 : &nbsp;&nbsp;<input type="text" name="id" id="id" value=""/> </label><br>
                        <label>암호 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="pw" id="pw" value=""/></label><br>
                        <label>이름 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" id="name" value=""/></label><br>
                        <label>생년월일 : <input type="text" name="birth" id="birth" value=""/></label><br>
                               성별 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="radio" name="sex" id="sex" value="male"/>남</label>&nbsp;
                                                                    <label><input type="radio" name="sex" id="sex" value="female"/>여</label><br>                        
                        <label>전화번호 : <input type="text" name="tel" id="tel" value=""></label><br>
                        <label>주소 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="addr" id="addr" value=""></label><br>
                        <label>이메일 : &nbsp;&nbsp;<input type="email" name="email" id="email" value=""></label>
                    </fieldset>
                    <input type="button" name="edit" class="edit" value="수정 등록">
                </form>
        </article>
    </div>
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

    
</body>
</html>