package test;

//공유객체 클래스
class Shared {
	
	//동기화 코드 적용한 메소드 만들기
	//해당 공유객체는 여러 Thread에 의해서 같이 사용되게 되는데
	//method를 호출할 때는 동기화 시켜서 사용
	public synchronized void printNum() {
		try {
			for(int i=0; i<10; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()
						+" : "+i);
				notify(); //통지
				wait();	//lock 놓기
				//번갈아가면서 수행하게 됨
				//없으면 한 thread 다 실행한 다음에 다른 thread 실행
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class MyRunnable_3 implements Runnable {
	
	private Shared shared;
	
	public MyRunnable_3(Shared shared) {
		this.shared = shared;
	}
	
	@Override
	public void run() {
		shared.printNum();		
	}
}

public class ThreadWaitNotiTest {

	public static void main(String[] args) {
		Shared obj = new Shared();	//공유객체 만들기
		
		Thread t1 = new Thread(new MyRunnable_3(obj));
		Thread t2 = new Thread(new MyRunnable_3(obj));
		
		t1.setName("첫번째 Thread");
		t2.setName("두번째 Thread");
		
		t1.start();
		t2.start();
		
	}

}
