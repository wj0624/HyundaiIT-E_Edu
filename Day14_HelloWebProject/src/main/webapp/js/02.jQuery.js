
 function myFunc(){
	// text()는 인자가 없으면 태그 사이에 있는 값을 알아내고, 있으면 값을 변경
	console.log($("#apple").text()); // 사과
	console.log($("#apple+li").text()); // 파인애플
	console.log($("ul > li.myList").text()); // 참외
	
	// val()는 입력상자 안의 값을 찾음
	console.log($("#uId").val());
	
	console.log($("ol > li:first").text()); // 선택한 순서 상 처음
	console.log($("ol > li:last").text()); // 선택한 순서 상 마지막

	console.log($("ol > li:nth-child(2)").text()); // 선택한 순서 중 n번째
	//nth-child() 순번은 1부터 시작
}