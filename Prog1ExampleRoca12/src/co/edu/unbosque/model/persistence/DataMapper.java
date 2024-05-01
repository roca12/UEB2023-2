package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Departamento;
import co.edu.unbosque.model.DepartamentoDTO;
import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.model.EmpleadoDTO;

public class DataMapper {

	public static EmpleadoDTO toDto(Empleado entity) {
		EmpleadoDTO dto = new EmpleadoDTO();
		dto.setCedula(entity.getCedula());
		dto.setNombre(entity.getNombre());
		dto.setFechaNacimiento(entity.getFechaNacimiento());
		dto.setCorreo(entity.getCorreo());
		dto.setTipoContrato(entity.getTipoContrato());
		dto.setHorasTrabajo(entity.getHorasTrabajo());

		return dto;
	}

	public static DepartamentoDTO toDto(Departamento entity) {
		DepartamentoDTO dto = new DepartamentoDTO();
		dto.setNombreDepartamento(entity.getNombreDepartamento());
		dto.setMultiplicadorSalario(entity.getMultiplicadorSalario());
		dto.setListaEmpleados(entity.getListaEmpleados());
		return dto;
	}
	
	//////////////////////////////////////////////////////////////////

	public static Empleado toEntity(EmpleadoDTO dto) {
		Empleado entity = new Empleado();
		entity.setCedula(dto.getCedula());
		entity.setNombre(dto.getNombre());
		entity.setFechaNacimiento(dto.getFechaNacimiento());
		entity.setCorreo(dto.getCorreo());
		entity.setTipoContrato(dto.getTipoContrato());
		entity.setHorasTrabajo(dto.getHorasTrabajo());

		return entity;

	}
	
	public static Departamento toEntity (DepartamentoDTO dto) {
		Departamento entity = new Departamento();
		entity.setNombreDepartamento(dto.getNombreDepartamento());
		entity.setMultiplicadorSalario(dto.getMultiplicadorSalario());
		entity.setListaEmpleados(dto.getListaEmpleados());
		return entity;
	}

}
