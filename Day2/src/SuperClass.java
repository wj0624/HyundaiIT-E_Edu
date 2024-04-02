
public class SuperClass {
	static int staticCall(String msg) {
		System.out.println(msg);
		return 0;
	}
	
	int a = staticCall("1번 문장입니다");
	static int b = staticCall("2번 문장입니다");
	
	public SuperClass() {
		staticCall("3번 문장입니다");
	}
	
	public SuperClass(int i) {
		this();
		staticCall("4번 문장입니다");
	}
	
	public void myFunc() {
		System.out.println("5번 문장입니다");
	}	
}