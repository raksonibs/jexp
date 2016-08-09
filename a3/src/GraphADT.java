import java.util.ArrayList;

/**
 * An interface for a graph.
 * @author Oskar Niburski
 */
public interface GraphADT<V, E> {
  /** Returns the number of vertices of the graph */
  public int numVertices();
  
  /** Returns the number of edges of the graph */
  public int numEdges();
  
  /** Returns the vertices of the graph as an iterable collection */
  public V vertices();
  
  /** Returns the edges of the graph as an iterable collection */
  public E edges();
  
  /** Replaces the element of a given vertex with a new element and
      returns the old element */
  public V replace(Vertex p, V o) throws InvalidPositionException;
  
  /** Replaces the element of a given edge with a new element and
      returns the old element */
  public E replace(Edge p, E o) throws InvalidPositionException;
  
  /** Gets edge */
  public E getEdge(Vertex p, Vertex o) throws InvalidPositionException;
  
  /** Gets edge */
  public int outDegree(Vertex p) throws InvalidPositionException;
  
  /** Gets edge */
  public int inDegree(Vertex p) throws InvalidPositionException;
  
  /** Gets edge */
  public Iterable<Edge> outgoingEdges(Vertex p) throws InvalidPositionException;
  
  /** Gets edge */
  public Iterable<Edge> incomingEdges(Vertex p) throws InvalidPositionException;
  
  /** Returns the edges incident on a vertex as an iterable collection */
  public Iterable<Edge> incidentEdges(Vertex v)
    throws InvalidPositionException;
  
  /** Returns the endvertices of a vertex as an array of length 2 */
  public Vertex[] endVertices(Edge e) throws InvalidPositionException;
  
  /** Returns the other endvertex of an incident edge */
  public Vertex opposite(Vertex v, Edge e)
    throws InvalidPositionException;
  
  /** Tests whether two vertices are adjacent */
  public boolean areAdjacent(Vertex u, Vertex v)
    throws InvalidPositionException;
  
  /** Inserts and return a new vertex with a given element */
  public void insertVertex(V o);
  
  /** Inserts and return a new edge with a given element between two
      vertices */
  public Edge insertEdge(V u, V v, E o)
    throws InvalidPositionException;
  
  /** Removes a vertex and all its incident edges and returns the
      element stored at the removed vertex */
  public V removeVertex(Vertex v) throws InvalidPositionException;
  
  /** Removes an edge and return its element */
  public E removeEdge(Edge e) throws InvalidPositionException;
}
