package javanetworkexam;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) {
		// 1.ServerSocket 객체를 생성
		//	 ServerSocket을 생성할 때 client가 접속해서 들어올
		//	 Port번호를 명시해야 함
		//	 0-65535 사이의 값을 사용해야 함
		//	 0-1023 까지는 Well known port라고 해서 이미 용도가
		//   정해져 있기 때문에 그 이후 값을 이용해야 함(권장)
		//	 하나의 컴퓨터에서 동작하는 프로그램이 사용하는 
		//	 Port 번호는 Unique 해야 함
		try {
			ServerSocket serverSocket = new ServerSocket(5555);
			System.out.println("서버소켓 객체 생성");
			
			Socket s = serverSocket.accept();	
			//일단 대기(클라이언트가 접속할 때까지) blocking
			System.out.println("accept()가 풀렸어요!");
			
			// 이렇게 얻어진 socket에 대해서 Stream 객체를 얻어냄
			// Server는 데이터를 내보내야 하니 outputStream 뽑아냄
			PrintWriter out = new PrintWriter(s.getOutputStream());
			out.println("이것은 소리없는 아우성 - 서버가 전달했어요!");
			
			//PrintWriter는 효율을 위해서 내부 buffer를 가지고 있음
			//명시적으로 flush를 이용해 데이터를 전달해야 함
			out.flush();
		} catch (Exception e) {
			
		}
	}

}