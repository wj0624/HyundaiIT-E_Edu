 function myFunc(){
	// 새로운 Element 만들기
	// 변수 선언 : var, let
	// var : 함수 기준
	// let : block 기준
	// <li id="myId">아이유</li> 형태로 생성
	var li = $("<li></li>").text("아이유").attr("id", "myId");
	
	// Element 생성했으면 원하는 위치에 붙이기 -> 4개의 method가 있음
	// 1. 맨 마지막 자식으로 붙이기 append()
	// $("ul").append(li);
	
	// 2. 맨 처음 자식으로 붙이기 prepend()
	//$("ul").prepend(li);
	
	// 3. 바로 앞 형제로 붙이기 before()
	//$("ul > li:last").before(li);
	
	// 4. 바로 뒤 형제로 붙이기 after()
}