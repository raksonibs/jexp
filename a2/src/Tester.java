public class Tester 
{ 
 public static void main(String[] args) 
 { 
 // make empty tree 
 LinkedTree<Character> T = new LinkedTree(); 
 // add root 
 T.addRoot('A');  // add children of root 
 T.createNode('B', (TreeNode)(T.root()), new NodePositionalList()); 
 TreePosition C = T.createNode('C', (TreeNode)(T.root()), new NodePositionalList()); 
 T.createNode('D', (TreeNode)(T.root()), new NodePositionalList()); 
 // add children of node C 
 T.createNode('E', C, new NodePositionalList()); 
 TreePosition F = T.createNode('F', C, new NodePositionalList()); 
 T.createNode('G', C, new NodePositionalList()); 
 // add children of node F 
 T.createNode('H', F, new NodePositionalList()); 
 T.createNode('I', F, new NodePositionalList()); 
 // print out info about the tree 
 System.out.println("Size = " + T.size()); 
 System.out.println("Here is the tree:"); 
 System.out.println(T); 
 } 
} 