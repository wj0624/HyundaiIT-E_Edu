
 function myFunc(){
	// 현재 체크된 체크박스 다 찾기
	// text()는 태그 사이에 있는 글자를 하나의 문자열로 만들어서 추출하는 함수
	// 체크박스 여러개 선택되면 문자열을 따로따로 추출하지만 하나로 붙여서 나옴
	// 운동, 노래 체크 => "운동노래" 출력
	//console.log($("[type=checkbox]:checked + span").text());
	
	// 반복문 each()
	$("[type=checkbox]:checked + span").each(function(idx, item){
		// 콜백함수: 특정 조건 되면 자동으로 수행
		// idx: 반복되는 index의 값, 0부터 시작
		// item: 앞쪽에서 나오는 반복대상이 되는 문서객체(selector가 아니라 문서객체)
		console.log($(item).text());
	});
}