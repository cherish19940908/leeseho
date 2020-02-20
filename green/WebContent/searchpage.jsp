<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="vo.DTO_AD"%>
<%@page import="vo.PageInfo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="css/gpstyle2.css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="shortcut icon"
	href="http://simbyone.com/wp-content/uploads/2014/04/3455e6f65c33232a060c28829a49b1cb.png">
<title>Animated Header with scroll</title>

<link
	href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic'
	rel='stylesheet' type='text/css'>

<link href="css/Icomoon/style.css" rel="stylesheet" type="text/css" />
<link href="css/animated-header.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="_scripts/jquery-2.0.2.min.js"></script>
<script type="text/javascript" src="_scripts/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript" src="_scripts/jquery.isotope.min.js"></script>
<script type="text/javascript" src="_scripts/animated-header.js"></script>

<link rel="stylesheet" type="text/css" href="css/loginstyle.css" />
<script type="text/javascript" src="_scripts/login.js"></script>
</head>
<body>
	<%
		PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
		int listCount = pageInfo.getListCount();
		int nowPage = pageInfo.getPage();
		int maxPage = pageInfo.getMaxPage();
		int startPage = pageInfo.getStartPage();
		int endPage = pageInfo.getEndPage();
	%>

	<%
		int pageNumber = 1; //1 이라는 것은 기본 적으로 1페이지를 의미하는거에요 무슨 페이지든 1페이지는 있으닌까
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber")); //파라디터는 이런식으로 타입을 변경시켜주는 함수를 사용해야한다.
		}
	%>


	<%@include file="header.jsp"%>
	<nav>
		<%@include file="nav.jsp"%>
	</nav>

	<%
		ArrayList<DTO_AD> articleList = (ArrayList<DTO_AD>) request.getAttribute("articleList");
	%>

	<section style="margin-top: 60px">




		<div style="width: 1920px;">
			<div
				style="width: 1315px; min-height: 800px; float: left; position: relative; left: 200px;">
				<%
					for (int i = 0; i < articleList.size(); i++) {
				%>


				<table>
					<tr>
						<div style="width: 1316px; height: 255px; margin-top: 30px">
							<div
								style="margin-left: 243px; border-bottom : solid 1px;border-color:#dbdbdb; width: 66%; min-height: 283px;">

								<a href="restaurantDetail.bo?rnum=<%=articleList.get(i).getRnum()%>&page=<%=nowPage%>"><span
									style="position: relative; top: 25px;"><img
										src="restaurantUpload/<%=articleList.get(i).getFile()%>"
										style="width: 340px;height: 220px;"></span></a> <span
									style="width: 200px; height: 50px; position: relative; left: 35px; bottom: 180px; font-size: 35px;"><%=articleList.get(i).getStore()%></span>
								<span
									style="position: relative; left: 46px; bottom: 180px; font-size: 44px; color: green;">4.5</span>
								<div
									style="position: relative; left: 380px; bottom: 180px; font-size: 17px;"><%=articleList.get(i).getHome()%>
									<%=articleList.get(i).getDethome()%>
								</div>
								<span style = "position : relative; left : 822px ;bottom :248px; font-size : 20px"><img src="img/readcount.png" style ="width: 20px;"> &nbsp;<%= articleList.get(i).getReadcount()%></span>
								<span style = "position : relative; left: 715px; bottom:10px;"><%=articleList.get(i).getStore() %> 더보기 ></span>


							</div>
						</div>

					</tr>
				</table>
				<%
					}
				%>
				<div style="text-align: center; margin-top: 70px">
					<section id="pageList">
						<%
							if (nowPage <= 1) {
						%>
						[이전]&nbsp;
						<%
							} else {
						%>
						<a href="restaurantList.bo?page=<%=nowPage - 1%>">[이전]</a>&nbsp;
						<%
							}
						%>

						<%
							for (int a = startPage; a <= endPage; a++) {
								if (a == nowPage) {
						%>
						[<%=a%>]
						<%
							} else {
						%>
						<a href="restaurantList.bo?page=<%=a%>">[<%=a%>]
						</a>&nbsp;
						<%
							}
						%>
						<%
							}
						%>

						<%
							if (nowPage >= maxPage) {
						%>
						[다음]
						<%
							} else {
						%>
						<a href="restaurantList.bo?page=<%=nowPage + 1%>">[다음]</a>
						<%
							}
						%>
					</section>
				</div>

			</div>

			<div id="section-right"
				style="width: 375px; display: inline-block; position: relative; left: 200px;">

				<div id="daumRoughmapContainer1576047049962"
					class="root_daum_roughmap root_daum_roughmap_landing"></div>
				<script charset="UTF-8" class="daum_roughmap_loader_script"
					src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

				<script charset="UTF-8">
					new daum.roughmap.Lander({
						"timestamp" : "1576047049962",
						"key" : "w7hx",
						"mapWidth" : "350",
						"mapHeight" : "450"
					}).render();
				</script>
				
				<div id="con">
					<img src="img/con-1.jpg">
				</div>
				<div id="con">
					<img src="img/con-2.jpg">
				</div>
				<div id="con">
					<img src="img/con-3.jpg">
				</div>

			</div>
		</div>

	</section>


	<%@include file="footer.jsp"%>


	</div>

</body>
</html>
