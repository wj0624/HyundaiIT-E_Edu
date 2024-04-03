package workshop04;

public class Test06 {

	public static void main(String[] args) {
		// 5개의 Account 형 객체 배열 선언
		Account [] arr = new Account[5];
		
		// for문을 이용하여 Account 객체를 배열에 생성
		for(int i=1; i<=5; i++) {
			arr[i-1] = new Account("221-0101-211"+String.valueOf(i), 100000, 4.5);
		}
		// for문을 이용하여 Account 정보 출력
		for(Account ac : arr) {
			System.out.println(accountInfo(ac));
		}
		System.out.println();
		// for문을 이용하여 이자율을 변경하고 이자를 화면에 출력
		for(Account ac : arr) {
			ac.setInterestRate(3.7);
			System.out.println(accountInfo(ac)+" 이자: "+ac.calculateInterest()+"원");
		}
		
	}
	
	public static String accountInfo(Account ac) {
		return "계좌번호: "+ac.getAccount()+" 잔액: "+ac.getBalance()+" 이자율: "+ac.getInterestRate()+"%";
	}

}

