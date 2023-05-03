<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닭나와</title>
<link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
<style>
    .h1, .h4 { text-align : center; }

    .h1 { font-size : 50px; }

    .h4 { font-size : 20px; }

    .input, .button {
        width : 400px;
        height : 45px;
        border-style : solid;
        border-width : 2px;
        border-radius : 5px;
        font-size : 16px;
    }

    .input {
        box-sizing : border-box;
        border-radius : 5px;
        margin : 50px 0px 50px 0px;
        font-size : 20px;
    }

    .button {
        background-color : black;
        border-radius : 5px;
        color : white;
        margin : 5px 0px 5px 0px;
    }

    .button:hover {
        background-color : gray;
        cursor : pointer;
    }

    .div1 {
        width : 400px;
        text-align: right;
        margin : auto;
    }
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<form id="emailConfirm" action="<%= contextPath %>/emailConfirm.me" method="get">

        <br><br><br><br>
        
        <h1 class="h1">이메일 인증</h1>

        <h4 class="h4">가입하신 이메일로 인증번호를 보냈습니다. <br>
           				 확인 후 해당 번호를 아래 빈칸에 입력하신 다음 <br>
           				 버튼을 눌러주세요.</h4>

        <div class="div1">

            <table>
                <tr>
                    <td><input type="text" name="code" class="input" maxlength="6" placeholder="인증번호 입력 (6자리)" required></td>
                </tr>
                <tr>
                    <td><button type="submit" class="button">다음</button></td>
                </tr>
            </table>

        </div>

    </form>
    
    <%@ include file="../common/footer.jsp"%>

</body>
</html>