package com.example.Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class asListexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<String> names=Arrays.asList("rohit","kholi","dravid"+"dhoni","pant","sky","axar");
Collections.sort(names);
//names.forEach((K)->System.out.println(K));
Collections.shuffle(names);
names.forEach((K)->System.out.println(K));
	}

}
