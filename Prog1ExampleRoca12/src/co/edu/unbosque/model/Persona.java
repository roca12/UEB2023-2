package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8594163042175038405L;
	private long cedula;
	private String nombre;
	private Date fechaNacimiento;
	private String correo;

	public Persona() {
	}

	public Persona(long cedula, String nombre, Date fechaNacimiento, String correo) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Cedula: " + cedula + 
				"\n"
				+ "nombre: " + nombre + 
				"\n"
				+ "fechaNacimiento: " + fechaNacimiento + 
				"\n"
				+ "correo: "+ correo + "\n";
	}
	
	
	public abstract String calcularSalarioHora(double salarioMes);
	

}
