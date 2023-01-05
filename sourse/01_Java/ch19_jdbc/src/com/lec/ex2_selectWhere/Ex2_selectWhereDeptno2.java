package com.lec.ex2_selectWhere;
//����ڿ��� ���ϴ� �μ���ȣ�� �޾� �μ������� ���, �ش� ������ ��������� ���

// 1. �ش�μ���ȣ�� ���� ��� : �������� �ʴ� �μ��Դϴ� 
// 2. �ش�μ���ȣ�� �ִ� ��� : �μ� ���� ���
// 2-1. �ش�μ� ����� �ִ� ��� : ��� ���� ���(���, �̸�, �޿�, ����̸�)
// 2-2. �ش�μ� ����� ���� ��� : �ش� �μ� ����� �����ϴ�

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ϴ� �μ���ȣ�� ? ");
		int deptno = scanner.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER\r\n" + "    FROM EMP W, EMP M \r\n"
				+ "    WHERE W.MGR=M.EMPNO AND W.DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println(deptno + "�� �μ������� ������ �����ϴ�");

				System.out.println("�μ���  : " + rs.getString("dname"));
				System.out.println("��ġ   : " + rs.getString("loc"));
				System.out.println();
				rs2 = stmt.executeQuery(sql2);
				if (rs2.next()) {
					do {
						String empno = rs2.getString("empno");
						String ename = rs2.getString("ename");
						int sal = rs2.getInt("sal");
						String manager = rs2.getString("manager");
						System.out.println("-" + ename);
						System.out.println("��� : " + empno);
						System.out.println("�̸� : " + ename);
						System.out.println("�޿� : " + sal);
						System.out.println("����̸� : " + manager);
						System.out.println();
					} while (rs2.next());
				} else {
					System.out.println("�ش� �μ��� ����� 0��");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs2 != null)
					rs2.close();
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
