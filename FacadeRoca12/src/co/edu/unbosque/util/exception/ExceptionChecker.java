package co.edu.unbosque.util.exception;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionChecker {

	public static void checkFutureDateFromActual(Date date) throws FutureDateException {
		if (date.after(new Date())) {
			throw new FutureDateException();
		}
	}

	public static void checkEmail(String email) throws EmailNotValidException {
		String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			throw new EmailNotValidException();
		}

	}

	public static void checkName(String name) throws NameNotValidException {
		// no numbers, no symbols
		Pattern p = Pattern.compile("[^\\s\\w]");
		Matcher m = p.matcher(name);
		if (m.find()) {
			throw new NameNotValidException();
		}
	}

	public static void checkNegativeNumber(int num) throws NegativeNumberException {
		if (num < 0) {
			throw new NegativeNumberException();
		}
	}

	public static void checkNegativeNumber(long num) throws NegativeNumberException {
		if (num < 0) {
			throw new NegativeNumberException();
		}
	}

	public static void checkNegativeNumber(float num) throws NegativeNumberException {
		if (num < 0) {
			throw new NegativeNumberException();
		}
	}

	public static void checkNegativeNumber(double num) throws NegativeNumberException {
		if (num < 0) {
			throw new NegativeNumberException();
		}
	}

	public static void checkNegativeNumber(BigInteger num) throws NegativeNumberException {
		if (num.compareTo(BigInteger.ZERO) == -1) {
			throw new NegativeNumberException();
		}
	}

	public static void checkNegativeNumber(BigDecimal num) throws NegativeNumberException {
		if (num.compareTo(BigDecimal.ZERO) == -1) {
			throw new NegativeNumberException();
		}
	}

}
