package com.Queueexx.example;

import java.util.NoSuchElementException;

class Node<T>{
	T data;
	Node<T> next;
	Node(T data){
		this.data=data;
		this.next=null;
	}
}
class LinkendListQueue<T>{
	private Node<T> front,rear;
	private int size;
	public LinkendListQueue() {
		this.front=null;
		this.rear=null;
		this.size=0;
	}
	public boolean isEmpty() {
		return this.front==null;
	}
	public int size() {
		return size;
	}
	public void enqueue(T item) {
		Node<T> newnode =new Node<>(item);
		if(isEmpty()) {
			front=newnode;
			rear=newnode;
		}
		else {
			
			rear.next=newnode;
			rear=newnode;
		}
		size++;
	}
	public T dequeue() {
		if(isEmpty()) {
			System.out.println("the queue is empty");
			throw(new NoSuchElementException());
		}
		T data=front.data;
		front=front.next;
		if(front==null) {
			rear=null;
		}
		size--;
		return data;
	}
	public T peek() {
		if(isEmpty()) {
			throw(new NoSuchElementException("Queue is empty"));
		}
		return front.data;
	}
}

public class LinkedListQueueex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkendListQueue<Integer> listtt=new LinkendListQueue();
		listtt.enqueue(101);
		listtt.enqueue(301);
		listtt.enqueue(201);
		listtt.enqueue(401);
		listtt.enqueue(501);
		   System.out.println("Size: " + listtt.size());       
	        System.out.println("Dequeued: " + listtt.dequeue());
	        System.out.println("Peek: " + listtt.peek());        
	        System.out.println("Size after dequeue: " + listtt.size());
	        System.out.println("Is Empty: " + listtt.isEmpty());

	}

}
