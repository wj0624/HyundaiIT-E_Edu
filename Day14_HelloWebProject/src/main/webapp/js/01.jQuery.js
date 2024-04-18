/**
 * JavaScript code 작성
 */

 function myFunc(){
	//console.log("소리 없는 아우성"); // 콘솔에 문자열 출력
	//$("*").css("color", "red"); // 전체 선택자
	//$("#myLi").remove(); // 아이디 선택자
	//$("div, input").css("background-color", "yellow"); // Type 선택자
	//$(".myStyle").css("color", "blue"); // 클래스 선택자
	//$("ol > li").css("background-color", "red"); // 자식 선택자
	//$("div li").css("background-color", "red"); // 후손 선택자
	//$("#myLi + li").text("댕댕이"); // myLi를 찾아서 내 다음 li인 형제
	//$("#myLi ~ li").text("댕댕이"); // myLi를 찾아서 내 다음 모든 형제 중 li인 것
 	//attr()은 속성의 값을 알아내거나 변경할 때 사용
 	$("[type]").attr("value", "변경되었어요"); // 속성 선택자 
 
 }