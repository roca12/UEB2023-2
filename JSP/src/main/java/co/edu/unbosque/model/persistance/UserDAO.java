package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import co.edu.unbosque.model.UserDTO;

public class UserDAO {

	private ArrayList<UserDTO> userList;

	public UserDAO() {
		userList = new ArrayList<UserDTO>();
		userList.add(new UserDTO("admin", "1234"));
	}
	boolean res=false;
	public boolean validate(UserDTO login) {
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

	public ArrayList<UserDTO> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserDTO> userList) {
		this.userList = userList;
	}

}
