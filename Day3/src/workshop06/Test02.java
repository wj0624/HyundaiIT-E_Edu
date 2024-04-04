package workshop06;

class Calculator {
	int a, b;
	public Calculator() {
	}
	
	public double plus(int a, int b) {
		return a+b;
	}
	
	public double minus(int a, int b) {
		return a-b;
	}
	
	public double multiplication(int a, int b) {
		return a*b;
	}
	
	public double divide(int a, int b) {
		try {
			return a/b;
		}
		catch(RuntimeException ex) {
			System.out.println("Exception 이 발생하였습니다. 다시 입력해 주세요");
			return 0.0;
		}
	}
}

public class Test02 {

	public static void main(String[] args) {
		if(args.length<3||args.length>3) {
			System.out.println("다시 입력 하세요");
		}
		else {
			Calculator cal = new Calculator();
			int a = Integer.parseInt(args[0]);
			String c = args[1];
			int b = Integer.parseInt(args[2]);
			switch(c) {
				case "+" :
					System.out.println("결과: "+cal.plus(a, b));
					break;
				case "-" :
					System.out.println("결과: "+cal.minus(a, b));
					break;
				case "x" :
					System.out.println("결과: "+cal.multiplication(a, b));
					break;
				case "/" :
					System.out.println("결과: "+cal.divide(a, b));
					break;
			}
			
		}
	}

}
