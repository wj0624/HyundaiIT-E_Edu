package workshop04;
import java.util.*;

public class Test04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int row = Integer.parseInt(args[0]);
		int col = Integer.parseInt(args[1]);
		
		int [][] arr = new int[row][col];
		double sum = 0.0;
		double avg = 0.0;
		
		Random random = new Random();
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				arr[i][j] = random.nextInt(5)+1;
				sum += arr[i][j];
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		avg = sum / (Double.parseDouble(args[0])*Double.parseDouble(args[1]));
		System.out.printf("\n"
				+ "sum=%.1f\n", sum);
		System.out.printf("avg=%.1f\n", avg);
	}

}
