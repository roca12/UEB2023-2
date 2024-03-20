package co.edu.unbosque.util.exception;

public class NameNotValidException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 160034329732979157L;

	public NameNotValidException() {
		super("Los nombres no pueden tener numeros ni simbolos");
	}

}