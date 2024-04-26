package comment.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {
	private int comment_id;
	private String userID;
	private String userName;
	private String content;
	private String created_date;
	private int post_id;

}
