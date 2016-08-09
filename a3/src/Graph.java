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
      this.edges = new ArrayList<Edge>();
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
	return (E) edges;
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
	edges.add(newEdge);
	this.numEdges += 1;
	return newEdge;
}

@Override
public V removeVertex(V v) throws InvalidPositionException {
	// TODO Auto-generated method stub
	
	if (!map.keySet().contains(v)) {
		throw new InvalidPositionException("Not valid key!");
	}
	
	ArrayList vertsEdges = map.get(v);
	
	 for ( Object edge : edges ) {
		 if (((Edge) edge).getTo().equals(v)) {
			 edges.remove(edge);
		 }
		 
		 if (((Edge) edge).getFrom().equals(v)) {
			 edges.remove(edge);
		 }
		 
	 }
	
	
	V removed = (V) map.remove(v);
	this.numVertices -= 1;
	return removed;
}

@Override
public E removeEdge(Edge e) throws InvalidPositionException {
	// TODO Auto-generated method stub
//	edgesMap.remove(e);
	for ( Object edge : edges ) {
		 if (((Edge) edge).equals(e)) {
			 edges.remove(edge);
		 }
	 }
	
	for ( V key : map.keySet() ) {
		map.get(key).remove(e);
	}
	
	this.numEdges -= 1;
	return (E) e;
}

@Override
public Edge getEdge(V p, V o) throws InvalidPositionException {
	// TODO Auto-generated method stub
	
	for ( Object edge : edges ) {
		if (((Edge) edge).getTo().equals(p) && ((Edge) edge).getFrom().equals(o)) {
			 return (Edge) edge;
		 }
	 }
	
	return null;
}

@Override
public int outgoingEdges(V p) throws InvalidPositionException {
	// TODO Auto-generated method stub
		if (!map.keySet().contains(p)) {
			throw new InvalidPositionException("Not valid key!");
		}
		
		return map.get(p).size();
}

@Override
public int incomingEdges(V p) throws InvalidPositionException {
	// TODO Auto-generated method stub
	if (!map.keySet().contains(p)) {
		throw new InvalidPositionException("Not valid key!");
	}
	
	int count = 0;
	
	for ( Object edge : edges ) {
		if (((Edge) edge).getTo().equals(p)) {
			 count++;
		 }
	 }
	
	return count;
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