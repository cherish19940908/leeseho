<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<head>
<title>GreenPlate</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


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
#korbtn {
	background-image: url('img/kor.jpg');
	background-size: cover;
	margin: 0 auto;
	width: 95%;
	display: block;
	padding: 0;
	height: 250px;
	border: 0;
}
</style>


</head>
<body>

	<%@include file="header.jsp"%>
	<nav>


		<%@include file="nav.jsp"%>

	</nav>

	<div id="wrap_">
		<div id="slider1">
			<form name="toplist" method="post" action="top.do?command=top">
				<div class="list">

					<div>
						<img src="img/editor.jpg">
					</div>

					<div>
						<img src="img/good10.jpg">
					</div>

					<div>
						<input type="hidden" name="type" value="한식"> <input
							type="submit" id="korbtn" value="">
					</div>

					<div>
						<img src="img/jokparty.jpg">
					</div>

					<div>
						<img src="img/porkparty.jpg">
					</div>

					<div>
						<img src="img/editor.jpg">
					</div>

					<div>
						<img src="img/good10.jpg">
					</div>

					<div>
						<a href="gpserchpage.jsp"><img src="img/week.jpg"></a>
					</div>

					<div>
						<img src="img/jokparty.jpg">
					</div>

					<div>
						<img src="img/porkparty.jpg">
					</div>

				</div>
				<script type="text/javascript">
					$('.list').slick({
						dots : true,
						infinite : true,
						slidesToShow : 4,
						slidesToScroll : 4,
						autoplay : true,
						autoplaySpeed : 3000

					});
				</script>
			</form>
		</div>
		<div id="slider2">
			<div class="party">

				<div>
					<img src="img/editor.jpg">
				</div>

				<div>
					<img src="img/good10.jpg">
				</div>

				<div>
					<img src="img/week.jpg">
				</div>

				<div>
					<img src="img/jokparty.jpg">
				</div>

				<div>
					<img src="img/porkparty.jpg">
				</div>

				<div>
					<img src="img/editor.jpg">
				</div>

				<div>
					<img src="img/good10.jpg">
				</div>

				<div>
					<img src="img/week.jpg">
				</div>

				<div>
					<img src="img/jokparty.jpg">
				</div>

				<div>
					<img src="img/porkparty.jpg">
				</div>

			</div>
			<script type="text/javascript">
				$('.party').slick({
					dots : true,
					infinite : true,
					slidesToShow : 4,
					slidesToScroll : 4,
					autoplay : true,
					autoplaySpeed : 3000

				});
			</script>
		</div>




		<%@include file="footer.jsp"%>



	</div>
</body>

</html>
