package assign1;

public class SLinkedList<E> {
	// Instance variables:
	private static class Node<E> {
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() { return element; }
		
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> n) { next = n; }
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public SLinkedList() {}
	
	public int size() { return size; }
	
	public boolean isEmpty() { return size == 0; }
	public E first() {
		if (isEmpty()) return null; return head.getElement();
		}
		public E last() {
		if (isEmpty()) return null;
		return tail.getElement(); }
		// update methods
		public void addFirst(E e) {
		head = new Node<>(e, head); if (size == 0)
		tail = head; size++;
		}
		
		public Node remove(int index) {

		    Node curr = head;
		    Node removed;

		    if (index == 0) {
		    	removed = head;
		        head = head.getNext();
		    } else {
		        for (int i = 1; i < index; i++){
		            curr = curr.getNext();
		        }
		        removed = curr;
		        curr.setNext(curr.getNext().getNext());
		    }

		    this.size--;
		    
		    return removed;
		}
		
		public Object set(Object data, int index) {
		    Node curr = head;
		    for (int i = 0; i < 0; i++){
		        curr = curr.getNext();
		    }

		    curr.element = data;
		    return curr;
		}
		
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty()) {
			
			head = newest;
		} else {
			tail.setNext(newest);
		}
		
		tail = newest;
		
		size++;
	}
	
	
	public E removeFirst() {
		if (isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size ==0) {
			tail = null;
		}
		
		return answer;
	}
	
	public Object get(int index) {

	    Node curr = head;
	    for (int i = 0; i < index; i++){
	        curr = curr.getNext();
	    }

	    return curr.element;
	}
	
}
