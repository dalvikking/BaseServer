package com.dalvik.database.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dalvik.database.api.IDBConnection;
import com.dalvik.database.exception.DBSQLException;

public class DBConnection implements IDBConnection {

	private Connection connection;

	public DBConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void commit() throws DBSQLException {
		try {
			if (!connection.getAutoCommit()) {
				connection.commit();
			} else {
				System.out.println("AutoCommit on set so not doing commit");
			}
		} catch (SQLException sx) {
			throw new DBSQLException("DBConnection.error.executing.commit"); //$NON-NLS-1$
		}
	}

	@Override
	public void close() throws DBSQLException {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException sx) {
			throw new DBSQLException("DBConnection.error.closing.database.connection");
		}
	}

	@Override
	public ResultSet executeQuery(String sql) throws DBSQLException {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			statement.close();
			return resultSet;
		} catch (SQLException sx) {
			throw new DBSQLException("DBConnection.error.executing.sql.query");
		}
	}

	@Override
	public int executeUpdate(String dmlQuery) throws DBSQLException {
		try {
			Statement statement = connection.createStatement();
			int noRows = statement.executeUpdate(dmlQuery);
			statement.close();
			return noRows;
		} catch (SQLException sx) {
			throw new DBSQLException("DBConnection.error.executing.update");
		}
	}

	@Override
	public Connection getRawConnection() throws DBSQLException {
		if (connection == null) {
			throw new DBSQLException("Underlying connection is null");
		}
		return connection;
	}
}
