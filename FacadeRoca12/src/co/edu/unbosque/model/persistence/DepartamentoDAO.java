package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.DepartamentoDTO;
import co.edu.unbosque.model.EmpleadoDTO;

public class DepartamentoDAO implements CRUDOperation<DepartamentoDTO>, DepartamentoOp {

	private ArrayList<DepartamentoDTO> listaDepartamentos;

	public DepartamentoDAO() {
		listaDepartamentos = new ArrayList<>();
	}

	@Override
	public void create(DepartamentoDTO data) {
		listaDepartamentos.add(data);
	}

	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		listaDepartamentos.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}

	@Override
	public String update(int index, DepartamentoDTO newData) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listaDepartamentos.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listaDepartamentos.size()
					+ " datos";
		}
		listaDepartamentos.set(index, newData);
		return "Departamento actualizado con exito";
	}

	@Override
	public String delete(int index) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listaDepartamentos.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listaDepartamentos.size()
					+ " datos";
		}
		listaDepartamentos.remove(index);
		return "Departamento en el indice " + index + " eliminado con exito";

	}

	@Override
	public void addEmpleadoToDepartamento(int depIndex, EmpleadoDTO e) {
		listaDepartamentos.get(depIndex).getListaEmpleados().add(e);

	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "n";
		}
		if (index >= listaDepartamentos.size()) {
			return "o";
		}
		return "g";
	}

	private String dataDepartamento = "";

	@Override
	public String readAllEmpleadosFromDepartamento(int depIndex) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listaDepartamentos.size()
					+ " datos";
		}
		case "g": {
			listaDepartamentos.get(depIndex).getListaEmpleados().forEach((e) -> {
				dataDepartamento += e.toString();
			});
			return dataDepartamento;
		}
		}
		return "Error en impresion de empleados";
	}

	@Override
	public String updateEmpleado(int depIndex, int indexEmp, EmpleadoDTO e) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listaDepartamentos.size()
					+ " datos";
		}
		case "g": {
			listaDepartamentos.get(depIndex).getListaEmpleados().set(indexEmp, e);
			return " empleado actualizado con exito";
		}
		}
		return "Error en impresion de empleados";
	}

	@Override
	public String deleteEmpleado(int depIndex, int indexEmp) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listaDepartamentos.size()
					+ " datos";
		}
		case "g": {
			listaDepartamentos.get(depIndex).getListaEmpleados().remove(indexEmp);
			return "empleado eliminado con exito";
		}
		}
		return "Error en impresion de empleados";
	}

	public ArrayList<DepartamentoDTO> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(ArrayList<DepartamentoDTO> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}

}
