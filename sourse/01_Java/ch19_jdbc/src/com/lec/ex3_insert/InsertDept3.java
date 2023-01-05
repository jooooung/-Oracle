package com.lec.ex3_insert;
//�Է¹��� �μ���ȣ�� �ߺ��� �μ���ȣ�� ��� �Է¹ޱ�

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			while (true) {
				System.out.println("�Է��� �μ���ȣ�� ? ");
				int deptno = scanner.nextInt();
				// �ߺ�üũ
				String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" + deptno;
				rs = stmt.executeQuery(selectQuery);
				rs.next();
				int cnt = rs.getInt("cnt"); // cnt�� �˻��� deptno�� ���� ��
				if (cnt != 0) { // ���� cnt�� 0�� �ƴϸ� deptno�� ����
					System.out.println("�ߺ��� �μ���ȣ�Դϴ�");
				} else {
					System.out.println("�Է��� �μ����� ? ");
					String dname = scanner.next();
					System.out.println("�Է��� �μ� ��ġ�� ? ");
					String loc = scanner.next();
					String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
					int result = stmt.executeUpdate(sql); // insert update delete
					System.out.println(result > 0 ? "�Է¼���" : "�Է½���");
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
