package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

public class EmpleadoDTO extends Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6749956669608168440L;
	private String tipoContrato;
	private int horasTrabajo;
	
	public EmpleadoDTO() {
		// TODO Auto-generated constructor stub

	}

	public EmpleadoDTO(String tipoContrato, int horasTrabajo) {
		super();
		this.tipoContrato = tipoContrato;
		this.horasTrabajo = horasTrabajo;
	}

	public EmpleadoDTO(long cedula, String nombre, Date fechaNacimiento, String correo, String tipoContrato,
			int horasTrabajo) {
		super(cedula, nombre, fechaNacimiento, correo);
		this.tipoContrato = tipoContrato;
		this.horasTrabajo = horasTrabajo;
	}

	public EmpleadoDTO(long cedula, String nombre, Date fechaNacimiento, String correo) {
		super(cedula, nombre, fechaNacimiento, correo);
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public int getHorasTrabajo() {
		return horasTrabajo;
	}

	public void setHorasTrabajo(int horasTrabajo) {
		this.horasTrabajo = horasTrabajo;
	}

	@Override
	public String toString() {
		return super.toString()+"Tipo de Contrato: " + tipoContrato + "\nhorasTrabajo: " + horasTrabajo + "\n\n";
	}

	@Override
	public String calcularSalarioHora(double salarioMes) {
		double salarioHora=salarioMes/this.horasTrabajo;
		return "El salario por horas del empleado es de "+salarioHora+" por hora.";
	}
	
	
	
}
