package test;

public class ThreadPriorityTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			for(int i=0; i<10; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t1.setPriority(1);
		
		Thread t2 = new Thread(()->{
			for(int i=0; i<10; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t2.setPriority(10);
		
		t1.start();
		t2.start();
	}
}
