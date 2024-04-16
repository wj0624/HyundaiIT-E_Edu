package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data //Setter, Getter, RequiredArgsConstrutcor, ToString 포함
@NoArgsConstructor //default 생성자
@AllArgsConstructor //모든 필드를 사용한 생성자
//@Getter //클래스 앞에 어노테이션 작성하면, 
//@Setter //해당 클래스 안에 있는 모든 필드에 대해 적용
//@RequiredArgsConstructor //지정한 인자만 필드로 사용하는 생성자
//@ToString //해당 필드를 이용해 문자열로 반환
public class BookVO {
	
	@NonNull private String bisbn;
	@NonNull private String btitle;
	private int bprice;
	private String bauthor;

}
