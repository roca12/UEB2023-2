package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.SharkDTO;

public class SharkDAO implements CRUDOperation {
	private ArrayList<SharkDTO> listOfSharks;
	public final String FILENAME = "datostiburon.csv";
	public final String SERIAL_FILENAME = "tiburon.dat";

	public SharkDAO() {
		listOfSharks = new ArrayList<>();
		// ya no carga de texto, ahora carga de serializado
		// readFromFile();
		if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
			Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
			@SuppressWarnings("unchecked")
			ArrayList<SharkDTO> temp2 = (ArrayList<SharkDTO>) temp;
			listOfSharks = temp2;
		} else {
			listOfSharks = new ArrayList<>();
		}
	}

	public void writeSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, listOfSharks);
	}

	public void readFromFile() {
		String content = FileHandler.openAndReadFile(FILENAME);
		if (content.isEmpty()) {
			return;
		}
		String[] lines = content.split("\n");
		for (int i = 0; i < lines.length; i++) {
			String[] cols = lines[i].split(";");
			int id = Integer.parseInt(cols[0]);
			String name = cols[1];
			String scientificName = cols[2];
			boolean saltWater = Boolean.parseBoolean(cols[3]);
			int numTeeth = Integer.parseInt(cols[4]);
			listOfSharks.add(new SharkDTO(id, name, scientificName, saltWater, numTeeth));
		}
	}

	String content = "";

	public void writeFile() {
		content = "";
		listOfSharks.forEach((shark) -> {
			content += shark.getId() + ";";
			content += shark.getName() + ";";
			content += shark.getScientificName() + ";";
			content += shark.isInSaltWater() + ";";
			content += shark.getNumTeeth() + "\n";
		});
		FileHandler.openAndWriteFile(FILENAME, content);
	}

	@Override
	public void create(String... attribs) {
		SharkDTO newShark = new SharkDTO();
		newShark.setId(Integer.parseInt(attribs[0]));
		newShark.setName(attribs[1]);
		newShark.setScientificName(attribs[2]);
		if (attribs[3].toLowerCase().contains("yes")) {
			newShark.setInSaltWater(true);
		} else {
			newShark.setInSaltWater(false);
		}
		newShark.setNumTeeth(Integer.parseInt(attribs[4]));
		listOfSharks.add(newShark);
		writeFile();
		writeSerializable();

	}

	@Override
	public void create(Object obj) {
		listOfSharks.add((SharkDTO) obj);
		writeFile();
		writeSerializable();

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
			if (!newData[0].isBlank() || !newData[0].isEmpty() || !newData[0].equals("")) {
				try {
					listOfSharks.get(index).setId(Integer.parseInt(newData[0]));
				} catch (NumberFormatException e) {

				}
			}
			if (!newData[1].isBlank() || !newData[1].isEmpty()) {
				listOfSharks.get(index).setName(newData[1]);
			}
			if (!newData[2].isBlank() || !newData[2].isEmpty()) {
				listOfSharks.get(index).setScientificName(newData[2]);
			}
			if (!newData[3].isBlank() || !newData[3].isEmpty() || !newData[3].equals("")) {
				if (newData[3].contains("yes")) {
					listOfSharks.get(index).setInSaltWater(true);
				} else {
					listOfSharks.get(index).setInSaltWater(false);
				}
			}
			if (!newData[4].isBlank() || !newData[4].isEmpty() || !newData[4].equals("")) {
				try {
					listOfSharks.get(index).setNumTeeth(Integer.parseInt(newData[4]));
				} catch (NumberFormatException e) {

				}

			}
			writeFile();
			writeSerializable();
			return true;
		}
	}

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listOfSharks.size()) {
			return false;
		} else {
			listOfSharks.remove(index);
			writeFile();
			writeSerializable();
			return true;
		}
	}

	@Override
	public boolean delete(Object obj) {
		SharkDTO toDelete = (SharkDTO) obj;
		if (listOfSharks.contains(toDelete)) {
			listOfSharks.remove(toDelete);
			writeFile();
			writeSerializable();
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
