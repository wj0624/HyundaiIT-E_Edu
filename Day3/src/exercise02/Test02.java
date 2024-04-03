package exercise02;

public class Test02 {
	public static void main(String[] args) {
		Student arrays [] = new Student[3];
		// Student 객체를 3개 생성하여 배열에 넣는다
		arrays[0] = new Student("홍길동", 15, 171, 81, "201101", "영문");
		arrays[1] = new Student("한사람", 13, 183, 72, "201102", "건축");
		arrays[2] = new Student("임걱정", 16, 175, 65, "201103", "무용");
		//배열에 있는 객체 정보를 모두 출력한다. - for문을 이용
		for(Student stu : arrays) {
			System.out.println(stu.printInformation());
		}
	}
}

class Human {
	String name;
	int age;
	int height;
	int weight;
	public Human() {
		
	}
	public Human(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public String printInformation() {
		return this.name+"   "+this.age+"   "+this.height+"   "+this.weight;
	}
}

class Student extends Human{
	String number;
	String major;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	public String printInformation() {
		return super.printInformation()+"   "+this.number+"   "+this.major;
	}
}