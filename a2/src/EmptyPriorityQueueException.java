/**
 * Runtime exception thrown when one tries to get at the 
 * minimum element of an empty priority queue.
 */

public class EmptyPriorityQueueException extends RuntimeException {  
  public EmptyPriorityQueueException() { }
  public EmptyPriorityQueueException(String err) { super(err); }
}

