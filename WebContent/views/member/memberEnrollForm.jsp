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

    .input, .button2 {
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
        margin-bottom : 5px;
    }

    .button1 {
        width : 100px;
        height : 44px;
        box-sizing : border-box;
        background-color : black;
        border-radius : 5px;
        color : white;
        margin : 0px 0px 6px 10px;
    }

    .button2 {
        background-color : black;
        border-radius : 5px;
        color : white;
        margin : 20px 0px 5px 0px;
    }

    .button1:hover, .button2:hover {
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

    #genderM, #genderF { cursor : pointer; }
    
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

	<form id="memberInsert-form" action="<%= contextPath %>/insert.me" method="post">

        <br><br><br><br>
        
        <h1 class="h1">회원가입</h1>

        <br>

        <div class="div1">

        <table>
            <tr>
                <td colspan="2">아이디 *</td>
            </tr>
            <tr>
                <td><input type="text" name="userId" class="input" minlength="5" maxlength="12" placeholder="5 ~ 12 글자 이내 작성 (영문, 숫자로)" required></td>
                <td><button type="button" class="button1" onclick="idCheck();">중복확인</button></td>
            </tr>
            <tr>
                <td colspan="2">비밀번호 *</td>
            </tr>
            <tr>
                <td colspan="2"><input type="password" name="userPwd" class="input" minlength="8" maxlength="15" placeholder="8 ~ 15 글자 이내 작성 (영문 + 숫자 + 특수문자[ ex) !@- ]로)" required></td>
            </tr>
            <tr>
                <td colspan="2">비밀번호 확인 *</td>
            </tr>
            <tr>
                <td colspan="2"><input type="password" id="userPwd2" class="input" minlength="8" maxlength="15" placeholder="위의 설정한 비밀번호와 일치하게 작성" required></td>
            </tr>
            <tr>
                <td colspan="2">닉네임 설정 *</td>
            </tr>
            <tr>
                <td><input type="text" name="userNickname" class="input" minlength="2" maxlength="10" placeholder="2 ~ 10 글자 이내 작성 (영문, 숫자, 한글)" required></td>
            	<td><button type="button" class="button1" onclick="nicknameCheck();">중복확인</button></td>
            </tr>
            <tr>
                <td colspan="2">이름 *</td>
            </tr>
            <tr>
                <td colspan="2"><input type="text" name="userName" class="input" minlength="2" maxlength="10" required></td>
            </tr>
            <tr>
                <td colspan="2">이메일 *</td>
            </tr>
            <tr>
                <td colspan="2"><input type="email" name="email" class="input" required></td>
            </tr>
            <tr>
                <td colspan="2">전화번호 *</td>
            </tr>
            <tr>
                <td colspan="2"><input type="text" name="phone" class="input" placeholder="(-)를 제외한 숫자만 입력" required></td>
            </tr>
            <tr>
                <td colspan="2">생년월일</td>
            </tr>
            <tr>
                <td colspan="2"><input type="date" name="birth" class="input" maxlength="10"></td>
            </tr>
            <tr>
                <td colspan="2">성별</td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="radio" name="gender" id="genderM" value="남" style="width : 15px; height : 15px;"><label for="genderM" style="font-size : 15px; margin-right : 15px;">&nbsp;남</label>
                    <input type="radio" name="gender" id="genderF" value="여" style="width : 15px; height : 15px;"><label for="genderF" style="font-size : 15px;">&nbsp;여</label>
                </td>
            </tr>
            <tr>
                <td colspan="2">주소</td>
            </tr>
            <tr>
            	<td><input type="text" name="address1" id="roadAddress" class="input" placeholder="도로명주소"></td>
                <td><input type="button" class="button1" onclick="addressAPI();" value="내 주소 찾기"></td>
            </tr>
            <tr>
            	<td colspan="2">
            		<span id="guide" style="color:#999;display:none"></span>
					<input type="text" name="address2" id="detailAddress" class="input" placeholder="상세주소">
				</td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit" class="button2" onclick="return validate();" disabled>가입하기</button></td>
            </tr>
        </table>
        </div>

    </form>
    
    <script>
    
    	// 중복체크 여부를 전역변수로 빼기
    	let checkArr = [false, false];
    
    	function idCheck() {
    		
    		let $userId = $("#memberInsert-form input[name=userId]");
			let regExp = /^[a-zA-Z0-9]{5,12}$/;
    		
			if(!regExp.test($userId.val())) { // 아이디 패턴에 맞지 않는 경우
                
                alert("양식에 맞는 아이디가 아닙니다. 다시 입력해 주세요!");
                $userId.focus();
			
			} else {
				
	    		$.ajax({
	    			url : "idCheck.me",
	    			type : "get",
	    			data : { checkId : $userId.val() },
	    			success : function(result) {
	    				
						if(result == "USIDN") { // 사용 불가
							
							alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
							$userId.focus();
							
							checkArr[0] = false;
							
						} else { // 사용 가능 ("USIDY")
							
							let answer = confirm("사용 가능한 아이디입니다. 사용하시겠습니까?");
							
							if(answer) { // 아이디 사용
								
								$userId.attr("readonly", true); // 아이디값을 수정 못하게 확정시키기
								
								checkArr[0] = true;
								
							} else { // 아이디 사용 X
							
								$userId.attr("readonly", false);
								
								$userId.focus();
							
								checkArr[0] = false;
							}
						}
						
						duplicateCheck();
	    			}
	    		});
			}
    	}
    	
    	function nicknameCheck() {
    		
    		let $userNickname = $("#memberInsert-form input[name=userNickname]");
			let regExp = /^[a-zA-Z0-9가-힣]{2,10}$/;
			
			if(!regExp.test($userNickname.val())) { // 닉네임 패턴에 맞지 않는 경우
                
                alert("양식에 맞는 닉네임이 아닙니다. 다시 입력해 주세요!");
                $userNickname.focus();
                
			} else {
				
	    		$.ajax({
	    			url : "nicknameCheck.me",
	    			type : "get",
	    			data : { checkNickname : $userNickname.val() },
	    			success : function(result) {
	    				
						if(result == "USNNN") { // 사용 불가
							
							alert("이미 존재하거나 탈퇴한 회원의 닉네임입니다.");
							$userNickname.focus();
							
							checkArr[1] = false;
							
						} else { // 사용 가능 ("USNNY")
							
							let answer = confirm("사용 가능한 닉네임입니다. 사용하시겠습니까?");
							
							if(answer) { // 닉네임 사용
								
								$userNickname.attr("readonly", true); // 닉네임값을 수정 못하게 확정시키기
								
								checkArr[1] = true;
								
							} else { // 닉네임 사용 X
								
								$userNickname.attr("readonly", false);
								
								$userNickname.focus();
							
								checkArr[1] = false;
							}
						}	 		
	
						duplicateCheck();
	    			}
	    		});
			}
    	}
    	
    	function duplicateCheck() {
    		
    		if(checkArr[0] && checkArr[1]) {
    			
    			$("#memberInsert-form button[type=submit]").removeAttr("disabled"); // 회원가입버튼 활성화
    		} else {
    			
    			$("#memberInsert-form button[type=submit]").attr("disabled", true);	
    		}
    	}
    	
    	function validate() {
    		
    		let userPwd = document.getElementsByName("userPwd")[0].value;
    		let userPwd2 = document.getElementById("userPwd2").value;
    		let userName = document.getElementsByName("userName")[0].value;
    		let email = document.getElementsByName("email")[0].value;
    		let phone = document.getElementsByName("phone")[0].value;

			let regExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@-])[A-Za-z\d!@-]{8,15}$/;
			
			if(!regExp.test(userPwd)) { // 비밀번호 패턴에 맞지 않는 경우
				
                alert("양식에 맞는 비밀번호가 아닙니다. 다시 입력해 주세요!");

                // 사용자에게 비밀번호 다시 입력을 유도   
                document.getElementsByName("userPwd")[0].select();

                return false;
            } else { // 비밀번호 패턴에 맞는 경우
            	
            	// 비밀번호 확인 일치 검사
            	if(userPwd != userPwd2) {
                    alert("비밀번호가 일치하지 않습니다.");
                    
                    document.getElementsByName("userPwd")[0].select();
                    
                    return false;
                }
            }
			
			regExp = /^[가-힣]{2,10}$/;
			
			if(!regExp.test(userName)) { // 이름 패턴에 맞지 않는 경우
                
                alert("양식에 맞는 이름이 아닙니다. 다시 입력해 주세요!");

                // 사용자에게 이름 다시 입력을 유도   
                document.getElementsByName("userName")[0].select();

                return false;
            }
			
			if(email == "") {
				
				alert("이메일을 입력해주세요!");
				
				// 사용자에게 이메일 입력을 유도   
                document.getElementsByName("email")[0].select();
				
                return false;
			}
			
			regExp = /^[0-9]{11}$/;
			
			if(!regExp.test(phone)) { // 전화번호 패턴에 맞지 않는 경우
                
                alert("양식에 맞는 전화번호가 아닙니다. (-)를 제외한 숫자로만 입력해 주세요!");

                // 사용자에게 전화번호 다시 입력을 유도   
                document.getElementsByName("phone")[0].select();

                return false;
            }
			
    		return true;
    	}
    
    </script>
    
    <!-- 주소 api -->
    
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	    function addressAPI() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var roadAddr = data.roadAddress; // 도로명 주소 변수

	                // 주소 정보를 해당 필드에 넣는다.
	                document.getElementById("roadAddress").value = roadAddr;

	            }
	        }).open();
	    }
	</script>
    
    <script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
    
    <%@ include file="../common/footer.jsp"%>

</body>
</html>