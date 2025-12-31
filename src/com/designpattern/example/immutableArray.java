package com.designpattern.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class makeImmutable{
	public List<int[]> arrayimmute() {
	    int[] arr = {1,2,3,4,5};  
	    return Collections.unmodifiableList(Arrays.asList(arr));
	}

}
public class immutableArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
makeImmutable m1=new makeImmutable();
List<int[]> l1=m1.arrayimmute();
int[]a=l1.get(0);
l1.add(a);
	}

}
