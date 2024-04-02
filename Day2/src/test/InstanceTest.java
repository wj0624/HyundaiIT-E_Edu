package test;

public class InstanceTest {
	static int a = staticCall("1번째 출력");
	int b = staticCall("2번째 출력");
	
	public static int staticCall(String msg) {
		System.out.println(msg);
		return 100;
	}
	
	public InstanceTest() {
		this.b = staticCall("3번째 출력");
	}

	public static void main(String[] args) {
		System.out.println("4번째 출력");
		int c = staticCall("5번째 출력");
		InstanceTest d = new InstanceTest();

	}

}
