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
        font-size : 16px;
    }

    .input {
        box-sizing : border-box;
        border-radius : 5px;
        margin : 10px 0px 50px 0px;
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

	<form id="searchPwdForm" action="<%= contextPath %>/emailConfirmForm.me" method="get">

        <br><br><br><br>
        
        <h1 class="h1">비밀번호 찾기</h1>

        <br><br><br>

        <div class="div1">

            <table>
                <tr>
                    <br><br>
                    <td style="text-align : left; font-size : 14px; font-weight : 550;">비밀번호를 찾고자 하는 아이디</td>
                </tr>
                <tr>
                    <td><input type="text" name="userId" class="input" maxlength="12" required></td>
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