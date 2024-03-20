package co.edu.unbosque.model;

public class AlphanumericStringDTO {
	private String text;
	private int letters;
	private int numbers;
	private int symbols;
	private int spaces;

	public AlphanumericStringDTO() {
		// TODO Auto-generated constructor stub
	}

	public AlphanumericStringDTO(String text, int letters, int numbers, int symbols, int spaces) {
		super();
		this.text = text;
		this.letters = letters;
		this.numbers = numbers;
		this.symbols = symbols;
		this.spaces = spaces;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getLetters() {
		return letters;
	}

	public void setLetters(int letters) {
		this.letters = letters;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public int getSymbols() {
		return symbols;
	}

	public void setSymbols(int symbols) {
		this.symbols = symbols;
	}

	public int getSpaces() {
		return spaces;
	}

	public void setSpaces(int spaces) {
		this.spaces = spaces;
	}

	@Override
	public String toString() {
		return text + "," + letters + "," + numbers + "," + symbols + "," + spaces;
	}

}
