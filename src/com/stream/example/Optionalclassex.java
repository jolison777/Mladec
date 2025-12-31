package com.stream.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Optionalclassex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<Integer> nums=Arrays.asList(3,5,7,9);
Optional<Integer> dt =nums.stream().findAny();
if(dt.isPresent()) {
	System.out.println(dt.get());
}
else
{
	System.out.println("no data");
}
List<String> names=Arrays.asList("sky","kholi","dravid","rohit","dhoni");
Optional<String> rstl=names.stream().findFirst();
 
if(rstl.isPresent()) {
	System.out.println(rstl.get());
}
else {
	System.out.println("no data");
}
	}
	 

}
