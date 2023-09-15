package co.edu.unbosque.controller;

import co.edu.unbosque.model.InvernalTreeDTO;
import co.edu.unbosque.model.persistence.InvernalTreeDAO;
import co.edu.unbosque.model.persistence.TreeDAO;

public class Controller {
	private TreeDAO tdao;
	private InvernalTreeDAO invtreedao;
	
	public Controller() {
		tdao= new TreeDAO();
		invtreedao= new InvernalTreeDAO();
	}
	
	public void run() {
		//agrega un arbol y queda en el DAO de tree
		tdao.create("Limonero","Citrus Limon","true","6.0");
		//agrega un arbol invernal y queda en el DAO de invernal tree
		invtreedao.create("Eucalipto","Eucalyptus globulus","true","1500.0","5.0");
		// ademas de el anterior tambien lo agrego al dao de tree
		InvernalTreeDTO nuevo = new InvernalTreeDTO("Eucalipto","Eucalyptus globulus",true,1500.0f,5.0f);
		tdao.create(nuevo);
		
		//treeDAO tiene dos arboles, y InvernalTreeDAO tiene uno solo
		
		System.out.println(tdao.readAllWithInvernalTree());
	}

}
