package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import co.edu.unbosque.model.AlphanumericStringDTO;

public class AlphanumericStringDAO {

	public static  ArrayList<AlphanumericStringDTO> stringsList= new ArrayList<>();

	
	public static  void createNew(AlphanumericStringDTO newString) {
		stringsList.add(newString);
	}

	public ArrayList<AlphanumericStringDTO> getUserList() {
		return stringsList;
	}

	

}
