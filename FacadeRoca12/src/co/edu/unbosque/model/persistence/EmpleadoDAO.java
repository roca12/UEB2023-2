package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import co.edu.unbosque.model.EmpleadoDTO;

public class EmpleadoDAO implements CRUDOperation<EmpleadoDTO> {

	private ArrayList<EmpleadoDTO> listaEmpleados;
	private String TEXT_FILE_URL = "data/empleados.csv";
	private String SERIALIZED_FILE_URL = "data/empleados.dat";
	private String PROPERTIES_FILE_URL = "data/empleados.properties";

	public EmpleadoDAO() {
		listaEmpleados = new ArrayList<>();
		cargarDesdeArchivoPropiedades();
		cargarDesdeArchivoTexto();
		cargarDesdeSerializado();
	}

	private void cargarDesdeArchivoPropiedades() {
		Properties temp = FileHandler.loadProperties(PROPERTIES_FILE_URL);
		int lineas = temp.entrySet().size();
		for (int i = 0; i < (lineas/6); i++) {
			EmpleadoDTO aux = new EmpleadoDTO();
			aux.setCedula(Long.parseLong(temp.getProperty("empleado" + i + ".cedula")));
			aux.setNombre(temp.getProperty("empleado" + i + ".nombre"));
			aux.setFechaNacimiento(new Date(Long.parseLong(temp.getProperty("empleado" + i + ".fechanacimiento"))));
			aux.setCorreo(temp.getProperty("empleado" + i + ".correo"));
			aux.setTipoContrato(temp.getProperty("empleado" + i + ".tipocontrato"));
			aux.setHorasTrabajo(Integer.parseInt(temp.getProperty("empleado" + i + ".horastrabajo")));
			listaEmpleados.add(aux);
		}
	}

	private void escribirArchivoPropiedades() {
		Properties temp = new Properties();
		for (int i = 0; i < listaEmpleados.size(); i++) {
			temp.put("empleado" + i + ".cedula", listaEmpleados.get(i).getCedula() + "");
			temp.put("empleado" + i + ".nombre", listaEmpleados.get(i).getNombre() + "");
			temp.put("empleado" + i + ".fechanacimiento", listaEmpleados.get(i).getFechaNacimiento().getTime() + "");
			temp.put("empleado" + i + ".correo", listaEmpleados.get(i).getCorreo() + "");
			temp.put("empleado" + i + ".tipocontrato", listaEmpleados.get(i).getTipoContrato() + "");
			temp.put("empleado" + i + ".horastrabajo", listaEmpleados.get(i).getHorasTrabajo() + "");
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
						if (o instanceof EmpleadoDTO) {
							EmpleadoDTO temp = (EmpleadoDTO) o;
							listaEmpleados.add(temp);
						}
					}
				}
			}
		}

	}

	private void esribirEnSerializado() {
		FileHandler.openAndWriteFileSerial(SERIALIZED_FILE_URL, listaEmpleados);
	}

	private void cargarDesdeArchivoTexto() {
		String contenido = FileHandler.openAndReadTextfiles(TEXT_FILE_URL);
		if (contenido.equals("")) {
			listaEmpleados = new ArrayList<>();
			return;
		}
		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			EmpleadoDTO temporal = new EmpleadoDTO();
			temporal.setCedula(Long.parseLong(columnas[0]));
			temporal.setNombre(columnas[1]);
			temporal.setFechaNacimiento(new Date(Long.parseLong(columnas[2])));
			temporal.setCorreo(columnas[3]);
			temporal.setTipoContrato(columnas[4]);
			temporal.setHorasTrabajo(Integer.parseInt(columnas[5]));
			listaEmpleados.add(temporal);
		}
	}

	public void escribirEnArchivoTexto() {
		String contenido = "";
		for (int i = 0; i < listaEmpleados.size(); i++) {
			contenido += listaEmpleados.get(i).getCedula() + ";";
			contenido += listaEmpleados.get(i).getNombre() + ";";
			contenido += listaEmpleados.get(i).getFechaNacimiento().getTime() + ";";
			contenido += listaEmpleados.get(i).getCorreo() + ";";
			contenido += listaEmpleados.get(i).getTipoContrato() + ";";
			contenido += listaEmpleados.get(i).getHorasTrabajo();
			if (i < listaEmpleados.size() - 1) {
				contenido += "\n";
			}

		}
		FileHandler.openAndWriteTextfiles(TEXT_FILE_URL, contenido);
	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "n";
		}
		if (index >= listaEmpleados.size()) {
			return "o";
		}
		return "g";
	}

	public EmpleadoDTO getLast() {
		return listaEmpleados.get(listaEmpleados.size() - 1);
	}

	@Override
	public void create(EmpleadoDTO data) {
		listaEmpleados.add(data);
		escribirEnArchivoTexto();
		esribirEnSerializado();
		escribirArchivoPropiedades();
	}

	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder("---Lista de empleados--- \n");
		listaEmpleados.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}

	@Override
	public String update(int index, EmpleadoDTO newData) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listaEmpleados.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listaEmpleados.size() + " datos";
		}
		listaEmpleados.set(index, newData);
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
		if (index >= listaEmpleados.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listaEmpleados.size() + " datos";
		}
		listaEmpleados.remove(index);
		escribirEnArchivoTexto();
		esribirEnSerializado();
		escribirArchivoPropiedades();
		return "Empleado en el indice " + index + " eliminado con exito";

	}

	public ArrayList<EmpleadoDTO> getListaEmpleados() {
		return listaEmpleados;
	}

}
