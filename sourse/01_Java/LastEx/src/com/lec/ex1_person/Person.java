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
			while(rs.next()) {
				jobs.add(rs.getString("jname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(jobs);
		do {
			System.out.print("1:�Է� || 2:��������ȸ || 3:��ü��ȸ || �׿�:����");
			fn = sc.next();
			switch(fn) {
			case "1" : // �̸�, ������(jobs), ��,��, �� �޾� insert
				sql = "INSERT INTO PERSON " + 
						"    VALUES (PNO_SQN.NEXTVAL, ?, "
						+ "(SELECT JNO FROM JOB WHERE JNAME=?), " + 
						"            ?, ?, ?)";
				try {
					// 1�ܰ� ����̹��ε�� �ѹ��� �ϸ� ��(������ ����)
					// 2~6�ܰ�
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.print("�̸� : ");
					String pname = sc.next();
					System.out.print("���� : ");
					String jname = sc.next();
					System.out.print("���� : ");
					int kor = sc.nextInt();
					System.out.print("���� : ");
					int eng = sc.nextInt();
					System.out.print("���� : ");
					int mat = sc.nextInt();
					pstmt.setString(1, "pname");
					pstmt.setString(2, "jname");
					pstmt.setString(3, "kor");
					pstmt.setString(4, "eng");
					pstmt.setString(5, "mat");
					rs = pstmt.executeQuery();
					rs.next();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					// 7�ܰ� close
					try {
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "2": // ������޾� ���� ���
				sql = "";
				try {
					// 2~6�ܰ�
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					// 7�ܰ� close
				}
				break;
			case "3":
				sql = "";
				try {
					// 2~6�ܰ�
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					// 7�ܰ� close
				}
				break;
			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}
