public class HeapAdaptablePriorityQueue extends HeapPriorityQueue 
                                        implements AdaptablePriorityQueue {

  /*******************************************
   * Inner class for a location-aware entry. 
   * This is taken from the textbook. 
   */
  protected static class LocationAwareEntry 
    extends MyEntry implements Entry {
    /** Position where the entry is stored. */
    private Position loc;
    public LocationAwareEntry(Object key, Object value) {
      super(key, value);
    }
    public LocationAwareEntry(Object key, Object value, Position pos) {
      super(key, value);
      loc = pos;
    }
    protected Position location() {
      return loc;
    }
    protected Position setLocation(Position pos) {
      Position oldPosition = location();
      loc = pos;
      return oldPosition;
    }
    protected Object setKey(Object key) {
      Object oldKey = key();
      this.key = key;
      return oldKey;
    }
    protected Object setValue(Object value) {
      Object oldValue = value();
      this.value = value;
      return oldValue;
    }
  }
  /* Okay, that's the end of the nested inner class.
   ***************************************************/

  // **** Constructors.

  public HeapAdaptablePriorityQueue() {
    super();
  }
  public HeapAdaptablePriorityQueue(java.util.Comparator c) {
    super(c);
  }

  // **** New methods needed to implement AdaptablePriorityQueue.

  public Object replaceValue(Entry e, Object value) throws InvalidEntryException {
    checkEntry(e);
    return ((LocationAwareEntry)e).setValue(value);
  }

  public Object replaceKey(Entry e, Object key) throws InvalidEntryException, InvalidKeyException {
//    FILL THIS IN
	  return key;
  }
    
  public Entry remove(Entry e) throws InvalidEntryException {
//    FILL THIS IN
	  return e;
  }


  /** New protected helper method.  
   * FILL IN THE DOCUMENTATION.
   */
  protected void upOrDownHeap(Position p, Entry e) {
    upHeap(p);
    if (p.element() == e)    // didn't need to bubble up
      downHeap(p);
  }
  
  /** Helper method to determine whether a given entry is valid.   
   * (Improved from the textbook.)
   */
  protected void checkEntry(Entry e) throws InvalidEntryException {
    if (e == null)
      throw new InvalidEntryException("null entry");
    else if (!(e instanceof LocationAwareEntry))
      throw new InvalidEntryException("entry is not location-aware");
    else if (e != ((LocationAwareEntry)e).location().element())
      throw new InvalidEntryException("location-aware entry is not at the position where it thinks it is");
  }

  // **** Override methods of HeapPriorityQueue.

//  FILL THIS IN

  // **** Test.


  public static void main(String args[]) {
  
//    FILL THIS IN 

  }
}
