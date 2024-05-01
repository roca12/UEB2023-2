package co.edu.unbosque.model;

public class PerroDTO {

	private String nombre;
	private String especie;
	private int edadEnAnios;
	private String colorPelo;
	private boolean esMacho;
	
	public PerroDTO() {
	}

	public PerroDTO(String nombre, String especie, int edadEnAnios, String colorPelo, boolean esMacho) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.edadEnAnios = edadEnAnios;
		this.colorPelo = colorPelo;
		this.esMacho = esMacho;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getEdadEnAnios() {
		return edadEnAnios;
	}

	public void setEdadEnAnios(int edadEnAnios) {
		this.edadEnAnios = edadEnAnios;
	}

	public String getColorPelo() {
		return colorPelo;
	}

	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}

	public boolean isEsMacho() {
		return esMacho;
	}

	public void setEsMacho(boolean esMacho) {
		this.esMacho = esMacho;
	}
	
	
	public String comer() {
		return "El perrito come dog chow";
	}
	
	public String dormir() {
		return "El perro se da 3 vueltas antes de echarse a dormir";
	}
	
	public String reproducirse() {
		return "el perro se reproduce mas que el ingeniero de sistemas";
	}

	@Override
	public String toString() {
		return "PerroDTO [nombre=" + nombre + ", especie=" + especie + ", edadEnAnios=" + edadEnAnios + ", colorPelo="
				+ colorPelo + ", esMacho=" + esMacho + "]";
	}
	
	
	
}
