package test;

class MyThread_1 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("-");
		}
	}
}

class MyThread_2 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("|");
		}
	}
}

public class ThreadJoinTest {

	public static void main(String[] args) {
		MyThread_1 t1 = new MyThread_1();
		MyThread_2 t2 = new MyThread_2();
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); //main thread를 기준으로 t1을 join
					   //main이 일시정지(대기상태)되고 t1을 실행
			t2.join();
			//main이 가장 뒤로 밀려서 가장 늦게 끝나게 됨
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
