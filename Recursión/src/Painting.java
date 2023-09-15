import java.util.Scanner;

public class Painting {

	static char[][] matrix;
	static Scanner sc = new Scanner(System.in);

	static void print(char[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}

	static void fill(char[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = '#';
			}
		}
	}

	static boolean isValid(int x, int y) {
		try {
			char aux = matrix[x][y];
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	static void paint(int posx, int posy) {

		int movex[] = { 0, 0, 1, -1 };
		int movey[] = { -1, 1, 0, 0 };
		for (int i = 0; i < movex.length; i++) {
			int posxActual = posx + movex[i];
			int posyActual = posy + movey[i];
			if (isValid(posxActual, posyActual)) {
				if (matrix[posx][posy] == '#') {
					matrix[posx][posy] = '@';
				}else if(matrix[posx][posy] == '*') {
					return;
				} 
				else if (matrix[posxActual][posyActual] == '*') {
					continue;
				} else if (matrix[posxActual][posyActual] == '@') {
					continue;
				} else if (matrix[posxActual][posyActual] == '#') {
					matrix[posxActual][posyActual] = '@';
					paint(posxActual, posyActual);
				}
			}
		}
	}

	public static void main(String[] args) {
		int x, y;
		int notiles, num_painters;
		x = sc.nextInt();
		y = sc.nextInt();
		notiles = sc.nextInt();
		matrix = new char[x][y];
		fill(matrix);
		for (int i = 0; i < notiles; i++) {
			matrix[sc.nextInt()][sc.nextInt()] = '*';
		}
		print(matrix);
		num_painters = sc.nextInt();
		for (int i = 0; i < num_painters; i++) {
			paint(sc.nextInt(), sc.nextInt());
		}
		print(matrix);
	}
}
