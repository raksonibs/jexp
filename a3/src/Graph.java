import java.util.*;

public class Graph<V, E> implements GraphADT<V, E>
{
   protected final int DEFAULT_CAPACITY = 10;
   protected int numVertices;   // number of vertices in the graph
   protected int numEdges;   // number of vertices in the graph
   protected boolean[][] adjMatrix;   // adjacency matrix
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
public Object[] vertices() {
	// TODO Auto-generated method stub
	return map.keySet().toArray();
}

@Override
public ArrayList edges() {
	// TODO Auto-generated method stub
	return (ArrayList) edges;
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
	
	Edge newEdge = new Edge(u,v, o);
	edges.add(newEdge);
	map.get(u).add(newEdge);
	map.get(v).add(newEdge);
	
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
	ArrayList tmpEdges = new ArrayList<>(edges);
	 for ( Object edge : tmpEdges ) {
		 if (((Edge) edge).getTo().equals(v)) {
			 edges.remove(edge);
		 }
		 
		 if (((Edge) edge).getFrom().equals(v)) {
			 edges.remove(edge);
		 }
		 
	 }
	
	ArrayList numEdgesHere = map.get(v);
	V removed = (V) map.remove(v);
	this.numVertices -= 1;
	this.numEdges -= numEdgesHere.size();
	return removed;
}

@Override
public E removeEdge(Edge e) throws InvalidPositionException {
	// TODO Auto-generated method stub
	
//	if (!map.keySet().contains(e)) {
//		throw new InvalidPositionException("Not valid key!");
//	}
//	edgesMap.remove(e);
	Edge foundEdge = null; 
	for ( Object edge : edges ) {
		 if (((Edge) edge).getTo() == e.getTo() && ((Edge) edge).getFrom() == e.getFrom() && ((Edge) edge).getCost() == e.getCost()) {
			 foundEdge = (Edge) edge;			 
		 }
	 }
	
	if (foundEdge != null) {
		for ( V key : map.keySet() ) {
			edges.remove(foundEdge);
		}
	}
	
	for (V key: map.keySet()) {
		map.get(key).remove(foundEdge);
	}
	
	this.numEdges -= 1;
	
//	System.out.println("NUMBER OF EDGES:" + numEdges);
	
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
public int outDegree(V p) throws InvalidPositionException {
	// TODO Auto-generated method stub
	if (!map.keySet().contains(p)) {
		throw new InvalidPositionException("Not valid key!");
	}
	
	int count = 0;
	
//	System.out.println("EDGES SIZE IN ARRAY " + edges.size());
	
	for ( Object edge : edges ) {
//		System.out.println(edge);
		if (((Edge) edge).getFrom().equals(p)) {
			 count++;
		 }
	 }
	
//	System.out.println("Calculated in degree for " + p + " as :" + count);
	
	return count;
}

@Override
public int inDegree(V p) throws InvalidPositionException {
	// TODO Auto-generated method stub
	if (!map.keySet().contains(p)) {
		throw new InvalidPositionException("Not valid key!");
	}
	
	int count = 0;
	
//	System.out.println("EDGES SIZE IN ARRAY " + edges.size());
	
	for ( Object edge : edges ) {
//		System.out.println(edge);
		if (((Edge) edge).getTo().equals(p)) {
			 count++;
		 }
	 }
	
//	System.out.println("Calculated in degree for " + p + " as :" + count);
	
	return count;
}

@Override
public ArrayList outgoingEdges(V p) throws InvalidPositionException {
	// TODO Auto-generated method stub
	if (!map.keySet().contains(p)) {
		throw new InvalidPositionException("Not valid key!");
	}
	
	ArrayList outgoingEdges = new ArrayList<V>();
	
	int count = 0;
	
	for ( Object edge : edges ) {
		if (((Edge) edge).getFrom().equals(p)) {
			 outgoingEdges.add(edge);
		 }
	 }
	
	return outgoingEdges;
	
}

@Override
public ArrayList incomingEdges(V p) throws InvalidPositionException {
	
	// TODO Auto-generated method stub
	if (!map.keySet().contains(p)) {
		throw new InvalidPositionException("Not valid key!");
	}
	
	ArrayList incomingEdges = new ArrayList<V>();
	
	int count = 0;
	
	for ( Object edge : edges ) {
		if (((Edge) edge).getTo().equals(p)) {
			 incomingEdges.add(edge);
		 }
	 }
	
	return incomingEdges;
}


public static void main(String[] args){
	System.out.println("Starting test");
    Graph graph = new Graph();
    graph.insertVertex("YYZ");
    System.out.println("Num Edges is zero: " + (graph.numEdges == 0));
    System.out.println("Num Vertices is 1: " + (graph.numVertices == 1));
    graph.insertVertex("JFK");
    graph.insertVertex("LAX");
    graph.insertVertex("WAR");
    graph.insertVertex("CAT");
    graph.insertVertex("DOG");
    System.out.println("Num Vertices is 6: " + (graph.numVertices == 6));
    System.out.println("Num Edges is zero: " + (graph.numEdges == 0));
    graph.insertEdge("DOG", "CAT", 3);
    System.out.println("Num Edges is 1: " + (graph.numEdges == 1)); 
    System.out.println("Num Vertices is 6: " + (graph.numVertices == 6));
    graph.insertEdge("DOG", "YYZ", 4);
    graph.insertEdge("DOG", "JFK", 2);
    graph.insertEdge("WAR", "JFK", 5);
    graph.insertEdge("LAX", "JFK", 5);
    graph.insertEdge("JFK", "LAX", 10);
    System.out.println("Num Edges is six: " + (graph.numEdges == 6));
    System.out.println("Num Vertices is six: " + (graph.numVertices == 6));
    
    for (Object edge : graph.edges()) {
		System.out.println("Edge: " + edge + " To: " + ((Edge) edge).getTo() + " From: " + ((Edge) edge).getFrom() + " Cost: " + ((Edge) edge).getCost());
	}
    
    Object[] verts = graph.vertices();
    
    for (int i = 0; i < verts.length; i++) {
    	System.out.println("Vertix: " + verts[i]);
    }
    
    System.out.println("Num indegree is 0 for dog: " + (graph.inDegree("DOG") == 0));
    System.out.println("Num outdegree is 3 for dog: " + (graph.outDegree("DOG") == 3));
    
    System.out.println("Num indegree is 3 for jfk: " + (graph.inDegree("JFK") == 3));
    System.out.println("Num outdegree is 1 for jfk: " + (graph.outDegree("JFK") == 1));
    
    System.out.println("Incoming edges for JFK");
    System.out.println("Incoming edges should be DOG to JFK, LAX to JFK, WAR to JFK");
    for (Object edge : graph.incomingEdges("JFK")) {
		System.out.println("Edge: " + edge + " To: " + ((Edge) edge).getTo() + " From: " + ((Edge) edge).getFrom() + " Cost: " + ((Edge) edge).getCost());
	}
    
    System.out.println("OutGOING edges for JFK");
    System.out.println("Outgoing edges should be JFK to LAX");
    for (Object edge : graph.outgoingEdges("JFK")) {
		System.out.println("Edge: " + edge + " To: " + ((Edge) edge).getTo() + " From: " + ((Edge) edge).getFrom() + " Cost: " + ((Edge) edge).getCost());
	}
    
    Edge edgeToRemove = new Edge("WAR", "JFK", 5);
    graph.removeEdge(edgeToRemove);
    System.out.println("Num Edges is five: " + (graph.numEdges == 5));
    System.out.println("Num Vertices is six: " + (graph.numVertices == 6));
    
    System.out.println("Incoming edges for JFK");
    System.out.println("Incoming edges should be DOG to JFK, LAX to JFK");
    for (Object edge : graph.incomingEdges("JFK")) {
		System.out.println("Edge: " + edge + " To: " + ((Edge) edge).getTo() + " From: " + ((Edge) edge).getFrom() + " Cost: " + ((Edge) edge).getCost());
	}
    
    System.out.println("OutGOING edges for JFK");
    System.out.println("Outgoing edges should be JFK to LAX");
    for (Object edge : graph.outgoingEdges("JFK")) {
		System.out.println("Edge: " + edge + " To: " + ((Edge) edge).getTo() + " From: " + ((Edge) edge).getFrom() + " Cost: " + ((Edge) edge).getCost());
	}
    
    graph.removeVertex("JFK");
    System.out.println("Num Edges is two: " + (graph.numEdges == 2));
    System.out.println("Num Vertices is 5: " + (graph.numVertices == 5));
    
    System.out.println("Done test");
}

}