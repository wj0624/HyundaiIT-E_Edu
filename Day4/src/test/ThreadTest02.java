package test;

//첫번째 방법
class MyThread extends Thread{ 
	@Override
	public void run() {
		//Thread의 실행코드가 나와요
		System.out.println("여기는 첫번째 Thread");
	}
	
}

//두번째 방법
class MyRunnable implements Runnable{

	@Override
	public void run() {
		//Thread의 실행코드
		System.out.println("여기는 두번째 Thread");
	}
	
}

public class ThreadTest02 {
	//main thread
	public static void main(String[] args) {
		MyThread t1 = new MyThread(); // thread를 생성, thread 객체
		t1.start();	//thread 실행, run() X
		// start()는 non-blocking method임
		// blocking method -> method return 될 때까지 대기하는 것
		// non-blocking -> 요청하고 기다리지 않고 바로 다음 줄로
		// start()는 thread scheduler에게 thread를 실행시켜
		// 달라고 요청하는 method, 직접 호출 x
		// Thread scheduler(JVM)가 직접 관리
		// 이론적으로 어떤 thread가 먼저 실행될지 모름
		
		MyRunnable r = new MyRunnable(); //runnable 객체
		Thread t2 = new Thread(r);
		t2.start();
	}

}
// thead 3개 -> main, t1, t2
