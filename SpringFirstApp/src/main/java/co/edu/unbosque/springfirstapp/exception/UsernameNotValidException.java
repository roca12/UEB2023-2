package co.edu.unbosque.springfirstapp.exception;

public class UsernameNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1290628531913444044L;

	public UsernameNotValidException() {
		super("The username does not meet the standard "
				+ "(8 characters minimum, at least one lowercase letter, "
				+ "at least one uppercase letter, "
				+ "at least one number and at least one symbol).");

	}

}
