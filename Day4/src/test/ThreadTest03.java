package test;

public class ThreadTest03 {

	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			//Runnable은 interface라서 new 써서 객체 안만들어짐
			//안되는 이유인 run()을 오버라이딩 해줌으로써 객체 만들어냄
			@Override
			public void run() {
				System.out.println("너무 복잡해요!");
			}
		}).start(); //이렇게 작성할 수 있다
		
		//interface가 오버라이딩 해야하는 메소드를 딱 한개만 가지고 있으니까
		//아래와 같이 생략해서 표현 가능하다 (Lambda)
		//인자 + 하는일 제외
		new Thread(() -> {
				System.out.println("너무 복잡해요!");
			}
		).start(); //위와 같은 표현
	}

}
