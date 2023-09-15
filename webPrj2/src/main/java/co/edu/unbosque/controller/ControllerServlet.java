package co.edu.unbosque.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import co.edu.unbosque.model.User;
import co.edu.unbosque.model.persistance.UserDAO;

public class ControllerServlet extends HttpServlet {

	private UserDAO uDao;

	private static final long serialVersionUID = 1L;

	public ControllerServlet() {
		super();
		uDao = new UserDAO();

	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		for (User u : uDao.getUserList()) {
			out.write(u.toString());
		}
		
		
		out.close();

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		System.out.println(name);
		System.out.println(password);
		log(name);
		log(password);
		
		User temp = new User();
		temp.setName(name);
		temp.setPassword(password);
		
		request.setAttribute("user", temp);

		boolean status = uDao.validate(temp);
		if (status) {
			RequestDispatcher rd = request.getRequestDispatcher("login-success.jsp");
			
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
		}

	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(req, resp);
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(req, resp);
	}
	
	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(req, resp);
	}
	
	
	
	

}
