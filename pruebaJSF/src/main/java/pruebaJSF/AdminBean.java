package pruebaJSF;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;

@ManagedBean
@RequestScoped
public class AdminBean {
	private String saludo = "Hola ";
	private String nombre = "";
	private String contrase = "";
	private String nombreComprobar = "Valeria";
	private String contraComprobar = "12345";

	
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

	public void saludar() {
		if (nombre.equalsIgnoreCase(nombreComprobar) && contrase.equalsIgnoreCase(contraComprobar)) {
			saludo = saludo + " " + nombre + " su contrase�a es " + contrase;
		} else {
			saludo = "Usted no esta registrado";
		}

	}
}
