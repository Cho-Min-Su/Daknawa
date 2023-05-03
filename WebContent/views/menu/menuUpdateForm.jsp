<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.menu.model.vo.Menu, com.kh.common.model.vo.Attachment"%>
<%
	Menu m = (Menu) request.getAttribute("m");
Attachment at = (Attachment) request.getAttribute("at");
int mno = Integer.parseInt(request.getParameter("mno"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닭나와</title>
<link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
</head>
<body>

	<%@ include file="../common/menubar.jsp"%>
	<div class="form-example-area">
		<div class="container" style="width: 500px;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="form-example-wrap">

						<form id="update-form" action="<%=contextPath%>/update.mn"
							method="post" enctype="multipart/form-data">
							<input type="hidden" name="mno" value="<%=mno%>">
							<div class="cmp-tb-hd"
								style="margin-bottom: 25px; margin-top: 40px; text-align: center;">
								<h2>메뉴 수정 페이지</h2>
							</div>
							<div class="form-example-int">
								<div class="form-group">
									<label>메뉴 이름</label>
									<div class="nk-int-st">
										<input type="text" class="form-control input-sm" name="name"
											value="<%=m.getMenuName()%>">
									</div>
								</div>
							</div>
							<div class="form-example-int">
								<div class="form-group">
									<label>메뉴 가격</label>
									<div class="nk-int-st">
										<input type="text" class="form-control input-sm" name="price"
											value="<%=m.getMenuPrice()%>">
									</div>
								</div>
							</div>
							<div class="form-example-int">
								<div class="form-group">
									<label>카테고리</label>
									<div class="bootstrap-select fm-cmp-mg">
										<select class="selectpicker" name="category"
											style="margin-top: 5px; margin-bottom: 5px;">
											<option value="치킨"
												<%=m.getMenuCategory().equals("치킨") ? "selected" : ""%>>치킨</option>
											<option value="감자튀김"
												<%=m.getMenuCategory().equals("감자튀김") ? "selected" : ""%>>감자튀김</option>
											<option value="떡볶이"
												<%=m.getMenuCategory().equals("떡볶이") ? "selected" : ""%>>떡볶이</option>
											<option value="기타"
												<%=m.getMenuCategory().equals("기타") ? "selected" : ""%>>기타</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-example-int">
								<div class="form-group">
									<label>브랜드</label>
									<div class="bootstrap-select fm-cmp-mg">
										<select class="selectpicker" name="brand"
											style="margin-top: 5px; margin-bottom: 5px;">
											<option value="1"
												<%=(m.getBrandNo() == 1) ? "selected" : ""%>>BBQ</option>
											<option value="2"
												<%=(m.getBrandNo() == 2) ? "selected" : ""%>>BHC</option>
											<option value="3"
												<%=(m.getBrandNo() == 3) ? "selected" : ""%>>교촌치킨</option>
											<option value="4"
												<%=(m.getBrandNo() == 4) ? "selected" : ""%>>처갓집양념치킨</option>
											<option value="5"
												<%=(m.getBrandNo() == 5) ? "selected" : ""%>>페리카나</option>
											<option value="6"
												<%=(m.getBrandNo() == 6) ? "selected" : ""%>>네네치킨</option>
											<option value="7"
												<%=(m.getBrandNo() == 7) ? "selected" : ""%>>굽네치킨</option>
											<option value="8"
												<%=(m.getBrandNo() == 8) ? "selected" : ""%>>멕시카나</option>
											<option value="9"
												<%=(m.getBrandNo() == 9) ? "selected" : ""%>>호식이두마리치킨</option>
										</select>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="floating-numner form-rlt-mg">
										<p>메뉴설명</p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
									style="margin-top: 15px;">
									<div class="form-group">
										<div class="nk-int-st">
											<textarea class="form-control" rows="5" name="desc"><%=m.getMenuDesc()%></textarea>
										</div>
									</div>
								</div>
							</div>
							<div class="form-example-int mg-t-15">
								<div class="form-group">
									<label>이미지</label>
									<div class="nk-int-st">
										<input type="file" class="form-control input-sm"
											name="reupfile"
											onchange="document.getElementById('image-label').innerHTML = this.value.split('\\').pop()">
									</div>
								</div>
							</div>
							<%
								if (at != null) {
							%>
							<!-- 기존 게시글에 첨부파일이 있다면 원본명을 보여주기 -->
							<%=at.getOriginName()%>

							<!-- 
                                            기존 게시글에 딸린 원래 첨부파일의 파일번호 (PK), 수정명을 hidden 으로 같이 넘기기 
                                            => 파일번호 : ATTACHMENT UPDATE 를 위해서 넘길 것
                                            => 수정명 : 파일도 수정된 경우 기존의 파일은 삭제하기 위해 넘길 것
                                        -->
							<input type="hidden" name="originFileNo"
								value="<%=at.getFileNo()%>"> <input type="hidden"
								name="originFileName" value="<%=at.getChangeName()%>">

							<%
								}
							%>
							<div class="form-example-int mg-t-15"
								style="text-align: center; margin-top: 25px;">
								<button class="btn btn-success notika-btn-success"
									style="margin: 0 2px;" type="submit">입력</button>
									<button class="btn btn-success notika-btn-success" style="margin: 0 2px;" onclick="cancel(event)">취소</button>
									<script>
									  function cancel(event) {
										event.preventDefault(); // 제출 막기
										window.location.href = '<%=contextPath%>/menu.ad'; // 페이지 이동
									  }
									</script>			
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>