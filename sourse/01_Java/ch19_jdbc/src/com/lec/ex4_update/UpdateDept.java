package com.lec.ex4_update;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//����ڿ��� ������ �μ���ȣ�� �μ���, �ٹ����� �Է¹޾� update
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement  stmt = null;
		System.out.print("������ �μ���ȣ�� ? ");
		int deptno = scanner.nextInt();
		System.out.print("������ �μ����� ? ");
		String dname = scanner.next();
		System.out.print("������ ��ġ�� ? ");
		String loc = scanner.next();
		String updateQuery = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d", dname, loc, deptno);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(updateQuery);	//insert update delete�� executeUpdate
			System.out.println(result>0? deptno+"�� �μ����� ��������" : "�ش� �μ��� �����ϴ�");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
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
