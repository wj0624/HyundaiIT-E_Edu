 function myFunc(){
	
	// 이전 내용 비우고 새로운 검색내용 보여주기
	$("tbody").empty();
	
	// 입력한 날짜 가지고 오기
	var date = $("#selectedDate").val();
	// 날짜 포맷 yyyy-mm-dd 에서 yyyymmdd로 변경
	targetDate = date.split('-').join('');
	
	// 서버쪽 프로그램 호출하는 코드
	// 영화진흥위원회의 일일 박스오피스 순위를 알아오는 Open API 이용
	// jQuery로 AJAX를 어떻게 이용할 수 있나요?
	
	// 실행시에 여러가지 정보를 줘야 실행 가능함
	// 실행시 필요한 정보를 자바스크립트 객체로 표현(literal)해서
	// ajax()함수의 인자로 넣어주면 됨
	$.ajax({
		async: true, // 비동기로 호출 (default)
		
		// url은 AJAX로 호출할 서버쪽 프로그램의 url을 문자열로 명시
		url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
		
		// 서버쪽 프로그램 호출 방식 지정
		type: "GET",
		
		// 서버쪽 프로그램 호출시 전달해야 하는 데이터
		// 영화진흥위원회 필수 요청데이터 key, targetDt()
		data: {
			key: "1b35bbbc4a552425b80fed781ecd87ba",
			targetDt: targetDate
		},
		
		// 서버쪽 프로그램 수행을 기다리는 시간
		// 만약 이 시간 안에(ms) 서버로부터 응답이 오지 않으면
		// 이 호출은 실패한 것으로 간주
		timeout: 3000,
		
		// dataType : "json" -> jQuery가 JavaScript 객체로 자동 변환
		// 서버로부터 전달되는 데이터는 JSON 문자열
		// 이 문자열을 적절히 parsing해서 프로그램에서 사용해야 함
		// 현재 JavaScript를 사용하고 있기 때문에
		// JSON문자열을 아주 간편하게 JavaScript객체로 변환 가능
		// 원래 이 작업을 프로그램 작성하는 사람이 해줘야 함
		// 그런데 jQuery는 이 작업을 자동으로 진행해줌
		dataType: "json",
		
		
		// 성공했을 때
		success: function(result) {
			
			// 성공했다면 서버로부터 JSON 가져와서 객체로 변환시켰음
			// 해당 결과 객체가 함수의 인자로 전달 됨
			// var title = result.boxOfficeResult.dailyBoxOfficeList[0].movieNm
			
			// arr 배열에 해당 날짜에 대한 영화 리스트 저장
			var arr = result.boxOfficeResult.dailyBoxOfficeList;
			
			// 이렇게 데이터를 받아와서 jQuery를 이용해서 element를 생성한 후
			// 화면에 붙여서 결과를 표현
			
			// 불러온 영화리스트에 대해 반복문 수행
			$.each(arr, function(idx, item){
				// 영화 정보 저장 객체
				var obj ={
					rank : item.rank,
				 	title : item.movieNm,
				 	openDt : item.openDt,
				 	audiAcc : item.audiAcc
				}
				
				// 행 생성 후 해당 행에 각 정보를 열로 집어 넣음
				var tr = $("<tr></tr>");
				tr.append($("<td></td>").text(obj.rank));
				// 비동기이므로 rank를 id로 설정하여, 각 순위에 맞는 이미지에 매핑하도록 함
				tr.append($("<td></td>").append($("<img>").attr("id", obj.rank)));
				tr.append($("<td></td>").text(obj.title));
				tr.append($("<td></td>").text(obj.openDt));
				tr.append($("<td></td>").text(obj.audiAcc));
				$("tbody").append(tr); // 표에 해당 행 추가
				
				// 카카오 이미지 검색 
				$.ajax({
					async: true,
					url: "https://dapi.kakao.com/v2/search/image",
					type: "GET",
					// 카카오 API 필수 요청데이터 Authorization(key), query
					headers: {
                        "Authorization": "KakaoAK b00a29155b38a71ba2de1fd0eed75971"
                    },
					data:{
						// 검색을 원하는 질의어 : 영화 제목
						query : obj.title
					},
					timeout: 3000,
					dataType: "json",
					success: function(re){
						// 해당 이미지를 순위에 맞게 매핑
						$("#"+obj.rank).attr("src", re.documents[0].thumbnail_url);
						
					},
					error: function(e) {
						console.error(e)
						alert("오류 발생")
					}
				});
				
			});
			// alert() : 경고창 띄우기
			//alert(obj.title)
		},
		// 실패했을 때
		error: function(e) {
			console.error(e)
			alert("오류 발생")
		}
	})
}
