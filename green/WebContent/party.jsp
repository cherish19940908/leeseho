<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String han =URLEncoder.encode("한식","UTF-8");
String j =URLEncoder.encode("중식","UTF-8");
String y =URLEncoder.encode("양식","UTF-8");
String ja =URLEncoder.encode("일식","UTF-8");
String w =URLEncoder.encode("세계음식","UTF-8");
String v =URLEncoder.encode("뷔페","UTF-8");
%>
<head>
<title>Party</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/gpstyleparty.css">
<link rel="stylesheet" type="text/css" href="css/loginstyle.css"/>
<link rel="stylesheet" type="text/css" href="css/party.css"/>

<link rel='stylesheet' type='text/css'
	href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic'>

<link rel="stylesheet" type="text/css" href="css/Icomoon/style.css" />
<link rel="stylesheet" type="text/css" href="css/animated-header.css" />
<script type="text/javascript" src="_scripts/jquery-2.0.2.min.js"></script>
<script type="text/javascript" src="_scripts/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript" src="_scripts/jquery.isotope.min.js"></script>
<script type="text/javascript" src="_scripts/animated-header.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="_scripts/login.js"></script>
<script type="text/javascript" src="scripts/party.js"></script>



</head>
<body>
	
<%@include file = "header.jsp"%>

<section>
<div style="width:100%px; height:86px;">
</div>
<article>
</article>
<div id="ptitle">
<img src="img/ptitle.jpg" width="100%;" height="100%;">
</div>
<div id="pic">
<div id="section">

<div class="picbox">
<a href = "sang.do?command=select_han&cate=<%=han%>"><div class="partypic" name="sam">
<div id="samsin" valign="middle" align="center">안녕하세요.</div>
</div></a>
<div class="pictitle">
파티제목
</div>
</div>

<div class="picbox">
<a href = "sang.do?command=select_j&cate=<%=j%>"><div class="partypic" name="jock">
<div id="jocksin" valign="middle" align="center">안녕하세요.</div>
</div></a>
<div class="pictitle">
파티제목
</div>
</div>

<div class="picbox">
<a href = "sang.do?command=select_y&cate=<%=y%>"><div class="partypic" name="bos">
<div id="bossin" valign="middle" align="center">안녕하세요.</div>
</div></a>
<div class="pictitle">
파티제목
</div>
</div>

<div class="picbox">
<a href = "sang.do?command=select_ja&cate=<%=ja%>"><div class="partypic" name="chi">
<div id="chisin" valign="middle" align="center">안녕하세요.</div>
</div></a>
<div class="pictitle">
파티제목
</div>
</div>

<div class="picbox">
<a href = "sang.do?command=select_w&cate=<%=w%>"><div class="partypic" name="bang">
<div id="bangsin" valign="middle" align="center">안녕하세요.</div>
</div></a>
<div class="pictitle">
파티제목
</div>
</div>

<div class="picbox">
<a href = "sang.do?command=select_v&cate=<%=v%>"><div class="partypic" name="gob">
<div id="gobsin" valign="middle" align="center">안녕하세요.</div>
</div></a>




</div>

</div>
</div>

</section>

<%@include file = "footer.jsp"%>

</body>

</html>
