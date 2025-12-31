package com.stream.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class flatMapex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<Integer> list1=Arrays.asList(10,20,30,40);
List<Integer> list2=Arrays.asList(11,22,33,44);
List<List<Integer>> cmbnd=Arrays.asList(list1,list2);
List<Integer> flatmp=cmbnd.stream().flatMap(List::stream).toList();
System.out.println(flatmp);
	}

}
