package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import co.edu.unbosque.model.User;

public class UserDAO {

	private ArrayList<User> userList;

	public UserDAO() {
		userList = new ArrayList<User>();
		userList.add(new User("admin", "1234"));
	}
	boolean res=false;
	public boolean validate(User login) {
		res=false;
		userList.forEach((user)->{
			if (user.getName().equals(login.getName())) {
				if (user.getPassword().equals(login.getPassword())) {
					res=true;
				}
			}
	
		});
		return res;

	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

}
