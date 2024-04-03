package exercise01;

public class Test04 {

	public static void main(String[] args) {
		double hap = 0;
		for(int i=1; i<101; i++) {
			hap += i;
		}
		double avg = hap/100;
		System.out.printf("합계: %.1f\n", hap);
		System.out.printf("평균: %.1f\n", avg);
	}

}