package workshop05;

class Student {
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public Student() {
	}

	public Student(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}

public class Test04 {

	public static void main(String[] args) {
		Student studentArray [] = new Student[3];
		// Student 객체를 3개 생성하여 배열에 넣는다
		studentArray[0] = new Student("홍길동", 15, 171, 81);
		studentArray[1] = new Student("한사람", 13, 183, 72);
		studentArray[2] = new Student("임걱정", 16, 175, 65);
		double ageSum = 0.0;
		double heightSum = 0.0;
		double weightSum = 0.0;
		
		// 배열에 있는 객체 정보를 모두 출력 한다 – for 문을 이용 할 것
		System.out.println("이름    나이    신장    몸무게");
		for(Student st : studentArray) {
			System.out.println(st.getName()+"   "+st.getAge()+"     "+st.getHeight()+"      "+st.getWeight());
			ageSum += st.getAge();
			heightSum += st.getHeight();
			weightSum += st.getWeight();
		}
		
		System.out.println();
		// 나이의 평균 출력
		System.out.printf("나이의 평균: %.2f\n", (ageSum/studentArray.length));
		// 신장의 평균 출력
		System.out.printf("신장의 평균: %.2f\n", (heightSum/studentArray.length));
		// 몸무게의 평균 출력
		System.out.printf("몸무게의 평균: %.2f", (weightSum/studentArray.length));		 

	}

}
