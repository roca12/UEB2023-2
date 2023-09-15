package co.edu.unbosque.controller;

import co.edu.unbosque.model.persistence.SharkDAO;
import co.edu.unbosque.view.Console;

public class Controller {

	private SharkDAO sharkDao;
	private Console con;

	public Controller() {
		sharkDao = new SharkDAO();
		con = new Console();
	}

	public void run() {

		mainloop: while (true) {
			con.showMenu();
			int op = con.readInt();
			con.readWholeLine();
			switch (op) {
			case 1: {
				con.printWithNewLine("id");
				String id = con.readWholeLine();
				con.printWithNewLine("Name");
				String name = con.readWholeLine();
				con.printWithNewLine("Scientific Name:");
				String scientificName = con.readWholeLine();
				con.printWithNewLine("Lives in salt water:");
				String inSaltWater = con.readWholeLine();
				con.printWithNewLine("Number of Teeth:");
				String numberOfTeeth = con.readWholeLine();

				sharkDao.create(id, name, scientificName, inSaltWater, numberOfTeeth);
				con.printWithNewLine("Shark created");
				break;
			}
			case 2: {
				con.printWithNewLine(sharkDao.readAll());
				break;
			}
			case 3: {
				con.printWithNewLine("Index to update:");
				int index = Integer.parseInt(con.readWholeLine());
				con.printWithNewLine("New id");
				String id = con.readWholeLine();
				con.printWithNewLine("New Name");
				String name = con.readWholeLine();
				con.printWithNewLine("New Scientific Name:");
				String scientificName = con.readWholeLine();
				con.printWithNewLine("New Lives in salt water:");
				String inSaltWater = con.readWholeLine();
				con.printWithNewLine("New Number of Teeth:");
				String numberOfTeeth = con.readWholeLine();
				boolean doneUpdate = sharkDao.updateByIndex(index, id, name, scientificName, inSaltWater,
						numberOfTeeth);
				if (doneUpdate) {
					con.printWithNewLine("Shark updated");
				} else {
					con.printWithNewLine("Error on update");
				}
				break;
			}
			case 4: {
				con.printWithNewLine("Index to delete:");
				int index = Integer.parseInt(con.readWholeLine());

				if (sharkDao.delete(index)) {
					con.printWithNewLine("Shark deleted");
				} else {
					con.printWithNewLine("Error on delete");
				}

				break;
			}
			case 5: {

				break mainloop;
			}
			default:
				con.showBadSelection();
			}

		}

	}

	public SharkDAO getSharkDao() {
		return sharkDao;
	}

	public void setSharkDao(SharkDAO sharkDao) {
		this.sharkDao = sharkDao;
	}

	public Console getCon() {
		return con;
	}

	public void setCon(Console con) {
		this.con = con;
	}

}
