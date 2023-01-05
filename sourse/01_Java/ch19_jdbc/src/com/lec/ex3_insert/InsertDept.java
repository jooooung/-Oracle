package com.lec.ex3_insert;
// �μ� ���� �Է��ϱ�
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//����ڿ��� �μ���ȣ �μ��� �ٹ����� �Է¹޾� insert
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement  stmt = null;
		System.out.println("�Է��� �μ���ȣ�� ? ");
		int deptno = scanner.nextInt();
		System.out.println("�Է��� �μ����� ? ");
		String dname = scanner.next();
		System.out.println("�Է��� �μ� ��ġ�� ? ");
		String loc = scanner.next();
		String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"', '"+loc+"')";
		sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);	//insert update delete
			System.out.println(result>0 ? "�Է¼���" : "�Է½���");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("�ߺ��� �μ���ȣ�̰ų� ��� �Է��� ���" +e.getMessage());
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
