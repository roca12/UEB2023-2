package grafo.generico;

import simple.MyLinkedList;

public class Vertex<T> {
	private T info;
	private MyLinkedList<Edge> adjacentEdges;

	public Vertex(T info) {
		this.info = info;
		adjacentEdges = new MyLinkedList<Edge>();
	}
	
	public void addEdge(Edge e) {
		adjacentEdges.addLast(e);
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public MyLinkedList<Edge> getAdjacentEdges() {
		return adjacentEdges;
	}

	public void setAdjacentEdges(MyLinkedList<Edge> adjacentEdges) {
		this.adjacentEdges = adjacentEdges;
	}

	@Override
	public String toString() {
		return "\nVertex [info=" + info + ", adjacentEdges=" + adjacentEdges + "]";
	}
}
