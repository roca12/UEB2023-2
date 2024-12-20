package co.edu.unbosque.model.persistance;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.model.UserDTO;

public class UserDAO implements CRUDOperation {

	private ArrayList<UserDTO> usersList;
	private DBConnection dbcon;

	public UserDAO() {
		usersList = new ArrayList<>();
	}

	@Override
	public void create(String... args) {
		try {
			

			dbcon.setPreparedStatement(dbcon.getConnect()
					.prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)"));
			dbcon.getPreparedStatement().setString(1, "Test");
			dbcon.getPreparedStatement().setString(2, "TestEmail");
			dbcon.getPreparedStatement().setString(3, "TestWebpage");
			dbcon.getPreparedStatement().setDate(4, new Date(2009, 12, 11));
			dbcon.getPreparedStatement().setString(5, "TestSummary");
			dbcon.getPreparedStatement().setString(6, "TestComment");
			dbcon.getPreparedStatement().executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String readAll() {
		String data = "";

		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM user;"));

			while (dbcon.getResultSet().next()) {
				String user = dbcon.getResultSet().getString("user");
				String password = dbcon.getResultSet().getString("password");
				usersList.add(new UserDTO(user, password));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (UserDTO u : usersList) {
			data += u.toString() + "\n";
		}
		return data;
	}

	@Override
	public boolean update(int index, String... args) {

		return false;
	}

	@Override
	public boolean delete(int index) {
		try {
			dbcon.setPreparedStatement(
					dbcon.getConnect().prepareStatement("delete from feedback.comments where myuser= ? ; "));
			dbcon.getPreparedStatement().setInt(0, index);
			dbcon.getPreparedStatement().executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
