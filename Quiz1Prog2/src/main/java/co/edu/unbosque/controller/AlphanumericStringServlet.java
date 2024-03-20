package co.edu.unbosque.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import co.edu.unbosque.model.AlphanumericStringDTO;
import co.edu.unbosque.model.persistance.AlphanumericStringDAO;

public class AlphanumericStringServlet extends HttpServlet {

	

	private static final long serialVersionUID = 1L;

	public AlphanumericStringServlet() {
		super();
		

	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<table>\n"
				+ "  <tr>\n"
				+ "    <th>Texto</th>\n"
				+ "    <th>letras</th>\n"
				+ "    <th>numeros</th>\n"
				+ "    <th>simbolos</th>\n"
				+ "    <th>espacios</th>\n"
				+ "  </tr>");
		for (AlphanumericStringDTO u : AlphanumericStringDAO.stringsList) {
			out.println("  <tr>\n"
					+ "    <td>"+u.getText()+"</td>\n"
					+ "    <td>"+u.getLetters()+"</td>\n"
					+ "    <td>"+u.getNumbers()+"</td>\n"
					+ "    <td>"+u.getSymbols()+"</td>\n"
					+ "    <td>"+u.getSpaces()+"</td>\n"
					+ "  </tr>");
		}
		out.write("</table>");
		
		out.close();

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String texto = request.getParameter("texto");
		System.out.println(texto);
		
		AlphanumericStringDTO newString = new AlphanumericStringDTO();
		newString.setText(texto);
		newString.setNumbers(countNumbers(texto));
		newString.setLetters(countLetters(texto));
		newString.setSpaces(countSpaces(texto));
		newString.setSymbols(countSymbols(texto));
		AlphanumericStringDAO.createNew(newString);
		PrintWriter out = response.getWriter();
		out.println("Dato creado y verificado con exito");
		out.println("<a href=\"index.jsp\">volver</a>");
		


	}
	
	public int countLetters(String text) {
		int cont=0;
		for (char c : text.toCharArray()) {
			if (Character.isLetter(c)) {
				cont++;
			}
		}
		return cont;
	}
	public int countNumbers(String text) {
		int cont=0;
		for (char c : text.toCharArray()) {
			if (Character.isDigit(c)) {
				cont++;
			}
		}
		return cont;
	}
	public int countSpaces(String text) {
		int cont=0;
		for (char c : text.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				cont++;
			}
		}
		return cont;
	}
	public int countSymbols(String text) {
		int cont=0;
		for (char c : text.toCharArray()) {
			if (!Character.isLetter(c)&&!Character.isDigit(c)&&!Character.isSpaceChar(c)) {
				cont++;
			}
		}
		return cont;
	}

}
