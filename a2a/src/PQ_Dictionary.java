class EntryJ {
    private int key;
    private Object value;

    public EntryJ(int key2, Object value){
        this.key = key2;
        this.value = value;
    }
    public int getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

}

public class PQ_Dictionary implements PriorityQueue {
	private int size;
	private int capacity = 5;
    private EntryJ S[];
	
	public PQ_Dictionary() {
		// TODO Auto-generated constructor stub
		S = new EntryJ[capacity];
	    size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Entry min() throws EmptyPriorityQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry insert(int key, Object value) throws InvalidKeyException {
		EntryJ temp = new EntryJ(key, value);

	      int i = 0;
	      while(i < S.length) {
	        EntryJ t = (EntryJ) S[i];
//	        if (t.compareTo(temp) == -1) {
	            i++;
//	        } else {
//	            int j = i;
//	            S[j + 1] = S[j];
//	            j++;
//	        }

	       }
	       S[i] = (EntryJ) temp;
	       size++;
	       Entry tmp = new Entry((Object)key, value);
	       return tmp;
	}

	@Override
	public Entry removeMin() throws EmptyPriorityQueueException {
		// TODO Auto-generated method stub
		return null;
	}

}
