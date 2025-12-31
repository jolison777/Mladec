package com.Generics.example;

import java.util.Arrays;
import java.util.List;

public class Exp3 {
	private static double add(List<? extends Number> list) {
		double a=0;
		for(Number n:list) {
			a+=n.doubleValue();
		}
		return a;
	}
//unbounded wildcards
	private static void unboundedData(List<?> list) {
		System.out.println(list);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<Integer> list1=Arrays.asList(12,3,4,5,6);
add(list1);
List<Double> list2=Arrays.asList(34.44,33.55,55.44);
add(list2);
unboundedData(list2);
unboundedData(list1); 

	}

}
