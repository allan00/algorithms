package test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class collection {

	public static void main(String[] args) {
		Map<String, String> hashmap = new HashMap<String , String>();
		hashmap.put(null, null);
		hashmap.put(null, "2");
		hashmap.put(null, "3");
		System.out.println(hashmap.get(null));
		System.out.println(hashmap.size());
		LinkedHashMap<String, String> l = new LinkedHashMap<String, String>();
		
	}

}
