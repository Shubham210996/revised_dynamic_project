package in.co.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSourceBundle {
	private static JdbcDataSourceBundle jds = null;
	private ComboPooledDataSource cpds = null;

	public JdbcDataSourceBundle() {
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");
		cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass(rb.getString("driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("user"));
			cpds.setPassword(rb.getString("password"));
			cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialPoolSize")));
			cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
			cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxPoolSize")));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static JdbcDataSourceBundle getInstance() {
		if (jds == null) {
			jds = new JdbcDataSourceBundle();
		}
		return jds;
	}

	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
