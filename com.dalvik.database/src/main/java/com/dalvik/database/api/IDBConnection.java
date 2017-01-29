package com.dalvik.database.api;

import java.sql.Connection;
import java.sql.ResultSet;

import com.dalvik.database.exception.DBSQLException;

public interface IDBConnection {
	public Connection getRawConnection() throws DBSQLException;

	public void commit() throws DBSQLException;

	public void close() throws DBSQLException;

	public ResultSet executeQuery(String sql) throws DBSQLException;

	public int executeUpdate(String dmlQuery) throws DBSQLException;

}
