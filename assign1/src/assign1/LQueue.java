package assign1;
/***********************************
* EECS2011 - Assignment 1
* File name: LQueue.java
* Author: Oskar Niburski
* Student Number: 212644944
* Comments: 
* 	Array list Advantages
* 		simple index access and allows for simple shifting. All O(1) here!
* 	Array List Disadvantages
* 		when using fixed size, problematic because list could be full. Using dynamic array, and the addDouble method provided below uses a much more dynamic way to add assumging one wants a dynmic array.
* 	Linked List Advantages
* 		All O(1)
* 	Linked List Disadvantages
* 		Uses more space because each node stores refrence to next compared to properly sized array
* 		As such, linked lists have large number of primitice operations per call
* 		Thus more expensive
* NOTE: I assumed a simple array, however add for dynamic array is addDouble, assuming this was necessary
************************************/

public class LQueue<E> implements Queue<E> {
	public static final int INIT_CAPACITY = 8;	// initial array capacity
	protected int capacity;  // current capacity of the array
	protected int front;     // index of the front element
	protected int rear;      // index of the rear element
	private E[] A;	    // array deque
	private int size = 0;
	
	private SLinkedList<E> list = new SLinkedList<>(); // an empty list public LinkedQueue() { } // new queue relies on the initially empty list public int size() { return list.size(); }
//  running time O(1)
	public boolean isEmpty() { 
		return list.isEmpty(); 
	}
//  running time O(1)
	public E first() { 
		return list.first(); 
	}
//  running time O(1)
	public E dequeue() { 
		return list.removeFirst(); 
	}
//  running time O(1)
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}
//  running time O(1)
	@Override
	public Object front() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if (list.isEmpty()) {
			throw new EmptyQueueException("Empty exception");
		}
		
		return list.first();
	}
//  running time O(1)
	@Override
	public void enqueue(Object o) {
		// TODO Auto-generated method stub
		 list.addLast((E) o);
		
	}
}

