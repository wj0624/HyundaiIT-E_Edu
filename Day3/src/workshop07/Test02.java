package workshop07;

public class Test02 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("JAVAprogram");
		String str = null;
		str = sb.charAt(0)+sb.toString().substring(1,4).toLowerCase()+String.valueOf(sb.charAt(4)).toUpperCase()+sb.substring(5)+"mer";
		System.out.println(str);
	}
}
