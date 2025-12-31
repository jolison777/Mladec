package com.example.Collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
 
class BookBro
{
	private int id;
	private int price;
	private String author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BookBro(int id, int price, String author) {
		super();
		this.id = id;
		this.price = price;
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", price=" + price + ", author=" + author + "]";
	}
}
public class withoutComparableComparator {
 
	public static void main(String[] args) {
		List<BookBro> dta = Arrays.asList(new BookBro(101,300,"java"),
				new BookBro(201,10,"php"),
				new BookBro(501,40,"python"),
				new BookBro(301,55,"c"),
				new BookBro(400, 25, "kotlin"));
		
		Function<BookBro,String> fn = BookBro::getAuthor;
		
		
		
		dta.stream().sorted(Comparator.comparing(BookBro::getId))
		.forEach(System.out::println);
	}
 
}


