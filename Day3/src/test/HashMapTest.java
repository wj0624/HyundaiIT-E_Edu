package test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "안녕하세요"); //삽입
		map.put("2", "하이하이");
		
		System.out.println(map.get("2")); //key값으로 value 가져오기
	}

}