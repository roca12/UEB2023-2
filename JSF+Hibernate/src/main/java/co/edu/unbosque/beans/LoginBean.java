package co.edu.unbosque.beans;

import co.edu.unbosque.model.User;
import co.edu.unbosque.model.persistence.UserDAO;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String saludo = "";
	private String nombre = "";
	private String contrase = "";
//	private String nombreComprobar = "admin";
//	private String contraComprobar = "1234";
	private UserDAO udao;

	public LoginBean() {
		udao = new UserDAO();
	}

	public String getContrase() {
		return contrase;
	}

	public void setContrase(String contrase) {
		this.contrase = contrase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public void validate() {

		for (User u : udao.findAll()) {
			if (nombre.equalsIgnoreCase(u.getUsername()) && contrase.equalsIgnoreCase(u.getPasskey())) {
				saludo = "Hola " + nombre + " su contraseña es " + contrase;
			} else {
				saludo = "Usted no esta registrado";
			}
		}
	}
}
