<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.menu.model.vo.Menu, com.kh.common.model.vo.Attachment"%>
<%
	Menu m = (Menu) request.getAttribute("m");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닭나와</title>
<link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
    <div class="form-example-area">
        <div class="container" style="width: 500px;">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="form-example-wrap" >
                        <form id="enroll-form" action="<%=contextPath%>/insert.mn" method="post" enctype="multipart/form-data">
                            <div class="cmp-tb-hd" style="margin-bottom: 25px; margin-top: 40px; text-align: center;">
                                <h2>메뉴 등록 페이지</h2>
                            </div>
                            <div class="form-example-int">
                                <div class="form-group">
                                    <label>메뉴 이름</label>
                                    <div class="nk-int-st">
                                        <input type="text" class="form-control input-sm" name="name" placeholder="메뉴 이름을 입력하세요">
                                    </div>
                                </div>
                            </div>
                            <div class="form-example-int">
                                <div class="form-group">
                                    <label>메뉴 가격</label>
                                    <div class="nk-int-st">
                                        <input type="text" class="form-control input-sm" name="price" placeholder="메뉴 가격을 입력하세요">
                                    </div>
                                </div>
                            </div>
                            <div class="form-example-int">
                                <div class="form-group">
                                    <label>카테고리</label>
                                    <div class="bootstrap-select fm-cmp-mg">
                                        <select class="selectpicker" name="category" style="margin-top: 5px; margin-bottom: 5px;">
                                            <option value="치킨">치킨</option>
                                            <option value="감자튀김">감자튀김</option>
                                            <option value="떡볶이">떡볶이</option>
                                            <option value="기타">기타</option>
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
											<option value="1">BBQ</option>
											<option value="2">BHC</option>
											<option value="3">교촌치킨</option>
											<option value="4">처갓집양념치킨</option>
											<option value="5">페리카나</option>
											<option value="6">네네치킨</option>
											<option value="7">굽네치킨</option>
											<option value="8">멕시카나치킨</option>
											<option value="9">호식이두마리치킨</option>
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
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 15px;">
                                    <div class="form-group">
                                        <div class="nk-int-st">
                                            <textarea class="form-control" rows="5" name="desc"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-example-int mg-t-15">
                                <div class="form-group">
                                    <label>이미지</label>
                                    <div class="nk-int-st">
                                        <input type="file" class="form-control input-sm" name="upfile" onchange="document.getElementById('image-label').innerHTML = this.value.split('\\').pop()">
                                    </div>
                                </div>
                            </div>
                            <div class="form-example-int mg-t-15" style="text-align: center; margin-top: 25px;">
                                <button class="btn btn-success notika-btn-success" style="margin: 0 2px;" type="submit">입력</button>
                                <button id="cancel-btn" class="btn btn-success notika-btn-success"
									style="margin: 0 2px;" onclick="location.href='<%=contextPath%>/menu.ad'">취소</button>
                            </div>
                            <script>
$(document).ready(function() {
  $('form#enroll-form').submit(function(event) {
    var fileInput = $('input[name="upfile"]');
    if(fileInput.get(0).files.length === 0) {
      event.preventDefault();
      alert('이미지를 선택하세요.');
    }
  });

  $('#cancel-btn').click(function() {
    $('input[name="upfile"]').val(''); // 이미지 선택창 초기화
    event.preventDefault();
  });
});
</script>
                            
                            
                            
                        </form>
                        
                        
                        
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <%@ include file="../common/footer.jsp"%>
    
</body>
</html>