package com.lec.ex3_supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;
	// dao�� �̱������� ���� / private �����ڿ��� driver�ε�
	private static CustomerDao INSTANCE =  new CustomerDao();	// �̱���
	
	public static CustomerDao getInstance() {
		return INSTANCE;
	}
	private CustomerDao() {	// ������ �Լ�(driver �ε�
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1.ȸ������ : public int insertCustomer(String ctel, String cname)
	public int insertCustomer(String ctel, String cname) {
		int result = FAIL;
		Connection 		  conn 	= null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME) " + 
				"    VALUES (CUSTOMER_CID_SQ.NEXTVAL, ?, ?)";
		try {
			conn  = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			result = pstmt.executeUpdate();	// update�� ������ query�� result��
//			System.out.println(result==SUCCESS? "ȸ������ ����":"ȸ������ ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 2.�� ��4�ڸ� �˻� : public ArrayList<CustomerDto> ctelGetCustomers(String searchTel)
	public ArrayList<CustomerDto> ctelGetCustomers(String searchTel){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>(); 
		Connection 		  conn 	= null;
		PreparedStatement pstmt = null;
		ResultSet 		  rs	= null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) LEVELUP" + 
				"    FROM CUSTOMER C, LEVELS L" + 
				"    WHERE C.LEVELNO=L.LEVELNO AND CTEL LIKE '%'||? " + 
				"    ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, searchTel);
			rs	 = pstmt.executeQuery();
			while(rs.next()) {
				int cid 		 = rs.getInt("cid");
				String ctel 	 = rs.getString("ctel");
				String cname 	 = rs.getString("cname");
				int cpoint 		 = rs.getInt("cpoint");
				int camount 	 = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int levelup 	 = rs.getInt("levelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, levelup));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs	!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}
		return dtos;
	}
	// 3.��ǰ���� : public int buy(int cid, int price)
	public int buy(int cid, int price) {
		int result = FAIL;
		Connection 		  conn 	= null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER " + 
				"    SET CPOINT = CPOINT + (?*0.05), " + 
				"        CAMOUNT = CAMOUNT + ?," + 
				"        LEVELNO = (SELECT L.LEVELNO" + 
				"                    FROM CUSTOMER, LEVELS L" + 
				"                    WHERE CAMOUNT+? BETWEEN LOW AND HIGH " + 
				"                          AND CID=?)" + 
				"    WHERE CID = ?";
		try {
			conn  = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, price);
			pstmt.setInt(3, price);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();	// update�� ������ query�� result��
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 3-2.��ǰ���� �� ������ ���� ��� : public CustomerDto getCustomer(int cid)
	public CustomerDto getCustomer(int cid) {
		CustomerDto dto = null;
		Connection conn  		= null;
		PreparedStatement pstmt = null;
		ResultSet		  rs	= null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"        (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) LEVELUP" + 
				"    FROM CUSTOMER C, LEVELS L" + 
				"    WHERE C.LEVELNO=L.LEVELNO" + 
				"        AND CID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {	//�˻� ����� ���� ���(cid�� ���� ���)
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int levelup = rs.getInt("levelup");
				dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, levelup);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 4-0.levelName ���� ��� : public ArrayList<String> getLevelNames()
	public ArrayList<String> getLevelNames() {
		ArrayList<String> levelnames = new ArrayList<String>(); 
		Connection 		  conn 	= null;
		PreparedStatement pstmt = null;
		ResultSet 		  rs	= null;
		String sql = "SELECT LEVELNAME FROM LEVELS";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt= conn.prepareStatement(sql);
			rs	 = pstmt.executeQuery();
			while(rs.next()) {
				levelnames.add(rs.getString("levelName"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs	!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}
		return levelnames;
	}
	// 4. ��޺� �� ��� : public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
	 public ArrayList<CustomerDto> levelNameGetCustomers(String levelName){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet 	 rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"        (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) LEVELUP" + 
				"    FROM CUSTOMER C, LEVELS L" + 
				"    WHERE C.LEVELNO=L.LEVELNO" + 
				"        AND LEVELNAME = ?" + 
				"    ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);	// "levelName" �� �־ �׽�Ʈ���� ������ �־���.""
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid 		 = rs.getInt("cid");
				String ctel 	 = rs.getString("ctel");
				String cname 	 = rs.getString("cname");
				int cpoint 		 = rs.getInt("cpoint");
				int camount 	 = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int levelup 	 = rs.getInt("levelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, levelup));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs	!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		 return dtos;
	 }
	// 5.��ü��� : public ArrayList<CustomerDto> getCustomers()
public ArrayList<CustomerDto> getCustomers() {
	 ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet 	 rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				"        (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) LEVELUP" + 
				"    FROM CUSTOMER C, LEVELS L" + 
				"    WHERE C.LEVELNO=L.LEVELNO" + 
				"    ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				int cid 		 = rs.getInt("cid");
				String ctel 	 = rs.getString("ctel");
				String cname 	 = rs.getString("cname");
				int cpoint 		 = rs.getInt("cpoint");
				int camount 	 = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int levelup 	 = rs.getInt("levelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, levelup));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs	!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		 return dtos;
	 }
	// 6.ȸ��Ż�� : public int deleteCustomer(String ctel)
public int deleteCustomer(String ctel) {
	int result = FAIL;
	Connection 		  conn 	= null;
	PreparedStatement pstmt = null;
	String sql = "DELETE FROM CUSTOMER WHERE CTEL = ?";
	try {
		conn  = DriverManager.getConnection(url, "scott", "tiger");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ctel);
		result = pstmt.executeUpdate();	// update�� ������ query�� result��
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	} finally {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	return result;
	}
}
