// From the textbook, but with added comments.

/** Implements a CompleteBinaryTree in a vector.  The children
 * of element i are stored at elements 2*i and 2*i+1.
 */

import java.util.Vector;    // conveniently makes "Vector" refer to "java.util.Vector"
import java.util.Iterator;  // conveniently makes "Iterator" refer to "java.util.Iterator"

public class VectorCompleteBinaryTree implements CompleteBinaryTree  {
  protected Vector v;  // vector of elements stored in the tree

  /******************************************
   * Here is an inner class for a vector-based complete binary tree node. 
   * The objects in the vector are instances of this node class.
   * The node class implements Position as well as having some other methods.
   * See the assignment for more discussion.
   *
   * The full name of this class is VectorCompleteBinaryTree.VectorNode,
   * since it is defined INSIDE VectorCompleteBinaryTree.
   * The class is protected, since we don't expect other classes to
   * know about it or its details (unless they extend VectorCompleteBinaryTree).
   * However, instances of this class can still be examined through the
   * public Position interface.
   */

  protected static class VectorNode implements Position {
    Object element; // element stored at this position
    int index;      // index of this position in the vector.
                    // We need to store the index so that we can 
                    // find related positions (parent and child)
                    // from this position; it's like storing
                    // pointers in a linked list node.
    public VectorNode(Object elt, int i) { 
      element = elt;
      index = i; 
    }
    public Object element() { return element; }
    public int index() { return index; }
    public Object setElement(Object elt) {
      Object temp = element;
      element = elt;
      return temp;  // return the element formerly at this position, for convenience
    }
  }

  /* Okay, that's the end of the nested inner class.
   ***************************************************/

  /** default constructor */
  public VectorCompleteBinaryTree() { 
    v = new Vector();
//    ((Object) v).insertAtRank(0,null); // the location at rank 0 is deliberately empty
  }

  /** Returns the number of (internal and external) nodes. */
  public int size() { return v.size()-1; } 

  /** Returns whether the tree is empty. */ 
  public boolean isEmpty() { return (size()==0); }

  /** Returns whether v is an internal node. */
  public boolean isInternal(Position v) throws InvalidPositionException {
    return hasLeft(v);  // if v has a right child it will have a left child,
                        // because this is a complete binary tree
  }

  /** Returns whether v is an external node. */
  public boolean isExternal(Position v) throws InvalidPositionException {
    return !isInternal(v);
  }

  /** Returns whether v is the root node. */
  public boolean isRoot(Position v) throws InvalidPositionException { 
    VectorNode vv = checkPosition(v);
    return vv.index() == 1;
  }

  /** Returns whether v has a left child. */
  public boolean hasLeft(Position v) throws InvalidPositionException { 
    VectorNode vv = checkPosition(v);
    return 2*vv.index() <= size();
  }

  /** Returns whether v has a right child. */
  public boolean hasRight(Position v) throws InvalidPositionException { 
    VectorNode vv = checkPosition(v);
    return 2*vv.index() + 1 <= size();
  }

  /** Returns the root of the tree. */
  public Position root() throws EmptyTreeException {
    if (isEmpty()) throw new EmptyTreeException("Tree is empty");
//    return (Position)v.elemAtRank(1);
    return Position p;
  } 

  /** Returns the left child of p. */
  public Position left(Position p) 
    throws InvalidPositionException, BoundaryViolationException { 
    if (!hasLeft(p)) throw new BoundaryViolationException("No left child");
//    return (Position)v.elemAtRank(2*((VectorNode) p).index());
    return p;
  }

  /** Returns the right child of p. */ 
  public Position right(Position p) 
    throws InvalidPositionException { 
    if (!hasRight(p)) throw new BoundaryViolationException("No right child");
//    return (Position)v.elemAtRank(2*((VectorNode) p).index() + 1);
    return p;
  }

  /** Returns the parent of p. */
  public Position parent(Position p) 
    throws InvalidPositionException, BoundaryViolationException { 
    if (isRoot(p)) throw new BoundaryViolationException("No parent");
//    return (Position)v.elemAtRank(((VectorNode) p).index() / 2);
    return p;
  }

  /** Replaces the element at v. */
  public Object replace(Position v, Object o) throws InvalidPositionException {
    VectorNode vv = checkPosition(v);
    return vv.setElement(o);
  }

  /** Add an element just after the last node (in a level numbering). 
   * This method is required to implement the CompleteBinaryTree interface
   * (whereas the other methods are for BinaryTree). */
  public Position add(Object e) {
    int rankToInsert = size()+1;
    Position p = new VectorNode(e,rankToInsert);
    v.insertAtRank(rankToInsert,p);
    return p;
  }

  /** Removes and returns the element at the last node (in a level numbering). 
   * This method is required to implement the CompleteBinaryTree interface
   * (whereas the other methods are for BinaryTree). */
  public Object remove() throws EmptyTreeException {
    if(isEmpty()) throw new EmptyTreeException("Tree is empty");
    return ((Position)v.removeAtRank(size())).element(); 
  }

  /** Determine whether v is a valid node. 
   * Note that this is protected, not public, because we don't
   * expect users of this class to call it.
   */
  protected VectorNode checkPosition(Position v) throws InvalidPositionException {
    if (v == null || !(v instanceof VectorNode))
      throw new InvalidPositionException("Position is invalid");
    return (VectorNode)v;
  }

  /****************************************************************
   * The methods below are just "stubs" that throw
   * UnsupportedOperationException.  You can probably get by without
   * them for this assignment.  If you wanted to fill them in later,
   * you could replace them with real methods.  Using temporary stubs
   * is a common development technique that allows you to work with
   * incomplete code.
   ****************************************************************/

  /** Returns an iterator over the elements stored at all nodes in the tree. */
  public Iterator elements() { 
    throw new UnsupportedOperationException("maybe implement this later"); 
  } 

  /** Returns an iterator over the children of a given node. */
  public Iterator children(Position p) { 
    throw new UnsupportedOperationException("maybe implement this later"); 
  }

  /** Returns an iterator over the positions in the tree. */
  public Iterator positions() {
    throw new UnsupportedOperationException("maybe implement this later"); 
  }
}
