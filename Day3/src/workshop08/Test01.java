package workshop08;
import java.util.*;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Character> h = new HashSet<>();
		String str = sc.next();
		for(int i=0; i<str.length(); i++) {
			h.add(str.charAt(i));
		}
		System.out.println(h);
	}

}
