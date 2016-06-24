// From the textbook.

/** Realization of a priority queue by means of a heap.  The heap is
  * built upon a vector-based complete binary tree.
  */
import java.util.Comparator;  // conveniently makes "Comparator" refer to "java.util.Comparator"

public class HeapPriorityQueue implements PriorityQueue { 
  protected CompleteBinaryTree T;
  protected Comparator comp;

  /** Creates an empty heap with the default comparator. */ 
  public HeapPriorityQueue() {  
    T = new VectorCompleteBinaryTree(); // use a vector-based tree
    comp = new DefaultComparator();     // use the default comparator, defined below
  }

  /** Creates an empty heap with the given comparator. */
  public HeapPriorityQueue(Comparator c) {
    T = new VectorCompleteBinaryTree();
    comp = c;
  }

  /** Returns the size of the heap. */
  public int size() { return T.size(); } 

  /** Returns whether the heap is empty. */
  public boolean isEmpty() { return T.size() == 0; }

  /** Inserts a key-value pair and return the Entry created. */
  public Entry insert(Object k, Object x) throws InvalidKeyException {
    checkKey(k);                      // may throw an InvalidKeyException
    Entry entry = new MyEntry(k,x);   // MyEntry is an inner class, defined below
    upHeap(T.add(entry));
    return entry;
  }

  /** Returns an entry with minimum key, without removing it. */
  public Entry min() throws EmptyPriorityQueueException {
    if (isEmpty()) 
      throw new EmptyPriorityQueueException("Priority queue is empty");
    return entry(T.root());
  }

  /** Removes and returns an Entry with minimum key. */
  public Entry removeMin() throws EmptyPriorityQueueException {
    if (isEmpty()) 
      throw new EmptyPriorityQueueException("Priority queue is empty");
    Entry min = entry(T.root());
    if (size() == 1)
      T.remove();
    else {
      T.replace(T.root(), T.remove());
      downHeap(T.root());
    }
    return min;
  }

  /************************************
   * The following methods are protected. 
   * They won't be called by users of the priority queue.
   * Rather, they are for internal use by the other methods.
   ************************************/

  /** Returns the entry stored at a particular position in the heap. */
  protected Entry entry (Position p) { 
    return (Entry) p.element(); 
  }

  /** Returns the key stored at a particular position in the heap. */
  protected Object key (Position p) {
    return ((Entry) p.element()).key(); 
  }

  /** Determines whether a given key is valid. */
  protected void checkKey(Object key) throws InvalidKeyException {
    try {
      comp.compare(key,key);
    }
    catch(Exception e) {
      throw new InvalidKeyException("Invalid key");
    }
  }

  /** Performs up-heap bubbling. */
  protected void upHeap(Position v) {
    Position u;
    while (!T.isRoot(v)) {
      u = T.parent(v);
      if (comp.compare(key(u), key(v)) <= 0) break;
      swapElements(u, v);
      v = u;
    }
  }

  /** Performs down-heap bubbling. */
  protected void downHeap(Position r) {
    while (T.isInternal(r)) {
      Position s;		// the position of the smaller child
      if (!T.hasRight(r))
	s = T.left(r);
      else if (comp.compare(key(T.left(r)), key(T.right(r))) <=0)
	s = T.left(r);
      else
	s = T.right(r);
      if (comp.compare(key(s), key(r)) < 0) {
	swapElements(r, s);
	r = s;
      }
      else 
	break;
    }
  }

  /** Swaps the elements of the two positions. */
  protected void swapElements(Position x, Position y) {
    Object temp = x.element();
    T.replace(x, y.element());
    T.replace(y, temp);
  }

  /** Useful to print the heap for debugging purposes */
  public String toString() {
    return T.toString();
  }

  /************************************
   * The following classes are protected. 
   * They won't be used publicly.
   * Rather, they are for internal use by the methods of this class,
   * which is why we're defining them INSIDE this class.
   ************************************/

  /** Inner class for heap entries. */
  protected static class MyEntry implements Entry {
    protected Object key, value;
    public MyEntry(Object k, Object v) { key = k; value = v; }
    public Object key() { return key; }
    public Object value() { return value; }
  }

  /** Inner class for a comparator that uses the natural ordering of keys. */
  protected static class DefaultComparator implements Comparator {
    public DefaultComparator() { /* default constructor */ }
    public int compare(Object a, Object b) throws ClassCastException { 
      return ((Comparable) a).compareTo(b); // use the natural order for a
    }
  }
}
