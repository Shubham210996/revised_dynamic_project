package in.co.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HeaderCtl")
public class HeaderCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("Operation");
		if (op !=null && op.equalsIgnoreCase("userlogin")) {
			resp.sendRedirect("UserLogin.jsp");
		}
		
		if (op != null && op.equalsIgnoreCase("Logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp");
			rd.forward(req, resp);
		}
		
		if(op.equalsIgnoreCase("about")) {
			RequestDispatcher rd = req.getRequestDispatcher("About.jsp");
			rd.forward(req, resp);
		}
		
		if(op.equalsIgnoreCase("home")) {
			RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
