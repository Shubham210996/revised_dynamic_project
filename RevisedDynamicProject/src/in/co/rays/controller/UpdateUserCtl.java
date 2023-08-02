package in.co.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet({"/UpdateUserCtl"})
public class UpdateUserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("no");
		String name = req.getParameter("name");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String confirmPass = req.getParameter("confirmPass");
		String contact = req.getParameter("contact");

		String op = req.getParameter("Operation");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setNo(Integer.parseInt(no));
		bean.setName(name);
		bean.setLoginId(loginId);
		bean.setPassword(password);
		bean.setConfirmPass(confirmPass);
		bean.setContact(contact);

		if (op.equalsIgnoreCase("Update")) {

			try {
				model.updateMethod(bean);
				List list = model.searchListMethod();
				req.setAttribute("list", list);
				req.setAttribute("updateMessage", "Data Updated Successfully");
				RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
				rd.forward(req, resp);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(op.equalsIgnoreCase("Delete")) {
			try {
				model.deleteMethod(Integer.parseInt(no));
				List list = model.searchListMethod();
				req.setAttribute("list", list);
				req.setAttribute("deleteMessage", "Data Deleted Successfully");
				RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
