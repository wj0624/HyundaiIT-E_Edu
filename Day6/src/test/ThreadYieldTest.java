package test;

class MyRunnable implements Runnable {
	//thread를 직접 제어하는 것이 아닌 runnable 객체 통해서 제어
	volatile boolean suspended = false;	//해당 thread가 suspend되면 true
	volatile boolean stopped = false;
	
	private Thread t;
	
	public void setThread(Thread t) {//나를 사용하는 thread에 대한 reference
		this.t = t;
	}
	@Override
	public void run() {
		
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					
				}
			}
			else {
				Thread.yield();
			}
		}
	}
	
	public void suspend() {
		suspended = true;
		//thread에 대해서 interrupt 걸기
		//thread에 대한 reference가 있어야 함
		t.interrupt();
		//왜 Thread.currentThread().interrupt(); 안되는지 여쭤봐야지
	}
	
	public void resume() {
		suspended = false;
	}
	
	public void stop() {
		stopped = true;
	}
}

public class ThreadYieldTest {

	public static void main(String[] args) {
		//Runnable 객체 만들기
		//모든 thread가 아래 instance variable을 공유하게 만들면 동작이 이상해짐
		//따라서 thread 각각의 instance 만들어줌
		MyRunnable r1 = new MyRunnable();
		MyRunnable r2 = new MyRunnable();
		MyRunnable r3 = new MyRunnable();
		
		Thread t1 = new Thread(r1, "*");	//Thread의 이름 지정
		Thread t2 = new Thread(r2, "**");	//Thread의 이름 지정
		Thread t3 = new Thread(r3, "***");	//Thread의 이름 지정
		
		r1.setThread(t1);
		r2.setThread(t2);
		r3.setThread(t3);
		
		t1.start();
		t2.start();
		t3.start();
		//main thread 포함 4개의 thread가 실행됨
		
		try {
			Thread.sleep(2000);	//main thread가 sleep
			r1.suspend();	//runnable객체의 함수를 사용하는 것이기 때문에 thread 사용 x
			Thread.sleep(2000);
			r2.suspend(); 
			Thread.sleep(3000);
			r1.resume(); 
			Thread.sleep(3000);
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
