<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.post.model.vo.Post, com.kh.common.model.vo.Attachment"%>
<%
    Post p = (Post)request.getAttribute("p");
    Attachment at = (Attachment)request.getAttribute("at"); 
%>
    
<!DOCTYPE html>
<html lang="english">
  <head>
    <title>닭나와</title>
    <link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta charset="utf-8" />
    <meta property="twitter:card" content="summary_large_image" />

    <style data-tag="reset-style-sheet">
      html {
        line-height: 1.15;
      }
      body {
        margin: 0;
      }
      * {
        box-sizing: border-box;
        border-width: 0;
        border-style: solid;
      }
      p,
      li,
      ul,
      pre,
      div,
      h1,
      h2,
      h3,
      h4,
      h5,
      h6,
      figure,
      blockquote,
      figcaption {
        margin: 0;
        padding: 0;
      }
      button {
        background-color: transparent;
      }
      button,
      input,
      optgroup,
      select,
      textarea {
        font-family: inherit;
        font-size: 100%;
        line-height: 1.15;
        margin: 0;
      }
      button,
      select {
        text-transform: none;
      }
      button,
      [type="button"],
      [type="reset"],
      [type="submit"] {
        -webkit-appearance: button;
      }
      button::-moz-focus-inner,
      [type="button"]::-moz-focus-inner,
      [type="reset"]::-moz-focus-inner,
      [type="submit"]::-moz-focus-inner {
        border-style: none;
        padding: 0;
      }
      button:-moz-focus,
      [type="button"]:-moz-focus,
      [type="reset"]:-moz-focus,
      [type="submit"]:-moz-focus {
        outline: 1px dotted ButtonText;
      }
      a {
        color: inherit;
        text-decoration: inherit;
      }
      input {
        padding: 2px 4px;
      }
      img {
        display: block;
      }
      html {
        scroll-behavior: smooth;
      }
    </style>
    <style data-tag="default-style-sheet">
      html {
        font-family: Inter;
        font-size: 16px;
      }

      body {
        font-weight: 400;
        font-style: normal;
        text-decoration: none;
        text-transform: none;
        letter-spacing: normal;
        line-height: 1.15;
        color: var(--dl-color-gray-black);
        background-color: var(--dl-color-gray-white);
      }
    </style>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400;500;600;700;800;900&amp;display=swap"
      data-tag="font"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&amp;display=swap"
      data-tag="font"
    />
    <link rel="stylesheet" href="./style.css" />
    <!-- CSS only -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
  </head>
  <body>
  
    <%@ include file="../common/menubar.jsp"%>
    <div>
      <link href="resources/css/blog-post1-enroll.css" rel="stylesheet" />

      <div class="blog-post1-container">
        <form
          id="enroll-form"
          action="<%= contextPath %>/pupdate.po"
          method="post"
          enctype="multipart/form-data"
        >
        <input type="hidden" name="pno" value="<%= p.getPostNo() %>">
        <div
        class="blog-post1-blog-post1"
        style="width: 1200px; margin: 0 auto"
        >
        <div class="blog-post1-blog-header" style="margin-bottom: 15px;">
          <div class="blog-post1-content">
            <div class="blog-post1-breadcrumbs">
              <span class="blog-post1-text TextRegularNormal">
                <span>수정 하기</span>
              </span>
              
              <span class="blog-post1-text02 TextRegularSemiBold">
                    <span></span>
                  </span>
                </div>
                <span class="blog-post1-text04 HeadingH2"> </span>
                <!-- 게시글 제목 -->
                <input
                type="text"
                name="title"
                required
                style="
                    border: 1px solid black;
                    width: 500px;
                    height: 70px;
                    font-size: 30px;
                    "
                  placeholder=" <%= p.getPostTitle() %>"
                  />
                </div>
                <div class="blog-post1-content01">
                  <div class="blog-post1-avatar">
                    <div class="blog-post1-content02">
                      <span class="blog-post1-text06 TextSmallSemiBold">
                        <span><%= p.getMemberNickname() %></span>
                      </span>
                      <div class="blog-post1-time">
                        <span class="blog-post1-text08 TextSmallNormal">
                          <span>작성일 : <%= p.getPostDate() %></span>
                        </span>
                        <span class="blog-post1-text10 TextMediumNormal">•</span>
                        <span class="blog-post1-text11 TextSmallNormal">
                          <span>5 min read</span>
                        </span>
                      </div>
                    </div>
                  </div>
                  <button class="blog-post1-share-buttons"></button>
                </div>
              </div>
              <div class="blog-post1-content03">
                <div class="blog-post1-content04">
                  <div class="blog-post1-rich-text">
                    <!-- 첨부 파일 -->
                    <% if(at == null){ %>
                      첨부파일 없음
                    <%} else{%> 
                    <!-- 
                      기존 게시글에 딸린 원래 첨부파일의 파일번호 (pk), 수정명을 hidden 으로 같이 넘기기 
                      => 파일번호 : ATTACHMENT UPDATE 를 위해서 넘길 것 
                      => 수정명 : 파일도 수정된 경우 기존의 파일은 삭제하기 위해 넘길 것 
                    -->
                    <img src="<%= contextPath %>/<%= at.getFilePath() + at.getChangeName() %>"
                          width="100" height="100">
                    <input type="hidden" name="originFileNo" value="<%= at.getFileNo() %>">
                    <input type="hidden" mame="originFileName" vlaue="<%= at.getChangeName() %> "> 
                    <%= at.getOriginName() %>
                    <%} %>
                    <input type="file" name="reUpfile">
                    <div class="blog-post1-content06">
                      <span class="blog-post1-text15 TextRegularNormal">
                        <!-- 게시글 내용 -->
                        <textarea
                        name="content"
                        rows="40"
                        required
                        style="border: 1px solid black; width: 800px; font-size: 20px;"
                        placeholder=" <%= p.getPostContent() %>"
                        ></textarea>
                    </span>
                  </div>
                  <button
                    class="btn btn-outline-dark"
                    style="margin: 0 auto"
                    type="submit"
                  >
                    작성 완료
                  </button>
                </div>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
    
    <%@ include file="../common/footer.jsp"%>
    
  </body>
</html>

