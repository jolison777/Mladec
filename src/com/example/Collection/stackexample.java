package com.example.Collection;
import java.io.*;
import java.util.*;

public class stackexample {



	
	    public static void main(String args[])
	    {
	        // Creating an empty Stack
	        Stack stack = new Stack();

	        // Use add() method to add elements
	        stack.push(10);
	        stack.push(15.2f);
	        stack.push(30);
	        stack.push("java");
	        stack.push(5);

	        System.out.println("Initial Stack: " + stack);

	        // Removing elements using pop() method
	        System.out.println("Popped element: "
	                           + stack.pop());
	        System.out.println("Popped element: "
	                           + stack.pop());

	        // Displaying the Stack after pop operation
	        System.out.println("Stack after pop operation "
	                           + stack);
		    System.out.println(stack.search(10));


	        System.out.println("Is stack empty? "
	                           + stack.empty());
	        // Pop remaining elements
	        stack.pop();
	        stack.pop();
	        stack.pop();

	        // Check if the stack is empty
	        System.out.println("Is stack empty? "
	                           + stack.empty());
	}

}
