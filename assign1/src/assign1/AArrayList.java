package assign1;
/***********************************
* EECS2011 - Assignment 1
* File name: AArrayList.java
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

public class AArrayList<E> implements List<E> {
    private E[] data;
    public static int CAPACITY = 10000;
    private int size = 0;
    
//    constructor
//    running time O(1)
    public AArrayList() {
       this(CAPACITY);
    }
//  constructor
//  running time O(1)
    public AArrayList(int capacity) {
    	data = (E[]) new Object[capacity];
    }
    
//  add method
//  running time O(n)
    public void add(int i, E e) {
    	checkVal(i, size + 1);
    	if (size == data.length) {
    		throw new IllegalStateException("Array is full");
    	}
    	for (int k=size - 1; k >= i; k--) {
    		data[k+1] = data[k];
    	}
    	data[i] = e;
    	size++;
    }
    
//    add double, assuming dynmaic array
//     addDouble is O(n) at full capacity, but amortized time is O(1)
    public void addDouble(int i, E e) {
    	checkVal(i, size + 1);
    	if (size == CAPACITY) {
    		CAPACITY = CAPACITY * 2;
    		E[] newdata = (E[]) new Object[CAPACITY];
    		for (int j = 0; j < size; j++) {
    			newdata[j] = data[j];
    		}
    		
    		data = newdata;
    	}
    	
    	for (int k=size - 1; k >= i; k--) {
    		data[k+1] = data[k];
    	}
    	data[i] = e;
    	size++;
    }
//  size method
//  running time O(1)
    public int size() {
        return size;
    }
//  isEm[ty method
//  running time O(1)
    public boolean isEmpty() {
        return size == 0;
    }
//  get method
//  running time O(1)
    public E get(int i) {
        checkVal(i, size);
        return data[i];
    }
//  remove method
//  running time O(n)
    public E remove(int i) throws IndexOutOfBoundsException {
    	checkVal(i, size);
    	E temp = data[i];
    	for (int k = i; k < size - 1; k++) {
    		data[k] = data[k+1]; 
    	}
    	data[size - 1] = null; 
    	size--;
    	return temp;
    }
//  set method
//  running time O(1)
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkVal(i, size);
		E tmp = data[i]; 
		data[i] = e;
		return tmp;
	}
	
//  checkindex helper method
//  running time O(1)
	protected void checkVal(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException("illegal index: " + i);
		}
	}
}
