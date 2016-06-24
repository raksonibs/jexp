// From the textbook, but with added comments.

public interface CompleteBinaryTree extends BinaryTree {
   /** 
    * Adds a new external Position to the "end" of the heap tree -- as
    * a child of an existing position, or as the root if the heap tree
    * is empty.
    *
    * This extends the underlying binary tree by adding 1 new node, so
    * it may result in an improper binary tree.  (By contrast, HW5's
    * createExternal() added two children to a node at the same time,
    * so it never created an improper binary tree.)
    * 
    * @param elem - an Object to be added
    * @return the Position created when elem is added
    */
   public Position add(Object elem);

   /**
    * Removes the "last" position in the heap tree.
    * @return the element stored at the removed Position.
    */
   public Object remove();
}
