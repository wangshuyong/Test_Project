package com.wangsy.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
	static String driver = "com.mysql.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost:3306/samp_db";
	static String username = "root";
	static String password = "";
	private static  Connection getConn() {
		
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(DB_URL, username,
					password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
		public Connection initialValue() {
			Connection conn=null;
			try {
				conn= DriverManager.getConnection(DB_URL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
	};

	public static Connection getConnection() {
		return connectionHolder.get();
	}

	private static int delete(String sql) {
		Connection conn = getConn();
		int i = 0;
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			System.out.println("resutl: " + i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
