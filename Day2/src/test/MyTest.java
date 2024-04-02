package test;

public class MyTest {
	//static block
	static {
			
	}
	
	//필드들
	private int a = 100;	//instance variable, Heap에 만들어짐
	private static int b = 200; //class variable, method area에 만들어짐
						//Heap의 인스턴스가 없어도 사용 가능 -> 클래스 이름 가지고 바로 사용 가능
	private int c = 300;
	
	//생성자들
	public MyTest() {
		
	}
	
	MyTest(int k){
		
	}

	//메소드들
	public static void main(String[] args) {
		//위에 있는 a 필드를 사용하려면 instance가 존재해야 함
		MyTest obj = new MyTest();
		//obj라는 reference variable을 이용해서 Heap영역에 생성된 instance를 사용할 수 있음
		//reference variable을 이용해서 instance를 사용할 때 이용하는 연산자 : dot operator(.)
		System.out.println("a의 값은 : "+ obj.a);
		
		int k = 200; //local variable
					 //지역변수는 메소드 내에서 선언, Stack에 만들어짐
	}

}
