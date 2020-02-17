<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<head>
<title>Restaurant</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/gpstylerestau.css">
<link rel="stylesheet" type="text/css" href="css/loginstyle.css" />
<link rel="stylesheet" type="text/css" href="css/restaurant.css" />
<link rel="stylesheet"
	href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel='stylesheet' type='text/css'
	href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic'>

<link rel="stylesheet" type="text/css" href="css/Icomoon/style.css" />
<link rel="stylesheet" type="text/css" href="css/animated-header.css" />

<script type="text/javascript" src="_scripts/jquery-2.0.2.min.js"></script>
<script type="text/javascript" src="_scripts/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript" src="_scripts/jquery.isotope.min.js"></script>
<script type="text/javascript" src="_scripts/animated-header.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="_scripts/login.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("sample6_extraAddress").value = extraAddr;

						} else {
							document.getElementById("sample6_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("sample6_detailAddress")
								.focus();
					}
				}).open();
	}
</script>
<script>
  
    //=================입력 Ajax
	function datdung() {
		if (party.content.value == "") {
			alert("댓글을 입력하여주십시오.");
		} else {
			callAjax();
		}
	}
	function callAjax() {
		$.ajax({
			type : "post",
			url : "./review.jsp",
			data : {
				content : $('#content').val(),
				nick : $('#nick').val(),
				pyung : $('#pyung').val()
			},
			success : whenSuccess,
			error : whenError
		});
	}
	function whenSuccess(resdata) {
		alert("댓글이 입력되었습니다.");
		$("#datgul").html(resdata);
		$('#content').val("");
		$('#pyung').val("맛있어요");
	}
	function whenError() {
		alert("Error");
	}
	//=================평가별 정렬 Ajax
	function callAjaxP(s) {
		$.ajax({
			type : "post",
			url : "./reviewP.jsp",
			data : {
				pyung : s
			},
			success : whenSuccessP,
			error : whenErrorP
		});
	}
	function whenSuccessP(resdata) {
		$("#datgul").html(resdata);
	}
	function whenErrorP() {
		alert("Error");
	}
	//=================전체 정렬 Ajax
	function callAjaxALL() {
		$.ajax({
			type : "post",
			url : "./review2.jsp",
			data : {
			},
			success : whenSuccessALL,
			error : whenErrorALL
		});
	}
	function whenSuccessALL(resdata) {
		$("#datgul").html(resdata);
	}
	function whenErrorALL() {
		alert("Error");
	}
	
</script>
</head>
<body>
	<%@include file="header.jsp"%>


	<section style="background:#f6f6f6;">
		<form name="party">
			<div style="width: 1900px; height: 86px; align: center;"></div>
			<div class="section">
				<div class="section" style="width: 300px"></div>
				<!--  =================================================================-->
				<div id="conta">
					<div class="jumbotron" style="margin-bottom: 10px;">
						<h1>
							정돈 <font color="orange">4.5</font>
						</h1>

						<p class="lead">서울 강남구 강남대로110길 26 1층 (지번) 역삼동 811-4</p>
						<p>
							<img src="img/wannago1.png" width="85px;" height="85px;" /> <a
								class="btn btn-success" href="#" role="button">예약하기</a>
						</p>
					</div>

					<div class="restaur">
						<div id="restau2">
							<img src="img\jung1.jpg" width="300px" height="250px"> <img
								src="img\jung2.jpg" width="300px" height="250px">
						</div>
						<div class="restauinfo">
							<h4>음식종류</h4>
							<p>까스 요리</p>

							<h4>식당 주소</h4>
							<p>
								서울 강남구 강남대로110길 26 1층<br> (지번) 역삼동 811-4
							</p>

							<h4>전화번호</h4>
							<p>02-563-0924</p>

							<h4>주차 여부</h4>
							<p>주차공간없음</p>
						</div>
						<div class="restauinfo">
							<h4>영업시간</h4>
							<p>11:30 - 22:00</p>

							<h4>쉬는시간</h4>
							<p>14:00 - 17:00</p>

							<h4>마지막 주문</h4>
							<p>21:00</p>

							<h4>가격대</h4>
							<p>만원-2만원</p>
						</div>

					</div>
				</div>
				<!--  =================================================================-->
				<div class="datdat">
					<div style="text-align: center;">
						<input type="hidden" id="nick" name="nick" value="haha" />
						<textarea style="height: 30px; width: 598px;" rows="2"
							placeholder="한줄 평을 남겨주세요." name="content"
							onfocus="this.placeholder = ''" id="content"
							onblur="this.placeholder = '한줄 평을 남겨주세요.'" style="border : none"></textarea>
					</div>
					<div style="border: solid 0px; text-align: center;">
						<select name="pyung" id="pyung">
							<option value="맛있어요">맛있어요</option>
							<option value="괜찮아요">괜찮아요</option>
							<option value="별로예요">별로예요</option>
						</select>
						<button type="button" class="btn btn-success"
							style="width: 500px;" id="datdu" name="datdu" onclick="datdung()">댓글
							등록</button>
					</div>
					<div class="button"
						style="clear: right; margin: 50px 20px 0px 0px; border: solid 0px;">
						<button type="button" class="btn btn-success" onclick="callAjaxP('별로예요')">별로예요</button>
					</div>
					<div class="button"
						style="float: right; margin: 50px 20px 0px 0px; border: solid 0px;">

						<button type="button" class="btn btn-success" onclick="callAjaxP('괜찮아요')" >괜찮아요</button>
					</div>
					<div class="button"
						style="float: right; margin: 50px 20px 0px 0px; border: solid 0px;">

						<button type="button" class="btn btn-success" onclick="callAjaxP('맛있어요')" >맛있어요</button>
					</div>
					<div class="button"
						style="float: right; margin: 50px 0px 0px 0px; border: solid 0px;">

						<button type="button" class="btn btn-success" onclick="callAjaxALL()">전체</button>
					</div>
				</div>
				<div id="datgul">
				   <%@include file="review2.jsp"%>
				</div>
			</div>



			<!--  ========================오른쪽=========================================-->

			<div id="resta" background="">
				<div id="map">
					<!-- * 카카오맵 - 지도퍼가기 -->
					<!-- 1. 지도 노드 -->
					<div id="daumRoughmapContainer1576114191754"
						class="root_daum_roughmap root_daum_roughmap_landing"></div>

					<!--
	2. 설치 스크립트
	* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
-->
					<script charset="UTF-8" class="daum_roughmap_loader_script"
						src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

					<!-- 3. 실행 스크립트 -->
					<script charset="UTF-8">
						new daum.roughmap.Lander({
							"timestamp" : "1576114191754",
							"key" : "w7sd",
							"mapWidth" : "500",
							"mapHeight" : "418"
						}).render();
					</script>
				</div>

				<div id="recommand">
					<div id="rt">주변 인기 식당</div>
					<div class="res">
						<div class="pic"></div>

						<div class="rescontent">
							<div class="retitle">족발</div>
							<div class="rename">식당이름 : 족발족발</div>
							<div class="reva">음식 종류 : 족발</div>
							<div class="relo">식당 위치 : 강남</div>
							<div class="repri">가격대 : 인당 12000원</div>
						</div>
					</div>
					<div class="res">
						<div class="pic"></div>
						<div class="rescontent">
							<div class="retitle">족발</div>
							<div class="rename">식당이름 : 족발족발</div>
							<div class="reva">음식 종류 : 족발</div>
							<div class="relo">식당 위치 : 강남</div>
							<div class="repri">가격대 : 인당 12000원</div>
						</div>
					</div>
					<div class="res">
						<div class="pic"></div>
						<div class="rescontent">
							<div class="retitle">족발</div>
							<div class="rename">식당이름 : 족발족발</div>
							<div class="reva">음식 종류 : 족발</div>
							<div class="relo">식당 위치 : 강남</div>
							<div class="repri">가격대 : 인당 12000원</div>
						</div>
					</div>
				</div>
			</div>

		</form>
	</section>

	<%@include file="footer.jsp"%>
</body>

</html>
