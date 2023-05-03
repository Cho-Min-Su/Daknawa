<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.common.model.vo.SubNav" %>
<%
	SubNav sn = (SubNav)request.getAttribute("sn");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닭나와</title>
<link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
<style>
        /* MY PAGE 타이틀 부분 */
        #container .title {
        padding-top: 80px;
        height: 200px;
        position: relative;
        min-width: 1000px;
      }
      #container .sub_title {
        font-size: 44px;
        line-height: 54px;
        color: #000;
        margin-bottom: 0px;
        text-align: center;
        text-transform: uppercase;
      }
      h2 {
        margin:0;
        font-weight: normal;
        display: block;
      }
      #mini_title {
        width: 100%;
        text-align: center;
        margin-bottom: 44px;
        position: absolute;
        top: 134px;
        left: 0;
      }
      ol {
        list-style: none;
        margin: 0;
        padding: 0;
        display: block;
      }
      li {
        display: inline-block;
        margin: 0;
        padding: 0;
        list-style: none;

        text-transform: uppercase;
      }
      a {
        text-decoration: none;
        color: #000;
      }

      /* 메뉴바 부분 */
      #mnb {
        width: 100%;
        min-width: 1000px;
        border-bottom: 1px solid #888686;
        background-color: #fff;
        margin-bottom: 60px;
      }

      #mnb .mnb_header {
        width: 100%;
        min-width: 1000px;
        background-color: #fff;
        border-top: 1px solid #9d9d9d;
      }

      #mnb .mnb_header>ul {
        width: 1000px;
        margin: 0 auto;
        padding: 0;
        display: block;
        list-style-type: disc;
      }
      #mnb_sub ul {
        width: 250px;
        margin: 0 auto;
        padding: 0;
        display: block;
        list-style-type: disc;
      }
      .menubar { height : 38px; }

      #mnb.menubar {
        margin-bottom : 100px;
      }
      #mnb .mnb_header ul li {
        text-align: center;
        /* float: left; */
        position: relative;
      }
      b .mnb_header ul li a {
        font-size: 14px;
        vertical-align: middle;
      }

    /* 서브 메뉴바 부분 */
    #mnb_sub {
            list-style-type : none;
            /*
                p 태그와 마찬가지로 ul 태그 또한 위, 아래로 기본 margin 이 잡혀있음
                또한 ul 태그는 padding 이 왼쪽에 기본적으로 존재함
                => margin : 0px; 과 padding : 0px; 으로 margin 과 padding 을 없애기
            */
            /*
            margin : 0px;
            padding : 0px; /* padding 값 조정으로 메뉴 가운데 배치 가능 */
           /* height : 100%; */

            width: 25%;
            height : 36px;
            margin: 0 auto;
            padding: 0;
            display: block;
        }

        /* 메인 메뉴를 나타내는 li 태그들 */
        #mnb_sub>li {
            float : left;
            height : 100%;
            background-color: #fff;
            display: block;
        }

        /* 메뉴 문구를 나타내는 a 태그들 */
        #mnb a {
            
            color : black;
            text-decoration : none;
            font-size : 14px;
            /*
                a 태그는 인라인요소이기 때문에
                width, height 속성이 적용되지 않음
                => display : block; 으로 블럭요소화 시켜줄것임
            */
            width : 250px;
            height : 100%;
            display : block;
            text-align : center;
            /* vertical-align : middle; vertical-align 은 블럭요소에서 적용되지 않음 */
            line-height : 36px;
            /*
                line-height 속성은 블럭요소에 대한 장평조절 속성
                보통은 블럭요소의 세로길이만큼 주면 알아서 가운데로 옴
            */
        }

        /* 메뉴에 마우스가 올라갔을 때 추가적인 속성 */
        #mnb_sub a:hover {
            color: #888686;
            font-size: 15px;
        }

        /* 서브메뉴에 해당되는 ul 에 대한 스타일 */
        #mnb_sub>li>ul {
            list-style-type : none;
            padding : 0px;
            display : none !important; /* 평소에는 안보여지게끔 숨김 처리 */
        }

        /* 메인 메뉴에 마우스가 올라가는 순간 서브메뉴가 보여지게끔 스타일 부여 */
        #mnb_sub>li:hover>ul {
            display : block !important;
        }
        /* 혹시 몰라서 서브메뉴 자체에도 효과 부여 */
        #mnb_sub>li>ul:hover {
            display : block !important;
        }

        #mnb .mnb_header ul li.active {
        background-color: #000;
      }
      #mnb .mnb_header ul li.active a {
        background-color: #000;
        color: #ffffff;
      }
</style>
	<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>

</head>
<body>
	
	<section id="container">
        <div class="title">
          <h2 class="sub_title">
            <span><%= sn.getTitle1() %></span>
            </h2>
            <ol id="mini_title">
            <li><a href="/Daknawa">Home</a>
            </li>
            <li>></li>
            <li><a id="title1" href="<%= sn.getTitle1Addr() %>"><%= sn.getTitle1() %></a>
            </li>
            <li>></li>
            <li><a href="<%= sn.getTitle2Addr() %>"><%= sn.getTitle2() %></a>
            </li>
            <li>></li>
            <li><%= sn.getTitle3() %></li>
            </ol>
        </div>
        
        <!-- ---------------------------------------- -->
        
        <div id="mnb" class="menubar">
		    <div class="mnb_header">
		        <ul id="mnb_sub">
	            	<li class="<%= sn.getActive1() %>">
	                    <a href="list.me">회원 관리</a>
	                    <ul>
	                        <li style="display: block !important;"><a href="list.me">회원정보 조회</a></li>
	                        <li style="display: block !important;"><a href="blacklist.me">블랙리스트 목록</a></li>                   
	                    </ul>
	                </li>
	                <li class="<%= sn.getActive2() %>">
	                    <a href="store.ad">매장 관리</a>
	                    <ul>
	                        <li><a href="store.ad">전체 매장 조회</a></li>                  
	                    </ul>
	                </li>
	                <li class="<%= sn.getActive3() %>">
	                    <a href="menu.ad">메뉴 관리</a>
	                    <ul>
	                        <li><a href="menu.ad">전체 메뉴 조회</a></li>                  
	                    </ul>
	                </li>
	                <li class="<%= sn.getActive4() %>">
	                    <a href="qna.ad">문의내역 관리</a>
	                    <ul>
	                        <li><a href="qna.ad">1:1 문의내역 관리</a></li>
	                    </ul>
	                </li>
		        </ul>
		    </div>
		    <br><br><br><br>
    	</div>
    	
    </section>
	
	<script>
	
		$(document).ready(function(){
		  $("a").click(function(){
		    console.log($(this).text());
		  });
		});
	</script>
	
	<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
	
</body>
</html>