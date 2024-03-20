package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class DepartamentoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4569194544864118703L;
	private String nombreDepartamento;
	private double multiplicadorSalario;
	private ArrayList<EmpleadoDTO> listaEmpleados;

	public DepartamentoDTO() {
		listaEmpleados = new ArrayList<>();
	}

	public DepartamentoDTO(String nombreDepartamento, double multiplicadorSalario) {
		super();
		this.nombreDepartamento = nombreDepartamento;
		this.multiplicadorSalario = multiplicadorSalario;
		listaEmpleados = new ArrayList<>();
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public double getMultiplicadorSalario() {
		return multiplicadorSalario;
	}

	public void setMultiplicadorSalario(double multiplicadorSalario) {
		this.multiplicadorSalario = multiplicadorSalario;
	}

	public ArrayList<EmpleadoDTO> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<EmpleadoDTO> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre del Departamento: ");
		sb.append(nombreDepartamento);
		sb.append("\nMultiplicador de Salario: ");
		sb.append(multiplicadorSalario + "\n");
		sb.append("// lista de empleados de " + nombreDepartamento + " //\n");
		if (listaEmpleados.isEmpty()) {
			sb.append("Este departamento no tiene empleados asignados\n");
		}

		listaEmpleados.forEach((e) -> {
			sb.append(e.toString());
		});

//		for (EmpleadoDTO e : listaEmpleados) {
//			sb.append(e.toString());
//		}

		return sb.toString() + "\n\n";
	}

}
