<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.qna.model.vo.Qna"%>
<%
    Qna q = (Qna)request.getAttribute("q");
System.out.println("q 들오나" + q);

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
                        <form id="update-form" action="<%= contextPath %>/~~~~~" method="post" >
                            <div class="cmp-tb-hd" style="margin-bottom: 25px; margin-top: 40px; text-align: center;">
                                <h2>1:1문의 답변 </h2>
                            </div>
                            <input type="hidden" name="memberNo" value="<%= loginUser.getUserNo() %>"> <!-- 회원번호 -->
                            <div class="form-example-int">
                                <div class="form-group">
                                    <label>아이디</label>
                                    <div class="nk-int-st">
                                        <input type="text" class="form-control input-sm" value="<%= loginUser.getUserId() %>" readonly>
                                    </div>
                                </div>
                            </div>
                            <div class="form-example-int">
                                <div class="form-group">
                                    <label>문의유형</label>
                                    <div class="bootstrap-select fm-cmp-mg">
                                        <select class="selectpicker" name="askType" style="margin-top: 5px; margin-bottom: 5px;">
                                            <option value="0">문의 유형 선택</option>
                                            <option value="1">홈페이지 이용 관련 문의</option>
                                            <option value="2">회원 관련 문의</option>
                                            <option value="3">커뮤니티 관리자에게 문의</option>
                                            <option value="4">기타 문의</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-example-int mg-t-15">
                                <div class="form-group">
                                    <label>문의 제목</label>
                                    <div class="nk-int-st">
                                        <input type="text" class="form-control input-sm" value="<%= q.getAskTitle() %>" name="askTitle">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="floating-numner form-rlt-mg">
                                        <p>문의 내용</p>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 15px;">
                                    <div class="form-group">
                                        <div class="nk-int-st">
                                            <textarea class="form-control" rows="5" name="askContent" placeholder="답변 내용을 적어주세요."><%= q.getAskContent() %></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                           
                            <div class="form-example-int mg-t-15" style="text-align: center; margin-top: 25px;">
                                <button class="btn btn-success notika-btn-success" style="margin: 0 2px;" type="submit">입력</button>
                                <button class="btn btn-success notika-btn-success" style="margin: 0 2px;" onclick="window.history.back()">취소</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <%@ include file="../common/footer.jsp"%>
    
</body>
</html>