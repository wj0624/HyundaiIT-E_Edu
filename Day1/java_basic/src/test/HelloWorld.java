package test;

public class HelloWorld {
	//fields
	int age;
	
	//constructors
	//constructor는 이름이 클래스 이름과 같고, 형태는 method와 유사(return type 존재 X)
	public HelloWorld() {
		// instance의 초기화를 담당
		
	}
	//만약 생성자를 직접적으로 명시하지 않으면
	//javac compiler가 소스코드를 bytecode로 컴파일 할 때
	//default constructor를 자동으로 삽입, 하지만 반드시 작성할 것
	//default constructor는 인자도 없고 하는일도 없는 생성자
	
	//methods
	public void sayHello() {
		
	}
	
	//프로그램의 entry point
	public static void main(String args[]) {
		System.out.println("안녕하세요");
		
		//인스턴스 만들기, 대부분의 프로그래밍 언어 인스턴스는 Heap 영역에 만들어짐
		//a는 reference variable이라고 부름 -> Heap 영역의 instance의 시작 주소를 가지고 있기 때문
		HelloWorld a = new HelloWorld();
	}
}