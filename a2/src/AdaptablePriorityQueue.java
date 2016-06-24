/** Extends the priority queue interface to support removal
 * and reprioritization of elements.  
 *
 * To implement this interface efficiently, you will need a
 * location-aware implementation of entries (so that you can restore
 * the heap property after such changes).
 */

public interface AdaptablePriorityQueue extends PriorityQueue { 

  /** Remove an entry, and return that entry (for convenience).
   * Note that you can say, for example,
   *    Entry e = pq.remove(pq.min())
   * which is equivalent to 
   *    Entry e = pq.removeMin();
   */
  public Entry remove(Entry e) throws InvalidEntryException;

  /** Replace the key of the given entry.  
   * Return the old key, for convenience.
   */
  public Object replaceKey(Entry e, Object key) throws InvalidEntryException, InvalidKeyException;

  /** Replace the value of the given entry.
   * Return the old value, for convenience.
   */
  public Object replaceValue(Entry e, Object value) throws InvalidEntryException;
}
