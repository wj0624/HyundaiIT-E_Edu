package workshop07;

import java.text.SimpleDateFormat;
import java.util.Date;

class ConvertDate{
	public String convert(Date date, int type) {
		
		switch(type) {
		case 1:
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(date);
		case 2:
			df = new SimpleDateFormat("yy년 M월 d일 E요일");
			return df.format(date);
		case 3:
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
			return df.format(date);
		}
		return null;
		
	}
}

public class Test06 {
	public static void main(String[] args) {
		ConvertDate cd = new ConvertDate();
		Date d = new Date();
		System.out.println("1) "+cd.convert(d, 1));
		System.out.println("2) "+cd.convert(d, 2));
		System.out.println("3) "+cd.convert(d, 3));
		
	}
}
