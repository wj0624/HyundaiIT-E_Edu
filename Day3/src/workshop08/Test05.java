package workshop08;

import java.util.*;

public class Test05 {

	public static void main(String[] args) {
		Random rand = new Random();
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			list1.add(rand.nextInt(9));
			list2.add(rand.nextInt(9));
		}
		
		for(int i=0; i<10; i++) {
			int a = list1.get(i);
			int b = list2.get(i);
			try {
				int c = list1.get(i)/list2.get(i);
				System.out.println(a+"/"+b+" "+c);
			}
			catch(Exception ex) {
				System.out.println(a+"/"+b+" 분모가0입니다");
			}
		}
	}
}
