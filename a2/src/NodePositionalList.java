import java.util.Iterator;


public class NodePositionalList<E> implements PositionalList<E>, Iterable<E> {

	protected int size;
	protected DNode<E> front, back;

	public NodePositionalList() {
		size = 0;
		front = new DNode<E>(null, null, null);
		back = new DNode<E>(front, null, null);
		front.setNext(back);
	}

	protected Position<E> checkPosition(Position<E> v)
			throws InvalidPositionException {
		if (v == null || !(v instanceof DNode))
			throw new InvalidPositionException("The position is invalid");
		return (TreePosition<E>) v;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Position<E> first() {
		return front.getNext();
	}

	@Override
	public Position<E> last() {
		return back.getPrev();
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {

		DNode<E> temporary = (DNode<E>) checkPosition(p);
		DNode<E> previous = temporary.getPrev();
		if (previous == front)
			throw new IllegalArgumentException(null);
		return previous;

	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		DNode<E> temporary = (DNode<E>) checkPosition(p);
		DNode<E> next = temporary.getNext();
		if (next == back)
			throw new IllegalArgumentException(null);
		return next;
	}

	@Override
	public Position<E> addFirst(E e) {
		DNode<E> Dnodenew;
		Dnodenew = new DNode<E>(front, front.getNext(), e);
		front.getNext().setPrev(Dnodenew);
		front.setNext(Dnodenew);
		size = size + 1;
		return first();
	}

	@Override
	public Position<E> addLast(E e) {
		DNode<E> OLast = back.getPrev();
		DNode<E> Dnodenew = new DNode<E>(OLast, back, e);
		OLast.setNext(Dnodenew);
		back.setPrev(Dnodenew);
		size = size + 1;
		return back;
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e)
			throws IllegalArgumentException {

		DNode<E> temporary = (DNode<E>) checkPosition(p);
		DNode<E> newerNode = new DNode<E>(temporary, temporary.getPrev(), e);
		temporary.getPrev().setNext(newerNode);
		temporary.setPrev(newerNode);
		size = size + 1;
		return temporary.getPrev();
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e)
			throws IllegalArgumentException {

		DNode<E> temporary = (DNode<E>) checkPosition(p);
		DNode<E> newerNode = new DNode<E>(temporary, temporary.getNext(), e);
		temporary.getNext().setPrev(newerNode);
		temporary.setNext(newerNode);
		size = size + 1;
		return temporary.getNext();
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		DNode<E> Temporary = (DNode<E>) checkPosition(p);
		E previouselement = Temporary.getElement();
		Temporary.setElement(e);
		return previouselement;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		DNode<E> temporary = (DNode<E>) checkPosition(p);

		E TemporaryE = temporary.getElement();

		DNode<E> TemporaryN = temporary.getNext();
		DNode<E> TemporaryP = temporary.getPrev();

		TemporaryP.setNext(TemporaryN);
		TemporaryN.setPrev(TemporaryP);

		temporary.setNext(null);
		temporary.setPrev(null);

		size = size - 1;
		return TemporaryE;
	}

	@Override
	public Iterable<Position<E>> positions() {
		PositionalList<Position<E>> plist = new NodePositionalList<Position<E>>();
		if (size != 0) {
			Position<E> tracker = first();
			do {
				plist.addLast(tracker);
				if (plist == this.last()) {
					break;
				} else {
					tracker = this.after(tracker);
				}
			} while (true);

		}
		return (Iterable<Position<E>>) plist;

	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator<E>((PositionList<E>) this);
	}

	
	
	public static <E> String toString(PositionList<E> lose) {
		Iterator<E> iter = lose.iterator();
		String answer = "";
		while (iter.hasNext()) {
			answer = answer + iter.next();
			if (iter.hasNext())
				answer = answer + ", ";
		}
		return answer;
	}

	
	public String toString() {
		return toString((PositionList<E>) this);
	}
}
