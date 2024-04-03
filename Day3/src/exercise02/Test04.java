package exercise02;
import java.util.*;

public class Test04 {

	public static void main(String[] args) {
		List list = new ArrayList();
		
		Random random = new Random();
		for(int i=0; i<10; i++){
			// ArrayList에 1~10까지의 정수를 랜덤하게 셋팅 하고 셋팅 된 데이터를 출력 한다.
			list.add(random.nextInt(10)+1);
			if(i==9) {
				System.out.print(list.get(i)+"\n");
			}
			else {
				System.out.print(list.get(i)+" ");
			}
			
		}
		
		// ArrayList의 값들을 Sorting 처리
		Collections.sort(list);
		for(int i=0; i<list.size(); i++){
			// Sorting 된 ArrayList 값들을 화면에 출력
			System.out.print(list.get(i)+" ");
		}
	}

}
