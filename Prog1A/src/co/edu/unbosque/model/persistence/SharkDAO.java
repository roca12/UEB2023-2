package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.SharkDTO;

public class SharkDAO implements CRUDOperation {
	private ArrayList<SharkDTO> listOfSharks;
	private final String FILEURL = "src/co/edu/unbosque/model/persistence/sharks.dfrc";

	public SharkDAO() {
		listOfSharks = new ArrayList<>();
		loadFromFile();

	}

	public void loadFromFile() {
		String content = FileHandler.openAndReadFile(FILEURL);
		if(content.equals("")) {
			return;
		}
		String[] lines = content.split("\n");
		for (int i = 0; i < lines.length; i++) {
			String[] cols = lines[i].split(";");
			int id = Integer.parseInt(cols[0]);
			String name = cols[1];
			String sciName = cols[2];
			boolean saltWater = Boolean.parseBoolean(cols[3]);
			int numTeeth = Integer.parseInt(cols[4]);
			listOfSharks.add(new SharkDTO(id, name, sciName, saltWater, numTeeth));
		}
	}

	String exit = "";

	public void writeOnFile() {
		exit="";
		listOfSharks.forEach((shark) -> {
			exit += shark.getId() + ";";
			exit += shark.getName() + ";";
			exit += shark.getScientificName() + ";";
			exit += shark.isInSaltWater() + ";";
			exit += shark.getNumTeeth() + "\n";
		});
		FileHandler.openAndWriteFile(FILEURL, exit);
	}

	@Override
	public void create(String... attribs) {
		SharkDTO newShark = new SharkDTO();
		newShark.setId(Integer.parseInt(attribs[0]));
		newShark.setName(attribs[1]);
		newShark.setScientificName(attribs[2]);
		if (attribs[3].contains("yes")) {
			newShark.setInSaltWater(true);
		} else {
			newShark.setInSaltWater(false);
		}
		newShark.setNumTeeth(Integer.parseInt(attribs[4]));
		listOfSharks.add(newShark);
		writeOnFile();

	}

	@Override
	public void create(Object obj) {
		listOfSharks.add((SharkDTO) obj);
		writeOnFile();

	}

	int index = 0;

	@Override
	public String readAll() {
		index = 0;
		StringBuilder sb = new StringBuilder();
		listOfSharks.forEach(shark -> {
			sb.append(index + " -> " + (shark.toString() + "\n"));
			index++;
		});
		return sb.toString();
	}

	@Override
	public boolean updateByIndex(int index, String... newData) {
		if (index < 0 || index >= listOfSharks.size()) {
			return false;
		} else {
			if (!newData[0].isBlank() || !newData[0].isEmpty() || newData[0] != null || !newData[0].equals("")) {
				try {
					listOfSharks.get(index).setId(Integer.parseInt(newData[0]));
				} catch (NumberFormatException e) {

				}

			}
			if (!newData[1].isBlank() || !newData[1].isEmpty() ) {
				listOfSharks.get(index).setName(newData[1]);
			}
			if (!newData[2].isBlank() || !newData[2].isEmpty() ) {
				listOfSharks.get(index).setScientificName(newData[2]);
			}
			if (!newData[3].isBlank() || !newData[3].isEmpty() || !newData[0].equals("")) {
				if (newData[3].contains("yes")) {
					listOfSharks.get(index).setInSaltWater(true);
				} else {
					listOfSharks.get(index).setInSaltWater(false);
				}
			}
			if (!newData[4].isBlank() || !newData[4].isEmpty()  || !newData[0].equals("")) {
				try {
					listOfSharks.get(index).setNumTeeth(Integer.parseInt(newData[4]));
				} catch (NumberFormatException e) {

				}

			}
			writeOnFile();
			return true;
		}
	}

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listOfSharks.size()) {
			return false;
		} else {
			listOfSharks.remove(index);
			writeOnFile();
			return true;
		}
	}

	@Override
	public boolean delete(Object obj) {
		SharkDTO toDelete = (SharkDTO) obj;
		if (listOfSharks.contains(toDelete)) {
			listOfSharks.remove(toDelete);
			writeOnFile();
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<SharkDTO> getListOfSharks() {
		return listOfSharks;
	}

	public void setListOfSharks(ArrayList<SharkDTO> listOfSharks) {
		this.listOfSharks = listOfSharks;
	}

}
