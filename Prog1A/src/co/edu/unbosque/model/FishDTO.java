package co.edu.unbosque.model;

public abstract class FishDTO {
	
	private int id;
	private String name;
	private String scientificName;
	private boolean inSaltWater;
	
	public FishDTO() {
		
	}

	public FishDTO(int id, String name, String scientificName, boolean inSaltWater) {
		super();
		this.id = id;
		this.name = name;
		this.scientificName = scientificName;
		this.inSaltWater = inSaltWater;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public boolean isInSaltWater() {
		return inSaltWater;
	}

	public void setInSaltWater(boolean inSaltWater) {
		this.inSaltWater = inSaltWater;
	}

	@Override
	public String toString() {
		return "FishDTO [id=" + id + ", name=" + name + ", scientificName=" + scientificName + ", inSaltWater="
				+ inSaltWater + "]";
	}
	
	public  abstract String getFood(String food);
	

}
