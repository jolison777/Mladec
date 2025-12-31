package com.example.Collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet data =new HashSet();
		data.add(1000);
		data.add("java");
		data.add('a');
		data.add(1000);
		data.add(22.344f);
		data.add(243.4);
		data.add(false);
		data.add(false);
		System.out.println(data);
		Iterator itr=data.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
			
		

	}

}
