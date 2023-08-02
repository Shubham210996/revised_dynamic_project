package in.co.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {
	private static JdbcDataSource jds = null;
	private ComboPooledDataSource cpds = null;

	JdbcDataSource() {

		cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/revise");
			cpds.setUser("root");
			cpds.setPassword("root");
			cpds.setInitialPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setMaxPoolSize(50);

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	public static JdbcDataSource getInstance() {
		if(jds == null) {
			jds = new JdbcDataSource();
		}
		return jds;
	}
	
	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		} catch (Exception e) {
			return null;
		}
	}
	
}
