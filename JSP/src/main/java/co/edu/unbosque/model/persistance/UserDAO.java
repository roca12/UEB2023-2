package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import co.edu.unbosque.model.User;

public class UserDAO {

	private ArrayList<User> userList;

	public UserDAO() {
		userList = new ArrayList<User>();
		userList.add(new User("admin", "1234"));
	}

	public boolean validate(User login) {
		for (User u : userList) {
			if (u.getName().equals(login.getName())) {
				if (u.getPassword().equals(login.getPassword())) {
					return true;
				}
			}
		}
		return false;

	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

}
