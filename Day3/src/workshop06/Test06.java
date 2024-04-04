package workshop06;

abstract class Car {
	String name;
	String engine;
	int oilTank;
	int oilSize;
	int distance;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String name, String engine, int oilTank, int oilSize, int distance) {
		this.name = name;
		this.engine = engine;
		this.oilTank = oilTank;
		this.oilSize = oilSize;
		this.distance = distance;
	}
	
	public abstract void go(int distance);
	public abstract void setOil(int oilSize);
}

interface Temp {
	int getTempGage();
}

class L3 extends Car implements Temp{
	public L3() {

	}
	
	public L3(String name, String engine, int oilTank, int oilSize, int distance) {
		super();
		this.name = name;
		this.engine = engine;
		this.oilTank = oilTank;
		this.oilSize = oilSize;
		this.distance = distance;
	}
	
	public void go(int distance) {
		this.oilSize -= distance/10;
		this.distance += distance;
	}
	
	public void setOil(int oilSize) {
		this.oilSize += oilSize;
	}
	
	public int getTempGage() {
		return this.distance/10;
	}
}

class L5 extends Car implements Temp{
	public L5() {

	}
	
	public L5(String name, String engine, int oilTank, int oilSize, int distance) {
		super();
		this.name = name;
		this.engine = engine;
		this.oilTank = oilTank;
		this.oilSize = oilSize;
		this.distance = distance;
	}
	
	public void go(int distance) {
		this.oilSize -= distance/8;
		this.distance += distance;
	}
	
	public void setOil(int oilSize) {
		this.oilSize += oilSize;
	}
	
	public int getTempGage() {
		return (this.distance/10)*2;
	}
}
public class Test06 {

	public static void main(String[] args) {
		// Car type의 객체 배열을 2개 만든다
		Car [] c = new Car[2];
		// 배열에 사용데이터에서 제공된 2개의 Car 객체를 넣는다.
		c[0] = new L3("L3", "1500", 50, 25, 0);
		c[1] = new L5("L5", "2000", 75, 35, 0);
		// 생성된 자동차의 기본 정보 출력
		System.out.println(" vehicleName  engineSize  oilTank  oilSize  distance temperature");
		System.out.println("---------------------------------------------------------------------------");
		for(Car ca : c) {
			System.out.println("     "+ca.name+"        "+ca.engine+"        "+ca.oilTank+"        "+ca.oilSize+
								"        "+ca.distance+"        "+((Temp) ca).getTempGage());
		}
		// 각각의 자동차에 25씩 주유 한다
		// 25씩 주유한 자동차의 정보를 출력 한다
		System.out.println("\n25 주유");
		System.out.println(" vehicleName  engineSize  oilTank  oilSize  distance temperature");
		System.out.println("---------------------------------------------------------------------------");
		for(Car ca : c) {
			ca.setOil(25);
			System.out.println("     "+ca.name+"        "+ca.engine+"        "+ca.oilTank+"        "+ca.oilSize+
								"        "+ca.distance+"        "+((Temp) ca).getTempGage());
		}
		// 각각의 자동차에 80씩 주행 한다
		// 80씩 주행한 정보를 출력 하며 엔진온도 정보를 출력 한다
		System.out.println("\n80 주행");
		System.out.println(" vehicleName  engineSize  oilTank  oilSize  distance temperature");
		System.out.println("---------------------------------------------------------------------------");
		for(Car ca : c) {
			ca.go(80);
			System.out.println("     "+ca.name+"        "+ca.engine+"        "+ca.oilTank+"        "+ca.oilSize+
								"        "+ca.distance+"        "+((Temp) ca).getTempGage());
		}

	}

}
