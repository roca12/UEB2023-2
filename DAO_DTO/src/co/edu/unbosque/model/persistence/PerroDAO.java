package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.PerroDTO;

public class PerroDAO {

	private ArrayList<PerroDTO> listaDePerros;

	public PerroDAO() {
		listaDePerros = new ArrayList<>();
	}

	public void crear(PerroDTO nuevoPerro) {
		listaDePerros.add(nuevoPerro);
	}

	public boolean eliminar(int indice) {
		if (indice < 0 || indice >= listaDePerros.size()) {
			return false;
		} else {
			listaDePerros.remove(indice);
			return true;
		}
	}

	public String mostrar() {
		String salida = "";
		for (PerroDTO p : listaDePerros) {
			salida += p.toString() + "\n";
		}
		return salida;
	}

	public boolean actualizar(int pos, PerroDTO nuevoDato) {
		if (pos < 0 || pos >= listaDePerros.size()) {
			return false;
		} else {
			listaDePerros.get(pos).setNombre(nuevoDato.getNombre());
			listaDePerros.get(pos).setEspecie(nuevoDato.getEspecie());
			listaDePerros.get(pos).setColorPelo(nuevoDato.getColorPelo());
			listaDePerros.get(pos).setEdadEnAnios(nuevoDato.getEdadEnAnios());
			listaDePerros.get(pos).setEsMacho(nuevoDato.isEsMacho());
			return true;
		}
	}
}
