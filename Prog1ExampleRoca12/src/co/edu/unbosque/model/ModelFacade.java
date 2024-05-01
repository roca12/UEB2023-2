package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.DepartamentoDAO;
import co.edu.unbosque.model.persistence.EmpleadoDAO;

public class ModelFacade {
	private EmpleadoDAO empleadoDAO;
	private DepartamentoDAO departamentoDAO;

	public ModelFacade() {
		empleadoDAO = new EmpleadoDAO();
		departamentoDAO = new DepartamentoDAO();
	}

	public EmpleadoDAO getEmpleadoDAO() {
		return empleadoDAO;
	}

	public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}

	public DepartamentoDAO getDepartamentoDAO() {
		return departamentoDAO;
	}

	public void setDepartamentoDAO(DepartamentoDAO departamentoDAO) {
		this.departamentoDAO = departamentoDAO;
	}

}
