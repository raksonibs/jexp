import java.util.Iterator;

public class LinkedTree<E> implements Tree<E> {
	protected TreePosition<E> root; 
	protected int size;

	public LinkedTree() {
		root = null;
		size = 0;
	}

		/**
* root()
* Grabs root
* @param
* @return Position<e>
*/
	@Override
	public Position<E> root() throws EmptyTreeException {
		if (root == null) {
			throw new EmptyTreeException("The tree is empty");
		} else {
			return root;
		}
	}

		/**
* finds parent()
* grabs parent of position
* @param Position<E> p
* @return Position<E> element
*/
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

		/**
* children()
* reutrns children of element
* @param Position<E> p
* @return Iterable<Position<E>>
*/
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

		/**
* numChildren(P)
* returns the number of children of p
* @param Position<E> p
* @return integer
*/
	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		return 0;
	}
		/**
* isInternal(P)
* boolean check if Position<E> p is internal
* @param Position<E> p
* @return boolean
*/
	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		if (isExternal(p) == true) {
			return false;
		} else {
			return true;
		}
	}

		/**
* isExternal(P)
* returns boolean determining if is external node or not
* @param Position<E> p
* @return boolean
*/
	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		TreePosition<E> temp = checkPosition(p);
		if (temp.getChildren() == null || temp.getChildren().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

		/**
* isRoot(P)
* returns boolean for root or not
* @param Position<E> p
* @return boolean
*/
	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		TreePosition<E> temp = checkPosition(p);
		if (temp == root) {
			return true;
		} else {
			return false;
		}
	}

		/**
* side()
* returns the size of Tree
* @param 
* @return integer
*/
	@Override
	public int size() {
		return size;
	}

		/**
* isEmpty()
* returns whether or not size is zero
* @param 
* @return boolean
*/
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
