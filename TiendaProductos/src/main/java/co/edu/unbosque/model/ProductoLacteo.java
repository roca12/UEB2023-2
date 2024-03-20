package co.edu.unbosque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productolacteo")

public class ProductoLacteo {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombreProducto", nullable = false)
	private String nombreProducto;

	@Column(name = "empresaProductora", nullable = false)
	private String empresaProductora;

	@Column(name = "costoFabricacion", nullable = false)
	private float costoFabricacion;

	@Column(name = "costoVenta", nullable = false)
	private float costoVenta;

	@Column(name = "librelactosa", nullable = false)
	private boolean librelactosa;

	public ProductoLacteo() {
		// TODO Auto-generated constructor stub
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

}
