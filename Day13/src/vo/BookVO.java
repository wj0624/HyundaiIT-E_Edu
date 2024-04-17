package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookVO {
	
	private String bisbn;
	private String btitle;
	private int bprice;
	private String bauthor;
	
}