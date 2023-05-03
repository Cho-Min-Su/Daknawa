<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키 불러오기
	// Cookie 객체 1개가 의미하는 것 : 키 + 밸류 세트 1개
	
	// [ 표현법 ]
	// request.getCookies() : Cookie[]
	
	Cookie[] cookies = request.getCookies(); //쿠키의 키값을 모두 가져오기
	
	// 내가 원하는 쿠키를 골라내는 작업 (반복문 돌리기)
	String saveId = "";
	
	if(cookies != null) {
		
		for(int i = 0; i < cookies.length; i++) {
			
			// saveId 키값을 가진 쿠키만 골라내기
			if(cookies[i].getName().equals("saveId")) {
				saveId = cookies[i].getValue();
				break;
			}
		}
		// 이 시점 기준에서 "saveId" 라는 키값을 가진 쿠키가 있었다면 saveId 라는 String 타입의 변수에는 저장하고자 하는 아이디가 담겨있을 것임!!
	}
%>
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
    }

    .input {
        box-sizing : border-box;
        border-radius : 5px;
        margin-bottom : 5px;
    }

    .button {
        background-color : black;
        border-radius : 5px;
        color : white;
        margin : 20px 0px 5px 0px;
    }

    .button:hover {
        background-color : gray;
        cursor : pointer;
    }

    .pass>a, .sign>a {
        text-decoration : none;
        color : black;
    }

    .div1 {
        width : 400px;
        margin : auto;
    }

    .div2 {
    	font-size : 16px;
    	margin-top : 10px;
    }
    
    .pass {
        text-align : center;
        width : 100%;
        margin-left : 75px;
    }

    .sign {
        text-align : right;
        width : 30%;
    }

    #saveId { width : 14px; height : 14px; margin-top : 10px; }

    label { font-size : 14px; }

</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	<script>
			
			$(function() {
				
				let saveId = "<%= saveId %>";
				
				if(saveId != "") { // 쿠키가 있는 경우, 아이디가 저장된 경우
					$("#login-form input[name=userId]").val(saveId);
					$("#saveId").attr("checked", true);
				}
			});
	</script>
	
	<form id="login-form" action="login.me" method="post">

        <br><br><br><br><br><br><br><br><br><br><br><br>
        
        <h1 class="h1">로그인</h1>

        <br>

        <div class="div1">

        <table>
            <tr>
                <td style="text-align: left;">아이디 *</td>
            </tr>
            <tr>
                <td><input type="text" name="userId" class="input" maxlength="12" required></td>
            </tr>
            <tr>
                <td style="text-align: left;">비밀번호 *</td>
            </tr>
            <tr>
                <td><input type="password" name="userPwd" class="input" maxlength="15" required></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" id="saveId" name="saveId" value="Y">
                    <label for="saveId">아이디 저장</label>
                </td>
            </tr>
            <tr>
                <td><button type="submit" class="button">로그인하기</button></td>
            </tr>
        </table>
        <div class="div2" style="display : flex;">
            <div class="pass">
                <a href="<%= contextPath %>/searchPwd.me">비밀번호 찾기</a>
            </div>
            <div class="sign">
                <a href="<%= contextPath %>/enrollForm.me" class="member-enroll">회원 가입</a>
            </div>
        </div>
        </div>

    </form>
	
	<%@ include file="../common/footer.jsp"%>

</body>
</html>