package exercise01;

public class Test07 {

	public static void main(String[] args) {
		Tv tvArray[] = new Tv[3];
		int sum = 0;
		//Tv 객체를 3개 생성하여 배열에 넣는다.
		tvArray[0] = new Tv("INFINIA", 1500000, "LED TV");
		tvArray[1] = new Tv("XCANVAS", 1000000, "LCD TV");
		tvArray[2] = new Tv("CINEMA", 2000000, "3D TV");
		
		//배열에 있는 객체 정보를 모두 출력한다 - for문 이용
		for(Tv tv: tvArray) {
			System.out.println(tv);
			sum += tv.price;
		}
		//Tv 가격의 합을 출력한다.
		System.out.println("가격의 합: "+sum);

	}

}

class Tv {
	String name;
	int price;
	String description;
	
	public Tv() {
		
	}

	public Tv(String name, int price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name +" "+ this.price +" "+ this.description;
	}
}