package test;

public class Main {

	public static void main(String[] args) {
		//SubClass sub = new SubClass();
		//System.out.println("c의 값은 : " + sub.c);
		//System.out.println("a의 값은 : " + sub.a);
		
//		System.out.println(sub.a);
//		sub.myFunc();
		
		SuperClass sub = new SubClass();
		System.out.println("c의 값은 : " + sub.a); //100
		sub.myFunc();	//super? XXX
	}
}
