package board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	private int post_id;
	private String title;
	private String content;
	private String author;
	private String name;
	private String created_date;
}
