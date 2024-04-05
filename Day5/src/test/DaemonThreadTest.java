package test;

public class DaemonThreadTest implements Runnable {
	
	static boolean autoSave = false;

	public static void main(String[] args) {
		
		Thread t = new Thread(new DaemonThreadTest());
		t.setDaemon(true); //이 부분이 없으면 종료되지 않음
		// 디폴트 : 독립 ==> setDaemon(true): 데몬쓰레드로
		// (메인쓰레드 종료시 종속쓰레드는 작업 다 못끝내도 메인 쓰레드와 함께 종료된다.)
		t.start();	//언젠가는 이 thread가 동작하게 될 것
		
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);	
				//슬립은 static method라서 t.sleep() 이렇게 instance를 사용하지 않음
				//Thread를 이용하는데, 이때 현재 수행되고 있는 thread를 재운다
			} catch (Exception e) {

			}
			System.out.println("i의 값은 : "+i);
			if(i==5) {
				autoSave = true;
			}
		}
	}
	
	@Override
	public void run() { //main thread 실행될 때 같이 실행되고 있음
		while(true) {
			try {
				Thread.sleep(3000); //실행되자마자 바로 잠(t
				// 깨어나는 case 1) 3초 후 2) interrupt(방해) -> exception 발생
			} catch (Exception e) {
				System.out.println("오류 발생");
			}

			if(autoSave) {
				System.out.println("자동저장됐어요");
			}
			//3초마다 자동 저장하는 thread
		}
	}
}