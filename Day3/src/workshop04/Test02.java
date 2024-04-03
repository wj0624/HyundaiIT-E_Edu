package workshop04;
import java.util.*;

class Calc{
	public int calculate(int data) {
		int sum = 0;
		System.out.print("짝수: ");
		for(int i=1; i<=data; i++) {
			if(i%2==0) {
				sum += i;
				System.out.print(i+" ");
			}
		}
		System.out.println();
		return sum;
	}
}

public class Test02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calc c = new Calc();
		System.out.println("결과: "+c.calculate(sc.nextInt()));
		
	}
}
