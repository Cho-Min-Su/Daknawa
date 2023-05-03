<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닭나와</title>
<link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
<style>
    .h1 {
        text-align : center;
        font-size : 50px;
    }

    .input, .button {
        width : 400px;
        height : 45px;
        border-style : solid;
        border-width : 2px;
        border-radius : 5px;
        font-size : 14px;
    }

    .input {
        box-sizing : border-box;
        border-radius : 5px;
        margin-bottom : 15px;
    }

    .button {
        background-color : black;
        border-radius : 5px;
        color : white;
        margin : 30px 0px 5px 0px;
    }

    .button:hover {
        background-color : gray;
        cursor : pointer;
    }

    .div1 {
        width : 400px;
        margin : auto;
    }

    .div1 td {
        text-align: left;
        font-size : 14px;
    }
    
</style>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>
	
	<form id="updatePwd" action="<%= contextPath %>/updatePwd.me" method="post">

        <br><br><br><br>
        
        <h1 class="h1">비밀번호 변경</h1>

        <br>

        <div class="div1">

        <table>
            <tr>
                <td style="text-align: left;">새 비밀번호</td>
            </tr>
            <tr>
                <td><input type="password" name="newPwd" class="input" minlength="8" maxlength="15" placeholder="8 ~ 15 글자 이내 작성 (영문 + 숫자 + 특수문자[ ex) !@- ]로)" required></td>
            </tr>
            <tr>
                <td style="text-align: left;">비밀번호 확인</td>
            </tr>
            <tr>
                <td><input type="password" id="checkPwd" class="input" maxlength="15" placeholder="위의 설정한 비밀번호와 일치하게 작성" required></td>
            </tr>
            <tr>
                <td><button type="submit" class="button" onclick="return validate();">완료</button></td>
            </tr>
        </table>
        </div>

    </form>
    
    <script>
    
	    function validate() {
			
			let newPwd = document.getElementsByName("newPwd")[0].value;
			let checkPwd = document.getElementById("checkPwd").value;
	
			let regExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@-])[A-Za-z\d!@-]{8,15}$/;
			
			
			
			
			if(!regExp.test(newPwd)) { // 비밀번호 패턴에 맞지 않는 경우
				
	            alert("양식에 맞는 비밀번호가 아닙니다. 다시 입력해 주세요!");
	
	            // 사용자에게 비밀번호 다시 입력을 유도   
	            document.getElementsByName("newPwd")[0].select();
	
	            return false;
	        } else { // 비밀번호 패턴에 맞는 경우
	        	
	        	// 비밀번호 확인 일치 검사
	        	if(newPwd != checkPwd) {
	                alert("두 비밀번호가 일치하지 않습니다. 다시 입력해 주세요!");
	                
	                document.getElementsByName("newPwd")[0].select();
	                
	                return false;
	            } else {
	            	
		            	if( "<%= loginUser.getUserPwd() %>" == checkPwd) {
		            		
		            		alert("현재 사용중인 비밀번호로는 변경하실 수 없습니다.");
		            		
		            		document.getElementsByName("newPwd")[0].select();
		            		
		            		return false;
		            	}
	            	
	            	
	            }
	        }
			
			return true;
	    }
    </script>
    
    <%@ include file="../common/footer.jsp"%>

</body>
</html>