
public class Edge<E, V> {
	private Object cost;
	private Object from;
	private Object to;
	private Object type;
	
	public Edge() {
		
	}
	
	public Edge(V u, V v, E o, E type) {
		this.to = v;
		this.from = u;
		this.cost = o;
		this.type = type;
	}
	
	public Object getCost() {
		return this.cost;
	}
	
	public Object getType() {
		return this.type;
	}
	
	public Object getTo() {
		return this.to;
	}
	
	public Object getFrom() {
		return this.from;
	}
	
	public String toString2() {
		return "Edge: To: " + this.getTo() + " From: " + this.getFrom() + " Cost: " + this.getCost();
	}
	
	public String toString() {
		return "" + this.getTo() + " " + this.getFrom() + " " + this.getCost() + " " + this.getType();
	}
	
	
}
