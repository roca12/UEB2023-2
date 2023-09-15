package co.edu.unbosque.view;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Console {

	private Scanner sc;

	public Console() {
		sc = new Scanner(System.in);
	}
	
	public void showMenu() {
		printWithNewLine("--- shark encyclopedia ---");
		printWithNewLine("1) create a new shark");
		printWithNewLine("2) read all sharks");
		printWithNewLine("3) update a shark by index");
		printWithNewLine("4) delete a shark by index");
		printWithNewLine("5) GTFO");
	}
	
	public void showBadSelection() {
		printWithNewLine("Invalid option, try again");
	}

	public void printWithNewLine(String data) {
		System.out.println(data);
	}

	public void printInSameLine(String data) {
		System.out.print(data);
	}

	public int readInt() {
		return sc.nextInt();
	}

	public long readLong() {
		return sc.nextLong();
	}

	public float readFloat() {
		return sc.nextFloat();
	}

	public double readDouble() {
		return sc.nextDouble();
	}

	public char readChar() {
		return sc.next().charAt(0);
	}

	public String readWord() {
		return sc.next();
	}

	public String readWholeLine() {
		return sc.nextLine();
	}

	public BigInteger readBigInt() {
		return sc.nextBigInteger();
	}

	public BigDecimal readBigDecimal() {
		return sc.nextBigDecimal();
	}

}
