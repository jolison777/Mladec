package com.example.Collection;

import java.util.ArrayList;
import java.util.List;

public class concurrentexception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");

		for (String s : list) {
		    if (s.equals("A")) {
		        list.remove(s); // ❌ Throws ConcurrentModificationException
		    }
		}
		for(String s:list) {
			System.out.println(s);
		}

	}

}
