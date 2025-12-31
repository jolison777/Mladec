package com.example.Collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Map data = new java.util.HashMap<>();
data.put("java", "Spring");
data.put(101, "php");
data.put('w', 99);
data.put(false, "yes");
data.put(101, "Rohit");
System.out.println(data);
System.out.println(data.size());
System.out.println(data.get('w'));
Iterator<Map.Entry> itr=data.entrySet().iterator();
while(itr.hasNext()) {
	Entry et=itr.next();
	System.out.println(et.getKey()+"="+et.getValue());
	
}
data.keySet().forEach(x ->System.out.println(x+" <- : ->"+data.get(x)));


	}

}
