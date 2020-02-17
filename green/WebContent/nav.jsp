<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	function total_check() {

		var type = null;
		var price = null;
		var location = null;

		for (var i = 0; i <= 16; i++) {
			if (search.location[i].checked) {
				location = search.location[i].value
			}
		}
		for (var t = 0; t <= 5; t++) {
			if (search.type[t].checked) {
				type = search.location[t].value
			}
		}
		for (var p = 0; p <= 3; p++) {
			if (search.price[p].checked) {
				price = search.price[p].value
			}
		}

		if (location == null) {
			alert("지역을 선택하세요")
		} else if (type == null) {
			alert("음식타입을 선택하세요")
		} else if (price == null) {
			alert("금액대를 선택하세요")
		} else {
			document.search.submit();
		}

	}
</script>
</head>
<body>
	<FORM action="restaurantList.bo" method="post" name="search">
		<div id="location">
			<div id="location-bar">
				<h2 id="ul-margin">지역선택</h2>
			</div>
			<div id="location-li">
				<div id="dd">
					<div class="boxes">
						<ul>
							<li><input type="checkbox" id="box-1" name="location"
								value="서울"> <label for="box-1">서울</label></li>
							<li><input type="checkbox" id="box-2" name="location"
								value="경기"> <label for="box-2">경기</label></li>
							<li><input type="checkbox" id="box-3" name="location"
								value="인천"> <label for="box-3">인천</label></li>
							<li><input type="checkbox" id="box-4" name="location"
								value="강원"> <label for="box-4">강원</label></li>
							<li><input type="checkbox" id="box-5" name="location"
								value="대전"> <label for="box-5">대전</label></li>
							<li><input type="checkbox" id="box-6" name="location"
								value="세종"> <label for="box-6">세종</label></li>
							<li><input type="checkbox" id="box-7" name="location"
								value="충남"> <label for="box-7">충남</label></li>
							<li><input type="checkbox" id="box-8" name="location"
								value="충북"> <label for="box-8">충북</label></li>
							<li><input type="checkbox" id="box-9" name="location"
								value="부산"> <label for="box-9">부산</label></li>
							<li><input type="checkbox" id="box-10" name="location"
								value="울산"> <label for="box-10">울산</label></li>
							<li><input type="checkbox" id="box-11" name="location"
								value="경남"> <label for="box-11">경남</label></li>
							<li><input type="checkbox" id="box-12" name="location"
								value="경북"> <label for="box-12">경북</label></li>
							<li><input type="checkbox" id="box-13" name="location"
								value="대구"> <label for="box-13">대구</label></li>
							<li><input type="checkbox" id="box-14" name="location"
								value="광주"> <label for="box-14">광주</label></li>
							<li><input type="checkbox" id="box-15" name="location"
								value="전남"> <label for="box-15">전남</label></li>
							<li><input type="checkbox" id="box-16" name="location"
								value="전북"> <label for="box-16">전북</label></li>
							<li><input type="checkbox" id="box-17" name="location"
								value="제주"> <label for="box-17">제주</label></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="menu">
			<div id="location-bar">
				<h2 id="ul-margin">메뉴선택</h2>
			</div>
			<div id="menu-bar">
				<div id="dd">
					<div class="boxes">
						<ul id="menu-ul">
							<li><input type="checkbox" id="menu-1" name="type"
								value="한식"> <label for="menu-1"><img
									src="img\han-yes.jpg"></label></li>
							<li><input type="checkbox" id="menu-2" name="type"
								value="중식"> <label for="menu-2"><img
									src="img\ch-yes.jpg"></label></li>
							<li><input type="checkbox" id="menu-3" name="type"
								value="일식"> <label for="menu-3"><img
									src="img\j-yes.jpg"></label></li>

						</ul>
					</div>
				</div>
			</div>
			<div id="menu-bar">
				<div id="dd">
					<div class="boxes">
						<ul id="menu-ul">
							<li><input type="checkbox" id="menu-4" name="type"
								value="양식"> <label for="menu-4"><img
									src="img\yang-yes.jpg"></label></li>
							<li><input type="checkbox" id="menu-5" name="type"
								value="세계음식"> <label for="menu-5"><img
									src="img\world-yes.jpg"></label></li>
							<li><input type="checkbox" id="menu-6" name="type"
								value="뷔페"> <label for="menu-6"><img
									src="img\v-yes.jpg"></label></li>

						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="price-recommend">
			<div id="location-bar" style="position: relative; right: 150px;">
				<h2 id="ul-margin">가격대</h2>
			</div>
			<div id="price-bar">
				<div id="dd">
					<div class="boxes">
						<ul id="menu-ul">
							<li><input type="checkbox" id="price-1" name="price"
								value="만원이하"> <label for="price-1"><img
									src="img\1-yes.jpg"></label></li>
							<li><input type="checkbox" id="price-2" name="price"
								value="1만원대"> <label for="price-2"><img
									src="img\2-yes.jpg"></label></li>

						</ul>
					</div>
				</div>
			</div>
			<div id="price-bar">
				<div id="dd">
					<div class="boxes">
						<ul id="menu-ul">

							<li><input type="checkbox" id="price-3" name="price"
								value="2만원대"> <label for="price-3"><img
									src="img\3-yes.jpg"></label></li>
							<li><input type="checkbox" id="price-4" name="price"
								value="3만원대"> <label for="price-4"><img
									src="img\4-yes.jpg"></label></li>
						</ul>
					</div>
				</div>
			</div>

			<input type="button" id="button-box" value="검색"
				onClick="total_check()">
	</FORM>
</body>
</html>