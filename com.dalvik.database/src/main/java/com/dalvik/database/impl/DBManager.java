package com.dalvik.database.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.dalvik.database.exception.DBRegisterationException;

public class DBManager {

	private static DBManager instance;

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	public synchronized void registerDriver(String profileName, String driverClassName)
			throws DBRegisterationException {
		ClassLoader loader = DBManager.class.getClassLoader();
		registerDriver(profileName, driverClassName, loader);
	}

	private synchronized void registerDriver(String profileName, String driverClassName, ClassLoader loader)
			throws DBRegisterationException {
		try {
			Class<?> driverClass = loader.loadClass(driverClassName);
			if (!Driver.class.isAssignableFrom(driverClass)) {
				throw new DBRegisterationException("DBManager.class.is.not.valid.jdbc.driver");
			}
		} catch (ClassNotFoundException e) {
			throw new DBRegisterationException("DBManager.unable.to.register.driver"); //$NON-NLS-1$
		}
	}

	public synchronized DBConnection getConnection(DBConfiguration dbConfig) throws DBRegisterationException {
		Connection connection = getRawConnection(dbConfig);
		if (connection != null) {
			return new DBConnection(connection);
		}
		return null;
	}

	private Connection getRawConnection(DBConfiguration dbConfig) {
		Connection connection = null;
		try {
			connection = connection = DriverManager.getConnection(dbConfig.getUrl() + "/" + dbConfig.getDbName(),
					dbConfig.getUsername(), dbConfig.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
