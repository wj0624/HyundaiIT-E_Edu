package test;

public class SubClass extends SuperClass {
	// 추가적인 field와 method를 정의하면 됨
	int a = 5000;	//shadow
	int b = 500;
	
	public SubClass() {
		this(10);
	}
	public SubClass(int k) { //상속자 오버로딩
		//현재 class가 최상위 클래스인지 확인하고 아니면,
		//상위클래스의 instance를 만드는 코드가 들어가야 함
		//SuperClass(); 이거 대신에 super 사용
		super();
	}
	
	//annotation
	@Override 
	public void myFunc() {
		System.out.println("여기는 subclass에요");
	}
}
