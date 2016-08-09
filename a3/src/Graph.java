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
   
   private Set<V> visitedNodes;
   private Set<V> unvisitedNodes;
   private Map<V, V> predecessors;
   private Map<V, Integer> distance;

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
   Number of vertices.
 ******************************************************************/

@Override
public int numVertices() {
	// TODO Auto-generated method stub
	return numVertices;
}

/******************************************************************
Number of Edges.
******************************************************************/
@Override
public int numEdges() {
	// TODO Auto-generated method stub
	return numEdges;
}

/******************************************************************
Object array of vertices.
******************************************************************/
@Override
public Object[] vertices() {
	// TODO Auto-generated method stub
	return map.keySet().toArray();
}

/******************************************************************
ArrayList for edges.
******************************************************************/
@Override
public ArrayList edges() {
	// TODO Auto-generated method stub
	return (ArrayList) edges;
}

/******************************************************************
ToString method.
******************************************************************/
public String toString() {
	String result = "";
	 for ( Object edge : edges ) {
		 result += edge.toString();
		 result += "\n";
	 }
	 
	 return result;
}

/******************************************************************
Insert Vertix into map.
******************************************************************/
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

/******************************************************************
Setter Method for num Vertices.
******************************************************************/
private void setNumVertices(int i) {
	// TODO Auto-generated method stub
	this.numVertices = i;
}

/******************************************************************
Insert Edge into map and edges.
******************************************************************/
@Override
public Edge insertEdge(V u, V v, E o) throws InvalidPositionException {
//	should be edge object with vertices reference and cost
	if (!map.keySet().contains(u)) {
		throw new InvalidPositionException("Not valid key!");
	}
	
	if (!map.keySet().contains(v)) {
		throw new InvalidPositionException("Not valid key!");
	}
	
	Edge newEdge = new Edge(u,v, o, "plane");
	edges.add(newEdge);
	map.get(u).add(newEdge);
	map.get(v).add(newEdge);
	
	this.numEdges += 1;
	return newEdge;
}

/******************************************************************
Remove Vertex
******************************************************************/
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

/******************************************************************
Remove Edge
******************************************************************/
@Override
public E removeEdge(Edge e) throws InvalidPositionException {
	// TODO Auto-generated method stub
	
//	if (!map.keySet().contains(e)) {
//		throw new InvalidPositionException("Not valid key!");
//	}
//	edgesMap.remove(e);
	Edge foundEdge = null;
	System.out.println("LOOKING FOR: " + e);
	for ( Object edge : edges ) {
		System.out.println(edge);
		 if (edge.toString().equals(e.toString())) {
			 System.out.println("FOUND AN EDGE");
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

/******************************************************************
Get Edge
******************************************************************/
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

/******************************************************************
Out Degree (number of edges coming out of vertex)
******************************************************************/
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

/******************************************************************
In Degree (number of edges coming into vertex)
******************************************************************/
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

/******************************************************************
All outgoing edges
******************************************************************/
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

/******************************************************************
Dijkstra Algorthim for graph
******************************************************************/
public ArrayList DijkstraAlgorithm(V v, V u) {
	
	visitedNodes = new HashSet<V>();
	unvisitedNodes = new HashSet<V>();
	distance = new HashMap<V, Integer>();
	predecessors = new HashMap<V, V>();
	distance.put(v, 0);
	
	while (unvisitedNodes.size() > 0) {
		V vertex = getMinimum(unvisitedNodes);
		visitedNodes.add(vertex);
		unvisitedNodes.remove(vertex);
		findMinimalDistance(vertex);
	}
	
	return outgoingEdges(v);
}

/******************************************************************
Find smallest distance
******************************************************************/
private void findMinimalDistance(V vertex) {
	// TODO Auto-generated method stub
	ArrayList<V> adjacentNodes = getNeibhbours(vertex);
	for (V target: adjacentNodes) {
		if (getShortestDistance(target) > getShortestDistance(vertex) + getDistance(vertex, target)) {
			distance.put(target,  getShortestDistance(vertex) + getDistance(vertex, target));
			predecessors.put(target, vertex);
			unvisitedNodes.add(target);
		}
	}
	
}

/******************************************************************
Shortest Distance to vertex
******************************************************************/
private int getShortestDistance(Object minimum) {
	// TODO Auto-generated method stub
	Integer d = distance.get(minimum);
	if (d == null) {
		return Integer.MAX_VALUE;
	} else {
		return d;
	}
}

/******************************************************************
Get Distance
******************************************************************/
private int getDistance(V vertex, V target) {
	// TODO Auto-generated method stub
	
	for ( Object edge : edges ) {
//		System.out.println(edge);
		if (((Edge) edge).getTo().equals(target) && ((Edge) edge).getFrom().equals(vertex)) {
			 return (int) ((Edge) edge).getCost();
		 }
	 }
	
	return 0;
}

/******************************************************************
DGet all the neighbours to traverse in parallel to determine distance
******************************************************************/
private ArrayList<V> getNeibhbours(V vertex) {
	// TODO Auto-generated method stub
	ArrayList<V> neighbors = new ArrayList<V>();
	
	for ( Object edge : edges ) {
		if (((Edge) edge).getFrom().equals(vertex) && !visitedNodes.contains(((Edge) edge).getTo())) {
			neighbors.add((V) ((Edge) edge).getTo());
		}
	}
	
	return neighbors;
}

/******************************************************************
Simple Minmium distance
******************************************************************/
private V getMinimum(Set<V> unvisitedNodes2) {
	// TODO Auto-generated method stub
	Object minimum = null;
	for (Object vertex: unvisitedNodes2) {
		if (minimum == null) {
			minimum = vertex;
		} else {
			if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
				minimum = vertex;
			}
		}
	}
	
	return null;
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
	Edge edgeToRemove = null;
	System.out.println("Starting Standard test");
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
    
    edgeToRemove = new Edge("WAR", "JFK", 5, "plane");
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
    
    System.out.println("Done Standard test");
    
    System.out.println("Starting AIRPLANE test");
    System.out.println("Please input some values, for example: + YYZ JFK 120 plane");
    System.out.println("Type 'QUIT' to exit");
    Graph graph2 = new Graph();
    Scanner in = new Scanner(System.in);
    
    while(in.hasNext()) {
        String s1 = in.nextLine();
        if(s1.equals("QUIT")) {
            break;
        }
        
        String[] splitString = s1.split("\\s+");
//        System.out.println("SplitString 0: " + splitString[0]);
//        System.out.println("SplitString 0: " + splitString[1]);
//        System.out.println("SplitString 0: " + splitString[2]);
        if (splitString[0].equals("+")) {
//        	add
        	graph2.insertVertex(splitString[1]);
            graph2.insertVertex(splitString[2]);
            graph2.insertEdge(splitString[1], splitString[2], splitString[3]);
            System.out.println("Added Route: " + s1);
        } else if (splitString[0].equals("-")) {
        	if (splitString.length > 2) {
//        		remove edge
        		edgeToRemove = new Edge(splitString[1], splitString[2], splitString[3], splitString[4]);
        		graph2.removeEdge(edgeToRemove);
        		System.out.println("Removed Edge: " + s1);
        	} else {
//        		remove vertix
        		graph2.removeVertex(splitString[1]);
        		System.out.println("Removed Vertix: " + s1);
        	}
//        	remove
        } else {
        	if (splitString.length == 1) {
//        		all connections 
        		System.out.println(graph2);
        		System.out.println("All Connections: " + s1);
        	} else if (splitString.length == 2) {
//        		all connections from airport splitString 1
        		for (Object edge : graph2.outgoingEdges(splitString[1])) {
        			System.out.println(edge);
        		}
        		System.out.println("All Connections from : " + s1);
        	} else {
//        		for (Object edge : graph2.outgoingEdges(splitString[1])) {
//        			System.out.println(edge);
//        		}
        		ArrayList output = graph2.DijkstraAlgorithm(splitString[1], splitString[2]);
        		for (Object edge : output) {
        			System.out.println(edge);
        		}
        		System.out.println("Shortest Path Between: " + s1);
//        		shortest path
        	}
//        	info wanted
        	
        }
        
    }
    
    System.out.println("Done AIRPLANE test");
}

}