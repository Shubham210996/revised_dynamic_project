package in.co.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String Op = req.getParameter("Operation");
		String uri = req.getParameter("uri");
		UserModel model = new UserModel();
		if (Op.equalsIgnoreCase("Login")) {
			try {
				UserBean bean = model.authenticate(loginId, password);
				if (bean != null) {
					System.out.println("User valid");
					HttpSession session = req.getSession();
					session.setAttribute("name", bean.getName());
					if (uri.equalsIgnoreCase("null")) {
						RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
						rd.forward(req, resp);
					} else {
						resp.sendRedirect(uri);
					}
				} else {
					System.out.println("User Invalid");
					req.setAttribute("invalidMessage", "Invalid Login ID or Password");
					RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp");
					rd.forward(req, resp);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (Op.equalsIgnoreCase("Sign up")) {
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");
			rd.forward(req, resp);
		}
	}
}
