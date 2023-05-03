<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.store.model.vo.Store, com.kh.common.model.vo.PageInfo"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Store> list = (ArrayList<Store>)request.getAttribute("list");
	
	
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
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	<style>
	.outer {
		width : 1000px;
		height : 550px;
		margin : auto;
		margin-top : 50px;
	}

	.list-area {
		border : 1px solid gray;
		text-align : center;
	}

	thead { background-color: 	#e2e7c9; }

	th, td { padding: 15px;}

	.col-md-4 { 
		float: left;
		margin-left: 173px;
	}

	.d-flex {
		float: left;
		margin-left: 10px;
	}

	

</style>

</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

	<%@ include file="../common/adminPageNavbar.jsp" %>

	<!-- @import url("https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"); -->


	<h2 align="center">관리자 매장관리</h2>

	<br><br>

	<div class="col-md-4">
		<label for="inputState" class="form-label"></label>
		<select id="inputState" class="form-select">
		  <option selected>동</option>
		  <option>브랜드명</option>
		</select>
	  </div>
	  <form class="d-flex">
        <input class="form-control me-2" type="search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">검색</button>
      </form>
      
	<button onclick="location.href='<%= contextPath %>/insertForm.st'">매장추가하기</button>
	<div class="outer">
		<table align="center" class="list-area">
			<thead>
				<tr>
					<th width="70">매장번호</th>
					<th width="100">브랜드명</th>
					<th width="130">매장명</th>
					<th width="400">매장주소</th>
					<th width="200">매장전화번호</th>
					<th width="200">영업시간</th>
					<th width="50">수정</th>
					<th width="50">삭제</th>
				</tr>
			</thead>
			<tbody>
				<% for(Store s : list) { %>
				
				<tr>
					<td><%= s.getStoreNo() %></td>
					<td><%= s.getBrandNo() %></td>
					<td><%= s.getStoreName() %></td>
					<td><%= s.getStoreAddress() %></td>
					<td><%= s.getStorePhone() %></td>
					<td><%= s.getStoreTime() %></td>
					<td>
						<button>
							<a href="<%= contextPath%>/updateForm.st?sno=<%= s.getStoreNo() %>" class="updateStore">수정</a>
						</button>
					</td>
					<td>
						<button>
							<a href="<%= contextPath%>/delete.st?sno=<%= s.getStoreNo() %>" class="deleteStore">삭제</a>
						</button>
					</td>
				</tr>
				<%  } %>
			</tbody>
		</table>
		
		
		<br><br>
		   
		   <!-- 페이징바 -->
            <div align="center" class="paging-area">
            
            	<% if(currentPage != 1) { %>
            		 <button onclick="location.href = '<%= contextPath %>/adlist.st?currentPage=<%= currentPage - 1 %>';">
            		 	&lt;
            		 </button>
            	<% } %>
            	
            	<% for(int p = startPage; p <= endPage; p++) { %>
            		<% if(p != currentPage) {  %>
            			<button onclick="location.href = '<%= contextPath %>/adlist.st?currentPage=<%= p %>';">
           					<%= p %> 			
            			</button>
            		<% } else { %>
            		<!-- 현재 내가 보고있는 페이지일 경우에는 클릭이 안되게끔 -->
            			<button disabled><%= p %></button>
            		<% } %>
            	<% } %>
            
            	<% if(currentPage != maxPage) { %>
            		<button onclick="location.href = '<%= contextPath %>/adlist.st?currentPage=<%= currentPage + 1 %>';">
            			&gt;
            		</button>
            	<% } %>
            </div>
		
	
	</div>
	<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>

	<%@ include file="../common/footer.jsp"%>

</body>
</html>