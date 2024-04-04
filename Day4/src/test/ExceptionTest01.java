package test;

public class ExceptionTest01 {

	public static void main(String[] args) {
		System.out.println("예외상황을 발생시켜보아요!");
		try {
//			int result = 10 / 0;	//Exception 발생
			ExceptionTest01 t = null; //null=메모리 주소 값 없음, 즉 가르키는 값이 없음
									//객체 자체가 없으므로 메소드 호출 불가
			System.out.println(t.toString());
		} catch(ArithmeticException e) {
			//발생한 예외에 대한 처리코드가 나와요
			System.out.println("처리완료!!");
		} catch(NullPointerException e) {
			System.out.println("NullPointer 처리완료!!");
		} finally {//예외가 있던없던 무조건 수행
			System.out.println("이놈은 무조건 수행돼요");
		}
		System.out.println("이거 수행되나요?");
	}
}
