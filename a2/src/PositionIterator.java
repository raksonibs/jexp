import java.util.Iterator;
import java.util.NoSuchElementException;

public class PositionIterator<E> implements Iterator<Position<E>> {
	private Position<E> cursor = first();	
	private Position<E> recent = null;	
	
	public boolean hasNext() { return (cursor != null);	} 
	private Position<E> first() {
		// TODO Auto-generated method stub
		return cursor;
	}
	public	Position<E>	next( )	throws	NoSuchElementException	{
		if (cursor == null) throw new NoSuchElementException("nothing left"); 
	return recent = cursor;	
}
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
		
	}
	}
