package co.edu.unbosque.util.exception;

public class NegativeNumberException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2980283458950681246L;

	public NegativeNumberException() {
		super ("El numero no puede ser negativo en esta posición");
	}

}
