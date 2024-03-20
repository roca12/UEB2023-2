package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.EmpleadoDTO;

public interface DepartamentoOp {
	
	public void addEmpleadoToDepartamento(int depIndex,EmpleadoDTO e);

	public String readAllEmpleadosFromDepartamento(int depIndex);

	public String updateEmpleado(int depIndex,int indexEmp, EmpleadoDTO e);

	public String deleteEmpleado(int depIndex,int indexEmp);
}
