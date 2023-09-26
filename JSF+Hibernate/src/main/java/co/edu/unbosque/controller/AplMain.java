package co.edu.unbosque.controller;


import co.edu.unbosque.model.User;
import co.edu.unbosque.model.persistence.UserDAO;

public class AplMain {
	
	public static void main(String[] args) {
		UserDAO us = new UserDAO();
		User u1= new User("admin", "1234");
		us.create(u1);
		
		for (User u : us.findAll()) {
			System.out.println(u.getId()+"-"+u.getUsername()+"-"+u.getPasskey());
		}	

	}

}
