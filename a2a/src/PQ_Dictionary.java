public class PQ_Dictionary<K,V> implements PriorityQueue<K,V> {
	private int size;
	private int capacity = 5;
    private Entry S[];
	
    /**
	 * Constructor for pq dictionary
	 * run time O(1)
	 * @param
	 * @return
	 */
	public PQ_Dictionary() {
		// TODO Auto-generated constructor stub
		S = new Entry[capacity];
	    size = 0;
	}

	/**
	 * Returns size of dictionary
	 * O(1)
	 * @param 
	 * @return int x
	 */
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * Returns a boolean determining 
	 * run time O(1)
	 * @param
	 * @return Entry x
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	/**
	 * run time O(1)
	 * @param 
	 * @return Entry x
	 */
	public Entry min() throws EmptyPriorityQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param int key, Object value
	 * @return Entry x
	 */
	public Entry insert(int key, Object value) throws InvalidKeyException {
		Entry tmp = new Entry(key, value);
		size++;
		return tmp;
	}

	/**
	 * @param 
	 * @return Entry x
	 */
	public Entry removeMin() throws EmptyPriorityQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
