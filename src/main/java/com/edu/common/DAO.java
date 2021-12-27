package com.edu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	private String jdbc_url;
	private String username;
	private String password;

	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "hr";

		try {

			conn = DriverManager.getConnection(jdbc_url, username, password);
			System.out.println("연결 성공!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
	}
}
