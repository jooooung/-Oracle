package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String fn, sql;
		ArrayList<String> jobs = new ArrayList<String>();
		try {
			sql = "SELECT JNAME FROM JOB";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				jobs.add(rs.getString("jname"));
			}
		} catch (Exception e) {
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
		
		do {
			System.out.print("1:�Է� || 2:��������ȸ || 3:��ü��ȸ || �׿�:����");
			fn = sc.next();
			switch (fn) {
			case "1": // �̸�, ������(jobs), ��,��, �� �޾� insert
				sql = "INSERT INTO PERSON " + 
						"    VALUES (pNO_SEQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ?)";
				try {
					// 1�ܰ� ����̹��ε�� �ѹ��� �ϸ� ��(������ ����)
					// 2~6�ܰ�
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.print("�̸� : ");
					String pname = sc.next();
					System.out.print("����"+jobs+" : ");
					String jname = sc.next();
					System.out.print("���� : ");
					int kor = sc.nextInt();
					System.out.print("���� : ");
					String eng = sc.next();
					System.out.print("���� : ");
					int mat = sc.nextInt();
					pstmt.setString(1, pname);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setString(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "�Է¼���":"����");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					// 7�ܰ� close
					try {
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "2": // ������޾� ���� ���
				sql = "SELECT ROWNUM RN, A.* "
						+ "    FROM (SELECT pNAME||'('||pNO||'��)' pNO, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) SUM "
						+ "            FROM PERSON P, JOB J WHERE P.jNO=J.jNO AND jNAME=? ORDER BY SUM DESC) A";
				try {
					// 2~6�ܰ�
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.print("��ȸ�� ������ ? ");
					System.out.print(jobs);
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					pstmt.setString(1, "jname");
					if (rs.next()) {
						System.out.println("���\t�̸�\t\t����\t����\t����\t����\t����");
						do {
							int rn = rs.getInt("rn");
							String pno = rs.getString("pno");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%d\n", rn, pno, jname, kor, eng, mat, sum);
						} while (rs.next());
					} else {
						System.out.println("�ش� ������ �����ϴ�.");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					// 7�ܰ� close
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
				break;
			case "3":
				sql = "SELECT ROWNUM RN, A.* "
						+ "    FROM (SELECT pNAME||'('||pNO||'��)' pNO, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) SUM "
						+ "            FROM PERSON P, JOB J WHERE P.jNO=J.jNO ORDER BY SUM DESC) A";
				try {
					// 2~6�ܰ�
					// 2~6�ܰ�
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						System.out.println("���\t�̸�\t     ����\t����\t����\t����\t����");
						do {
							int rn = rs.getInt("rn");
							String pno = rs.getString("pno");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.printf("%d\t%s  %s\t%d\t%d\t%d\t%d\n", rn, pno, jname, kor, eng, mat, sum);
						} while (rs.next());
					} else {
						System.out.println("��ϵ� ����� �����ϴ�.");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					// 7�ܰ� close
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
				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}
