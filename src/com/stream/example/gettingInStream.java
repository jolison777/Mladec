package com.stream.example;

import java.util.stream.Stream;

public class gettingInStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Number> strm=Stream.of(2,3,4,5);
		Stream<String> names=Stream.of("sky","rohit","dravid","kohli");
		Stream.of(2,3,4,5).parallel().findFirst().ifPresent(System.out::println);
		Stream.of("sky","rohit","dravid","kohli").parallel().sorted().forEach(System.out::println);
		names.sorted().forEach(t -> System.out.println(t));

	}

}
