import java.util.*;

public class Graph<V, E> implements GraphADT<V, E>
{
   protected final int DEFAULT_CAPACITY = 10;
   protected int numVertices;   // number of vertices in the graph
   protected int numEdges;   // number of vertices in the graph
   protected boolean[][] adjMatrix;   // adjacency matrix
   protected ArrayList vertices;   // values of vertices
   protected ArrayList edges;   // values of vertices
   protected ArrayList incomingVertices;
   protected ArrayList outgoingVertices;
   protected Map<V, ArrayList> map;
   protected Map<E, ArrayList> edgesMap;

   /******************************************************************
     Creates an empty graph.
   ******************************************************************/
   public Graph()
   {
      numVertices = 0;
      numEdges = 0;
      this.vertices = new ArrayList<Integer>();
      ArrayList empty = new ArrayList<>();
      this.map =  new HashMap<V, ArrayList>();
      this.edgesMap =  new HashMap<E, ArrayList>();
   }

   /******************************************************************
     Returns a string representation of the adjacency matrix. 
   ******************************************************************/
   public String toString()
   {
      if (numVertices == 0)
         return "Graph is empty";

      String result = new String("");

      result += "Adjacency List Structure\n";
      result += "----------------\n";
      result += "index\t";
      result += "\n";
      return result;
   }


@Override
public int numVertices() {
	// TODO Auto-generated method stub
	return numVertices;
}

@Override
public int numEdges() {
	// TODO Auto-generated method stub
	return numEdges;
}

@Override
public V vertices() {
	// TODO Auto-generated method stub
	return (V) map.keySet();
}

@Override
public E edges() {
	// TODO Auto-generated method stub
	return (E) edgesMap.keySet();
}

@Override
public V replace(Vertex p, V o) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public E replace(Edge p, E o) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Iterable<Edge> incidentEdges(Vertex v) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Vertex[] endVertices(Edge e) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Vertex opposite(Vertex v, Edge e) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean areAdjacent(Vertex u, Vertex v) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void insertVertex(V o) {
	// TODO Auto-generated method stub
	map.put(o, new ArrayList<>());
	int v = numVertices;
//    ArrayList<Integer> neighbors = new ArrayList<Integer>();
////    vertices.put(v, neighbors);
//    this.vertices.add(v, neighbors);
    setNumVertices(v+1);
}

private void setNumVertices(int i) {
	// TODO Auto-generated method stub
	this.numVertices = i;
}

@Override
public Edge insertEdge(V u, V v, E o) throws InvalidPositionException {
//	should be edge object with vertices reference and cost
	if (!map.keySet().contains(u)) {
		throw new InvalidPositionException("Not valid key!");
	}
	
	if (!map.keySet().contains(v)) {
		throw new InvalidPositionException("Not valid key!");
	}
	
	ArrayList verts = new ArrayList();
	verts.add(u);
	verts.add(v);
	Edge newEdge = new Edge(u,v, o);
	edgesMap.put((E) newEdge, verts);
	this.numEdges += 1;
	return newEdge;
}

@Override
public V removeVertex(Vertex v) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public E removeEdge(Edge e) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public E getEdge(Vertex p, Vertex o) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int outDegree(Vertex p) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int inDegree(Vertex p) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public Iterable<Edge> outgoingEdges(Vertex p) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Iterable<Edge> incomingEdges(Vertex p) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return null;
}


public static void main(String[] args){
	System.out.println("Starting test");
    Graph graph = new Graph();
    graph.insertVertex("YYZ");
    graph.insertVertex("JFK");
    graph.insertVertex("LAX");
    graph.insertVertex("WAR");
    graph.insertVertex("CAT");
    graph.insertVertex("DOG");
    graph.insertEdge("DOG", "CAT", 3);
    graph.insertEdge("DOG", "YYZ", 4);
    graph.insertEdge("DOG", "JFK", 2);
    graph.insertEdge("WAR", "JFK", 5);
    graph.insertEdge("LAX", "JFK", 5);
    graph.insertEdge("JFK", "LAX", 10);
    System.out.println("Done test");
}

}