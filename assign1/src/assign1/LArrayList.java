package assign1;
/***********************************
* EECS2011 - Assignment 1
* File name: LArrayList.java
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

public class LArrayList<E> implements List<E> {
    private E[] data;
    public static final int CAPACITY = 16;
    private int size = 0;
    protected Node head, tail;
    private SLinkedList<E> list = new SLinkedList<>(); // an empty list public LinkedQueue() { } // new queue relies on the initially empty list public int size() { return list.size(); }
//  running time O(1)
    public LArrayList() {
    	head = tail = null;
        size = 0;
    }
//  running time O(1)
    public LArrayList(int capacity) {
    	data = (E[]) new Object[capacity];
    }
    
    /**
     * Display the content of the array
     * O(N) running time
     */
    public void printArray( )
    {

	for ( Node p = head; p != null; p = p.getNext() )
	    System.out.print( p.getElement() + " " );
	System.out.println();

    }
//  running time O(1)
    public void add(int i, E e) {
    	checkIndex(i, size + 1);
    	list.addLast(e);
    	
    	
    	size++;
    }
//  running time O(1)
    public int size() {
        return size;
    }
//  running time O(1)
    public boolean isEmpty() {
        return list.isEmpty();
    }
//  running time O(1)
    public E get(int i) {
        checkIndex(i, size);
        return (E) list.get(i);
    }
//  running time O(1)
    public E remove(int i) throws IndexOutOfBoundsException {
    	checkIndex(i, size);
    	E temp = (E) list.remove(i);
    	return temp;
    }
//  running time O(1)
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return (E) list.set(e, i);
	}
//  running time O(1)
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException("illegal index: " + i);
		}
	}
}
