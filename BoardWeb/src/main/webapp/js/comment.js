function cmntDelete(commentID){
	// 삭제 확인
	var deleteConfirm = confirm("댓글을 삭제하시겠습니까?");
	
	if(deleteConfirm){ // 삭제 확인 누르면 실행
		$.ajax({
			async: true,
			url: "http://localhost:8080/board/deleteCmnt",
			type: "POST",
			
			data:{
				comment_id: commentID
			},
			
			timeout: 3000,
			
			success: function(){
				//console.log(commentID);
				// 서버에서 delete 실행이 성공하면
				var deleteCmnt = $("#"+commentID);
				deleteCmnt.remove(); // 해당 내용 삭제
			}
		});
	}

}

function cmntEdit(commentID){
    var cmntContent = $("#editCmnt_" + commentID).text();
    var inputField = '<input type="text" id="editInput_' + commentID + '" value="' + cmntContent + '">';
    $("#editCmnt_" + commentID).replaceWith(inputField);

    // 수정 완료 버튼을 추가하고 클릭 이벤트 핸들러를 등록
    var saveButton = '<button class="saveBtn" data-comment-id="' + commentID + '">수정</button>';
    $("#cmntEdit"+commentID).before(saveButton);
    $("#cmntEdit"+commentID).hide();
    $("#cmntDelete"+commentID).hide();

    // 수정 완료 버튼을 클릭했을 때의 동작
    $(document).on("click", ".saveBtn", function() {
        var editedContent = $("#editInput_" + $(this).data("comment-id")).val(); // 수정된 내용을 가져옴

        // AJAX를 사용하여 서버로 수정된 내용을 전송
        $.ajax({
            async: true,
            url: "http://localhost:8080/board/editCmnt",
            type: "POST",
            data:{
                comment_id: commentID,
                content: editedContent
            },
            success: function(){

                    // 성공적으로 저장되었을 때 수정 상자를 숨기고 수정된 내용을 보여줌
                    var editSuccess = '<p id="editCmnt_' + commentID + '">' + editedContent + '</p>';
                    console.log(editSuccess);
                    //$("#editInput_" + commentID).remove(); // 입력 상자 제거
                    $(".saveBtn").remove(); // 저장 버튼 제거
                    $("#editInput_" + commentID).replaceWith(editSuccess); // 댓글 내용을 보여줌
            		
                // 수정 성공 후 수정 및 삭제 버튼 다시 표시
                $("#cmntEdit"+commentID).show();
                $("#cmntDelete"+commentID).show();
            }
            
            
        });
    });
}