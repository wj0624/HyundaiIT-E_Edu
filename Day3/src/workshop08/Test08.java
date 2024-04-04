package workshop08;
import java.util.*;

class Mobile{
	String code;
	String name;
	double price;
	
	public Mobile() {
		// TODO Auto-generated constructor stub
	}

	public Mobile(String code, String name, double price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public String printInfo() {
		return this.code+" "+this.name+" "+this.price;
	}
}

public class Test08 {

	public static void main(String[] args) {
		Map<String, Mobile> map =new HashMap<String,Mobile>();
		double sum = 0.0;
		 
		// 4개의 Mobile 객체 생성
		Mobile m1 = new Mobile("LU6800", "Optimus 2x", 80000);
		Mobile m2 = new Mobile("SU6600", "Optimus Black", 90000);
		Mobile m3 = new Mobile("KU5700", "Optimus Big", 70000);
		Mobile m4 = new Mobile("SU7600", "Optimus Mach", 95000);
		// map에 4개의 객체를 code를 키 값으로 넣는다.
		map.put(m1.code, m1);
		map.put(m2.code, m2);
		map.put(m3.code, m3);
		map.put(m4.code, m4);
		
		// Mobile 정보를 출력 하고 합계를 계산
		for(String key : map.keySet()) {
			sum += map.get(key).price;
			System.out.println(map.get(key).printInfo());
		}
		System.out.println("합계: "+sum);
		// Mobile 객체의 가격 정보를 10% 증가 시킨다.
		for(String key : map.keySet()){
			Mobile m = map.get(key);
			m.price *= 1.1;
		}
		// 변경된 정보를 출력 하고 합계를 계산
		sum = 0;
		System.out.println("가격 변경 후");
		for(String key : map.keySet()) {
			sum += map.get(key).price;
			System.out.println(map.get(key).printInfo());
		}
		System.out.println("합계: "+sum);
	}

}
