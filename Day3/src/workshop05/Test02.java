package workshop05;

class Company{
	private double salary;
	private double annualIncome;
	private double afterTaxAnnualIncome;
	private double bonus;
	private double afterTaxBonus;
	
	public Company() {
	}
	
	public Company(double salary) {
		this.salary = salary;
		this.annualIncome = salary * 12;
	}
	
	public double getAnnualIncome() {
		return this.annualIncome;
	}
	
	public double getAfterTaxIncome() {
		return this.annualIncome * 0.9;
	}
	
	public double getBonus() {
		return this.salary * 0.2 * 4;
	}
	
	public double getAfterTaxBonus() {
		return this.getBonus() * 0.945;
	}
}

public class Test02 {

	public static void main(String[] args) {
		Company cp = new Company(Double.parseDouble(args[0]));
		System.out.println("연 기본급 합: "+cp.getAnnualIncome()+" 세후: "+cp.getAfterTaxIncome());
		System.out.println("연 보너스 합: "+cp.getBonus()+" 세후: "+cp.getAfterTaxBonus());
		System.out.println("연 지급액 합: "+(cp.getAfterTaxIncome()+cp.getAfterTaxBonus()));
		

	}

}
