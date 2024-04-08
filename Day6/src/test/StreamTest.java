package test;

import java.io.*;

public class StreamTest {

	public static void main(String[] args) {
		// 키보드로 한 line을 입력받아서 그대로 출력
		// 당연히 입력 Stream과 출력 Stream이 필요
		// 키보드로부터 입력을 받기위한 입력 Stream
		// 모니터에 출력하기 위한 출력 Stream
		// 표준입력(키보드입력) System.in
		// 표준출력(모니터출력) System.out
		InputStreamReader isr = new InputStreamReader(System.in);
		//아직도 불편해요! InputStreamReader는 문자단위로 입력받을 수 있음
		//우리는 한 line 단위로 입력 받고 싶음(문자열 단위로)
		BufferedReader br = new BufferedReader(isr);
		try {
			String msg = br.readLine();
			System.out.println("입력받은 데이터 : "+msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}