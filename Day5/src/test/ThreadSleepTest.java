package test;

class Sleep_1 extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(2000); //이렇게 작성해야 t1이 sleep
		} catch(Exception e) {
			
		}
		for(int i=0; i<300; i++) {
			System.out.print("-");
		}
		System.out.println("<< Thread 1 종료 >>");
	}
}

class Sleep_2 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("|");
		}
		System.out.println("<< Thread 2 종료 >>");
	}
	
}

public class ThreadSleepTest {
	public static void main(String[] args) {
		Thread t1 = new Sleep_1();
		Thread t2 = new Sleep_2();
		
		t1.start();
		t2.start();
		
		try {
//			t1.sleep(2000);  //이렇게 사용 X
			//sleep은 현재 수행되는 thread를 재우는 것이기 때문에
			//t1.sleep이라고 해도 main thread가 자게 됨
			//t1을 재우고 싶으면 t1의 run에 있어야 함
			Thread.sleep(2000); //이렇게 작성해야함
		} catch(Exception e) {
			
		}
		//실행시 main thread가 제일 늦게 끝남
		System.out.println("<< main thread 종료 >>");
	}

}
