package exercise02;

abstract class Plane {
	String planeName;
	int fuelSize;
	public Plane() {
		// TODO Auto-generated constructor stub
	}
	public Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	public void refuel(int fuel) {
		this.fuelSize += fuel;
	}
	
	public abstract void flight(int distance);
	
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public int getFuelSize() {
		return fuelSize;
	}
	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
}

class Airplane extends Plane{
	public Airplane() {
		// TODO Auto-generated constructor stub
	}

	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	public void flight(int distance) {
		setFuelSize(this.fuelSize-(distance/10)*30);
	}
}

class Cargoplane extends Plane{
	public Cargoplane() {
		// TODO Auto-generated constructor stub
	}

	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
		// TODO Auto-generated constructor stub
	}
	
	public void flight(int distance) {
		setFuelSize(this.fuelSize-(distance/10)*50);
	}
}

public class Test06 {

	public static void main(String[] args) {
		// Airplane과 Cargoplane 객체 생성
		Airplane ap = new Airplane("L747", 1000);
		Cargoplane cp = new Cargoplane("C40", 1000);
		
		// 생성된 객체의 정보 출력
		System.out.println("   Plane      fuelSize");
		System.out.println("---------------------------");
		System.out.println("   "+ap.getPlaneName()+"        "+ap.getFuelSize());
		System.out.println("   "+cp.getPlaneName()+"         "+cp.getFuelSize());
		// Airplane과 Cargoplane 객체에 100씩 운항
		ap.flight(100);
		cp.flight(100);
		
		// 100 운항 후 객체 정보 출력
		System.out.println("\n100 운항");
		System.out.println("   Plane      fuelSize");
		System.out.println("---------------------------");
		System.out.println("   "+ap.getPlaneName()+"        "+ap.getFuelSize());
		System.out.println("   "+cp.getPlaneName()+"         "+cp.getFuelSize());
		 
		//Airplane과 Cargoplane 객체에 200씩 주유
		ap.refuel(200);
		cp.refuel(200);
		 
		// 200 주유 후 객체 정보 출력
		System.out.println("\n200 주유");
		System.out.println("   Plane      fuelSize");
		System.out.println("---------------------------");
		System.out.println("   "+ap.getPlaneName()+"        "+ap.getFuelSize());
		System.out.println("   "+cp.getPlaneName()+"         "+cp.getFuelSize());
	}

}
