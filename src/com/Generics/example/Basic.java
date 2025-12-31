package com.Generics.example;

import java.util.ArrayList;
import java.util.List;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			ArrayList<String> data=new ArrayList<String>();
			data.add("php");
			data.add("khp");
			data.add("jhp");
			data.add("phpp");
			data.add("chp");
			for(String ch:data) {
				
					System.out.println( ch.startsWith("p"));
				
			}
			List<String> fltr = data.stream().filter(x->x.startsWith("p")).toList();
			System.out.println(fltr);
			
		

	}

}
