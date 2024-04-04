package workshop06;

class Calc{
	public int calculate(int data) {
		int sum = 0;
		for(int i=1; i<=data; i++) {
			if(i%2==0) {
				sum += i;
			}
		}
		return sum;
	}
}

public class Test01 {

	public static void main(String[] args) {
		if(Integer.parseInt(args[0])<5 || Integer.parseInt(args[0])>10) {
			System.out.println("다시 입력하세요");
		}
		else {
			Calc c = new Calc();
			System.out.println("결과: "+c.calculate(Integer.parseInt(args[0])));
		}
	}
}
