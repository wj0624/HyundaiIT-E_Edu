package workshop07;

import java.text.DecimalFormat;

class ConvertString{
	public String convert(String str) {
		DecimalFormat dec = new DecimalFormat("###,###");
		return dec.format(Integer.parseInt(str));
	}
}

public class Test07 {

	public static void main(String[] args) {
		ConvertString cs = new ConvertString();
		System.out.println(cs.convert(args[0])+"원");
	}

}
