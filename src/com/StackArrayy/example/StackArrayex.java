package com.StackArrayy.example;


class StackArrays{
	private int maxSize;
	private int[]arr;
	private int top;
	
	public StackArrays(int size) {
		
		    this.arr = new int[size];
		    this.maxSize = size;   // ✅ assign parameter
		    this.top = -1;         // ✅ start with empty stack
	}
	
	public boolean isFull() {
		return(top==maxSize-1);
	}
	public boolean isEmpty() {
		return (top==-1);
	}
	public void push(int value) {
		if(isFull()) {
			System.out.println("STack Overflow");
			return;
		}
		arr[++top]=value;
		System.out.println("Element pushed : "+value);
	}
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack underflow we cant remove");
			return -1;
		}
		int tp=arr[top];
		top--;
		System.out.println("Popped element : "+tp);
		return tp;
	}
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stack underflow we cant remove");
			return -1;
		}
		int tp=arr[top];
		System.out.println("Popped element : "+tp);
		return tp;
	}
	public int size() {
		return top+1;
	}
}

public class StackArrayex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackArrays obj=new StackArrays(5);
		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(50);
		obj.push(60);
		obj.push(70);
		
		System.out.println(obj.size());


	}
	

}
