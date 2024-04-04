package workshop08;
import java.util.*;

public class Test06 {

	public static void main(String[] args) {
		Random rand = new Random();
		HashMap<Integer, Integer> h1 = new HashMap<>();
		HashMap<Integer, Integer> h2 = new HashMap<>();
		
		for(int i=1; i<=10; i++) {
			h1.put(i, rand.nextInt(9));
			h2.put(i, rand.nextInt(9));
		}
		
		for(int i=1; i<=10; i++) {
			int a = h1.get(i);
			int b = h2.get(11-i);
			try {
				int c = h1.get(i)/h2.get(i);
				System.out.println(a+"/"+b+" "+c);
			}
			catch(Exception ex) {
				System.out.println(a+"/"+b+" 분모가0입니다");
			}
		}
	}
}
