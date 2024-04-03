package test;

public abstract class TestA {
	//field
	private int age;
	private String name;
	
	//constructor
	public TestA() {
		
	}

	public TestA(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	
	//method
	public void myFunc() {
		//method를 정의했음
		
	}
	
	public abstract void sayHello(); //선언만! 
									 //어떻게 동작하는지 아직 정의 안됨

}

class MySubClass extends TestA {

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		
	}
	
}
