package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {

	private static final String DB_URL = "jdbc:mariadb://localhost/maven";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	private Connection conn;
	public JDBCConfiguration() {
		try {
			initConnect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initConnect() throws ClassNotFoundException {

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        try {
			setConn(DriverManager.getConnection(
					DB_URL, DB_USER, DB_PASSWORD));
			System.out.println("Connected database successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
