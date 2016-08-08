/**
 * An interface for a position, which is a holder object storing a
 * single element.
 * @author Oskar Niburski
 */
//begin#fragment All
public interface Position<E> {
  /** Return the element stored at this position. */
  E element();
}
//end#fragment All