package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JdbcDataSource;
import in.co.rays.util.JdbcDataSourceBundle;

public class UserModel {

	public UserBean authenticate(String loginId, String password) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/revise", "root", "root");

		Connection con = JdbcDataSourceBundle.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from userdata where loginId = ? and password = ?");

		ps.setString(1, loginId);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setNo(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLoginId(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setConfirmPass(rs.getString(5));
			bean.setContact(rs.getString(6));

		}
		return bean;
	}

	public void insertMethod(UserBean bean) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/revise", "root", "root");

		Connection con = JdbcDataSourceBundle.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into userdata values(?,?,?,?,?,?)");

		ps.setInt(1, nextPk());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getConfirmPass());
		ps.setString(6, bean.getContact());

		int i = ps.executeUpdate();
		System.out.println(i + " Data Inserted Successfully");

	}

	public Integer nextPk() throws Exception {
		int pk = 0;
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/revise", "root", "root");

		Connection con = JdbcDataSourceBundle.getConnection();
		PreparedStatement ps = con.prepareStatement("select max(no) from userdata");

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1) + 1;
		}
		return pk;
	}

	public void updateMethod(UserBean bean) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/revise", "root", "root");

		Connection con = JdbcDataSourceBundle.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"update userdata set name = ?, loginId = ?, password = ?, confirmPass = ?, contact = ? where no = ?");

		ps.setString(1, bean.getName());
		ps.setString(2, bean.getLoginId());
		ps.setString(3, bean.getPassword());
		ps.setString(4, bean.getConfirmPass());
		ps.setString(5, bean.getContact());
		ps.setInt(6, bean.getNo());

		int i = ps.executeUpdate();
		System.out.println(i + " Data Updated Successfully");
	}

	public List searchListMethod() throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/revise", "root", "root");

		Connection con = JdbcDataSourceBundle.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from userdata");
		ResultSet rs = ps.executeQuery();
		ArrayList list = new ArrayList();
		while (rs.next()) {
			UserBean bean = new UserBean();
			bean.setNo(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLoginId(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setConfirmPass(rs.getString(5));
			bean.setContact(rs.getString(6));
			list.add(bean);
		}

		return list;
	}

	public UserBean beanById(int idNumber) throws Exception { // beanById and findByPK are same Methods.
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/revise", "root", "root");

		Connection con = JdbcDataSourceBundle.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from userdata where no = ?");
		ps.setInt(1, idNumber);
		ResultSet rs = ps.executeQuery();
		UserBean bean = new UserBean();
		while (rs.next()) {
			bean.setNo(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLoginId(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setConfirmPass(rs.getString(5));
			bean.setContact(rs.getString(6));
		}

		return bean;
	}

	public void deleteMethod(int idNumber) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/revise","root","root");
		int maxNum = nextPk();
		Connection con = JdbcDataSourceBundle.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from userdata where no = ?");
		ps.setInt(1, idNumber);
		int i = ps.executeUpdate();
		System.out.println(i + " Data deleted Successfully");
		for (int no = idNumber; no <= maxNum; no++) {
			if (beanById(no + 1) != null) {
				UserBean bean = beanById((no + 1));
				updatePk(bean, no);
			}
		}
	}

	public void updatePk(UserBean bean, int no) throws Exception {
		int num = no;
		Connection con = JdbcDataSourceBundle.getConnection();
		PreparedStatement ps = con.prepareStatement("update userdata set no = ? where no = ?");
		ps.setInt(1, (num));
		ps.setInt(2, bean.getNo());
		int i = ps.executeUpdate();
		System.out.println(i + " Pk updated");
	}

}
