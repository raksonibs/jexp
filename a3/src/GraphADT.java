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
  
  /** Gets edge */
  public Edge getEdge(V p, V o) throws InvalidPositionException;
  
  /** Gets edge */
  public int outgoingEdges(V p) throws InvalidPositionException;
  
  /** Gets edge */
  public int incomingEdges(V p) throws InvalidPositionException;
  
  /** Inserts and return a new vertex with a given element */
  public void insertVertex(V o);
  
  /** Inserts and return a new edge with a given element between two
      vertices */
  public Edge insertEdge(V u, V v, E o)
    throws InvalidPositionException;
  
  /** Removes a vertex and all its incident edges and returns the
      element stored at the removed vertex */
  public V removeVertex(V v) throws InvalidPositionException;
  
  /** Removes an edge and return its element */
  public E removeEdge(Edge e) throws InvalidPositionException;
}
