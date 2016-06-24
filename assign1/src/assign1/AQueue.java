package assign1;
/***********************************
* EECS2011 - Assignment 1
* File name: AQueue.java
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
public class AQueue<E> {
	public static final int INIT_CAPACITY = 8;	// initial array capacity
	protected int capacity;  // current capacity of the array
	protected int front;     // index of the front element
	protected int rear;      // index of the rear element
	private E[] A;	    // array 
	private int size = 0;
//  constructor
//  running time O(1)
	public AQueue()      // constructor method
	{
		this(INIT_CAPACITY);
		capacity = INIT_CAPACITY;
		front = rear = 0;
	}
//  constructor
//  running time O(1)
	public AQueue(int capacity) {
		A = (E[]) new Object[capacity];
	}
//  [rint helper
//  running time O(n)
	public void printQueue( )
	{
		for ( int i = front; i != rear; i = (i+1) % capacity )
			System.out.print( A[i] + " " );
		System.out.println();
	}
//  size
//  running time O(1)
	public int size() {
		return size;
	}
//  empty check
//  running time O(1)
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}  
		
		return false;
	}

//  first
//  running time O(1)	
	public E first() {
		if (isEmpty()) return null;
//		int avail = (front + size) % A.length; // use modular arithmetic
		return A[front];
	}
	
//  first
//  running time O(1)	
	public E front() {
		if (isEmpty()) return null;
//		int avail = (front + size) % A.length; // use modular arithmetic
		return A[front];
	}
//  enqueu with modular approach
//  running time O(1)
	public void enqueue(Object e) throws FullQueueException {
		if (size == A.length) throw new FullQueueException("Queue is full");
		int avail = (front + size) % A.length; // use modular arithmetic
		A[avail] = (E) e;
		size++;
	}
// dequeue with modular approach
//  running time O(1)
	public Object dequeue() throws EmptyQueueException {
		if (isEmpty()) return null;
		E answer = A[front];
		A[front] = null;
		front = (front + 1) % A.length;
		size--;
		return answer;
	}
}
