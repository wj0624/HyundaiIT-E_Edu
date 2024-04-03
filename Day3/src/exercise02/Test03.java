package exercise02;
import java.util.*;

public class Test03 {

	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34";
		double data [] = new double[5]; 
		double sum = 0;
		// StringTokenizer를 이용하여 데이터를 꺼낸다.
		StringTokenizer st = new StringTokenizer(str, ",");
		for(int i=0; st.hasMoreElements();i++){
			// 배열에 실수 데이터를 넣는다.
			data[i] = Double.parseDouble(st.nextToken());
		}
		for(int i=0; i<data.length; i++){
			//배열 데이터의 합을 구한다.
			sum += data[i];
		}
		// 결과 값을 출력 한다.
		System.out.printf("합계:%.3f\n", sum);
		System.out.printf("평균:%.3f", sum/data.length);
	}
}
