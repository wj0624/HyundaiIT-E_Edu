package workshop08;

import java.util.*;

class MakeList{
	ArrayList<Integer> arr;
	public MakeList() {
		this.arr = new ArrayList<>();
	}
	
	public void makeArrayList(int size) {
		Random rand = new Random();
		for(int i=0; i<size; i++) {
			arr.add(rand.nextInt(100)+1);
		}
	}
	
	public double getAverage() {
		int sum = 0;
		for(int i=0; i<this.arr.size(); i++) {
			sum += arr.get(i);
		}
		return sum/this.arr.size();
	}
	
	public ArrayList getList() {
		return arr;
	}
}

public class Test02 {

	public static void main(String[] args) {
		// argument로 정수를 받는다.
		int a = Integer.parseInt(args[0]);
		ArrayList<Integer> list = null;
		// MakeList 객체 생성
		MakeList ml = new MakeList();
		ml.makeArrayList(a);
		// for문을 이용하여 ArrayList의 정보 출력하고 평균을 출력 한다.
		list = ml.getList();
		for(int i : list) {
			System.out.print(i+" ");
		}
		// 평균 출력
		System.out.println("\n평균: "+ml.getAverage());

	}

}
