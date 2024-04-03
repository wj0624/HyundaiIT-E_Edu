package exercise01;

public class Test03 {
	public static void main(String[] args) {
		for(int i=2; i<6; i++) {
			if(i%2==0) continue;
			for(int j=1; j<10; j++) {
				if(i*j%2==1) {
					System.out.printf("%d*%d=%d\n", i, j, i*j);
				}
			}
		}
	}
}
