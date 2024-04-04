package workshop07;

import java.util.StringTokenizer;

public class Test04 {

	public static void main(String[] args) {
		String str = "I am second to none";
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==' ') {
				System.out.print(str.charAt(i));
			}
			else {
				System.out.print(str.charAt(i)+" ");
				count++;
			}
		}
		System.out.println("문자개수: "+count);
		StringTokenizer st = new StringTokenizer(str);
		count = 0;
		while(st.hasMoreTokens()) {
			System.out.print(st.nextToken()+" ");
			count++;
		}
		System.out.println("단어개수: "+count);
	}
}
