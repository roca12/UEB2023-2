package co.edu.unbosque.util.exception;

public class EmailNotValidException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2952102137138085720L;

	public EmailNotValidException() {
		super("El correo electronico no tiene un formato valido");
	}
}
