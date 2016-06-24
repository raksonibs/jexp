/***********************************
 * EECS2011 - Assignment 3
 * File name: ArrayDeque.java
 * Author: Niburski, Oskar
 * Email: oskarniburski@gmail.com
 * CSE number: 212644944
 ************************************/


public class ArrayDeque
{
	public static final int INIT_CAPACITY = 8;	// initial array capacity
	protected int capacity;  // current capacity of the array
	protected int front;     // index of the front element
	protected int rear;      // index of the rear element
	protected int[] A;	    // array deque

	public ArrayDeque( )      // constructor method
	{
		A = new int[ INIT_CAPACITY ];
		capacity = INIT_CAPACITY;
		front = rear = 0;
	}


	/**
	 * Display the content of the deque
	 * 
	 */
	public void printDeque( )
	{
		for ( int i = front; i != rear; i = (i+1) % capacity )
			System.out.print( A[i] + " " );
		System.out.println();
	}


	/**
	 * Display the content of the whole array
	 *
	 */
	public void printArray( )
	{
		for ( int i = 0; i < capacity; i++ )
			System.out.print( A[i] + " " );
		System.out.println();
	}


	// ***************************************
	// DO NOT MODIFY THE CODE ABOVE THIS LINE.
	// ADD YOUR CODE BELOW THIS LINE.
	//
	// ***************************************
	private int size = 0;
	
	/**
	 * Returns the number of items in this collection.
	 * @return the number of items in this collection.
	 */
	public int size()
	{

		return size;
	}


	/**
	 * Returns true if this collection is empty.
	 * @return true if this collection is empty.
	 */ 
	public boolean isEmpty()
	{
		if (size() == 0) {
			return true;
		}  
		
		return false;
		
	}


	/**
	 * Returns the first element of the deque
	 * 
	 */
	public int getFirst() throws EmptyDequeException
	{
		if (isEmpty()) {
			throw new EmptyDequeException("Queue is empty.");
		}

		return A[front];    
	}


	/**
	 * Returns the last element of the deque
	 * 
	 */
	public int getLast( ) throws EmptyDequeException
	{
		if (isEmpty()) {
			throw new EmptyDequeException("Queue is empty.");
		}
		// should this be capacity instead?
		int last = (rear - 1 + size) % size;
		
		return A[last];
	}


	/**
	 * Inserts e at the beginning (as the first element) of the deque
	 * 
	 */
	public void insertFirst( int e )
	{
		int nextAvailable = 0;
		
		if (size < capacity) {
			// incremement normally
			nextAvailable = (front - 1 + capacity) % capacity;
			A[nextAvailable] = e;
			
		} else if (size == 0) {
			// everything is zero, just increase by one!
			A[front] = e;
			front++;	
			rear++;
					
		} else {
//			need to expand here!
			int[] T = new int[capacity * 2];
			for (int i = 0; i < capacity; ++i) {
				T[i] = A[i];
			}
			
			A = T;
			capacity = capacity * 2;
			A[capacity - 1] = e;
			
			// step back 1 on capcity to place to newer front!
		}
		
		front = (front - 1 + capacity) % capacity;
		size++; 
	}


	/**
	 * Inserts e at the end (as the last element) of the deque
	 * 
	 */
	public void insertLast( int e )
	{
		
		if (size < capacity) {
			// grab next available
			int nextAvailable = (front + size) % capacity;
			A[nextAvailable] = e;
			
		} else if (isEmpty()) {
			// normal
			A[rear] = e;
			rear++;
			
		} else {
			// increase size!
			int[] B = new int[capacity * 2];
			for (int i = 0; i < capacity; i++) {
				B[i] = A[i];
			}
			
			A = B;
			A[capacity] = e;
			capacity = capacity * 2;
			rear = front + size;
		}
		// don't forget to increase overall size and change pointers!
		size++;
		rear = (front + size) % capacity;

	}


	/**
	 * Removes and returns the first element of the deque
	 * 
	 */
	public int removeFirst( ) throws EmptyDequeException
	{
		int j = 0;
		
		if (isEmpty()) {
			throw new EmptyDequeException("Queue is empty.");
		}
		
		if (size < capacity/4 && size > INIT_CAPACITY) {
			int[] B = new int[capacity / 2];
			// start from front and copy all to new shrunk array
			// odd to think about on the 1/4th
			for (int i = front; i != rear; i++) {
				B[j] = A[i];
				j++;
			}
			// perform ops
			A = B;
			capacity = capacity / 2;
			front = 0;
			rear = front + size;
		}
		
		int first = A[front];
		A[front] = 0;
		front = (front + 1) % capacity;
		size--;
		
		if (isEmpty()) {
			//IMPORTANT: CHECK IF EMPTY AGAIN!
			// note: this is where my previous attempt did not work. always remember to reset the value if empty, or front and rear may point to incorrect things on empty!
			front = 0;
			rear = 0;
		}
		
		return first; 
	}


	/**
	 * Removes and returns the last element of the deque
	 * 
	 */
	public int removeLast( ) throws EmptyDequeException
	{
		if (isEmpty()) {
			throw new EmptyDequeException("Queue is empty.");
		}
		
		if (size < capacity/4 && size > INIT_CAPACITY) {
			int[] B = new int[capacity / 2];
			for (int i = (front + size); i > 0; --i) {
				B[i] = A[i];
			}
			
			A = B;
			capacity = capacity / 2;
			rear = capacity - 1;
			front = 0;
			rear = front + size;
		}
		
		int lastIndexKnown = (rear - 1 + size) % size;
		int last = A[lastIndexKnown];
		A[lastIndexKnown] = 0;
		size--;
		rear = (front + size) % capacity;
		
		if (isEmpty())  {
			front = 0;
			rear = 0;
		}
		
		return last;	

	}

}  // end class

