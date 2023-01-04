package com.lec.ex0_Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySql {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		Connection conn = null;
		// JDBC���α׷��� �ܰ�� ��� Ŭ����

		try {
			Class.forName(driver); // 1. ����̹� �ε�
			System.out.println("����̹� ���� ����");
			conn = DriverManager.getConnection(url, "root", "mysql"); // 2. DB���ᰴü
			System.out.println("MYSQL ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ���� : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
