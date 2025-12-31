package com.example.Collection;

import java.util.TreeMap;

public class TreeMapex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 TreeMap<String, Integer> data=new TreeMap<String, Integer>();
 data.put("orange", 200);
 data.put("banana", 25);
 data.put("sprouts", 250);
 data.put("orangr", 15);
 data.put("mango", null);
 data.put("Zen",2);
data.forEach((K,V)->System.out.println("Item "+K+" Price "+V)); ;
	}

}
