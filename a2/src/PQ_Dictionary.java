/**
* PQ_Dictionary implementing PriorityQueue
* @author Oskar Niburski
*/
import java.util.Comparator;

public class PQ_Dictionary<K,V> implements PriorityQueue<K,V> {
	int size;

	/**
	* Unsorted PQ Entry Node
	* @author Oskar Niburski
	*/
	protected static class InnerEntry<K,V> implements Entry<K,V> { 
		 private K k; // key
		 private V v; // value
		 public InnerEntry(K key, V value) {
		 	k = key;
		 	v = value;
		 }
	 // The Key and value
		 public K getKey() { return k; }
		 public V getValue() { return v; }
	 
	 } 
	 private Comparator<K> comp;
	 
	 protected PQ_Dictionary(Comparator<K> c) { comp = c; }

	 protected int compare(Entry<K,V> a, Entry<K,V> b) {
	 	return comp.compare(a.getKey(), b.getKey()); }

	 	protected boolean checkKey(K key) throws IllegalArgumentException {
	 		try {
	 return (comp.compare(key,key) == 0); // see if key can be compared to itself
	} catch (ClassCastException e) {
		throw new IllegalArgumentException("Wrong key");
	} 
}

	private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();
	/**
* isEmpty()
* Checks emptiness of queue
* @param
* @return boolean
*/
	public boolean isEmpty() { return size() == 0; }


		/**
* isEmpty()
* Checks size of queue
* @param
* @return int
*/
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

		/**
* insert()
* Adds entry to queue
* @param K key, V value
* @return Entry
*/
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key); 
		Entry<K,V> newest = new InnerEntry<>(key, value); list.addLast(newest);
		return newest;
	}

		/**
* min()
* Grabs smallest element
* @param
* @return Entry
*/
	@Override
	public Entry<K, V> min() {
		// TODO Auto-generated method stub
		if (list.isEmpty()) return null;
		return findMin().element();
	}

		/**
* removeMin()
* removes the smallest min
* @param	
* @return Entry
*/
	@Override
	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		if (list.isEmpty()) return null;
		return list.remove(findMin());
	}
	
		/**
* isEmpty()
* findMin()
* @param
* @return Position entry!
*/
	private Position<Entry<K,V>> findMin() { 
		Position<Entry<K,V>> small = list.first();
		for (Position<Entry<K,V>> walk : list.positions())
		if (compare(walk.element(), small.element()) < 0) {
			small = walk; 
		}
	return small; 
}


}
