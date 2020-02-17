<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.io.PrintWriter"%>
<%@page import="vo.ReviewBean"%>
<%
ReviewBean article = (ReviewBean) request.getAttribute("article");
	String nowPage = (String) request.getAttribute("page");
%>



<html lang="en">
<head>
<meta http-equiv="Content-Tpye" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" minitial-scale="1">
<link rel="stylesheet" type="text/css" href="css/boardstyle.css">
<link rel="stylesheet" type="text/css" href="css/gpstyle2.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="shortcut icon"
	href="http://simbyone.com/wp-content/uploads/2014/04/3455e6f65c33232a060c28829a49b1cb.png">

<link rel="stylesheet" type="text/css" href="css/loginstyle.css" />

<title>그린플레이트 게시판</title>
<link
	href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic'
	rel='stylesheet' type='text/css'>

<link href="css/Icomoon/style.css" rel="stylesheet" type="text/css" />
<link href="css/animated-header.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="_scripts/jquery-2.0.2.min.js"></script>
<script type="text/javascript" src="_scripts/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript" src="_scripts/jquery.isotope.min.js"></script>
<script type="text/javascript" src="_scripts/animated-header.js"></script>

<script type="text/javascript" src="_scripts/login.js"></script>

</head>
<body>
	<%
		String origfilename = (String) session.getAttribute("origfilename");	
	%>


	<%@include file="header.jsp"%>

	<nav>
		<img src="img\board_nav_img.jpg" style="width: 100%">
	</nav>
	<section style="min-height: 535px; width: 100%;">
		<div style="width: 800px; margin-left: 520px; margin-top: 114px">
			<div class="row">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd;">
					<thead>
						<tr>
							<th colspan="3"
								style="background-color: #eeeeee; text-align: center">Q&A글보기
								</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="width: 10%;">글 제목</td>
							<td colspan="2"><%=article.getRtitle().replaceAll("", "&nbsp").replaceAll("<", "&gt").replaceAll(">", "&gt")%></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td colspan="2"><%=article.getNick()%></td>
						</tr>
						<tr>
							<td>지역</td>
							<td colspan="2"><%=article.getLocation()%></td>
						</tr>

						<tr>
							<td>작성일</td>
							<td colspan="2"><%=article.getDate()%></td>
						</tr>
						<tr>
							<td>조회수</td>
							<td colspan="2"><%=article.getReadcount()%></td>
						</tr>
						<tr>
							<td>첨부파일</td>
							<td colspan="2">
								<%
									if (!(article.getRfile() == null)) {
								%> 
								<a
								href="file_down.jsp?downFile=<%=article.getRfile()%>">
									<%=article.getRfile()%>
							   </a> <%
                                    	}
                                 %>
							</td>
						</tr>
						<tr>
							<td>내용</td>
							<td colspan="2" style="min-height: 100px; text-align: left"><%=article.getRcontent().replaceAll("", "&nbsp").replaceAll("<", "&gt").replaceAll(">", "&gt") %></td>
						</tr>
					</tbody>
				</table>
				
				<%
					if (id != null) {
				
			  %>
			<a class="btn btn-success" style="color: white"
			href="reviewModifyForm.bo?board_num=<%=article.getRnum() %>">
			수정 </a> <a class="btn btn-success" style="color: white"
			href="reviewDeleteForm.bo?board_num=<%=article.getRnum() %>&page=<%=nowPage%>">
			삭제 </a> <a href="reviewList.bo?page=<%=nowPage%>" class="btn btn-success" style="color: white">목록</a>&nbsp;&nbsp;
				<%
					}
				%>

			</div>
		</div>
	</section>
	<%@include file="footer.jsp"%>
</body>
</html>



