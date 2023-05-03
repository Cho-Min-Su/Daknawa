<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.post.model.vo.Post, com.kh.common.model.vo.PageInfo" %>
<%
    PageInfo pi = (PageInfo)request.getAttribute("pi");
    ArrayList<Post> list = (ArrayList<Post>)request.getAttribute("list");
    
    int currentPage = pi.getCurrentPage();
    int startPage = pi.getStartPage();
    int endPage = pi.getEndPage();
    int maxPage = pi.getMaxPage();
    
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닭나와</title>
<link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>

    body {
        background-color: #f8f9fa;
    }

    .outer {
        margin: 5%;
        margin-top: 3%;
    }

    .title {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 10px;
    }

    .title h1 {
        margin-bottom: 0;
        color: #4c4c4c;
        font-size: 28px;
    }

    table {
        border-collapse: collapse;
        width: 100%;
        background-color: #fff;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
    }

    td, th {
        border: 1px solid #ddd;
        padding: 20px;
        text-align: left;
    }

    th {
        background-color: #f1f1f1;
    }

    .btn-group {
        float: right;
    }

    .btn {
        font-size: 14px;
        padding: 8px 16px;
    }

    #page-numbers {
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }

    .page-numbers button {
        background-color: #f1f1f1;
        border: none;
        color: #4c4c4c;
        cursor: pointer;
        font-size: 14px;
        padding: 8px 16px;
        margin: 0 2px;
    }

    .page-numbers button:hover {
        background-color: #ddd;
    }

    .page-numbers button.disabled {
        cursor: not-allowed;
        opacity: 0.5;
    }

    tr.post-1:hover {
        background-color: #f1f1f1;
        cursor: pointer;
    }
</style>
</head>
<body>
    
    <%@ include file="../common/menubar.jsp" %>

    <div class="outer">
        <div class="title">
            <h1>공지사항</h1>
            <div class="btn-group">
                <select id="category" class="btn btn-outline-secondary">
                    <option value="selectList">이동할 카테고리 선택</option>
                    <option value="notice">공지사항</option>
                    <option value="free">자유게시판</option>
                    <option value="review">리뷰게시판</option>
                </select>
                <% if(loginUser != null && loginUser.getUserNickName().equals("관리자")) { %>
                <a id="insertList" class="btn btn-secondary" href="<%= contextPath %>/nEnrollForm.no">글작성</a>
                <% } %>
            </div>

            <script>
                var category = document.getElementById("category");
            
                category.addEventListener("change", function() {
                    var selectedOption = category.value;
            
                    var pageUrl = "";
            
                    switch(selectedOption) {
                        case 'notice':
                            pageUrl = "nlist.no?currentPage=1";
                            break;
                        case 'free':
                            pageUrl = "plist.bo?currentPage=1";
                            break;
                        case 'review':
                            pageUrl = "review.bo?currentPage=1#1";
                            break;
                        default:
                            pageUrl = "";
                            break;
                    }
            
                    if (pageUrl !== "") {
                        window.location.href = pageUrl;
                    }
                });
            </script>


        </div>
        <table id="list-area">
            <thead>
                <tr>
                    <th width="1%">번호</th>
                    <th width="57%">글제목</th>
                    <th width="10%">작성자</th>
                    <th width="5%">조회수</th>
                    <th width="10%">작성일</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% if(list.isEmpty()) { %>
                    <tr>
                    <td colspan="5">
                    조회된 리스트가 없습니다.
                    </td>
                    </tr>
                    <% } else { %>
                    <% for(Post p : list) { %>
                    <tr class="post-1">
                    <td><%= p.getPostNo() %></td>
                    <td><%= p.getPostTitle() %></td>
                    <td><%= p.getMemberNickname() %></td>
                    <td><%= p.getPostView() %></td>
                    <td><%= p.getPostDate() %></td>
                    </tr>
                    <% } %>
                    <% } %>
                    </tbody>
                </table>

                    <script>
                        $(function() {
                            $("#list-area>tbody>tr").click(function() {
                
                                let pno = $(this).children().eq(0).text();
                
                                location.href = "<%= contextPath %>/nDetail.no?pno=" + pno;
                            });                 
                        });   
                    </script>
                
                    <div id="page-numbers" class="page-numbers">
                
                     <% if(currentPage != 1){ %>
                    <button onclick="location.href='<%= contextPath%>/nlist.no?currentPage=<%=currentPage - 1%>';">&lt;</button>
                    <%}%>
                    
                    <% for(int p = startPage; p <= endPage; p++){ %>
                    
                      <%if(p != currentPage){ %>
                        <button onclick="location.href='<%= contextPath %>/nlist.no?currentPage=<%=p%>';"><%= p %></button>
                      <%} else{ %>
                        <!-- 현재 내가 보고있는 페이지일 경우에는 클릭이 안되게끔 -->
                        <button disabled><%= p %></button>
                      <%} %>
                      
                    <%} %>
                    
                    <% if(currentPage != maxPage){ %>
                    <button onclick="location.href='<%= contextPath%>/nlist.no?currentPage=<%=currentPage + 1%>';">&gt;</button>
                    <%} %>
                           
                    </div>
                     
                </div>
                
                <%@ include file="../common/footer.jsp"%>
                
        </body>
    </html>
                    
                    

