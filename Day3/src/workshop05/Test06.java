package workshop05;

class Mobile{
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
	
	public int operate(int time) {
		return this.batterySize -= 10;	
	}
	
	public int charge(int time) {
		return this.batterySize += 10;	
	}
}

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
