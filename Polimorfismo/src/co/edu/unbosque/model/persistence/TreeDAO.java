package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InvernalTreeDTO;
import co.edu.unbosque.model.TreeDTO;

public class TreeDAO implements CRUDOperation {
	private ArrayList<TreeDTO> trees;

	public TreeDAO() {
		trees = new ArrayList<>();
	}

	@Override
	public void create(String... strs) {
		TreeDTO temp = new TreeDTO();
		temp.setName(strs[0]);
		temp.setScientificName(strs[1]);
		temp.setFloral(Boolean.parseBoolean(strs[2]));
		temp.setLogWidth(Float.parseFloat(strs[3]));
		trees.add(temp);
	}

	@Override
	public void create(Object o) {
		trees.add((TreeDTO) o);
	}

	@Override
	public String readAll() {
		String printable = "";
		for (TreeDTO treeDTO : trees) {
			printable += treeDTO.toString();
		}
		return printable;
	}

	@Override
	public boolean update(int index, String... strs) {
		if (index < 0 || index >= trees.size()) {
			return false;
		} else {
			if (!strs[0].isBlank() || strs[0] != null) {
				trees.get(index).setName(strs[0]);
			}
			if (!strs[1].isBlank() || strs[1] != null) {
				trees.get(index).setScientificName(strs[1]);
			}
			trees.get(index).setFloral(Boolean.valueOf(strs[2]));
			trees.get(index).setLogWidth(Float.parseFloat(strs[3]));
			return true;
		}

	}

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= trees.size()) {
			return false;
		} else {
			trees.remove(index);
			return true;
		}
	}

	@Override
	public boolean delete(Object o) {
		if (o == null) {
			return false;
		} else if (trees.remove((TreeDTO) o)) {
			return true;
		} else {
			return false;
		}
	}

	public String readAllWithInvernalTree() {
		String printable = "";
		for (int i = 0; i < trees.size(); i++) {
			TreeDTO temp = trees.get(i);
			if (temp instanceof InvernalTreeDTO) {
				InvernalTreeDTO invernalTemp = (InvernalTreeDTO) temp;
				printable += invernalTemp.toString();
			} else if (temp instanceof TreeDTO) {
				printable += temp.toString();
			}
		}
		return printable;
	}
}
