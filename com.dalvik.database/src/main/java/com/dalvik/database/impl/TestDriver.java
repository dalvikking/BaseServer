package com.dalvik.database.impl;

import com.dalvik.database.exception.DBRegisterationException;

public class TestDriver {

	public static void main(String args[]) {

		System.out.println("-------- PostgreSQL " + "JDBC Connection Testing ------------");

		try {
			DBManager.getInstance().registerDriver("postgres", "org.postgresql.Driver");
		} catch (DBRegisterationException e1) {
			e1.printStackTrace();
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		DBConnection connection = null;

		DBConfiguration conf = new DBConfiguration();
		conf.setDbName("ecommerce");
		conf.setPassword("");
		conf.setUsername("postgres");
		conf.setUrl("jdbc:postgresql://127.0.0.1:5432");

		try {
			connection = DBManager.getInstance().getConnection(conf);
		} catch (DBRegisterationException e) {
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
