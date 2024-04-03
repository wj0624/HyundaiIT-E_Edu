package exercise01;

public class Test06 {

	public static void main(String[] args) {
		int [] array = {1,2,3,4,5,6,7,8,9,10};
		double sum = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i]%2==0)
				continue;
			System.out.println(array[i]);
			sum += array[i];
		}
		System.out.printf("합계:%.1f", sum);
	}
}
