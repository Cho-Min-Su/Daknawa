<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.store.model.vo.Store, com.kh.common.model.vo.PageInfo"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Store> list = (ArrayList<Store>)request.getAttribute("list");
	
	String bname = (String)request.getAttribute("bname");
	String keyword = (String)request.getAttribute("keyword");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
 %>
 
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta charset="utf-8" />
    <meta property="twitter:card" content="summary_large_image" />
    <title>닭나와</title>
    <link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
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

      a:hover { color:black !important; }
      
      .site-footer
{
  background-color:#26272b;
  padding:45px 0 20px;
  font-size:15px;
  line-height:24px;
  color:#737373;
}
.site-footer hr
{
  border-top-color:#bbb;
  opacity:0.5
}
.site-footer hr.small
{
  margin:20px 0
}
.site-footer h6
{
  color:#fff;
  font-size:16px;
  text-transform:uppercase;
  margin-top:5px;
  letter-spacing:2px
}
.site-footer a
{
  color:#737373;
}
.site-footer a:hover
{
  color:#3366cc;
  text-decoration:none;
}
.footer-links
{
  padding-left:0;
  list-style:none
}
.footer-links li
{
  display:block
}
.footer-links a
{
  color:#737373
}
.footer-links a:active,.footer-links a:focus,.footer-links a:hover
{
  color:#3366cc;
  text-decoration:none;
}
.footer-links.inline li
{
  display:inline-block
}
.site-footer .social-icons
{
  text-align:right
}
.site-footer .social-icons a
{
  width:40px;
  height:40px;
  line-height:40px;
  margin-left:6px;
  margin-right:0;
  border-radius:100%;
  background-color:#33353d
}
.copyright-text
{
  margin:0
}
@media (max-width:991px)
{
  .site-footer [class^=col-]
  {
    margin-bottom:30px
  }
}
@media (max-width:767px)
{
  .site-footer
  {
    padding-bottom:0
  }
  .site-footer .copyright-text,.site-footer .social-icons
  {
    text-align:center
  }
}
.social-icons
{
  padding-left:0;
  margin-bottom:0;
  list-style:none
}
.social-icons li
{
  display:inline-block;
  margin-bottom:4px
}
.social-icons li.title
{
  margin-right:15px;
  text-transform:uppercase;
  color:#96a2b2;
  font-weight:700;
  font-size:13px
}
.social-icons a{
  background-color:#eceeef;
  color:#818a91;
  font-size:16px;
  display:inline-block;
  line-height:44px;
  width:44px;
  height:44px;
  text-align:center;
  margin-right:8px;
  border-radius:100%;
  -webkit-transition:all .2s linear;
  -o-transition:all .2s linear;
  transition:all .2s linear
}
.social-icons a:active,.social-icons a:focus,.social-icons a:hover
{
  color:#fff;
  background-color:#29aafe
}
.social-icons.size-sm a
{
  line-height:34px;
  height:34px;
  width:34px;
  font-size:14px
}
.social-icons a.facebook:hover
{
  background-color:#3b5998
}
.social-icons a.twitter:hover
{
  background-color:#00aced
}
.social-icons a.linkedin:hover
{
  background-color:#007bb6
}
.social-icons a.dribbble:hover
{
  background-color:#ea4c89
}
@media (max-width:767px)
{
  .social-icons li.title
  {
    display:block;
    margin-right:0;
    font-weight:600
  }
}
.button {
        background-color : black;
        border-radius : 5px;
        color : white;
        margin : 20px 0px 5px 0px;
    }

    .button:hover {
        background-color : gray;
        cursor : pointer;
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
    <link rel="stylesheet" href="resources/css/style.css" />
  </head>
  
  <body>
      <%@ include file="../common/menubar.jsp"%>
      
      <!-- @import url("https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"); -->
  
    <div>
      <link href="resources/css/layout155.css" rel="stylesheet" />
      <div class="layout155-container">
        <div class="layout155-layout155">
           <div id="map" style="width:1400px;height:700px;"></div>
          <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2d566a338a02241ce115c4453b6b7ac5&libraries=services"></script>
          
          <script>
            
        // 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
        var infowindow = new kakao.maps.InfoWindow({zIndex:1});

        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
            mapOption = {
                center: new kakao.maps.LatLng(37.533758199999944, 126.89699999999971), // 지도의 중심좌표
                level: 6, // 지도의 확대 레벨
                scrollwheel : false
            };  
            var map = new kakao.maps.Map(mapContainer, mapOption); 
       
        // 주소-좌표 변환 객체를 생성합니다
        var geocoder = new kakao.maps.services.Geocoder();

        // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
        var mapTypeControl = new kakao.maps.MapTypeControl();

        // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
        // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
        map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

        // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
        var zoomControl = new kakao.maps.ZoomControl();
        map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
       
        var coords = [];
        
        var imageSrc = 'resources/css/public/playground_assets/logo.png', // 마커이미지의 주소입니다    
            imageSize = new kakao.maps.Size(35, 35), // 마커이미지의 크기입니다
            imageOption = {offset: new kakao.maps.Point(8, 0)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
            
      // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)

      var marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(37.533758199999944, 126.89699999999971),
            image: markerImage 
        });

        var infowindow = new kakao.maps.InfoWindow({
                content: '<div style="width:150px;text-align:center;padding:6px 0;">KH정보교육원</div>'
            });
        infowindow.open(map, marker);
        <% for(Store s : list) {   %>
        console.log(1);
        // 주소로 좌표를 검색합니다
        geocoder.addressSearch('<%= s.getStoreAddress() %>', function(result, status) {
        /// console.log('<%= s.getStoreAddress() %>');
                // 정상적으로 검색이 완료됐으면 
        if (status === kakao.maps.services.Status.OK) {

            coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: coords,
                image: markerImage 
            });

            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new kakao.maps.InfoWindow({
                content: '<div style="width:150px;text-align:center;padding:6px 0;"><%= s.getStoreName() %></div>'
            });
            infowindow.open(map, marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
            kakao.maps.event.addListener(marker, 'click', function() {
            // 마커 위에 인포윈도우를 표시합니다
              document.location.href = '#<%= s.getStoreName() %>';
          });
        } 
        map.setCenter(new kakao.maps.LatLng(37.5182, 126.9124));

    });    
    <%  } %>

          </script>
        </div>
      </div>
    </div>
    
    
  <div>
      <link href="resources/css/category-filters5.css" rel="stylesheet"/>
      
	  <form id="keywordList-form" action="<%= contextPath %>/list.st?currentPage=1" method="get" >
	    <input type="hidden" name="currentPage" maxlength="12" value="1">
	  
      <div class="category-filters5-container">
        <div class="category-filters5-category-filters5">

          <div class="category-filters5-section-title">
            <span class="category-filters5-text HeadingH2">
              <span><h1>매장검색</h1></span>
            </span>
          </div>

          <div class="category-filters5-content" style="width: 1200px; margin-right: 0px;">
            <div class="category-filters5-row1">

              <div class="category-filters5-filter-two" style="width:150px;">
                <select name="" class="category-filters5-select2">
					      <option value="" selected>시/도</option>
	 				      <option value="서울특별시">서울특별시</option>
				        </select>
              </div>

              <div class="category-filters5-filter-three" style="width:150px;">
                <select name="" class="category-filters5-select2">
					      <option value="" selected>구/군</option>
	 				      <option value="영등포구">영등포구</option>
				        </select>
              </div>

              <div class="category-filters5-filter-four" style="width:150px; margin : 0px;">
                <select name="bname" class="category-filters5-select2">
                <option value="" selected>브랜드조회</option>
                <option value="BBQ">BBQ</option>
                <option value="BHC">BHC</option>
                <option value="교촌치킨">교촌치킨</option>
                <option value="처갓집양념치킨">처갓집양념치킨</option>
                <option value="페리카나">페리카나</option>
                <option value="네네치킨">네네치킨</option>
                <option value="굽네치킨">굽네치킨</option>
                <option value="멕시카나치킨">멕시카나치킨</option>
                <option value="푸호식이두마리치킨">호식이두마리치킨</option>
                <option value="또래오래">또래오래</option>
                <option value="지코바치킨">지코바치킨</option>
                <option value="푸라닭">푸라닭</option>
                <option value="60계치킨">60계치킨</option>
                <option value="바른치킨">바른치킨</option>
                <option value="노랑통닭">노랑통닭</option>
                <option value="맘스터치">맘스터치</option>
                <option value="훌랄라 참숯바베큐치킨">훌랄라 참숯바베큐치킨</option>
                <option value="치킨마루">치킨마루</option>
                <option value="또봉이통닭">또봉이통닭</option>
                </select>
              </div>		

			        <div>
				      <input type="text" name="keyword" class="category-filters5-select2" style="width: 200px; height: 23px; " placeholder="검색어를 입력하세요.">
              </div>
              <div>
              <button class="button" style="width: 70px; padding: 15px 5px; margin: 0px 0px 0px 48.5px !important; border-radius: 2px;" type="submit">검색</button>
              </div>

			      </div>
          </div>
				</div>
     	</div>
    </form> 
  </div>

    <div>
      <link href="resources/css/career17.css" rel="stylesheet" />

      <div class="career17-container">
        <div class="career17-career17" style="padding-top: 0px;" >
          <div class="career17-section-title">
            <span class="career17-text TextRegularSemiBold"></span>
          </div>
          <div class="career17-content1">
          
          <% for(Store s : list) { %>
            <a href="#map" style="text-decoration: none;">
            <div class="career17-card">
              <div class="career17-job">
                <span class="career17-text03 HeadingH5">
                  <span id="<%= s.getStoreName() %>"><b><%= s.getStoreName() %></b></span>
                </span>
                
                
                <table>
                <tr>
                <td>
                	<img
                    src="resources/css/public/playground_assets/iconpini146-ify4.svg"
                    alt="IconPinI146"
                    class="career17-icon-pin"/>
                    </td>
                   <td>
                  <span><%= s.getStoreAddress() %></span>
                  </td>
                  </tr>
                 </table>
              </div>
              
              <div class="career17-info">
                <table>
                  <tr>
                    <td>
                      <div class="career17-content3">
                        <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-telephone-fill" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                        </svg>
                        <span class="career17-text09 TextMediumNormal" style="margin-left: 10px;">
                        <span style="margin-left:5px;"><%= s.getStorePhone() %></span>
                        </span>
                      </div>
                    </td>
              
                    <td>
                      <div class="career17-content3" style="margin-left: 10px;">
                          <img
                            src="resources/css/public/playground_assets/iconclocki146-fjhq.svg"
                            alt="IconClockI146"
                            class="career17-icon-clock"
                          />
                          <span class="career17-text09 TextMediumNormal">
                          <span><%= s.getStoreTime() %></span>
                          </span>
                      </div>
                    </td>
                  </tr>
                </table>
              </div>
            </div>
          </a>
            <% } %>
            
          </div>
        </div>
      </div>
    </div>
    
        <br><br>
            
            <div align="center" class="paging-area">
            
            	<% if(currentPage != 1) { %>
            		 <button onclick="location.href = '<%= contextPath %>/list.st?currentPage=<%= currentPage - 1 %>&bname=<%= bname %>&keyword=<%= keyword %>';">
            		 	&lt;
            		 </button>
            	<% } %>
            	
            	<% for(int p = startPage; p <= endPage; p++) { %>
            		<% if(p != currentPage) {  %>
            			<button onclick="location.href = '<%= contextPath %>/list.st?currentPage=<%= p %>&bname=<%= bname %>&keyword=<%= keyword %>';">
           					<%= p %> 			
            			</button>
            		<% } else { %>
            			<button disabled><%= p %></button>
            		<% } %>
            	<% } %>
            
            	<% if(currentPage != maxPage) { %>
            		<button onclick="location.href = '<%= contextPath %>/list.st?currentPage=<%= currentPage + 1 %>&bname=<%= bname %>&keyword=<%= keyword %>';">
            			&gt;
            		</button>
            	<% } %>
            </div>
                  <%@ include file="../common/footer.jsp"%>
            
		 <!-- Site footer -->
   <!--  <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-sm-12 col-md-6">
            <h6>About</h6>
            <p class="text-justify">Scanfcode.com <i>CODE WANTS TO BE SIMPLE </i> is an initiative  to help the upcoming programmers with the code. Scanfcode focuses on providing the most efficient code or snippets as the code wants to be simple. We will help programmers build up concepts in different programming languages that include C, C++, Java, HTML, CSS, Bootstrap, JavaScript, PHP, Android, SQL and Algorithm.</p>
          </div>

          <div class="col-xs-6 col-md-3">
            <h6>Categories</h6>
            <ul class="footer-links">
              <li><a href="http://scanfcode.com/category/c-language/">C</a></li>
              <li><a href="http://scanfcode.com/category/front-end-development/">UI Design</a></li>
              <li><a href="http://scanfcode.com/category/back-end-development/">PHP</a></li>
              <li><a href="http://scanfcode.com/category/java-programming-language/">Java</a></li>
              <li><a href="http://scanfcode.com/category/android/">Android</a></li>
              <li><a href="http://scanfcode.com/category/templates/">Templates</a></li>
            </ul>
          </div>

          <div class="col-xs-6 col-md-3">
            <h6>Quick Links</h6>
            <ul class="footer-links">
              <li><a href="http://scanfcode.com/about/">About Us</a></li>
              <li><a href="http://scanfcode.com/contact/">Contact Us</a></li>
              <li><a href="http://scanfcode.com/contribute-at-scanfcode/">Contribute</a></li>
              <li><a href="http://scanfcode.com/privacy-policy/">Privacy Policy</a></li>
              <li><a href="http://scanfcode.com/sitemap/">Sitemap</a></li>
            </ul>
          </div>
        </div>
        <hr>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            <p class="copyright-text">Copyright &copy; 2017 All Rights Reserved by 
         <a href="#">Scanfcode</a>.
            </p>
          </div>

          <div class="col-md-4 col-sm-6 col-xs-12">
            <ul class="social-icons">
              <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
              <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
              <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
              <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>   
            </ul>
          </div> 
        </div>
      </div>
</footer>-->
		
  	</body>
</html>