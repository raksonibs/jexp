import java.util.*;

public class Graph<V, E> implements GraphADT<V, E>
{
   protected final int DEFAULT_CAPACITY = 10;
   protected int numVertices;   // number of vertices in the graph
   protected boolean[][] adjMatrix;   // adjacency matrix
   protected V[] vertices;   // values of vertices
   protected V[] incomingVertices;
   protected V[] outgoingVertices;

   /******************************************************************
     Creates an empty graph.
   ******************************************************************/
   public Graph()
   {
      numVertices = 0;
      this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
      this.vertices = (V[])(new Object[DEFAULT_CAPACITY]);
   }

   /******************************************************************
     Returns a string representation of the adjacency matrix. 
   ******************************************************************/
   public String toString()
   {
      if (numVertices == 0)
         return "Graph is empty";

      String result = new String("");

      result += "Adjacency Matrix\n";
      result += "----------------\n";
      result += "index\t";

      for (int i = 0; i < numVertices; i++) 
      {
         result += "" + i;
         if (i < 10)
            result += " ";
      }
      result += "\n\n";

      for (int i = 0; i < numVertices; i++)
      {
         result += "" + i + "\t";
      
         for (int j = 0; j < numVertices; j++)
         {
            if (adjMatrix[i][j])
               result += "1 ";
            else
               result += "0 ";
         }
         result += "\n";
      }

      result += "\n\nVertex Values";
      result += "\n-------------\n";
      result += "index\tvalue\n\n";

      for (int i = 0; i < numVertices; i++)
      {
         result += "" + i + "\t";
         result += vertices[i].toString() + "\n";
      }
      result += "\n";
      return result;
   }

   /******************************************************************
     Inserts an edge between two vertices of the graph.
   ******************************************************************/
   public void addEdge (int index1, int index2)
   {
      if (indexIsValid(index1) && indexIsValid(index2))
      {
         adjMatrix[index1][index2] = true;
         adjMatrix[index2][index1] = true;
      }
   }

   /******************************************************************
     Removes an edge between two vertices of the graph.
   ******************************************************************/
   public void removeEdge (int index1, int index2)
   {
      if (indexIsValid(index1) && indexIsValid(index2))
      {
         adjMatrix[index1][index2] = false;
         adjMatrix[index2][index1] = false;
      }
   }

   /******************************************************************
     Inserts an edge between two vertices of the graph.
   ******************************************************************/
   public void addEdge (V vertex1, V vertex2)
   {
      addEdge (getIndex(vertex1), getIndex(vertex2));
   }

   /******************************************************************
     Removes an edge between two vertices of the graph.
   ******************************************************************/
   public void removeEdge (V vertex1, V vertex2)
   {
      removeEdge (getIndex(vertex1), getIndex(vertex2));
   }

   /******************************************************************
     Adds a vertex to the graph, expanding the capacity of the graph
     if necessary.
   ******************************************************************/
   public void addVertex ()
   {
      if (numVertices == vertices.length)
         expandCapacity();

      vertices[numVertices] = null;
      for (int i = 0; i <= numVertices; i++)
      {
         adjMatrix[numVertices][i] = false;
         adjMatrix[i][numVertices] = false;
      }      
      numVertices++;
   }

   /******************************************************************
     Adds a vertex to the graph, expanding the capacity of the graph
     if necessary.  It also associates an object with the vertex.
   ******************************************************************/
   public void addVertex (V vertex)
   {
      if (numVertices == vertices.length)
         expandCapacity();

      vertices[numVertices] = vertex;
      for (int i = 0; i <= numVertices; i++)
      {
         adjMatrix[numVertices][i] = false;
         adjMatrix[i][numVertices] = false;
      }      
      numVertices++;
   }

   /******************************************************************
     Removes a vertex at the given index from the graph.  Note that 
     this may affect the index values of other vertices.
   ******************************************************************/
   public void removeVertex (int index)
   {
      if (indexIsValid(index))
      {
         numVertices--;

         for (int i = index; i < numVertices; i++)
            vertices[i] = vertices[i+1];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j <= numVertices; j++)
               adjMatrix[i][j] = adjMatrix[i+1][j];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
               adjMatrix[j][i] = adjMatrix[j][i+1];
      }
   }

   /******************************************************************
     Removes a single vertex with the given value from the graph.  
   ******************************************************************/
   public void removeVertex (V vertex)
   {
      for (int i = 0; i < numVertices; i++)
      {
         if (vertex.equals(vertices[i]))
         {
            removeVertex(i);
            return;
         }
      }
   }

   /******************************************************************
     Creates new arrays to store the contents of the graph with
     twice the capacity.
   ******************************************************************/
   protected void expandCapacity()
   {
      V[] largerVertices = (V[])(new Object[vertices.length*2]);
      boolean[][] largerAdjMatrix = 
            new boolean[vertices.length*2][vertices.length*2];

      for (int i = 0; i < numVertices; i++)
      {
         for (int j = 0; j < numVertices; j++)
         {
            largerAdjMatrix[i][j] = adjMatrix[i][j];
         }
         largerVertices[i] = vertices[i];
      }

      vertices = largerVertices;
      adjMatrix = largerAdjMatrix;
   }

   /******************************************************************
     Returns the number of vertices in the graph.
   ******************************************************************/
   public int size()
   {
      return numVertices;
   }

   /******************************************************************
     Returns true if the graph is empty and false otherwise. 
   ******************************************************************/
   public boolean isEmpty()
   {
      return (numVertices == 0);
   }


   /******************************************************************
     Returns the index value of the first occurrence of the vertex.
     Returns -1 if the key is not found.
   ******************************************************************/
   public int getIndex(V vertex)
   {
      for (int i = 0; i < numVertices; i++)
         if (vertices[i].equals(vertex))
            return i;
      return -1;
   }

   /******************************************************************
     Returns true if the given index is valid. 
   ******************************************************************/
   protected boolean indexIsValid(int index)
   {
      return ((index < numVertices) && (index >= 0));
   }

   /******************************************************************
     Returns a copy of the vertices array.
   ******************************************************************/
   public Object[] getVertices()
   {
      Object[] vertices = new Object[numVertices];
      Object vertex;
      
      for (int i = 0; i < numVertices; i++)
      {
         vertex = this.vertices[i];
         vertices[i] = vertex;
      }
      return vertices;
   }

@Override
public int numVertices() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int numEdges() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public Iterable<Vertex> vertices() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Iterable<Edge> edges() {
	// TODO Auto-generated method stub
	return null;
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
public Vertex insertVertex(V o) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Edge insertEdge(Vertex u, Vertex v, E o) throws InvalidPositionException {
	// TODO Auto-generated method stub
	return null;
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
}