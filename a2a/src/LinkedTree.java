import java.util.Iterator;

public class LinkedTree<E> implements Tree<E> {
	protected TreePosition<E> root; 
	protected int size;

	public LinkedTree() {
		root = null;
		size = 0;
	}

	@Override
	public Position<E> root() throws EmptyTreeException {
		if (root == null) {
			throw new EmptyTreeException("The tree is empty");
		} else {
			return root;
		}
	}

	public Position<E> parent(Position<E> p) throws IllegalArgumentException {

		TreePosition<E> temp = checkPosition(p);
		if (temp == null) {
			throw new IllegalArgumentException("Position does not exist");
		}
		Position<E> ptemp = temp.getParent();
		if (ptemp == null) {
			throw new IllegalArgumentException("No Parent");
		}
		return ptemp;

	}

	@Override
	public Iterable<Position<E>> children(Position<E> p)
			throws IllegalArgumentException {
		TreePosition<E> temp = checkPosition(p);
		if (temp == null) {
			throw new IllegalArgumentException("Position does not exist");
		}
		if (isExternal(temp)) {
			throw new IllegalArgumentException("Position has no children");
		}
		return (Iterable<Position<E>>) temp.getChildren();
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		return 0;
	}

	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		if (isExternal(p) == true) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		TreePosition<E> temp = checkPosition(p);
		if (temp.getChildren() == null || temp.getChildren().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		TreePosition<E> temp = checkPosition(p);
		if (temp == root) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator<E> iterator() {
		Iterable<Position<E>> pos = positions();
		PositionalList<Position<E>> elem = new NodePositionalList<Position<E>>();
		for (Position<E> it : pos) {
			elem.addLast((Position<E>) it.element());
		}
		return (Iterator<E>) elem.iterator();
	}

	@Override
	public Iterable<Position<E>> positions() {
		PositionalList<Position<E>> pos = new NodePositionalList<Position<E>>();

		if (isEmpty() == false) {
			preorderTrav(root(), pos);
		}
		return (Iterable<Position<E>>) pos;
	}

	private void preorderTrav(Position<E> v, PositionalList<Position<E>> pos)
			throws InvalidPositionException {
		pos.addLast(v);
		for (Position<E> w : children(v)) {
			preorderTrav(w, pos);
		}
	}

	protected TreePosition<E> checkPosition(Position<E> v)
			throws InvalidPositionException {
		if (v == null || !(v instanceof TreePosition)) {
			throw new InvalidPositionException("The position is invalid");
		}
		return (TreePosition<E>) v;
	}

	public Position<E> addRoot(E e) throws NonEmptyTreeException {
		if (isEmpty() == false) {
			throw new NonEmptyTreeException("This tree already has a root");
		}
		size = 1;
		root = createNode(e, null, null);
		return (Position<E>) root;
	}

	public static <E> String parentheticRepresentation(LinkedTree<E> T,
			Position<E> v) {
		String s = v.element().toString();
		if (T.isInternal(v)) {
			Boolean firstEncounter = true;
			for (Position<E> w : T.children(v))
				if (firstEncounter) {
					s += " ( " + parentheticRepresentation(T, w);
					firstEncounter = false;
				} else
					s += " , " + parentheticRepresentation(T, w);
			s += " ) ";
		}
		return s;
	}

	
	public String toString() {
		return parentheticRepresentation(this, this.root);
	}

	protected TreePosition<E> createNode(E element, TreePosition<E> parent,
			PositionalList<Position<E>> children) {
		TreeNode<E> node = new TreeNode(element, parent, children);
		size++;
		return node;
	}

	public void swapElements(Position<E> v, Position<E> w)
			throws InvalidPositionException {
		TreePosition<E> temp1 = checkPosition(v);
		TreePosition<E> temp2 = checkPosition(w);
		E tempele = temp2.element();
		temp2.setElement(temp1.element());
		temp1.setElement(tempele);
	}

}
