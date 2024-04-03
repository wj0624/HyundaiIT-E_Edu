package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		set.add("홍길동");
		set.add("신사임당");
		set.add("홍길동");
		
		//반복적으로 값 가지고 올 때 iterator(반복자) 사용하면 편함
		//Iterator에는 순서 개념이 없음.
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) { //다음 값 가지고 있어?
			System.out.println(iter.next()); 
			//다음거 가지고 와, 그리고 iterator 위치 바뀜
		}
	}

}
