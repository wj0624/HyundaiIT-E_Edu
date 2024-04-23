function comparePW() {
    var password = $("#PW").val();
    var confirmPassword = $("#confirmPW").val();

    if (password != confirmPassword) {
        alert("비밀번호가 일치하지 않습니다.");
        
        return false; // 폼 제출 중지
    }
    return true; // 폼 제출 계속
}