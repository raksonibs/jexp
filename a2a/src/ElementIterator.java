

import java.util.Iterator;

public class ElementIterator<E> implements Iterator<E> {
	
	 protected PositionList<E> list; // the underlying list
	  protected Position<E> next; // the next position

	Iterator<Position<E>>	posIterator	=	new	PositionIterator();
	


	public ElementIterator(PositionList<E> positionList) 
	{
		list = positionList;
		next = (list.isEmpty())? null : list.first();
	}


	public boolean hasNext() {
		return posIterator.hasNext();
	}

	
	public E next() {
		return posIterator.next().getElement();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
