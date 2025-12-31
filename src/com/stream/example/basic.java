package com.stream.example;

import java.util.Arrays;
import java.util.List;

public class basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 List<String> names=Arrays.asList("sky","kholi","dravid","rohit","dhoni");
 names.stream()
 .map(n->n.toUpperCase())
 .forEach((k)->System.out.println(k));
 
 
 
 List<Integer> nums=Arrays.asList(2,3,4,5,6,8);
 nums.stream()
 .map(n-> n*n)
 .forEach(System.out::println);
	}

}
