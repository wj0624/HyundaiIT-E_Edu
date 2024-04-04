package test;

class MyException extends Exception{
	
}

public class ExceptionTest02 {

	public static void main(String[] args) {
		try {
			throw new MyException(); //Exception 객체가 만들어짐
			//Exception 발생 =/= Exception 객체가 만들어짐. 즉, 전달해주어야함
		} catch(MyException e) {
			System.out.println("사용자 정의 Exception 발생");
		}
	}
}