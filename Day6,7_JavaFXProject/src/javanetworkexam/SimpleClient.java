package javanetworkexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleClient {

	public static void main(String[] args) {
		// 클라이언트는 능동적으로 서버 프로세서(ServerSocket)에
		// 접속을 시도, 당연히 IP와 Port를 알려줘야 함.
		// IP는 당연히 목적지의 IP주소를 넣어야 함
		// 지금은 서버 프로그램이 같은 컴퓨터에 있기 때문에
		// IP주소를 현재 사용하고 있는 컴퓨터를 지칭하는 특별한 IP 주소를 이용
		// 127.0.0.1이라는 IP(loop back)를 이용(혹은 이 IP에 할당된 localhost)
		
		// 접속을 시도해서 만약 접속이 성공하면 진짜 객체가 생성됨
		// 접속 실패하면 null이 return 됨
		try {
			Socket s = new Socket("localhost", 5555);
			System.out.println("접속 성공성공!");
			
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String msg = br.readLine();
			System.out.println(msg);
		} catch (Exception e) {
			
		}
	}

}
