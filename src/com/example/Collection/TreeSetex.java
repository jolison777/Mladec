package com.example.Collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
TreeSet data=new TreeSet();
data.add("ja");
data.add("e");
data.add("javascript");
data.add("edu");
data.add("java");
data.add("python");
data.add("education");
data.add("angular");
Iterator itr=data.iterator();

 // while(itr.hasNext()) { System.out.println(itr.next()); }
 
System.out.println(data.subSet("angular",true ,"python",true));
System.out.println(data.ceiling("j"));
System.out.println(data.floor("e"));
System.out.println(data.lower("ed"));
System.out.println(data.higher("ed"));
TreeSet<String> data1 = new TreeSet<>();
data1.add("a");
data1.add("c");
data1.add("f");
data1.add("k");
System.out.println(data1);

System.out.println(data1.ceiling("e")); // → "k"
System.out.println(data1.floor("l")); // → "c"
System.out.println(data1.higher("f"));
System.out.println(data1.lower  ("f"));

	}

}
