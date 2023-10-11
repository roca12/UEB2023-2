package co.edu.unbosque.model;

public class SharkDTO extends FishDTO {

	private int numTeeth;

	public SharkDTO() {
		// TODO Auto-generated constructor stub
	}

	public SharkDTO(int numTeeth) {
		super();
		this.numTeeth = numTeeth;
	}

	public SharkDTO(int id, String name, String scientificName, boolean inSaltWater) {
		super(id, name, scientificName, inSaltWater);
	}

	public SharkDTO(int id, String name, String scientificName, boolean inSaltWater, int numTeeth) {
		super(id, name, scientificName, inSaltWater);
		this.numTeeth = numTeeth;
	}

	public int getNumTeeth() {
		return numTeeth;
	}

	public void setNumTeeth(int numTeeth) {
		this.numTeeth = numTeeth;
	}

	@Override
	public String toString() {
		return super.toString() + " SharkDTO [numTeeth=" + numTeeth + "]";
	}

	@Override
	public String getFood(String food) {
		if (food.equalsIgnoreCase("veggies")) {
			return "The shark don´t gonna eat that";
		} else if (food.equalsIgnoreCase("meat")) {
			return "Yuuumi, fresh meat";
		} else if (food.equalsIgnoreCase("human")) {
			return "They dont usually eat human, taste awful";
		}

		return "no food provided";

	}

}
