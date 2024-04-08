package test;

//공유자원 하나 정의 -> 공유객체 만들어서 사용
//공유객체 만드려먼 당연히 class가 있어야 함
class Account{
	private int balance = 1000;
	
	//잔액 알아오기 method
	public int getBalance() {
		return balance;
	}
	
	//synchronized 키워드로 임계영역(Critical Section)을 설정
	//당연히 순차처리 됨
	//그러다 보니 method에 이 키워드를 사용하는게 부담스러움
	//다른 thread는 이 method 끝날때까지 기다려야하므로 실행속도 느려짐
	//method 내부에 모든 내용이 공유자원 사용하는 것 아님
	//그래서 일반적으로 synchronized block을 이용해 필요한 곳에만 붙임
	//출금 method
	public void withdraw(int money) {
		if(balance > money) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			synchronized(this) {//공유 객체에 붙음				
				balance -= money;
			}
		}
	}
}

class MySyncRunnable implements Runnable {
	Account acc = new Account();
	
	@Override
	public void run() {
		while(acc.getBalance()>0) {
			int money = (int) (Math.random()*3+1)*100; //Math.random() 0보다 크고 1보다 작은 실수 나옴
			//money 100, 200, 300 중에 나옴
			acc.withdraw(money);
			System.out.println("잔액은 : "+acc.getBalance());
		}
		
	}
}


public class ThreadSyncTest {

	public static void main(String[] args) {
		MySyncRunnable r = new MySyncRunnable();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		//경쟁적으로 thread 2개가 빼려고함

	}

}
