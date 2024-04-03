package exercise01;
import java.io.*;
import java.util.*;


public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a%2 == 0){
			System.out.println("2의 배수 입니다.");
		}
		else {
			System.out.println("2의 배수가 아닙니다.");
		}
	}

}
