package co.edu.unbosque.model;

public class ProductoLacteoDTO {

	private long id;
	private String nombreProducto;
	private String empresaProductora;
	private float costoFabricacion;
	private float costoVenta;
	private boolean librelactosa;

	public ProductoLacteoDTO() {
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public boolean isLibrelactosa() {
		return librelactosa;
	}



	public void setLibrelactosa(boolean librelactosa) {
		this.librelactosa = librelactosa;
	}



	public ProductoLacteoDTO(long id, String nombreProducto, String empresaProductora, float costoFabricacion,
			float costoVenta, boolean librelactosa) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.empresaProductora = empresaProductora;
		this.costoFabricacion = costoFabricacion;
		this.costoVenta = costoVenta;
		this.librelactosa = librelactosa;
	}



	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getEmpresaProductora() {
		return empresaProductora;
	}

	public void setEmpresaProductora(String empresaProductora) {
		this.empresaProductora = empresaProductora;
	}

	public float getCostoFabricacion() {
		return costoFabricacion;
	}

	public void setCostoFabricacion(float costoFabricacion) {
		this.costoFabricacion = costoFabricacion;
	}

	public float getCostoVenta() {
		return costoVenta;
	}

	public void setCostoVenta(float costoVenta) {
		this.costoVenta = costoVenta;
	}

	public boolean isLibreLactosa() {
		return librelactosa;
	}

	public void setLibreLactosa(boolean libreLactosa) {
		this.librelactosa = libreLactosa;
	}
}
