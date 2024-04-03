package exercise02;
import java.util.*;

public class Test05 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		double sum = 0.0;
		Random random = new Random();
		
		for(int i=1; i<11; i++){
			// HashMap에 1~100까지의 정수를 랜덤하게 10개 셋팅
			map.put(i, random.nextInt(100)+1);
		} 
		for(int i=0; i<map.size(); i++){
			// HashMap 데이터를 화면에 출력
			if(i==map.size()-1) {
				System.out.print(map.get(i+1)+"\n");
			}
			else
				System.out.print(map.get(i+1)+" ");
		}
		for(int i=0; i<map.size(); i++){
			// HashMap 데이터의 합계를 계산
			sum += Double.parseDouble(String.valueOf(map.get(i+1)));
		}
		// 합계와 평균을 화면에 출력
		System.out.printf("합계:%.2f\n", sum);
		System.out.printf("평균:%.2f", sum/map.size());

	}

}
