<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.qna.model.vo.Qna"%>
<%
    Qna q = (Qna)request.getAttribute("q");
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
                        <form id="update-form" action="<%= contextPath %>/adUpdate.ask" method="post" >
                            <input type="hidden" name="ano" value="<%= q.getAskNo() %>">
                            <div class="cmp-tb-hd" style="margin-bottom: 25px; margin-top: 40px; text-align: center;">
                                <h2>QNA 답변 상세보기</h2>
                            </div>
                            <div class="form-example-int">
                                <div class="form-group">
                                    <label>문의 제목</label>
                                    <div class="nk-int-st">
                                        <input type="text" class="form-control input-sm" value="<%= q.getAskTitle() %>" readonly>
                                    </div>
                                </div>
                            </div>
                            <div class="form-example-int mg-t-15">
                                <div class="form-group">
                                    <label>문의타입</label>
                                    <div class="nk-int-st">
                                        <input type="text" class="form-control input-sm" value="<%= q.getAskType() %>" readonly>
                                    </div>
                                </div>
                            </div>
                            <div class="form-example-int mg-t-15">
                                <div class="form-group">
                                    <label>문의한 날짜</label>
                                    <div class="nk-int-st">
                                        <input type="text" class="form-control input-sm" value="<%= q.getAnswerDate() %>" readonly>
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
                                            <textarea class="form-control" rows="5" readonly><%= q.getAskContent() %></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-example-int mg-t-15">
                                <div class="form-group">
                                    <label>답변한 날짜</label>
                                    <div class="nk-int-st">
                                        <input type="text" class="form-control input-sm" value="<%= q.getAnswerDate() %>" readonly>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="floating-numner form-rlt-mg">
                                        <p>답변 내용</p>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 15px;">
                                    <div class="form-group">
                                        <div class="nk-int-st">
                                            <textarea class="form-control" rows="5" name="answerContent" placeholder="답변 내용을 적어주세요."></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                           
                            <!-- <div class="form-example-int mg-t-15">
                                <div class="fm-checkbox">
                                    <label><input type="checkbox" class="i-checks"> <i></i> Don't forget to check me out</label>
                                </div>
                            </div> -->
                            <div class="form-example-int mg-t-15" style="text-align: center; margin-top: 25px;">
                                <button class="btn btn-success notika-btn-success" style="margin: 0 2px;" type="submit">입력</button>
                                <button class="btn btn-success notika-btn-success" style="margin: 0 2px;">취소</button>
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