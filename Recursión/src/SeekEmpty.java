import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SeekEmpty {

	static char[] chairRow;
	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();;

	static void addSpaces() {
		int cant = r.nextInt(chairRow.length);
		for (int i = 0; i < cant; i++) {
			int pos = r.nextInt(chairRow.length);
			if (chairRow[pos] == ' ') {
				cant++;
			} else {
				chairRow[pos] = ' ';
			}
		}
	}

	static void print(int pos) {
		if (pos == 0) {
			System.out.print("|");
		}
		
		if (pos == chairRow.length) {
			System.out.println();
			return;
		} else {
			System.out.print(chairRow[pos] + "|");
			print(pos + 1);
		}
	}

	static void fill() {
		Arrays.fill(chairRow, '@');
	}

	static int countBlanks(int pos, int count) {
		if (pos == chairRow.length) {
			return count;
		}

		else if (chairRow[pos] == ' ') {
			count++;
			count = countBlanks(pos + 1, count);
		}

		else if (chairRow[pos] != ' ') {
			count = countBlanks(pos + 1, count);
		}

		return count;
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		chairRow = new char[n];
		fill();
		addSpaces();
		print(0);
		System.out.println(countBlanks(0, 0));
	}
}
