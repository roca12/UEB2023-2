package co.edu.unbosque.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import co.edu.unbosque.model.AlphanumericStringDTO;
import co.edu.unbosque.model.persistance.AlphanumericStringDAO;

public class CountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CountServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int cont = 0;
		for (AlphanumericStringDTO u : AlphanumericStringDAO.stringsList) {
			cont += u.getNumbers();
		}
		out.write(cont+"");

		out.close();

	}

}
