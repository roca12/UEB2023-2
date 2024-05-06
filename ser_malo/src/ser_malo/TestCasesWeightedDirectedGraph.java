// Programa para generar casos de prueba para un gráfico dirigido no ponderado
package ser_malo;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TestCasesWeightedDirectedGraph {
	static int RUN = 5;
	static int MAX_VERTICES = 15;
	static int MAX_EDGES = 25;
	static int MAXWEIGHT = 15;

	static class Pair {
		int first, second;

		public Pair(int first, int second) {
			this.first = first;

			this.second = second;
		}
	}

	static int getIndex(Set<Pair> set, Pair value) {
		int result = 0;
		for (Object entry : set) {
			if (entry.equals(value)) {
				return result;
			}
			result++;
		}
		return set.size() + 1;
	}

	public static void main(String[] args) {
		Set<Pair> container = new HashSet<>();

		Random r = new Random();
		int VERTICES; // Número de vértices
		int NUMEDGE; // Número de caminos
		for (int i = 1; i <= RUN; i++) {
			VERTICES = 1 + r.nextInt(MAX_VERTICES);

			NUMEDGE = 1 + r.nextInt(MAX_EDGES);
			while (NUMEDGE > VERTICES * (VERTICES - 1) / 2) {
				NUMEDGE = 1 + r.nextInt(MAX_EDGES);
			}
			System.out.printf("%d %d\n", VERTICES, NUMEDGE);
			for (int j = 1; j <= NUMEDGE; j++) {
				int a = 1 + r.nextInt(VERTICES);
				int b = 1 + r.nextInt(VERTICES);
				Pair p = new Pair(a, b);

				while (getIndex(container, p) != container.size() + 1) {
					a = 1 + r.nextInt(VERTICES);
					b = 1 + r.nextInt(VERTICES);
					p = new Pair(a, b);
				}
				container.add(p);
			}
			for (Pair p : container) {
				int wt = 1 + r.nextInt(MAXWEIGHT);
				System.out.printf("%d %d %d\n", p.first - 1, p.second - 1, wt);
			}

			container.clear();
			System.out.printf("\n");
		}
	}
}