package com.example.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int []arr= {12,13,14,'a'}; for(int i=0;i<arr.length;i++) {
		 * System.out.println(arr[i]); }
		 */
		ArrayList l1=new ArrayList();
		l1.add("java");
		l1.add(l1);
		l1.add('a');
		l1.add("java");
		l1.add(3.23f);
		l1.add(80.5);
		l1.add(false);
	 l1.add("jiii");
	// System.out.println(l1);
	 ListIterator itr=l1.listIterator();
	 while(itr.hasNext()) {
		 System.out.println(itr.next());
		 ;
	 }
		
	
		
		 while(itr.hasPrevious()) { System.out.println(itr.previous()); }
		 

System.out.println(l1.get(0));
System.out.println(l1.size());
l1.set(0, "qw");
System.out.println(l1.get(0));


	}

}
