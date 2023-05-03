<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.Member, com.kh.common.model.vo.PageInfo" %>
<%
	// 필요한 데이터들 뽑기
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	
	int temp = 0;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>닭나와</title>
    <link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/css/bootstrap.min.css">
    <!-- font awesome CSS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/css/font-awesome.min.css">
  
    <!-- meanmenu CSS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/css/meanmenu/meanmenu.min.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/css/normalize.css">
	<!-- wave CSS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/css/wave/waves.min.css">
    <link rel="stylesheet" href="resources/admin/css/wave/button.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- Notika icon CSS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/css/notika-custom-icon.css">
    <!-- Data Table JS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/css/jquery.dataTables.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/css/main.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="resources/admin/css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="resources/admin/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<style>
	#data-table-basic>tbody>tr:hover {
		background-color : lightgray;
		cursor : pointer;
	}
	
	<style>
    .h1 {
        text-align : center;
        font-size : 50px;
    }

    .input {
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
<body>

	<%@ include file="../common/menubar.jsp" %>

	<%@ include file="../common/adminPageNavbar.jsp" %>
    
    <div class="data-table-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="data-table-list">
                        <div class="basic-tb-hd">
                            <h2>회원 관리</h2>
                            <p>회원정보 조회, 블랙리스트 추가, 탈퇴처리</p>
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>회원번호</th>
                                        <th>아이디</th>
                                        <th>닉네임</th>
                                        <th>이름</th>
                                        <th>Email</th>
                                        <th>전화번호</th>
                                        <th>블랙리스트</th>
                                        <th>탈퇴처리</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                    <% for(Member m : list) { %>
                                    <tr onclick="get1(this);">
                                        <td><%= m.getUserNo() %></td>
                                        <td><%= m.getUserId() %></td>
                                        <td><%= m.getUserNickName() %></td>
                                        <td><%= m.getUserName() %></td>
                                        <td><%= m.getEmail() %></td>
                                        <td><%= m.getPhone() %></td>
                                        <td onclick="blacklist(<%= m.getUserNo() %>);">추가</td>
                                        <td onclick="deleteMember(<%= m.getUserNo() %>);">탈퇴</td>
                                    </tr>
                                    <% } %>
                                </tbody>
                               
                                <tfoot>
                                    <tr>
                                        <th>회원번호</th>
                                        <th>아이디</th>
                                        <th>닉네임</th>
                                        <th>이름</th>
                                        <th>Email</th>
                                        <th>전화번호</th>
                                        <th>블랙리스트</th>
                                        <th>탈퇴처리</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>   
    <!-- End Footer area-->
    
    <!-- 블랙리스트 추가 -->
    <script>
    
    	var toggle = 0;
    
    	function blacklist(mno) {
    		
    		toggle = 1;
    		
    		let answer = confirm("블랙리스트에 추가하시겠습니까?");
    		
    		if(answer) {
    			
    			$.ajax({
        			url : "blacklist.ad",
        			type : "post",
        			data : { mno : mno },
        			success : function(result) {
        				
        				if(result > 0) {
        					
        					alert("블랙리스트에 정상적으로 등록되었습니다.");
        					
        					location.reload();
        					
        				} else {
        					
        					alert("블랙리스트 등록에 실패하였습니다. 다시 시도해주세요.");				
        				}
        			},
        			error : function() {
        				alert("블랙리스트 등록에 실패하였습니다. 다시 시도해주세요.");
        			}
        		});
    			
    		}
    		
    	}

    	<!-- 탈퇴 처리 -->
    
    	function deleteMember(mno) {
    		
    		toggle = 1;
    		
    		let answer = confirm("해당 회원을 탈퇴처리 하시겠습니까?");
    		
    		if(answer) {
    			
    			$.ajax({
        			url : "delete.ad",
        			type : "post",
        			data : { mno : mno },
        			success : function(result) {
        				
        				if(result > 0) {
        					
        					alert("해당 회원이 정상적으로 탈퇴처리되었습니다.");
        					
        					location.reload();
        					
        				} else {
        					
        					alert("탈퇴처리에 실패하였습니다. 다시 시도해주세요.");				
        				}
        			},
        			error : function() {
        				alert("탈퇴처리에 실패하였습니다. 다시 시도해주세요.");
        			}
        		});
    			
    		}
    		
    	}
 		
    	
    	
		function get1(e) {
			
			if(toggle == 0) {
				
				let memId = $(e).children().eq(1).text();
				
				$.ajax({
					url : "select.me",
					type : "post",
					async : false,
					data : { memId : memId },
					success : function(sm) {
						
						if(sm != null) {
							
							$("#userNo").val(sm.userNo);
							$("#userId").val(sm.userId);
							$("#userPwd").val(sm.userPwd);
							$("#userNickName").val(sm.userNickName);
							$("#userName").val(sm.userName);
							$("#email").val(sm.email);
							$("#phone").val(sm.phone);
							$("#birth").val(sm.birth);
							$("#gender").val(sm.gender);
							$("#roadAddress").val(sm.address1);
							$("#detailAddress").val(sm.address2);
							
							$('div.modal').modal("show");
							
						} else {
							
							alert("회원의 정보를 불러오지 못했습니다. 다시 시도해주세요!");
						}
						
					},
					error : function() {
						alert("정보를 불러오지 못했습니다. 다시 시도해주세요.");
					}
					
				});
			}
			toggle = 0;
		}
		
	</script>
	
	<!-- 회원 상세정보 모달창 (부트스트랩) -->
	<!-- The Modal -->
    <div class="modal" id="memberDetailForm">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">회원 상세정보</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
        
                <!-- Modal body -->
                <div class="modal-body" align="center">
					
			        <div class="div1">
				        <table>
				        	<tr>
				                <td>회원 번호</td>
				            </tr>
				            <tr>
				                <td><input type="text" name="userNo" id="userNo" class="input" readonly></td>
				            </tr>
				            <tr>
				                <td>아이디</td>
				            </tr>
				            <tr>
				                <td><input type="text" name="userId" id="userId" class="input" readonly></td>
				            </tr>
				            <tr>
				                <td>비밀번호</td>
				            </tr>
				            <tr>
				                <td><input type="text" name="userPwd" id="userPwd" class="input" readonly></td>
				            </tr>
				            <tr>
				                <td>닉네임</td>
				            </tr>
				            <tr>
				                <td><input type="text" name="userNickname" id="userNickName" class="input" readonly></td>
				            </tr>
				            <tr>
				                <td>이름</td>
				            </tr>
				            <tr>
				                <td><input type="text" name="userName" id="userName" class="input" readonly></td>
				            </tr>
				            <tr>
				                <td>이메일</td>
				            </tr>
				            <tr>
				                <td><input type="email" name="email" id="email" class="input" readonly></td>
				            </tr>
				            <tr>
				                <td>전화번호</td>
				            </tr>
				            <tr>
				                <td><input type="text" name="phone" id="phone" class="input" readonly></td>
				            </tr>
				            <tr>
				                <td>생년월일</td>
				            </tr>
				            <tr>
				                <td><input type="text" name="birth" id="birth" class="input" readonly></td>
				            </tr>
				            <tr>
				                <td>성별</td>
				            </tr>
				            <tr>
				            	<td><input type="text" name="gender" id="gender" class="input" readonly></td>
				            </tr>
				            <tr>
				                <td>주소</td>
				            </tr>
				            <tr>
				            	<td><input type="text" name="address1" id="roadAddress" class="input" readonly placeholder="도로명주소"></td>
				            </tr>
				            <tr>
				            	<td>
				            		<span id="guide" style="color:#999;display:none"></span>
									<input type="text" name="address2" id="detailAddress" class="input" readonly placeholder="상세주소">
								</td>
				            </tr>
				        </table>
			        </div>
                   
                </div>
            </div>
        </div>
    </div>
    
    <script>
    	$(function() {
    		
    		document.querySelector('.modal .close').addEventListener('click', function() {
    		    $(".modal").modal("hide");
    		  });	
    	});
    </script>

    <!-- jquery
		============================================ -->
    <script src="resources/admin/js/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="resources/admin/js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="resources/admin/js/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="resources/admin/js/jquery-price-slider.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="resources/admin/js/owl.carousel.min.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="resources/admin/js/jquery.scrollUp.min.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="resources/admin/js/meanmenu/jquery.meanmenu.js"></script>
    <!-- counterup JS
		============================================ -->
    <script src="resources/admin/js/counterup/jquery.counterup.min.js"></script>
    <script src="resources/admin/js/counterup/waypoints.min.js"></script>
    <script src="resources/admin/js/counterup/counterup-active.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="resources/admin/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <!-- sparkline JS
		============================================ -->
    <script src="resources/admin/js/sparkline/jquery.sparkline.min.js"></script>
    <script src="resources/admin/js/sparkline/sparkline-active.js"></script>
    <!-- flot JS
		============================================ -->
    <script src="resources/admin/js/flot/jquery.flot.js"></script>
    <script src="resources/admin/js/flot/jquery.flot.resize.js"></script>
    <script src="resources/admin/js/flot/flot-active.js"></script>
    <!-- knob JS
		============================================ -->
    <script src="resources/admin/js/knob/jquery.knob.js"></script>
    <script src="resources/admin/js/knob/jquery.appear.js"></script>
    <script src="resources/admin/js/knob/knob-active.js"></script>
    <!--  Chat JS
		============================================ -->
    <script src="resources/admin/js/chat/jquery.chat.js"></script>
    <!--  todo JS
		============================================ -->
    <script src="resources/admin/js/todo/jquery.todo.js"></script>
	<!--  wave JS
		============================================ -->
    <script src="resources/admin/js/wave/waves.min.js"></script>
    <script src="resources/admin/js/wave/wave-active.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="resources/admin/js/plugins.js"></script>
    <!-- Data Table JS
		============================================ -->
    <script src="resources/admin/js/data-table/jquery.dataTables.min.js"></script>
    <script src="resources/admin/js/data-table/data-table-act.js"></script>
    <!-- main JS
		============================================ -->
    <script src="resources/admin/js/main.js"></script>
	<!-- tawk chat JS
		============================================ -->
    <!-- <script src="resources/admin/js/tawk-chat.js"></script> -->
    
    <script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
      <%@ include file="../common/footer.jsp"%>
</body>

</html>