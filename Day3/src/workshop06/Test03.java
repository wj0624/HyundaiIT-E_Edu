package workshop06;

class Account {
	private String account;
	private int balance;
	private double interestRate;
	
	public Account() {
	}

	public Account(String account, int balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double calculateInterest() {
		return this.balance*this.interestRate/100;
	}
	
	public void deposit(int money) throws Exception {
		if(money<0)
			throw new Exception("입금 금액이 0보다 적습니다.");
		else
			this.balance += money; 
	}
	public void withdraw(int money) throws Exception {
		if(money<0||money>this.balance) {
			throw new Exception("출금 금액이 0보다 적거나 현재 잔액보다 많습니다.");
		}
		else
			this.balance -= money;
	}
}

public class Test03 {

	public static void main(String[] args) {
		Account account;
		// account 객체 생성
		account = new Account("441-0290-1203", 500000, 7.3);
		// account 기본 정보 출력
		System.out.println("계좌정보: "+account.getAccount()+" "+account.getBalance()+" "+account.getInterestRate());
		// account 에 -10원 입금 – Exception 처리
		try {
			account.deposit(-10);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		// account 에 600000원 출금 – Exception 처리
		try {
			account.withdraw(600000);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		// 이자 출력 – 현재 잔고를 기준으로 고객에게 줄 이자 금액을 출력 한다
		System.out.println("이자: "+account.calculateInterest());
	}

}
