package co.edu.unbosque.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import co.edu.unbosque.model.DepartamentoDTO;
import co.edu.unbosque.model.EmpleadoDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.exception.EmailNotValidException;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.view.Consola;
import co.edu.unbosque.view.ViewFacade;

public class Controller {
	// consola solo, no es necesario el facade
	// si se va a usar GUI, no crear la consola, usar sysos para confirmaciones
	private Consola con;
	private ViewFacade vf;
	private ModelFacade mf;
	private Properties conf;

	public Controller() {
		FileHandler.checkDataFolder();
		FileHandler.checkConfigFolder();
		conf = FileHandler.loadProperties("config/appconfig.properties");
	}

	public void showEmpleadoMenu() {
		empleadoloop: while (true) {

			con.printNewLine("Menú empleado");
			con.printNewLine("1) agregar\n2) eliminar\n3) actualizar\n4) mostrar todo\n5) volver");
			int op = con.readInt();
			switch (op) {
			case 1:
				try {
					con.printNewLine("---- creando nuevo empleado ----");
					con.printSameLine("Numero de cedula:");
					long cedula = con.readLong();
					con.printSameLine("Nombre completo:");
					con.burnLine();
					String nombre = con.readLine();
					con.printSameLine("Fecha de nacimiento (dd/mm/aaaa):");
					SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
					String date = con.readLine();
					Date nacimiento;
					nacimiento = sdf2.parse(date);
					con.printSameLine("Correo electronico:");
					String correo = con.readLine();
					ExceptionChecker.checkEmail(correo);
					con.printSameLine("Tipo de contrato:");
					String contrato = con.readLine();
					con.printSameLine("Horas de trabajo:");
					int horas = con.readInt();
					mf.getEmpleadoDAO().create(new EmpleadoDTO(cedula, nombre, nacimiento, correo, contrato, horas));
					con.printNewLine("Empleado creado con exito");
				} catch (ParseException e) {
					con.printNewLine("El formato de fecha debe ser dd/MM/aaaa");
					// e.printStackTrace();
				} catch (EmailNotValidException e) {
					con.printNewLine("El formato del correo electronico no es valido");
					// e.printStackTrace();
				}
				break;
			case 2:
				con.printNewLine("inserte la posición del empleado a eliminar");
				int index = con.readInt();
				con.printNewLine(mf.getEmpleadoDAO().delete(index));

				break;
			case 3:
				con.printNewLine("Cual es la posición del empleado?");
				int indexExistente = con.readInt();
				if (mf.getEmpleadoDAO().checkIndex(indexExistente).equals("g")) {
					try {
						con.printNewLine("---- actualizando empleado existente ----");
						con.printSameLine("Numero de cedula:");
						long newCedula = con.readLong();
						con.printSameLine("Nombre completo:");
						con.burnLine();
						String newNombre = con.readLine();
						con.printSameLine("Fecha de nacimiento (dd/mm/aaaa):");
						String newDate = con.readLine();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date newNacimiento;
						newNacimiento = sdf.parse(newDate);
						con.printSameLine("Correo electronico:");
						String newCorreo = con.readLine();
						ExceptionChecker.checkEmail(newCorreo);
						con.printSameLine("Tipo de contrato:");
						String newContrato = con.readLine();
						con.printSameLine("Horas de trabajo:");
						int newHoras = con.readInt();
						mf.getEmpleadoDAO().update(indexExistente,
								new EmpleadoDTO(newCedula, newNombre, newNacimiento, newCorreo, newContrato, newHoras));
						con.printNewLine("Empleado actualizado con exito");
					} catch (ParseException e) {
						con.printNewLine("El formato de fecha debe ser dd/MM/aaaa");
						// e.printStackTrace();
					} catch (EmailNotValidException e) {
						con.printNewLine("El formato del correo electronico no es valido");
						// e.printStackTrace();
					}
				} else {
					con.printNewLine("La posición no existe");
				}
				break;
			case 4:
				con.printNewLine("-------- Lista de todos los empleados -------\n");
				con.printNewLine(mf.getEmpleadoDAO().readAll());
				break;
			case 5:
				break empleadoloop;
			}
		}
	}

	public void showDepartamentoMenu() {
		departamentoloop: while (true) {

			con.printNewLine("Menú departamento");
			con.printSameLine("1) agregar\n2) eliminar\n3) actualizar\n4) mostrar todo\n");
			con.printNewLine(
					"5) agregar empleado a departamento\n6) eliminar empleado a departamento\n7) actualizar empleado a departamento\n8) mostrar empleados de departamento\n9) volver");
			int op = con.readInt();
			switch (op) {
			case 1:
				con.printNewLine("---- creando nuevo departamento ----");
				con.printSameLine("Nombre del departamento:");
				con.burnLine();
				String nombreDep = con.readLine();
				con.printSameLine("Multiplicador de salario:");
				double multiplicador = con.readDouble();
				mf.getDepartamentoDAO().create(new DepartamentoDTO(nombreDep, multiplicador));
				con.printNewLine("Departamento creado con exito");

				break;
			case 2:
				con.printNewLine("inserte la posición del departamento a eliminar");
				int index = con.readInt();
				con.printNewLine(mf.getDepartamentoDAO().delete(index));

				break;
			case 3:
				con.printNewLine("Cual es la posición del departamento?");
				int indexExistente = con.readInt();
				if (mf.getDepartamentoDAO().checkIndex(indexExistente).equals("g")) {
					con.printNewLine("---- Actualizando departamento existente ----");
					con.printSameLine("Nombre del departamento:");
					con.burnLine();
					String newNombreDep = con.readLine();
					con.printSameLine("Multiplicador de salario:");
					double newMultiplicador = con.readDouble();
					// cambio el nombre y multiplicador pero conservo los empleados, no quiero
					// volver a llenarlos
					DepartamentoDTO updated = mf.getDepartamentoDAO().getListaDepartamentos().get(indexExistente);
					updated.setNombreDepartamento(newNombreDep);
					updated.setMultiplicadorSalario(newMultiplicador);
					mf.getDepartamentoDAO().update(indexExistente, updated);
					con.printNewLine("Departamento creado con exito");
				} else {
					con.printNewLine("La posición no existe");
				}
				break;
			case 4:
				con.printNewLine("-------- Lista de todos los departamentos -------");
				con.printNewLine(mf.getDepartamentoDAO().readAll());
				break;
			case 5:
				con.printNewLine("-------- Agregando empleado a departamento -------");
				con.printNewLine("1) agregar el ultimo empleado 2) agregar un empleado especifico");
				int opAddEmpleado = con.readInt();
				EmpleadoDTO temp = null;
				if (opAddEmpleado == 1) {
					temp = mf.getEmpleadoDAO().getLast();
				} else {
					con.printSameLine("Indice del empleado en lista de empleados: ");
					int indexExistenteEnEmpleado = con.readInt();
					temp = mf.getEmpleadoDAO().getListaEmpleados().get(indexExistenteEnEmpleado);
				}
				con.printSameLine("indice del departamento");
				int depIndex = con.readInt();
				if (mf.getDepartamentoDAO().checkIndex(depIndex).equals("g")) {
					mf.getDepartamentoDAO().addEmpleadoToDepartamento(depIndex, temp);
				} else {
					con.printNewLine("El indice del departamento no es valido");
				}
				break;
			case 6:
				con.printNewLine("--------Eliminando empleado a departamento -------");
				con.printSameLine("indice del departamento: ");
				int indexDep = con.readInt();
				if (!mf.getDepartamentoDAO().checkIndex(indexDep).equals("g")) {
					con.printNewLine("El indice del departamento no existe");
					break;
				}
				con.printSameLine("indice del empleado dentro del departamento: ");
				int indexEmp = con.readInt();
				if (indexEmp < 0 || indexEmp >= mf.getDepartamentoDAO().getListaDepartamentos().get(indexDep)
						.getListaEmpleados().size()) {
					con.printNewLine("El indice del empleado dentro del departamento no existe");
					break;
				}
				mf.getDepartamentoDAO().getListaDepartamentos().get(indexDep).getListaEmpleados().remove(indexEmp);
				con.printNewLine("empleado del departamento eliminado con exito");
				break;
			case 7:
				con.printNewLine("--------Actualizando empleado a departamento -------");
				con.printSameLine("indice del departamento: ");

				int indexDepUpdate = con.readInt();
				if (!mf.getDepartamentoDAO().checkIndex(indexDepUpdate).equals("g")) {
					con.printNewLine("El indice del departamento no existe");
					break;
				}

				con.printSameLine("indice del empleado dentro del departamento: ");
				int indexEmpUpdate = con.readInt();
				if (indexEmpUpdate < 0 || indexEmpUpdate >= mf.getDepartamentoDAO().getListaDepartamentos()
						.get(indexDepUpdate).getListaEmpleados().size()) {
					con.printNewLine("El indice del empleado dentro del departamento no existe");
					break;
				}

				try {
					con.printNewLine("---- actualizando empleado ----");
					con.printSameLine("Numero de cedula:");
					long cedula = con.readLong();
					con.printSameLine("Nombre completo:");
					con.burnLine();
					String nombre = con.readLine();
					con.printSameLine("Fecha de nacimiento (dd/mm/aaaa):");
					SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
					String date = con.readLine();
					Date nacimiento;

					nacimiento = sdf2.parse(date);

					con.printSameLine("Correo electronico:");
					String correo = con.readLine();
					ExceptionChecker.checkEmail(correo);
					con.printSameLine("Tipo de contrato:");
					String contrato = con.readLine();
					con.printSameLine("Horas de trabajo:");
					int horas = con.readInt();
					mf.getDepartamentoDAO().getListaDepartamentos().get(indexDepUpdate).getListaEmpleados()
							.set(indexEmpUpdate, new EmpleadoDTO(cedula, nombre, nacimiento, correo, contrato, horas));
					con.printNewLine("empleado del departamento eliminado con exito");
				} catch (ParseException e) {
					con.printNewLine("El formato de fecha debe ser dd/MM/aaaa");
					// e.printStackTrace();
				} catch (EmailNotValidException e) {
					con.printNewLine("El formato del correo electronico no es valido");
					// e.printStackTrace();
				}

				break;
			case 8:
				con.printNewLine("-------- Lista de empleados de un departamento -------");
				con.printSameLine("indice del departamento: ");

				int indexDepShowEmp = con.readInt();
				if (!mf.getDepartamentoDAO().checkIndex(indexDepShowEmp).equals("g")) {
					con.printNewLine("El indice del departamento no existe");
					break;
				}
				con.printNewLine(mf.getDepartamentoDAO().readAllEmpleadosFromDepartamento(indexDepShowEmp));

				break;

			case 9:
				break departamentoloop;
			}
		}
	}

	public void runInConsole() {
		con = new Consola();
		mf = new ModelFacade();

		mainloop: while (true) {
			con.printNewLine(conf.getProperty("app.saludoempresa"));
			con.printNewLine("1) administrar empleados\n2) administrar departamentos\n3) salir\n");
			int op = con.readInt();
			switch (op) {
			case 1:
				showEmpleadoMenu();
				break;
			case 2:
				showDepartamentoMenu();
				break;
			case 3:
				con.printNewLine("BYE BYE");
				break mainloop;
			}
		}
	}

	public void runInGUI() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		vf.getVp().setTitle(conf.getProperty("mainwindow.titulo"));
		int x = Integer.parseInt(conf.getProperty("mainwindow.posx"));
		int y = Integer.parseInt(conf.getProperty("mainwindow.posy"));
		int ancho = Integer.parseInt(conf.getProperty("mainwindow.ancho"));
		int alto = Integer.parseInt(conf.getProperty("mainwindow.alto"));
		vf.getVp().setBounds(x, y, ancho, alto);
		vf.getVp().setVisible(true);
		
	}

	public void run() {
		if (conf.getProperty("app.modo").equals("consola")) {
			runInConsole();
		} else {
			runInGUI();
		}
	}
}
