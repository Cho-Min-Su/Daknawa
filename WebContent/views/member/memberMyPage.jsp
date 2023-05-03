<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닭나와</title>
<link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
<style>
        /* MY PAGE 타이틀 부분 */
        #container .title {
        padding-top: 80px;
        height: 200px;
        position: relative;
        min-width: 1000px;
      }
      #container .sub_title {
        font-size: 44px;
        line-height: 54px;
        color: #000;
        margin-bottom: 0px;
        text-align: center;
        text-transform: uppercase;
      }
      h2 {
        margin:0;
        font-weight: normal;
        display: block;
      }
      #mini_title {
        width: 100%;
        text-align: center;
        margin-bottom: 44px;
        position: absolute;
        top: 134px;
        left: 0;
      }
      ol {
        list-style: none;
        margin: 0;
        padding: 0;
        display: block;
      }
      li {
        display: inline-block;
        margin: 0;
        padding: 0;
        list-style: none;

        text-transform: uppercase;
      }
      a {
        text-decoration: none;
        color: #000;
      }

      /* 메뉴바 부분 */
      #mnb {
        width: 100%;
        min-width: 1000px;
        border-bottom: 1px solid #888686;
        background-color: #fff;
        margin-bottom: 60px;
      }

      #mnb .mnb_header {
        width: 100%;
        min-width: 1000px;
        background-color: #fff;
        border-top: 1px solid #9d9d9d;
      }

      #mnb .mnb_header>ul {
        width: 1000px;
        margin: 0 auto;
        padding: 0;
        display: block;
        list-style-type: disc;
      }
      #mnb_sub ul {
        width: 250px;
        margin: 0 auto;
        padding: 0;
        display: block;
        list-style-type: disc;
      }
      .menubar { height : 38px; }

      #mnb.menubar .mnb_header ul li {
        /* width: 25%; ------------------------- */ 
      }
      #mnb .mnb_header ul li {
        text-align: center;
        /* float: left; */
        position: relative;
      }
      b .mnb_header ul li a {
        font-size: 14px;
        vertical-align: middle;
      }

    /* 서브 메뉴바 부분 */
    #mnb_sub {
            list-style-type : none;
            /*
                p 태그와 마찬가지로 ul 태그 또한 위, 아래로 기본 margin 이 잡혀있음
                또한 ul 태그는 padding 이 왼쪽에 기본적으로 존재함
                => margin : 0px; 과 padding : 0px; 으로 margin 과 padding 을 없애기
            */
            /*
            margin : 0px;
            padding : 0px; /* padding 값 조정으로 메뉴 가운데 배치 가능 */
           /* height : 100%; */

            width: 25%;
            height : 36px;
            margin: 0 auto;
            padding: 0;
            display: block;
        }

        /* 메인 메뉴를 나타내는 li 태그들 */
        #mnb_sub>li {
            float : left;
            height : 100%;
            background-color: #fff;
            display: block;
        }

        /* 메뉴 문구를 나타내는 a 태그들 */
        #mnb a {
            
            color : black;
            text-decoration : none;
            font-size : 14px;
            /*
                a 태그는 인라인요소이기 때문에
                width, height 속성이 적용되지 않음
                => display : block; 으로 블럭요소화 시켜줄것임
            */
            width : 250px;
            height : 100%;
            display : block;
            text-align : center;
            /* vertical-align : middle; vertical-align 은 블럭요소에서 적용되지 않음 */
            line-height : 36px;
            /*
                line-height 속성은 블럭요소에 대한 장평조절 속성
                보통은 블럭요소의 세로길이만큼 주면 알아서 가운데로 옴
            */
        }

        /* 메뉴에 마우스가 올라갔을 때 추가적인 속성 */
        #mnb_sub a:hover {
            color: #888686;
            font-size: 15px;
        }

        /* 서브메뉴에 해당되는 ul 에 대한 스타일 */
        #mnb_sub>li>ul {
            list-style-type : none;
            padding : 0px;
            display : none !important; /* 평소에는 안보여지게끔 숨김 처리 */
        }

        /* 메인 메뉴에 마우스가 올라가는 순간 서브메뉴가 보여지게끔 스타일 부여 */
        #mnb_sub>li:hover>ul {
            display : block !important;
        }
        /* 혹시 몰라서 서브메뉴 자체에도 효과 부여 */
        #mnb_sub>li>ul:hover {
            display : block !important;
        }

        .active1, .active2, .active3, .active4 {
        background-color: #000;
      }
      .active1 a {
        background-color: #000;
        color: #ffffff;
      }

    /* 내정보 부분 */
    #infoUpdate-form { margin : auto; }
    
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
        border-radius : 5px;
        background-color : black;
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
    
    .button3:hover {
            background-color : orangered;
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
    
    .modal-body table { margin-top : 20px; }

    #genderM, #genderF { cursor : pointer; }
    
    </style>


</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

	<%@ include file="../common/myPageNavbar.jsp" %>
	
	<%
		String userId = loginUser.getUserId();
		String userNickName = loginUser.getUserNickName();
		String userName = loginUser.getUserName();
		String email = loginUser.getEmail();
		String phone = loginUser.getPhone();
		String birth = (loginUser.getBirth() == null) ? "" : loginUser.getBirth();
		String gender = (loginUser.getGender() == null) ? "" : loginUser.getGender();
		String address1 = (loginUser.getAddress1() == null) ? "" : loginUser.getAddress1();
		String address2 = (loginUser.getAddress2() == null) ? "" : loginUser.getAddress2();
	%>
	
	 <section id="container">
	 	
    	<div>
		    <% if(loginUser != null) { %>
		    
				<form id="infoUpdate-form" action="update.me" method="post">
			        
			        <h1 class="h1">내 정보</h1>
			
			        <br>
			
			        <div class="div1">
			
			        <table>
			            <tr>
			                <td colspan="2">아이디 *</td>
			            </tr>
			            <tr>
			                <td colspan="2"><input type="text" value="<%= userId %>" name="userId" class="input" minlength="5" maxlength="12" placeholder="5 ~ 12 글자 이내 작성 (영문, 숫자로)" required readonly></td>
			            </tr>
			            <tr>
			                <td colspan="2">비밀번호 *</td>
			            </tr>
			            <tr>
			                <td colspan="2"><button type="button" class="button2" style="margin : 0px 0px 5px 0px;" data-toggle="modal" data-target="#updatePwdForm">변경하러가기</button></td>
			            </tr>
			            <tr>
			                <td colspan="2">닉네임 설정 *</td>
			            </tr>
			            <tr>
			                <td><input type="text" value="<%= userNickName %>" name="userNickname" class="input" minlength="2" maxlength="10" placeholder="2 ~ 10 글자 이내 작성 (영문, 숫자, 한글)" required></td>
			            	<td><button type="button" class="button1" onclick="nickNameCheck();">중복확인</button></td>
			            </tr>
			            <tr>
			                <td colspan="2">이름 *</td>
			            </tr>
			            <tr>
			                <td colspan="2"><input type="text" value="<%= userName %>" name="userName" class="input" minlength="2" maxlength="10" required></td>
			            </tr>
			            <tr>
			                <td colspan="2">이메일 *</td>
			            </tr>
			            <tr>
			                <td colspan="2"><input type="email" value="<%= email %>" name="email" class="input" required></td>
			            </tr>
			            <tr>
			                <td colspan="2">전화번호 *</td>
			            </tr>
			            <tr>
			                <td colspan="2"><input type="text" value="<%= phone %>" name="phone" class="input" placeholder="(-)를 제외한 숫자만 입력" required></td>
			            </tr>
			            <tr>
			                <td colspan="2">생년월일</td>
			            </tr>
			            <tr>
			                <td colspan="2"><input type="date" value="<%= birth %>" name="birth" class="input" maxlength="10"></td>
			            </tr>
			            <tr>
			                <td colspan="2">성별</td>
			            </tr>
			            <tr>
			            	<% if(gender.equals("남")) { %>
			                	<td colspan="2">
			                    	<input type="radio" name="gender" id="genderM" value="남" checked style="width : 15px; height : 15px;"><label for="genderM" style="font-size : 15px; margin-right : 15px;">&nbsp;남</label>
			                    	<input type="radio" name="gender" id="genderF" value="여" style="width : 15px; height : 15px;"><label for="genderF" style="font-size : 15px;">&nbsp;여</label>
			                	</td>
			                <% } else if(gender.equals("여")) { %>
			                	<td colspan="2">
			                    	<input type="radio" name="gender" id="genderM" value="남" style="width : 15px; height : 15px;"><label for="genderM" style="font-size : 15px; margin-right : 15px;">&nbsp;남</label>
			                    	<input type="radio" name="gender" id="genderF" value="여" checked style="width : 15px; height : 15px;"><label for="genderF" style="font-size : 15px;">&nbsp;여</label>
			                	</td>
			                <% } else { %>
			                	<td colspan="2">
			                    	<input type="radio" name="gender" id="genderM" value="남" style="width : 15px; height : 15px;"><label for="genderM" style="font-size : 15px; margin-right : 15px;">&nbsp;남</label>
			                    	<input type="radio" name="gender" id="genderF" value="여" style="width : 15px; height : 15px;"><label for="genderF" style="font-size : 15px;">&nbsp;여</label>
			                	</td>
			                <% } %>
			            </tr>
			            <tr>
			                <td colspan="2">주소</td>
			            </tr>
			            <tr>
			                <td><input type="text" value="<%= address1 %>" name="address1" id="roadAddress" class="input" placeholder="도로명주소"></td>
			                <td><input type="button" class="button1" onclick="addressAPI();" value="내 주소 찾기"></td>
			            </tr>
			            <tr>
			            	<td colspan="2">
			            		<span id="guide" style="color:#999;display:none"></span>
								<input type="text" value="<%= address2 %>" name="address2" id="detailAddress" class="input" placeholder="상세주소">
							</td>
			            </tr>
			            <tr>
			                <td colspan="2"><button type="submit" class="button2" onclick="return validate();" disabled>수정하기</button></td>
			            </tr>
			        </table>
			        </div>
		        
		    	</form>
				
		    </div>
		    <% } %>
    	
  </section>
  
  <!-- 비밀번호 변경용 모달창 (부트스트랩) -->
	<!-- The Modal -->
    <div class="modal" id="updatePwdForm">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">비밀번호 변경</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
        
                <!-- Modal body -->
                <div class="modal-body" align="center">
                
                    <form id="updatePwd" action="<%= contextPath %>/updatePwd.me" method="post">


				        <div class="div1">
							
					        <table>
					            <tr>
					                <td style="text-align: left;">새 비밀번호</td>
					            </tr>
					            <tr>
					                <td><input type="password" name="newPwd" class="input" style="margin-bottom : 15px;" minlength="8" maxlength="15" placeholder="8 ~ 15 글자 이내 작성 (영문 + 숫자 + 특수문자[ ex) !@- ]로)" required></td>
					            </tr>
					            <tr>
					                <td style="text-align: left;">비밀번호 확인</td>
					            </tr>
					            <tr>
					                <td><input type="password" id="checkPwd" class="input" style="margin-bottom : 15px;" maxlength="15" placeholder="위의 설정한 비밀번호와 일치하게 작성" required></td>
					            </tr>
					            <tr>
					                <td><button type="submit" class="btn btn-secondary btn-block" style="margin-top : 16px;" onclick="return validatePwd();">완료</button></td>
					            </tr>
					        </table>
				        </div>

    				</form>
                    
                </div>
            </div>
        </div>
    </div>
  
  <script>
    function nickNameCheck() {
		
		let $userNickname = $("#infoUpdate-form input[name=userNickname]");
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
						
						if("<%= userNickName %>" == $userNickname.val()) {
							
							let answer = confirm("현재 회원님의 닉네임입니다. 그대로 사용하시겠습니까?");
							
							if(answer) { // 닉네임 사용
								
								$("#infoUpdate-form button[type=submit]").removeAttr("disabled"); // 회원정보 수정버튼 활성화
								
								$userNickname.attr("readonly", true); // 닉네임값을 수정 못하게 확정시키기
								
							} else { // 닉네임 사용 X
								
								$userNickname.focus();

							}
							
						} else {
					
							alert("이미 존재하거나 탈퇴한 회원의 닉네임입니다.");
							$userNickname.focus();

						}
					
					} else { // 사용 가능 ("USNNY")
						
						let answer = confirm("사용 가능한 닉네임입니다. 사용하시겠습니까?");
						
						if(answer) { // 닉네임 사용
							
							$("#infoUpdate-form button[type=submit]").removeAttr("disabled"); // 회원정보 수정버튼 활성화
							
							$userNickname.attr("readonly", true); // 닉네임값을 수정 못하게 확정시키기
							
						} else { // 닉네임 사용 X
							
							$("#infoUpdate-form button[type=submit]").attr("disabled", true);
							
							$userNickname.attr("readonly", false);
							
							$userNickname.focus();

						}
					}	 		
    			}
    		});
		}
	}
    
 	// 비밀번호 일치 여부를 검사 (유효성 검사)
	function validatePwd() {
			
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
	            	
	            	if("<%= loginUser.getUserPwd() %>" == checkPwd) {
	            		
	            		alert("현재 사용중인 비밀번호로는 변경하실 수 없습니다.");
	            		
	            		document.getElementsByName("newPwd")[0].select();
	            		
	            		return false;
	            	}	
	            }
	        }
 	}
 	
    function validate() {
		
		let userName = document.getElementsByName("userName")[0].value;
		let phone = document.getElementsByName("phone")[0].value;

		let regExp = /^[가-힣]{2,10}$/;
		
		if(!regExp.test(userName)) { // 이름 패턴에 맞지 않는 경우
            
            alert("양식에 맞는 이름이 아닙니다. 다시 입력해 주세요!");

            // 사용자에게 이름 다시 입력을 유도   
            document.getElementsByName("userName")[0].select();

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