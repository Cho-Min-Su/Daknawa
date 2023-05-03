<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.kh.menu.model.vo.Menu, com.kh.common.model.vo.Attachment"%>
<%@ page import="com.kh.common.model.vo.PageInfo"%>

<%
ArrayList<Menu> list = (ArrayList<Menu>) request.getAttribute("list");
ArrayList<Attachment> ilist = (ArrayList<Attachment>) request.getAttribute("ilist");
int mno = Integer.parseInt(request.getParameter("mno"));
int h; int lo;
// h = 하트 상태 확인 0 보다크면 like 상태
if (request.getAttribute("heart") != null) h = (Integer) request.getAttribute("heart");
else h = 0;
// lo = 좋아요 수
if (request.getAttribute("love") != null)  lo = (Integer) request.getAttribute("love");
else lo = 0;
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>닭나와</title>
<link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="resources/css/styles_detail.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>



	<!-- Product section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0"
						src="<%=contextPath%>/<%=ilist.get(0).getFilePath() + ilist.get(0).getChangeName()%>"
						alt="..." />
				</div>
				<div class="col-md-6">
				<h2 class="display-7 fw-bolder"><%=list.get(0).getBrandName()%></h2>
					<h1 class="display-7 fw-bolder" style="display: inline-block;"><%=list.get(0).getMenuName()%></h1>
					<%
						if (loginUser != null) {
							
					%>
					<%-- 하트아이콘 --%>
					<i class="fa-heart fa-regular"
						style="font-size: 2rem; cursor: pointer;"
						onclick="heart(<%=list.get(0).getMenuNo()%>)"></i>
					<%
						}
					%>

					<script>
					$(document).ready(function() {
						  <%if (h > 0) {%> // like / unlike 상태 확인
						    var heartIcon = $(".fa-heart");
						    heartIcon.removeClass("fa-regular").addClass("fa-solid fa-bounce").css("color", "#ED0707");
						    heartIcon.one("animationiteration webkitAnimationIteration oanimationiteration", function() {
				          $(this).removeClass("fa-bounce");
						    });
						  <%}%>
						});
					function heart(menuNo) {
					    var heartIcon = $(".fa-heart");
					    var isLiked = heartIcon.hasClass("fa-solid");
					    var type = isLiked ? "unlike" : "like"; // 하트가 칠해져 있다면 "unlike", 칠해져 있지 않다면 "like" 지정

					    $.ajax({
					        url: "heart.mn", // 서블릿으로 전송
					        type: "get",
					        data: {
					            menuNo: menuNo, // 메뉴번호랑 타입(like, unlike) 전달
					            type: type
					        },
					        success: function(response) {
					            if(response.success) {
					                if(isLiked) { // like 상태일 경우 기존 상태를 지우고 unlike 상태로 변환
					                    heartIcon.removeClass("fa-solid").addClass("fa-regular fa-bounce").css("color", "");
					                } else { // unlike 상태일  경우 기존 상태를 지우고 like 상태로 변환
					                    heartIcon.removeClass("fa-regular").addClass("fa-solid fa-bounce").css("color", "#ED0707");
					                } // 애니메이션 효과 멈춤
					                heartIcon.one("animationiteration webkitAnimationIteration oanimationiteration", function() {
					                    $(this).removeClass("fa-bounce");
					                }); // 좋아요 수 늘리고 지우기
					                var likeCount = parseInt($(".like-count").text());
					                $(".like-count").text(isLiked ? likeCount - 1 : likeCount + 1);
					            } else {
					                // 에러 처리
					            	 alert("좋아요 처리에 실패했습니다. 다시 로그인해주세요.");
					            }
					        }
					    });
					}

				</script>

					<div class="fs-5 mb-5">
						<span><%=list.get(0).getMenuPrice()%>원</span>
					</div>
					<p class="lead"><%=list.get(0).getMenuDesc()%></p>
					<br>
					<div class="d-flex">
					</div> <br>조회수 <%=list.get(0).getView()%> 좋아요 <span class="like-count"><%=lo%></span>
				</div>
			</div>
		</div>
	</section>
	<!-- Related items section-->
	<section class="py-5 bg-light">
		<div class="container px-4 px-lg-5 mt-5">
			<h2 class="fw-bolder mb-4">가장 많이 본 메뉴</h2>
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<%
					for (int k = 1; k <= 4; k++) {
					Menu m = list.get(k);
				%>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<%
							for (Attachment i : ilist) {
						%>
						<%
							if (m.getMenuNo() == i.getMenuNo()) {
						%>
						<img class="card-img-top"
							src="<%=contextPath%>/<%=i.getFilePath() + i.getChangeName()%>"
							alt="..." style="width: 100%; height: 160px; object-fit: cover" />
						<!-- Product details-->
						<%
							}
						%>
						<%
							}
						%>
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=m.getMenuName()%></h5>
								<!-- Product price-->
								<%=m.getMenuPrice()%>원
								</div><br>
							<div class="text-center">조회수 <%=m.getView()%></div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto"
									href="<%=contextPath%>/list.mn?
				mno=<%=m.getMenuNo()%>">자세히보기</a>
							</div>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</section>

	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	
	<%@ include file="../common/footer.jsp"%>
	
</body>
</html>
