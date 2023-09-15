package grafo;

import simple.MyLinkedList;

public class Vertex<D> {
	private D info;
	private MyLinkedList<Edge> adyacentEdges;

	public Vertex(D info) {
		this.info = info;
		adyacentEdges = new MyLinkedList<Edge>();
	}
	
	public void addEdge(Edge e) {
		adyacentEdges.addLast(e);
	}

	public D getInfo() {
		return info;
	}

	public void setInfo(D info) {
		this.info = info;
	}

	public MyLinkedList<Edge> getAdyacentEdges() {
		return adyacentEdges;
	}

	public void setAdyacentEdges(MyLinkedList<Edge> adyacentEdges) {
		this.adyacentEdges = adyacentEdges;
	}

	@Override
	public String toString() {
		return "\nVertex [info=" + info + ", adyacentEdges=" + adyacentEdges + "]";
	}
}
