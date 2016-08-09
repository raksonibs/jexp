
public class Edge<E, V> {
	private Object cost;
	private Object from;
	private Object to;
	
	public Edge() {
		
	}
	
	public Edge(V u, V v, E o) {
		this.to = u;
		this.from = v;
		this.cost = o;
	}
	
	public Object getCost() {
		return this.cost;
	}
	
	
}
