package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.model.EmpleadoDTO;

public class EmpleadoDAO implements CRUDOperation<EmpleadoDTO> {

	private ArrayList<EmpleadoDTO> listaEmpleadosDto;
	private ArrayList<Empleado> listaEmpleadosEntity;
	private String TEXT_FILE_URL = "data/empleados.csv";
	private String SERIALIZED_FILE_URL = "data/empleados.dat";
	private String PROPERTIES_FILE_URL = "data/empleados.properties";

	public EmpleadoDAO() {
		listaEmpleadosDto = new ArrayList<>();
		listaEmpleadosEntity = new ArrayList<>();
		cargarDesdeArchivoPropiedades();
		cargarDesdeArchivoTexto();
		cargarDesdeSerializado();
		for (int i = 0; i < listaEmpleadosEntity.size(); i++) {
			listaEmpleadosDto.add(DataMapper.toDto(listaEmpleadosEntity.get(i)));
		}
	}

	private void cargarDesdeArchivoPropiedades() {
		Properties temp = FileHandler.loadProperties(PROPERTIES_FILE_URL);
		int lineas = temp.entrySet().size();
		for (int i = 0; i < (lineas / 6); i++) {
			Empleado aux = new Empleado();
			aux.setCedula(Long.parseLong(temp.getProperty("empleado" + i + ".cedula")));
			aux.setNombre(temp.getProperty("empleado" + i + ".nombre"));
			aux.setFechaNacimiento(new Date(Long.parseLong(temp.getProperty("empleado" + i + ".fechanacimiento"))));
			aux.setCorreo(temp.getProperty("empleado" + i + ".correo"));
			aux.setTipoContrato(temp.getProperty("empleado" + i + ".tipocontrato"));
			aux.setHorasTrabajo(Integer.parseInt(temp.getProperty("empleado" + i + ".horastrabajo")));
			listaEmpleadosEntity.add(aux);
		}
	}

	private void escribirArchivoPropiedades() {
		for (int i = 0; i < listaEmpleadosDto.size(); i++) {
			listaEmpleadosEntity.add(DataMapper.toEntity(listaEmpleadosDto.get(i)));
		}
		Properties temp = new Properties();
		for (int i = 0; i < listaEmpleadosEntity.size(); i++) {
			temp.put("empleado" + i + ".cedula", listaEmpleadosEntity.get(i).getCedula() + "");
			temp.put("empleado" + i + ".nombre", listaEmpleadosEntity.get(i).getNombre() + "");
			temp.put("empleado" + i + ".fechanacimiento",
					listaEmpleadosEntity.get(i).getFechaNacimiento().getTime() + "");
			temp.put("empleado" + i + ".correo", listaEmpleadosEntity.get(i).getCorreo() + "");
			temp.put("empleado" + i + ".tipocontrato", listaEmpleadosEntity.get(i).getTipoContrato() + "");
			temp.put("empleado" + i + ".horastrabajo", listaEmpleadosEntity.get(i).getHorasTrabajo() + "");
		}
		FileHandler.saveProperties(PROPERTIES_FILE_URL, temp);
	}

	private void cargarDesdeSerializado() {
		if (FileHandler.checkSerializedFile(SERIALIZED_FILE_URL)) {
			Object obj = FileHandler.openAndReadFileSerial(SERIALIZED_FILE_URL);
			// safe casting
			if (obj instanceof ArrayList<?>) {
				ArrayList<?> al = (ArrayList<?>) obj;
				if (al.size() > 0) {
					for (int i = 0; i < al.size(); i++) {
						Object o = al.get(i);
						if (o instanceof Empleado) {
							Empleado temp = (Empleado) o;
							listaEmpleadosEntity.add(temp);
						}
					}
				}
			}
		}

	}

	private void esribirEnSerializado() {
		for (int i = 0; i < listaEmpleadosDto.size(); i++) {
			listaEmpleadosEntity.add(DataMapper.toEntity(listaEmpleadosDto.get(i)));
		}
		FileHandler.openAndWriteFileSerial(SERIALIZED_FILE_URL, listaEmpleadosEntity);
	}

	private void cargarDesdeArchivoTexto() {
		String contenido = FileHandler.openAndReadTextfiles(TEXT_FILE_URL);
		if (contenido.equals("")) {
			listaEmpleadosEntity = new ArrayList<>();
			return;
		}
		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			Empleado temporal = new Empleado();
			temporal.setCedula(Long.parseLong(columnas[0]));
			temporal.setNombre(columnas[1]);
			temporal.setFechaNacimiento(new Date(Long.parseLong(columnas[2])));
			temporal.setCorreo(columnas[3]);
			temporal.setTipoContrato(columnas[4]);
			temporal.setHorasTrabajo(Integer.parseInt(columnas[5]));
			listaEmpleadosEntity.add(temporal);
		}
	}

	public void escribirEnArchivoTexto() {
		for (int i = 0; i < listaEmpleadosDto.size(); i++) {
			listaEmpleadosEntity.add(DataMapper.toEntity(listaEmpleadosDto.get(i)));
		}
		String contenido = "";
		for (int i = 0; i < listaEmpleadosEntity.size(); i++) {
			contenido += listaEmpleadosEntity.get(i).getCedula() + ";";
			contenido += listaEmpleadosEntity.get(i).getNombre() + ";";
			contenido += listaEmpleadosEntity.get(i).getFechaNacimiento().getTime() + ";";
			contenido += listaEmpleadosEntity.get(i).getCorreo() + ";";
			contenido += listaEmpleadosEntity.get(i).getTipoContrato() + ";";
			contenido += listaEmpleadosEntity.get(i).getHorasTrabajo();
			if (i < listaEmpleadosEntity.size() - 1) {
				contenido += "\n";
			}

		}
		FileHandler.openAndWriteTextfiles(TEXT_FILE_URL, contenido);
	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "n";
		}
		if (index >= listaEmpleadosDto.size()) {
			return "o";
		}
		return "g";
	}

	public EmpleadoDTO getLast() {
		return listaEmpleadosDto.get(listaEmpleadosDto.size() - 1);
	}

	@Override
	public void create(EmpleadoDTO data) {
		listaEmpleadosDto.add(data);
		escribirEnArchivoTexto();
		esribirEnSerializado();
		escribirArchivoPropiedades();
	}

	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder("---Lista de empleados--- \n");
		listaEmpleadosDto.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}

	@Override
	public String update(int index, EmpleadoDTO newData) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listaEmpleadosDto.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listaEmpleadosDto.size()
					+ " datos";
		}
		listaEmpleadosDto.set(index, newData);
		escribirEnArchivoTexto();
		esribirEnSerializado();
		escribirArchivoPropiedades();
		return "Empleado actualizado con exito";
	}

	@Override
	public String delete(int index) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listaEmpleadosDto.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listaEmpleadosDto.size()
					+ " datos";
		}
		listaEmpleadosDto.remove(index);
		escribirEnArchivoTexto();
		esribirEnSerializado();
		escribirArchivoPropiedades();
		return "Empleado en el indice " + index + " eliminado con exito";

	}

	public ArrayList<EmpleadoDTO> getListaEmpleados() {
		return listaEmpleadosDto;
	}

}
