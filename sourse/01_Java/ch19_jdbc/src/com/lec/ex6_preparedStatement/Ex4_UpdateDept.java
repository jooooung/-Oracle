package com.lec.ex6_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//������ �μ���ȣ�� �޾� �����ϴ� �μ���ȣ�� ����, �������� ������ �������� �ʴ´�
public class Ex4_UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "SELECT * FROM DEPT WHERE DEPTNO=?";
		String updateQuery = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectQuery);
			System.out.print("������ �μ���ȣ�� ? ");
			int deptno = scanner.nextInt();
			pstmt.setInt(1, deptno); // ? ä���
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.print("������ �μ����� ? ");
				String dname = scanner.next();
				System.out.print("������ ��ġ�� ? ");
				String loc = scanner.next();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(updateQuery);
				pstmt.setString(1, "dname");
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				if (result > 0) {
					System.out.println("��������");
				}
			} else {
				System.out.println("�������� �ʴ� �μ���ȣ�Դϴ�");
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
