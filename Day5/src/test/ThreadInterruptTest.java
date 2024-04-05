package test;
import javax.swing.*;

class MyThread_3 extends Thread {
	@Override
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
//			for(long k=0; k<25000000000L; k++);//busy waiting, 시간 지연
			//위와 같은 코드 사용 대신 sleep을 사용
			try {
				Thread.sleep(4000);
			} catch (Exception e) {
				interrupt();
			}
		}
		System.out.println("카운트가 종료되었어요");
	}
}

public class ThreadInterruptTest {

	public static void main(String[] args) {
		Thread t = new MyThread_3();
		t.start();
		
		//약간의 시간지연을 위해 Swing을 이용해봐요(GUI)
		//blocking method
		String input = JOptionPane.showInputDialog("값을 입력하세요");
		System.out.println("입력된 값은 : "+input);

		t.interrupt();
	}
}
