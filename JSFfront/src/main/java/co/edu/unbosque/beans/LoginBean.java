package co.edu.unbosque.beans;


import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String saludo = "";
	private String nombre = "";
	private String contrase = "";
	
	private String newUsername="";
	private String newPass1="";
	private String newPass2="";
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	// https://mkyong.com/java/how-to-send-http-request-getpost-in-java/

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

	public String getNewUsername() {
		return newUsername;
	}

	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}

	public String getNewPass1() {
		return newPass1;
	}

	public void setNewPass1(String newPass1) {
		this.newPass1 = newPass1;
	}

	public String getNewPass2() {
		return newPass2;
	}

	public void setNewPass2(String newPass2) {
		this.newPass2 = newPass2;
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public void showSticky() {
		FacesContext.getCurrentInstance().addMessage("sticky-key",new FacesMessage(
				FacesMessage.SEVERITY_INFO, 
				"Sticky Message", 
				"Message Content")
		);
	}

	public void validate() {
		showSticky();
	}
	
	public void matchPasswords() {
		
	}
}