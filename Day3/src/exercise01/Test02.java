package exercise01;
import java.io.*;
import java.util.*;

public class Test02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a*b<10) {
			System.out.println("한자리 수 입니다.");
		}
		else {
			System.out.println("두자리 수 입니다.");
		}
	}
}
