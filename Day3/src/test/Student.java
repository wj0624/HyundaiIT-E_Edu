package test;

public class Student {
	//field
	private String name;
	private int age;
	
	//constructor
	public Student() {
		
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	// setter&getter
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
	
	// method
	@Override
	public boolean equals(Object obj) { //Object 최상위이기 때문에 모든 객체가 들어올 수 있음
		//인자로 들어온 가 instance가 equals method를 가지고 있는
		//instance의 내용과 같으면 같은 객체로 판별하는 로직을 작성
		//당연히 처음은 두 instance type을 똑같이 맞춰야함
		Student target = (Student)obj;
		boolean result = false;
		if (this.getName().equals(target.getName()) &&
			this.getAge() == target.getAge()) {
			result = true;
		}
		return result;
	}
	
	@Override
	public String toString() {
		return this.getName()+" : "+this.getAge();
	}
}

class MyTest {
	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 20);
//		Student s2 = new Student("홍길동", 20);
//		
//		boolean result = s1 == s2; //변수 안에 있는 값이 같은지
//								   //False, 메모리주소 다름
//		System.out.println(result);
//		System.out.println(s1.equals(s2));
		System.out.println(s1);
	}
}
