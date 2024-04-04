package workshop08;
import java.util.*;

abstract class Ship{
	String shipName;
	int fuelTank;
	
	public Ship() {
		// TODO Auto-generated constructor stub
	}

	public Ship(String shipName, int fuelTank) {
		this.shipName = shipName;
		this.fuelTank = fuelTank;
	}
	
	public abstract void sail(int dist);
	public abstract void refuel(int fuel);
}

class Boat extends Ship{
	public Boat() {
		// TODO Auto-generated constructor stub
	}
	
	public Boat(String shipName, int fuelTank) {
		super();
		this.shipName = shipName;
		this.fuelTank = fuelTank;
	}

	@Override
	public void sail(int dist) {
		this.fuelTank -= dist*10;
	}

	@Override
	public void refuel(int fuel) {
		this.fuelTank += fuel*10;
	}
}

class Cruise extends Ship{
	public Cruise() {
		// TODO Auto-generated constructor stub
	}
	
	public Cruise(String shipName, int fuelTank) {
		super();
		this.shipName = shipName;
		this.fuelTank = fuelTank;
	}

	@Override
	public void sail(int dist) {
		this.fuelTank -= dist*13;
	}

	@Override
	public void refuel(int fuel) {
		this.fuelTank += fuel*8;
	}
}


public class Test03 {

	public static void main(String[] args) {
		// ArrayList를 만들어 각각의 Ship 객체 생성 넣는다
		ArrayList<Ship> sList = new ArrayList<>();
		sList.add(new Boat("Boat01", 500));
		sList.add(new Cruise("Cruise01", 1000));
		// 생성된 객체의 정보 출력 - for문 사용
		System.out.println(" shipName    fuelTank");
		System.out.println("-----------------------");
		for(Ship s : sList) {
			System.out.println("  "+s.shipName+"       "+s.fuelTank);
		}
		// 각각의 Ship 객체에 10 운항 후 객체 정보 출력 - for 문 사용
		System.out.println("\n10 운항");
		System.out.println(" shipName    fuelTank");
		System.out.println("-----------------------");
		for(Ship s : sList) {
			s.sail(10);
			System.out.println("  "+s.shipName+"       "+s.fuelTank);
		}
		//각각의 Ship 객체에 50 주유 후 객체 정보 출력 – for문 사용
		System.out.println("\n50 주유");
		System.out.println(" shipName    fuelTank");
		System.out.println("-----------------------");
		for(Ship s : sList) {
			s.refuel(50);
			System.out.println("  "+s.shipName+"       "+s.fuelTank);
		}

	}

}
