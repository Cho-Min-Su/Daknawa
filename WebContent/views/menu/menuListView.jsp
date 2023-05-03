<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.kh.menu.model.vo.Menu, com.kh.common.model.vo.Attachment"%>
<%@ page import="com.kh.common.model.vo.PageInfo"%>

<%
	ArrayList<Menu> list = (ArrayList<Menu>) request.getAttribute("list");
ArrayList<Attachment> ilist = (ArrayList<Attachment>) request.getAttribute("ilist");
PageInfo pi = (PageInfo) request.getAttribute("pi");
String userId = request.getParameter("userId");
// 자주 쓰일법한 변수들 셋팅
int currentPage = pi.getCurrentPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
int maxPage = pi.getMaxPage();
%>

<!DOCTYPE html>
<html lang="en">
<head>
<style>
/* 모달 전체를 가운데로 정렬합니다. */
.modal {
	display: flex;
	justify-content: center;
	align-items: center;
}

/* 모달 배경 스타일을 지정합니다. */
.modal-backdrop {
	background-color: rgba(0, 0, 0, 0.6);
}

/* 모달창 스타일을 지정합니다. */
.modal-content {
	border-radius: 20px;
	box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.5);
	background-color: #fff;
	max-width: 600px;
	margin: 0 20px;
}

/* 모달창 제목 스타일을 지정합니다. */
.modal-title {
	font-size: 24px;
	font-weight: bold;
	margin: 0;
	padding: 20px;
	color: #fff;
	background-color: #f39c12;
	border-radius: 20px 20px 0 0;
	text-align: center;
}

/* 모달창 닫기 버튼 스타일을 지정합니다. */
.close {
	font-size: 24px;
	font-weight: bold;
	color: #fff;
	position: absolute;
	top: 10px;
	right: 10px;
	cursor: pointer;
	opacity: 0.8;
}

.close:hover {
	opacity: 1;
}

/* 모달창 이미지 스타일을 지정합니다. */
.modal-body img {
	max-width: 100%;
	height: auto;
	display: block;
	margin: 0 auto;
}

/* 모달창 하단의 체크박스와 레이블 스타일을 지정합니다. */
.modal-footer input[type="checkbox"] {
	margin-right: 5px;
}

.modal-footer label {
	font-size: 14px;
}

.button {
	background-color: black;
	border-radius: 5px;
	color: white;
	margin: 20px 0px 5px 0px;
}

.button:hover {
	background-color: gray;
	cursor: pointer;
}
</style>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>닭나와</title>
<link rel="shortcut icon" type="resources/admin/image/x-icon"
	href="resources/css/public/playground_assets/logo.png">
<!-- swiper.js 라이브러리추가 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/5.4.5/css/swiper.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/5.4.5/js/swiper.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/7.4.0/swiper-bundle.min.css" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="resources/css/styles.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	
</script>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>

	<div id="content_1">
		<!-- Slider main container -->
		<div class="swiper">
			<!-- Additional required wrapper -->
			<div class="swiper-wrapper">
				<!-- Slides -->
				<div class="swiper-slide">
					<img src="resources/img/1.png"
						style="display: block; margin: 0 auto" />
				</div>
				<div class="swiper-slide">
					<img src="resources/img/2.png"
						style="display: block; margin: 0 auto" />
				</div>
				<div class="swiper-slide">
					<img src="resources/img/3.png"
						style="display: block; margin: 0 auto" />
				</div>
				<div class="swiper-slide">
					<img src="resources/img/4.png"
						style="display: block; margin: 0 auto" />
				</div>
			</div>

			<!-- If we need pagination -->
			<div class="swiper-pagination"></div>
			<!-- If we need navigation buttons -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
			<!-- If we need scrollbar -->
			<div class="swiper-scrollbar" style="display: none"></div>
		</div>
	</div>

	<script>
		// 슬라이더 동작 정의
		const swiper = new Swiper(".swiper", {
			autoplay : {
				delay : 3000, // 3초마다 이미지 변경
			},
			loop : true, //반복 재생 여부
			slidesPerView : 1, // 이전, 이후 사진 미리보기 갯수
			pagination : {
				// 페이징 버튼 클릭 시 이미지 이동 가능
				el : ".swiper-pagination",
				clickable : true,
			},
			navigation : {
				// 화살표 버튼 클릭 시 이미지 이동 가능
				prevEl : ".swiper-button-prev",
				nextEl : ".swiper-button-next",
			},
		});
	</script>
	<br />

	<div>
		<link href="resources/css/category-filters5.css" rel="stylesheet" />

		<form id="keywordList-form"
			method="GET" action="search.mn">
							<input type="hidden" id="type-input" name="type">
			<div class="category-filters5-container">
				<div class="category-filters5-category-filters5">

					<div class="category-filters5-section-title">
						<span class="category-filters5-text HeadingH2"> <span><h1
									style="margin-top: 30px;">메뉴 정보</h1></span>
						</span>
					</div>

					<div class="category-filters5-content"
						style="width: 595px; margin-right: 0px; display: absolute; left: 47px">
						<div class="category-filters5-row1">

							<div class="category-filters5-filter-four"
								style="width: 150px; margin-right: 0px;">
								<select id="menu-select" name="menu"
									class="category-filters5-select2">
									<option value="전체">전체</option>
									<option value="치킨">치킨</option>
									<option value="감자튀김">감자튀김</option>
									<option value="떡볶이">떡볶이</option>
									<option value="기타">기타</option>
								</select>
							</div>
							<div>
								<input type="search" name="query"
									class="category-filters5-select2"
									style="width: 200px; height: 23px; margin-right: 0px;"
									placeholder="검색어를 입력하세요.">
							</div>
							<div>
								<button class="button"
									style="width: 70px; padding: 15px 5px; margin: 0px; margin-left: 25px;"
									type="submit">검색</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

	<script>
	$(document).ready(function() {
		  // 메뉴 선택 변경 시 type 값 지정
		  $('#menu-select').change(function() {
		    var selected = $(this).val();
		    var type = "";
		    if (selected !== "전체") {
		      type = selected;
		    }
		    $("#type-input").val(type); // type 값을 hidden input 요소에 지정

		    // 전체를 선택한 경우 menu.mn 페이지로 이동
		    if (selected === "전체") {
		      window.location.href = "<%=contextPath%>/menu.mn";
		    } else {
		      window.location.href = "<%=contextPath%>/list.ch?type=" + type + "&menu=" + selected;
		    }
		  });

		  // 페이지 로드 시 선택된 값을 변경
		  var urlParams = new URLSearchParams(window.location.search);
		  var selectedMenu = urlParams.get('menu');
		  var selectedType = urlParams.get('type');
		  if (selectedMenu === null) {
		    selectedMenu = "전체";
		  }
		  $("#menu-select").val(selectedMenu);
		  if (selectedType !== null) {
		    $("#type-input").val(selectedType);
		  }

		  // 전체 페이지로 이동할 때도 선택한 값을 유지하도록 함
		  $('.category-filters5-filter-four a:first').click(function() {
		    $("#menu-select").val("");
		  });
		});

</script>








	<!-- <div style="display: flex; justify-content: center"
		class="navbar navbar-expand-lg navbar-light bg-light">
		<nav class="navbar">
			<div class="container-fluid">
				<a href="<%=contextPath%>/menu.mn">전체메뉴</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							id="chicken-menu" aria-current="page"
							href="<%=contextPath%>/list.ch?type=치킨">치킨메뉴</a></li>
						<li class="nav-item"><a class="nav-link" href="#"></a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								사이드 </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item"
									href="<%=contextPath%>/list.ch?type=감자튀김">감자튀김</a></li>
								<li><a class="dropdown-item"
									href="<%=contextPath%>/list.ch?type=떡볶이">떡볶이</a></li>
								<li><hr class="dropdown-divider" /></li>
								<li><a class="dropdown-item"
									href="<%=contextPath%>/list.ch?type=기타">기타</a></li>
							</ul></li>
					</ul>
				</div>
				<form class="d-flex" method="GET" action="search.mn">
					<div class="input-group">
						<input type="hidden" name="type">
						<input class="form-control" type="search" name="query"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</div>
				</form>
			</div>
		</nav>
	</div> -->


	<section class="py-5" style="padding-top: 15px !important;">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<%
					for (Menu m : list) {
				%>
				<div class="col mb-5">
					<div class="card h-100"
						style="border-radius: 0px; border: rgba(32, 31, 31, 0.171) 0.5px solid;">
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
						<%
							}
						%>
						<%
							}
						%>
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h6 class="fw-bolder"><%=m.getBrandName()%></h6>
								<h5 class="fw-bolder"><%=m.getMenuName()%></h5>
								<!-- Product price-->
								<%=m.getMenuPrice()%>원
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto"
									style="border-radius: 2px; border: rgba(32, 31, 31, 0.796) 0.5px solid;"
									href="<%=contextPath%>/list.mn?
				mno=<%=m.getMenuNo()%>">자세히
									보기</a>
							</div>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
			<!-- 페이징바 -->
			<div align="center" class="paging-area">
				<%
					if (currentPage != 1) {
				%>
				<button
					onclick="location.href = ' <%=contextPath%>/menu.mn?currentPage=<%=currentPage - 1%>';">
					&lt;</button>
				<%
					}
				%>
				<%
					for (int p = startPage; p <= endPage; p++) {
				%>
				<%
					if (p == currentPage) {
				%>
				<button
					onclick="location.href = '<%=contextPath%>/menu.mn?currentPage=<%=p%>';"
					disabled>
					<b><%=p%></b>
				</button>
				<%
					} else {
				%>
				<!--  현재 내가 보고 있는 페이지일 경우에는 클릭이 안되게끔 -->
				<button
					onclick="location.href = '<%=contextPath%>/menu.mn?currentPage=<%=p%>';">
					<%=p%>
				</button>
				<%
					}
				%>
				<%
					}
				%>
				<%
					if (currentPage != maxPage) {
				%>
				<button
					onclick="location.href = ' <%=contextPath%>/menu.mn?currentPage=<%=currentPage + 1%>';">
					&gt;</button>
				<%
					}
				%>
			</div>
		</div>
	</section>

	<%@ include file="../common/footer.jsp"%>
	<!-- Bootstrap core JS-->
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>

	<!-- 광고 팝업용 모달창-->
	<!-- The Modal -->
	<div class="modal" id="adModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">오늘의 치킨!</h4>
					<button type="button" class="close" data-dismiss="modal">
						&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body" style="padding: 0;">
					<img src="<%=request.getContextPath()%>/resources/img/ad.png" />
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<input type="checkbox" id="mainPop" name="mainPop" /> <label
						for="mainPop">24 시간 동안 보지 않기</label>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(function() {
			$("#mainPop").click(function() {
				$("#adModal").modal("hide");
				let today = new Date();
				today.setDate(today.getDate() + 1); // 하루 뒤의 날짜를 구함
				document.cookie = "mainPop=n; expires=" + today.toUTCString();
			});

			if (document.cookie.includes("mainPop=n")) {
				$("#adModal").modal("hide");
			} else {
				$("#adModal").modal("show");
			}

			document.querySelector('#adModal .close').addEventListener('click',
					function() {
						$("#adModal").modal("hide");
					});
		});
	</script>

</body>
</html>
