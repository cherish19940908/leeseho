<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.DTO_AD"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>GreenPlate</title>


<link rel="stylesheet" type="text/css" href="css/gpstyle2.css">
<link rel="stylesheet" type="text/css" href="css/menubar.css">
<link rel="stylesheet" type="text/css" href="css/gp.css" />
<link rel="stylesheet" type="text/css"
	href="slick-1.8.1/slick/slick.css" />
<link rel="stylesheet" type="text/css"
	href="slick-1.8.1/slick/slick-theme.css" />
<link rel="stylesheet" type="text/css" href="css/loginstyle.css" />

<link rel="stylesheet"
	href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="shortcut icon"
	href="http://simbyone.com/wp-content/uploads/2014/04/3455e6f65c33232a060c28829a49b1cb.png">
<link rel='stylesheet' type='text/css'
	href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic'>

<link rel="stylesheet" type="text/css" href="css/Icomoon/style.css" />
<link rel="stylesheet" type="text/css" href="css/animated-header.css" />

<script type="text/javascript" src="_scripts/jquery-2.0.2.min.js"></script>
<script type="text/javascript" src="_scripts/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript" src="_scripts/jquery.isotope.min.js"></script>
<script type="text/javascript" src="_scripts/animated-header.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script type="text/javascript" src="slick-1.8.1/slick/slick.min.js"></script>
<script type="text/javascript" src="slick-1.8.1/slick/slick.js"
	charset="utf-8"></script>
<script type="text/javascript" src="_scripts/login.js"></script>
<style>
#asd {
	width: 100%;
	height: 277px;
	z-index: 100;
	margin-top: 34px;
	border-bottom:1px;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<div id="asd"></div>
	<div id="section">
		<table>
			<%
				if (request.getAttribute("toplist") != null) {
					ArrayList<DTO_AD> articleList = (ArrayList<DTO_AD>) request.getAttribute("toplist");
					for (int i = 0; i < articleList.size(); i++) {
			%>
			<tr>
				<td><%=articleList.get(i).getStore()%></td>
				<td><%=articleList.get(i).getHome()%></td>
				<td><%=articleList.get(i).getContent()%></td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</div>


	<%@include file="footer.jsp"%>
</body>
</html>