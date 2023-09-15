package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InvernalTreeDTO;

public class InvernalTreeDAO implements CRUDOperation {
	private ArrayList<InvernalTreeDTO> invernalTrees;

	public InvernalTreeDAO() {
		invernalTrees = new ArrayList<>();
	}

	@Override
	public void create(String... strs) {
		InvernalTreeDTO temp = new InvernalTreeDTO();
		temp.setName(strs[0]);
		temp.setScientificName(strs[1]);
		temp.setFloral(Boolean.parseBoolean(strs[2]));
		temp.setLogWidth(Float.parseFloat(strs[3]));
		temp.setMinTemperature(Float.parseFloat(strs[4]));
		invernalTrees.add(temp);
	}

	@Override
	public void create(Object o) {
		invernalTrees.add((InvernalTreeDTO) o);
	}

	@Override
	public String readAll() {
		String printable = "";
		for (InvernalTreeDTO InvernalTreeDTO : invernalTrees) {
			printable += InvernalTreeDTO.toString();
		}
		return printable;
	}

	@Override
	public boolean update(int index, String... strs) {
		if (index < 0 || index >= invernalTrees.size()) {
			return false;
		} else {
			if (!strs[0].isBlank() || strs[0] != null) {
				invernalTrees.get(index).setName(strs[0]);
			}
			invernalTrees.get(index).setScientificName(strs[1]);
			invernalTrees.get(index).setFloral(Boolean.valueOf(strs[2]));
			invernalTrees.get(index).setLogWidth(Float.parseFloat(strs[3]));
			invernalTrees.get(index).setMinTemperature(Float.parseFloat(strs[4]));
			return true;
		}

	}

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= invernalTrees.size()) {
			return false;
		}else {
			invernalTrees.remove(index);
			return true;
		}
	}

	@Override
	public boolean delete(Object o) {
		if (o==null) {
			return false;
		}else if (invernalTrees.remove((InvernalTreeDTO)o)) {
			return true;
		}else {
			return false;
		}
	}

}
