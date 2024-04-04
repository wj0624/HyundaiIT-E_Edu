package test;


public class ThreadTest01 {
	//single process, single thread
	//이 프로그램에서는 thread 하나만 존재 -> main thread
	public static void main(String[] args) {
		//main thread는 main 메소드를 가진 thread
		//main method =/= main thread
		//thread 별로 call stack을 가짐, heap, method area는 공유
		System.out.println("안녕하세요");

	}

}
//자바 프로그램 내 모든 thread가 종료되어야 프로그램이 종료