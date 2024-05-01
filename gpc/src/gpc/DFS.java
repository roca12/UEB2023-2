package gpc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DFS {
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		int v, e;
		v = sc.nextInt();
		e = sc.nextInt();
		Graph g = new Graph(v);
		for (int i = 0; i < e; i++) {
			g.addEdge(sc.nextInt(), sc.nextInt());
			sc.nextInt();
		}
		System.out.println("Siguiendo la primera busqueda en profundidad " + "(iniciando desde vertice  0)");
		g.DFS(0);
	}

	static class Graph {
		private int V; // número de vertices
		// Array de listas de adyacencia
		private LinkedList<Integer> adj[];

		Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i) {
				adj[i] = new LinkedList();
			}
		}
		// Agregando caminos

		void addEdge(int v, int w) {
			adj[v].add(w);
		}

		void DFSUtil(int v, boolean visited[]) {
			// Marca el nodo actual como visitado y lo imprime
			visited[v] = true;
			System.out.print(v + " ");
			// Recorre todos los vertices adyacentes a este vertice
			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					DFSUtil(n, visited);
				}
			}
		}

		void DFS(int v) {
			// Marca todos los vertices como no visitados (Falso)
			boolean visited[] = new boolean[V];
			DFSUtil(v, visited);
		}

	}
}