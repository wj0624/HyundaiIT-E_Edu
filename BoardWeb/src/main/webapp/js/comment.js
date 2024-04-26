function cmntDelete(commentID, postID){
	
	var deleteConfirm = confirm("댓글을 삭제하시겠습니까?");
	
	if(deleteConfirm){
		$.ajax({
			async: true,
			url: "http://localhost:8080/board/deleteCmnt",
			type: "POST",
			
			data:{
				comment_id: commentID,
				post_id: postID
			},
			
			timeout: 3000,
			
			success: function(){
				console.log(commentID);
				var deleteCmnt = $("#"+commentID);
				deleteCmnt.remove();
			}
		});
	}

}

function cmntEdit(commentID){
	
	
	$.ajax({
		async: true,
		url: "http://localhost:8080/board/editCmnt",
		type: "POST",
		
		data:{
			comment_id: commentID,
		},
		
		timeout: 3000,
		
		success: function(){
			var editCmnt = $("#"+commentID);
			edit.text();
		}
	});
}