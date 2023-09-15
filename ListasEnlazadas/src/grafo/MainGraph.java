package grafo;


public class MainGraph {

	public static void main(String[] args) {
		Graph g1 = new Graph();

		Vertex<City> bog = new Vertex<City>(new City("BOG", 90));
		Vertex<City> med = new Vertex<City>(new City("MED", 45));
		Vertex<City> cal = new Vertex<City>(new City("CAL", 13));
		Vertex<City> let = new Vertex<City>(new City("LET", 7));
		Vertex<City> buc = new Vertex<City>(new City("BUC", 8));


		bog.addEdge(new Edge(bog, med, 50));
		bog.addEdge(new Edge(bog, cal, 50));
		buc.addEdge(new Edge(buc, med, 50));
		cal.addEdge(new Edge(cal, let, 50));
		bog.addEdge(new Edge(bog, let, 50));
		
		g1.addVertex(bog);
		g1.addVertex(med);
		g1.addVertex(cal);
		g1.addVertex(let);
		g1.addVertex(buc);
		
		System.out.println(g1);
		

	}

}
