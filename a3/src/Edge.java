
public class Edge<E, V> {
	private Object cost;
	private Object from;
	private Object to;
	
	public Edge() {
		
	}
	
	public Edge(V u, V v, E o) {
		this.to = v;
		this.from = u;
		this.cost = o;
	}
	
	public Object getCost() {
		return this.cost;
	}
	
	public Object getTo() {
		return this.to;
	}
	
	public Object getFrom() {
		return this.from;
	}
	
	public String toString() {
		return "Edge: To: " + this.getTo() + " From: " + this.getFrom() + " Cost: " + this.getCost();
	}
	
	
}
