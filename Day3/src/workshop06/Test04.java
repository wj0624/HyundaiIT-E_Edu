package workshop06;

abstract class Mobile{
	String mobileName;
	int batterySize;
	String osType;
	
	public Mobile() {
	}

	public Mobile(String mobileName, int batterySize, String osType) {
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}
	
	public abstract int operate(int time);
	
	public abstract int charge(int time);

	public String getMobileName() {
		return mobileName;
	}

	public int getBatterySize() {
		return batterySize;
	}

	public String getOsType() {
		return osType;
	}
}

class Ltab extends Mobile{
	public Ltab() {
	}
	
	public Ltab(String mobileName, int batterySize, String osType) {
		super();
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}
	
	public int operate(int time) {
		return this.batterySize -= time*10;	
	}
	
	public int charge(int time) {
		return this.batterySize += time*10;	
	}
}

class Otab extends Mobile{
	public Otab() {
	}
	
	public Otab(String mobileName, int batterySize, String osType) {
		super();
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}
	
	public int operate(int time) {
		return this.batterySize -= time*12;	
	}
	
	public int charge(int time) {
		return this.batterySize += time*8;	
	}
}

public class Test04 {

	public static void main(String[] args) {
		// 각각의 Mobile 객체 생성
		Ltab lt = new Ltab("Ltab", 500, "AP-01");
		Otab ot = new Otab("Otab", 1000, "AND-20");
		// 생성된 객체의 정보 출력
		System.out.println("  Mobile    Battery     OS");
		System.out.println("-----------------------------");
		System.out.println("  "+lt.getMobileName()+"        "+lt.getBatterySize()+"      "+lt.getOsType());
		System.out.println("  "+ot.getMobileName()+"       "+ot.getBatterySize()+"     "+ot.getOsType());
		// 각각의 Mobile 객체에 10분씩 충전
		lt.charge(10);
		ot.charge(10);
		// 10분 충전 후 객체 정보 출력
		System.out.println();
		System.out.println("10분 충전");
		System.out.println("  Mobile    Battery     OS");
		System.out.println("-----------------------------");
		System.out.println("  "+lt.getMobileName()+"        "+lt.getBatterySize()+"      "+lt.getOsType());
		System.out.println("  "+ot.getMobileName()+"       "+ot.getBatterySize()+"     "+ot.getOsType());
		// 각각의 Mobile 객체에 5분씩 통화
		lt.operate(5);
		ot.operate(5);
		// 5분 통화 후 객체 정보 출력
		System.out.println();
		System.out.println("5분 통화");
		System.out.println("  Mobile    Battery     OS");
		System.out.println("-----------------------------");
		System.out.println("  "+lt.getMobileName()+"        "+lt.getBatterySize()+"      "+lt.getOsType());
		System.out.println("  "+ot.getMobileName()+"       "+ot.getBatterySize()+"     "+ot.getOsType());
	}

}
