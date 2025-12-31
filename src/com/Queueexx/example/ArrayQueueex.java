package com.Queueexx.example;


class ArrayQueue
{
	 int[] arr;
	private int front;
	int rear;
	private int size;
	private int capacity;
	public ArrayQueue(int capacity)
	{
		this.capacity = capacity;
		this.arr = new int[capacity];
		this.front = 0;
		this.rear = -1;
		this.size = 0;
	}
	public boolean isEmpty()
	{
		return size == 0;
	}
	public boolean isFull()
	{
		return size == capacity;
	}
	public int size()
	{
		return size;
	}
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println("queuee is full");
			return;
		}
		rear=(rear+1)%capacity;
		arr[rear]=value;
		size++;
		System.out.println("Enqueued one element: "+value);
	}
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("the queue is empty");
			return -1;
		}
		int value=arr[front];
		front=(front+1)%capacity;
		size--;
		return value;
	}
	public int peek() {
		if(isEmpty()) {
			System.out.println("queue is empty");
			return -1;
		}
		return arr[front];
	}
}

public class ArrayQueueex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue data=new ArrayQueue(5);
		data.enqueue(10);
		data.enqueue(20);
		data.enqueue(30);
		data.enqueue(40);
		data.enqueue(50);
		data.enqueue(60);
		System.out.println("top element is: "+data.peek());
		data.dequeue();
		data.dequeue();
		System.out.println("top element is : "+data.peek());
		data.enqueue(60);
		data.enqueue(70);
		System.out.println("The rear element :"+data.arr[data.rear]);

	}

}
