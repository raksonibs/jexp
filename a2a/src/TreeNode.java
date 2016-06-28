public class TreeNode<E> implements TreePosition<E> 
{ 
private E element; // element stored at this node 
private TreePosition<E> parent; // adjacent node 
private PositionalList<Position<E>> children; // children nodes


public TreeNode()
{
}

public TreeNode(E element, TreePosition<E> parent, PositionalList<Position<E>> children)
{
	setElement(element);
	setParent(parent);
	setChildren(children);
}
@Override
public E element()
{
	return element;
}
@Override
public void setElement(E o)
{	
	this.element = o;
}
@Override
public PositionalList<Position<E>> getChildren()
{
	return children;
}
@Override
public void setChildren(PositionalList<Position<E>> c)
{
	this.children = c;	
}
@Override
public TreePosition<E> getParent()
{
	return parent;
}
@Override
public void setParent(TreePosition<E> v)
{
	this.parent = v;
}

@Override
public E getElement() {
	// TODO Auto-generated method stub
	return element;
}
} 
