<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="css/board_write_style.css">
<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/gpstyle2.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="http://simbyone.com/wp-content/uploads/2014/04/3455e6f65c33232a060c28829a49b1cb.png">
<title>그린플레이트 게시판</title>
<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>

<link href="css/Icomoon/style.css" rel="stylesheet" type="text/css" />
<link href="css/animated-header.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="_scripts/jquery-2.0.2.min.js"></script>
<script type="text/javascript" src="_scripts/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript" src="_scripts/jquery.isotope.min.js"></script>
<script type="text/javascript" src="_scripts/animated-header.js"></script>

<link rel="stylesheet" type="text/css" href="css/loginstyle.css"/>
<script type="text/javascript" src="_scripts/login.js"></script>


<link rel="stylesheet" type="text/css" href="css/boardstyle.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic'rel='stylesheet'type='text/css'>

</head>
<body>


	
		<%@include file = "header.jsp"%>

		<nav>
			<img src="img\board_nav_img.jpg" style ="width : 100%">
		</nav>

		<section style = "min-height: 648px">
		<div id ="write-bar">
		<form class="form-horizontal" role="form" action="reviewWritePro.bo"
				method="post" enctype="multipart/form-data" name="boardform">
	<div class="form-group">
		<label for="rtitle" class="col-sm-2 control-label">제목</label>
		<div class="col-sm-10">
			<input type="text" class="form-control"  name="rtitle" placeholder="게시글 제목을 입력하세요" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="rpass" class="col-sm-2 control-label">비밀번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control"  name="rpass" placeholder="게시글 비밀번호을 입력하세요" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="rnick" class="col-sm-2 control-label">작성자</label>
		<div class="col-sm-10">
			<input type="text" class="form-control"  name="nick"  value="<%=nick%>"Readonly>
			<input type="hidden" value = "<%=id%>" name = "id">
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">지역</label>
		<div class="col-sm-10">
		<div class="form-control">
		   <select style ="width: 100%; border: none;" name="location">
		   <option>서울</option>
		   <option>경기</option>
		   <option>인천</option>
		   <option>강원</option>
		   <option>대전</option>
		   <option>충남</option>
		   <option>충붑</option>
		   <option>세종</option>
		   <option>부산</option>
		   <option>울산</option>
		   <option>경남</option>
		   <option>경북</option>
		   <option>울산</option>
		   <option>대구</option>
		   <option>광주</option>
		   <option>전남</option>
		   <option>전북</option>
		   <option>제주</option>   
		   </select>
		   </div>
			<!--  <input type="text" class="form-control"  name="location" placeholder="지역을 작성해 주세요" value="">-->
		</div>
	</div>
	
	<div class="form-group">
		<label for="rcontent" class="col-sm-2 control-label">게시글</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="10" name="rcontent"></textarea>
		</div>
	</div>
	<div class="form-group"> 
		<label for="rfile" class="col-sm-2 control-label">첨부파일</label>
		<div class="col-sm-10">
			<input type="file" class="form-control"  name="rfile" id = "rfile">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<input type="submit" class="btn btn-success" style ="color : white" id ="write_button" value="작성완료">
		</div>
	</div>
	

	</div>
</form>

		 
		</section>
		<footer style = "margin-top : 1px;">
	<%@include file = "footer.jsp"%>
</footer>

	

</body>
</html>
