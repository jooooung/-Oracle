package com.lec.ex1_selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";	// thin:����Ŭ ����, 1521 : ����Ŭ ��Ʈ, xe:����Ŭ ����
		String sql = "SELECT * FROM EMP";
		Connection conn = null;	// db ���� ��ü
		Statement  stmt = null;	// sql ������ ��ü
		ResultSet  rs 	= null;	// select ���� ����� ���� ��ü
		try {
			Class.forName(driver);	//1
			conn = DriverManager.getConnection(url, "scott", "tiger");  //2
			stmt = conn.createStatement();	// 3
			rs	 = stmt.executeQuery(sql);	// 4, 5
			if(rs.next()) {	//select ����� 1�� �̻�
				System.out.println("���\t�̸�\t��å\t�����\t�Ի���\t�޿�\t��\t�μ���ȣ");
				do {
					int empno = rs.getInt(1);
					String ename = rs.getString("ename");
					String job	 = rs.getString("job");
					String mgr	 = rs.getString("mgr");
					//String hiredate = rs.getString("hiredate");
					Date	 hiredate = rs.getDate("hiredate");	// Date : �ð� ������
					Timestamp hiredate1 = rs.getTimestamp("hiredate");	//Timestamp : �ð� ����
					int 	  sal		= rs.getInt("sal");
					int		  comm		= rs.getInt("comm");
					int		  deptno	= rs.getInt("deptno");
					System.out.printf("%d\t %s\t %s\t %s\t %TF %d\t %d\t %d\n", empno, ename, job, mgr, hiredate, sal, comm, deptno);
				} while(rs.next());
			} else {	// select ����� 1�൵ ����
				System.out.println("��ϵ� ��� ������ �����ϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null)   rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
