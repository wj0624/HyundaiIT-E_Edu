package workshop08;
import java.util.*;

public class Test07 {

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		 ArrayList list = new ArrayList();
		 HashSet set = new HashSet();
		 
		 Random rand = new Random();
		 // ArrayList에 size만큼의 개수 만큼 랜덤한 숫자를 넣는다.
		 for(int i=0; i<size; i++){
			 list.add(rand.nextInt(10)+1);
		 }
		// ArrayList에 정보를 HashSet에 넣는다.
		for(int i=0; i<size; i++){
			set.add(list.get(i));
		}
		System.out.println(list);
		System.out.println(set);
	}

}
