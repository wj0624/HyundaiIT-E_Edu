package test;
import java.util.ArrayList;
import java.util.List;

class MyStudent {
	
}
public class ArrayListTest {
	
	public static void main(String[] args) {
		//ArrayList 객체를 만들어서 사용
		//List 계열은 객체면 type에 상관없이 모두 저장이 가능
		//다른 reference data type들을 저장할 수 있음
		//그런데 실제로 구현하다보면 거의 예외없이
		//같은 데이터타입을 이용해서 사용하게 됨(마치 배열처럼)
		List list = new ArrayList();
		list.add("홍길동");
		list.add(new MyStudent());
		list.add(100); 
		//100은 int형태의 primitive type
		//따라서 ArrayList안에 저장될 수 없음
		//자바에는 primitive type에 각각 대응되는 wrapper class가 존재
		//list.add(100); => list.add(new Integer(100))
		//boxing이라는 표현을 사용. 자동으로 이뤄짐: auto boxing
//		for(int i=0; i<10; i++) {
//			
//		}
		for(Object obj : list) {
			System.out.println(obj); 
			//자동으로 모든 객체가 가지고 있는 toString() 호출
			//toString() 오버라이딩 된 것이 동적 바인딩 일어나서 알아서 호출됨
		}
		
		List<String> myList = new ArrayList<String>();
		myList.add("홍길동");
		myList.add("신사임당");
		
		for(String str : myList) {
			System.out.println(str);
		}
	}

}
