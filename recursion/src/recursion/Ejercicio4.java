package recursion;

public class Ejercicio4 {
	static int[][] matrix = new int[10][10];
	static int cont = 1;
	static int negativeCont = -1;

	public static void main(String[] args) {
		fill(matrix);
		print(matrix);
		System.out.println("/////////////");
		recursiveFill();
		print(matrix);
		

	}
	
	public static void recursiveFill() {
		changeRow(0, 0);
	}

	public static void changeRow(int y, int x) {
		if (y== matrix.length) {
			return;
		}
		fillRow(y, x);
		changeRow(y+1, x);
	}

	public static void fillRow(int y, int x) {
		if (x == matrix.length) {
			return;
		}
		matrix[y][x] = negativeCont;
		negativeCont--;
		fillRow(y, x + 1);
	}

	public static void fill(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = cont;
				cont++;
			}
		}
	}

	public static void print(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
