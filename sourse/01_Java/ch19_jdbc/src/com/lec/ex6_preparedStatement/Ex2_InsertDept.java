package com.lec.ex6_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//�Է¹��� �μ���ȣ �ߺ� üũ �� �μ��� �ٹ����� �Է¹޾� insert
public class Ex2_InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String insertQurey = "INSERT INTO DEPT VALUES (?, ?, ?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectQuery);
			System.out.println("�Է��� �μ���ȣ�� ? ");
			int deptno = scanner.nextInt();
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt("cnt");	//cnt�� �˻��� deptno�� ���� ��
			if (cnt != 0) {	//���� cnt�� 0�� �ƴϸ� deptno�� ����
				System.out.println("�ߺ��� �μ���ȣ�Դϴ�");
			} else {
				System.out.println("�Է��� �μ����� ? ");
				String dname = scanner.next();
				System.out.println("�Է��� �μ� ��ġ�� ? ");
				String loc = scanner.next();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(insertQurey);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				int result = pstmt.executeUpdate(); // insert update delete
				System.out.println(result > 0 ? "�Է¼���" : "�Է½���");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
