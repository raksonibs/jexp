

public class DNode<E> implements Position<E> {
  private DNode<E> previous, next;
  private E element;	

  public DNode(DNode<E> newP, DNode<E> newN, E e) {
    previous = newP;
    next = newN;
    element = e;
  }
  
  public E getElement() throws InvalidPositionException {
    if ((previous == null) && (next == null))
      throw new InvalidPositionException("");
    return element;
  }
  
  public DNode<E> getNext() { return next; }
  public DNode<E> getPrev() { return previous; }

  public void setNext(DNode<E> newNext) { next = newNext; }
  public void setPrev(DNode<E> newPrev) { previous = newPrev; }
  public void setElement(E newElement) { element = newElement; }
  
  
}

