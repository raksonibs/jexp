// Code from the textbook.

/** Interface for the priority queue ADT */
public interface PriorityQueue<K,V> {

  /** Returns the number of items in the priority queue. */
	int size();
	boolean isEmpty();
	Entry<K,V> insert(K key, V value) throws IllegalArgumentException; 
	Entry<K,V> min();
	Entry<K,V> removeMin();
}
