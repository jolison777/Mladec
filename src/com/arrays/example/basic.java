package com.arrays.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] names= {"rohit,'kholi'","mahi","sky","Bumrah"};
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		for(String s:names) {
			System.out.println(s+" ");
		}
		List<String> l1=Arrays.asList(names);
		System.out.println(l1.toString());
		
		
			
		}
	}


