package exercise02;

import java.util.HashMap;

abstract class Employee {
	String name;
	int number;
	String department;
	int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int number, String department, int salary) {
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}
	
	public abstract double tax();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}

interface Bonus {
	void incentive(int pay);
}

class Secretary extends Employee implements Bonus{
	public Secretary() {
	}
	
	public Secretary(String name, int number, String department, int salary) {
		super();
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}

	public double tax() {
		return this.getSalary()*0.1;
	}
	
	public void incentive(int pay) {
		this.setSalary((int) (this.salary+pay*0.8));
	}
}

class Sales extends Employee implements Bonus{
	public Sales() {
	}

	public Sales(String name, int number, String department, int salary) {
		super();
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}
	
	public double tax() {
		return this.getSalary()*0.13;
	}
	
	public void incentive(int pay) {
		this.setSalary((int) (this.salary+pay*1.2));
	}
}

public class Test07 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		// 1번의 데이터를 기반으로 객체를 생성 하여 HashMap에 넣는다.
		Secretary se = new Secretary("Hilery", 1, "secretary", 800);
		Sales sa = new Sales("Clinten", 2, "sales", 1200);
		// HashMap에 넣을 때 키 값은 각 객체의 Number로 한다.
		map.put(se.number, se);
		map.put(sa.number, sa);
		// 모든 객체의 기본 정보를 출력 한다(for문을 이용하여 출력 한다.)
		System.out.println("name     department    salary");
		System.out.println("------------------------------------");
		for(int i=1; i<map.size()+1; i++) {
			Employee em = (Employee) map.get(i);
			System.out.println(em.getName()+"    "+em.getDepartment()+"     "+em.getSalary());
		}
		// 모든 객체에 인센티브 100씩 지급하고 다시 HashMap에 넣는다.
		((Bonus) map.get(1)).incentive(100);
		((Bonus) map.get(2)).incentive(100);
		
		// 모든 객체의 정보와 세금을 출력 한다 (for문을 이용하여 출력 한다.)
		System.out.println();
		System.out.println("name     department    salary    tax");
		System.out.println("----------------------------------------");
		for(int i=1; i<map.size()+1; i++) {
			Employee em = (Employee) map.get(i);
			System.out.println(em.getName()+"    "+em.getDepartment()+"     "+em.getSalary()+"     "+em.tax());
		}
	}

}
