package exercise01;
import java.io.*;
import java.util.*;

public class Test05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		Calc c = new Calc(a, b);
		System.out.printf("합: %d\n", c.sum(a,b));
		System.out.printf("차: %d\n", c.subtract(a,b));
		System.out.printf("곱: %d\n", c.multiply(a,b));
		System.out.printf("나누기: %d\n", c.divide(a,b)); 
		

	}

}

class Calc {
	private int a;
	private int b;
	
	Calc(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public int subtract(int a, int b) {
		return a-b;
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}
	
	public int divide(int a, int b) {
		if(b<=0)
			return 0;
		else
			return a/b;
	}
}