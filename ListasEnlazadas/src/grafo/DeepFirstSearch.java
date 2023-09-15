package grafo;

import pilacola.StackImpl;
import simple.MyLinkedList;

public class DeepFirstSearch extends AbstractSearch {

	public DeepFirstSearch(Vertex<?> sourceVertex, Vertex<?> destinationVertex) {
		super(sourceVertex, destinationVertex);
	}

	@Override
	public boolean runSearch() {
		
		if (this.sourceVertex.equals(destinationVertex)) {
			System.out.println("Nodo destino encontrado a 0 de profundidad");
			System.out.println(sourceVertex.getInfo());
		}
		
		StackImpl<Vertex<?>> stackOfNodes = new StackImpl<Vertex<?>>();
		MyLinkedList<Vertex<?>> visitedNodes = new MyLinkedList<Vertex<?>>();
		
		stackOfNodes.push(sourceVertex);
		System.out.println("Ruta a seguir para ubicar el nodo");
		
		while (stackOfNodes.size() != 0) {
			
			Vertex<?> current = stackOfNodes.pop();
			if (current.equals(destinationVertex)) {
				// System.out.print(destinationVertex);
				System.out.println(destinationVertex.getInfo());
				System.out.println("nodo buscado encontrado\n");
				return true;
			} else {
				System.out.print(current.getInfo() + " -> ");
				visitedNodes.addLast(current);
				MyLinkedList<Edge> adyacents = current.getAdyacentEdges();
				while (!adyacents.isEmpty()) {
					stackOfNodes.push(adyacents.extract().getDestination());
				}
			}
		}
		return false;

	}

}
