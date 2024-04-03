package workshop04;
import java.util.*;

public class Test03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		for(int i=a; i<=10; i++) {
			if(i%3==0||i%5==0) continue;
			sum += i;
			list.add(i);
			
		}
		
		for(int i=0; i<list.size(); i++) {
			if(i==list.size()-1) {
				System.out.println(list.get(i));
			}
			else{
				System.out.print(list.get(i)+"+");
			}
		}
		
		System.out.println("결과: "+sum);
	}
}
