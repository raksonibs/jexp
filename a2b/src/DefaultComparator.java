import java.util.Comparator;
/**
* Comparator intiilizer
* @author Oskar Niburski
*/
public class DefaultComparator<E> implements Comparator<E> { 
	public int compare(E a, E b) throws ClassCastException {

return ((Comparable<E>) a).compareTo(b);
}
}