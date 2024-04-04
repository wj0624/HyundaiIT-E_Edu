package test;

class MyThread1 extends Thread{
	public MyThread1(String name) {
		super(name);
		//this.setName(name);
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(this.getName());
		}
	}
}

class MyRunnable1 implements Runnable{
	@Override
	public void run() {
		//Thread.currentThread().setName("신사임당");
		for(int i=0; i<10; i++) {
			//System.out.println(this.getName());
			//여기서 this는 Runnable 객체라서 getName()이 없기 때문에 사용불가
			System.out.println(Thread.currentThread().getName());
			//curentThread() -> static 메소드
		}
	}
}

public class ThreadTest04 {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("홍길동");
		MyRunnable1 r = new MyRunnable1();
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		//순서 정해지지 않고 실행됨
	}

}
