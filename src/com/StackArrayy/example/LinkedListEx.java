package com.StackArrayy.example;

import java.util.EmptyStackException;

class Node<T>{
	T data;
	Node<T> next;
	
	Node(T data){
		this.data=data;
		this.next=null;
	}
	
}
class LinkedListStack<T>{
	private Node<T> top;
	private int size;
	public LinkedListStack()
	{
		this.top=null;
		this.size=0;
	}
	public boolean isEmpty() {
		return top==null;
	}
	public int size() {
		return size;
	}
	public void push(T element) {
		Node<T> newNode=new Node<>(element);
		newNode.next=top;
		top=newNode;
		size++;
		System.out.println("Pushed Element: "+element);
	}
	public T pop() {
		if(isEmpty()){
			System.out.println("Stack Underflow");
			throw(new EmptyStackException());
		}
		T poppedElement=top.data;
		top=top.next;
		size--;
		return poppedElement;	
	}
	public T peek() {
		if(isEmpty()){
			System.out.println("Stack Underflow");
			throw(new EmptyStackException());
		}
		T poppedElement=top.data;
		return poppedElement;
		
	}
}

public class LinkedListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListStack<Integer> data=new LinkedListStack<>();
		data.push(100);
		data.push(500);
		data.push(400);
		data.push(300);
		data.push(200);
System.out.println("Top element is: "+data.peek());
System.out.println("Top element is: "+data.pop());
System.out.println("Top element is: "+data.size());


	}

}
