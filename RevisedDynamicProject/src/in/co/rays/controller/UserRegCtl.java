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

@WebServlet("/UserRegCtl")
public class UserRegCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String confirmPass = req.getParameter("confirmPass");
		String contact = req.getParameter("contact");
		String Op = req.getParameter("Operation");

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setName(name);
		bean.setLoginId(loginId);
		bean.setPassword(password);
		bean.setConfirmPass(confirmPass);
		bean.setContact(contact);

		try {
			model.insertMethod(bean);
			HttpSession session = req.getSession();
			session.setAttribute("name", bean.getName());
			RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		System.out.println(name);
//		System.out.println(loginId);
//		System.out.println(password);
//		System.out.println(confirmPass);
//		System.out.println(contact);
	}

}
