<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/include/head.jsp" />
    <link rel="stylesheet" href="css/joinMember.css">
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
         <h1>회원 가입</h1>            
                    <h3>고객님의 개인 정보는 엄격하게 관리됩니다.</h3>    
                <form action="joinMemberPro.do" method="post" name="frm" onsubmit="return lenCheck()">
                	
                    <table>
	               		<tr>
	               			<th>아이디 : 
	               			<td><input type="text" name="id" id="id" /></td>
	               			<td><input type="button" onclick="dupCheck()" value="중복체크"><td>
	               		</tr>
	               		<tr>
	               			<th>암호 : 
	               			<td><input type="password" name="pswd1" id="pswd1" required/>
	               		</tr>
	               		<tr>
	               			<th>암호 확인 : 
	               			<td><input type="password" name="pswd2" id="pswd2" required onkeyup="pwCheck()"/>
	               			<td><span id="pwStatus"></span></td>
	               		</tr>
	               		<tr>
	               			<th>이름 : 
	               			<td><input type="text" name="name" id="name" required/>
	               		</tr>
	               		<tr>
	               			<th>생년월일 : 
	               			<td><input type="text" name="birth" id="birth" required/>
	               		</tr>
	               		<tr>
	               			<th>성별 : 
	               			<td><input type="radio" name="gender" id="man" value="1" required />남 &nbsp;
	               				<input type="radio" name="gender" id="woman" value="2" required />여
	               		</tr>
	               		<tr>
	               			<th>전화번호 : 
	               			<td><input type="text" name="tel" id="tel" required>
	               		</tr>
	               		<tr>
	               			<th>주소 : 
	               			<td><input type="text" name="address" id="address" required>
	               		</tr>
	               		<tr>
	               			<td colspan="2" align="center"><input type="submit" name="enroll" class="enroll" value="가입"></td> 
	               		</tr>
	               		<tr>
	               			<td colspan="2" align="center"><input type="reset" value="취소"></td> 
	               		</tr>
               		</table>
                
                
                </form>
        </article>
    </div>
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

</body>

<script>
	function dupCheck() {
		let id = document.frm.id.value;
		if(id == '') {
			alert("아이디를 입력하세요");
			document.frm.id.focus();
			return;
		}
		window.open('joinCheck.do?id='+id, 'joinCheck', 'width=600, height=300');
	}
	
	function lenCheck() {
		let id = document.frm.id.value.trim();
		
		if(!(id.length >= 3 && id.length <=12)) {
			alert("아이디는 3에서 12글자만 입력 가능합니다.");
			document.frm.id.select();
			return false;
		}
	}
	
	function pwCheck() {
		pw1 = document.frm.pswd1.value;
		pw2 = document.frm.pswd2.value;
		pwStatus = document.getElementById("pwStatus");
		
		if(pw1 == pw2) {
			pwStatus.innerHTML = "패스워드 확인";
			pwStatus.style.color = "blue"
		}
		else {
			pwStatus.innerHTML = "패스워드 틀림";
			pwStatus.style.color = "red"
		}
	}
	
/* 	<tr>
		<th>암호 : 
		<td><input type="password" name="pswd1" id="pswd1" required/>
	</tr>
	<tr>
		<th>암호 확인 : 
		<td><input type="password" name="pswd2" id="pswd2" required onkeyup="pwCheck()"/>
			<span class="pwStatus"></span>
	</tr> */
</script>

</html>