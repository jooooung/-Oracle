package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.BoardDto;

public class BoardDao {
	private static final int SUCCESS = 1;
	private static final int FAIL = 0;
	private DataSource ds;
	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
//  1. 글목록
	public ArrayList<BoardDto> list(int startRow, int endRow){
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT *" + 
				"    FROM (SELECT ROWNUM RN, A.* FROM" + 
				"            (SELECT * FROM MVC_BOARD2 ORDER BY BGROUP DESC, BSTEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    bid 	 	= rs.getInt("bid");
				String bname 	= rs.getString("bname");
				String btitle   = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int    bhit 	= rs.getInt("bhit");
				int    bgroup   = rs.getInt("bgroup");
				int    bstep 	= rs.getInt("bstep");
				int    bindent  = rs.getInt("bindent");
				String bip 		= rs.getString("bip");
				dtos.add(new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "실패");
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
//	2. 글개수
	public int getBoardTotalCnt() {
		int totCnt = 0;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM MVC_BOARD2";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt(1);	// 1번째 열을 int로 가져오기
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}
//	3. 글쓰기(원글)
	public int write(String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD2 (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)" + 
				"    VALUES (MVC_BOARD_SEQ2.NEXTVAL, ?, ?, ?, MVC_BOARD_SEQ2.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			pstmt.executeUpdate();
			result = SUCCESS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
//	4. bID로 조회수 올리기
	private void hitup(int bid) {
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD2 SET BHIT = BHIT + 1 WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
//	5. 글 상세보기(조회수 올리기)
	public BoardDto content(int bid) {
		BoardDto dto = null;
		hitup(bid);
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MVC_BOARD2 WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String bname 	= rs.getString("bname");
				String btitle   = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int    bhit 	= rs.getInt("bhit");
				int    bgroup   = rs.getInt("bgroup");
				int    bstep 	= rs.getInt("bstep");
				int    bindent  = rs.getInt("bindent");
				String bip 		= rs.getString("bip");
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
//	5. 글수정VIEW, 답변글VIEW(bID로 DTO가져오기)
	public BoardDto modifyView_replyView(int bid) {
		BoardDto dto = null;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MVC_BOARD2 WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt.setInt(1, bid);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String bname 	= rs.getString("bname");
				String btitle   = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int    bhit 	= rs.getInt("bhit");
				int    bgroup   = rs.getInt("bgroup");
				int    bstep 	= rs.getInt("bstep");
				int    bindent  = rs.getInt("bindent");
				String bip 		= rs.getString("bip");
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
//	6. 글 수정하기
	public int modify(BoardDto dto) {
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD2 " + 
				"    SET BNAME=?," + 
				"        BTITLE=?," + 
				"        BCONTENT=?," + 
				"        BIP=?" + 
				"    WHERE BID=?";
	try {
		conn = ds.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getBname());
		pstmt.setString(2, dto.getBtitle());
		pstmt.setString(3, dto.getBcontent());
		pstmt.setString(4, dto.getBip());
		pstmt.setInt(5, dto.getBid());
		pstmt.executeUpdate();
		result = SUCCESS;
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
//	7. 글삭제
	public int delete(int bid) {
		int result = FAIL;
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MVC_BOARD2 WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("글삭제 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "글삭제 실패");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
//	8. 답변글 저장전 작업(답변이 있다면 그 답변의 STEP을 +1)
	private void preReplyStep(int bgroup, int bstep) {
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD2 SET bSTEP = bSTEP + 1" + 
				"    WHERE BGROUP = ? AND BSTEP > ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "preReplyStep에서 오류");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
//	9. 답변글 쓰기   : 답변 글쓴이 : bname, btitle, bcontent
	// 시스템적으로 : bip
	// 원글             : bgroup, bstep,bindent
	public int reply(String bname, String btitle, String bcontent, 
					 String bip, int bgroup, int bstep, int bindent) {
		int result = FAIL;
		preReplyStep(bgroup, bstep);
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD2 (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)" + 
				"    VALUES (MVC_BOARD_SEQ2.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, bgroup);
			pstmt.setInt(5, bstep + 1);
			pstmt.setInt(6, bindent + 1);
			pstmt.setString(7, bip);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("답글 쓰기 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "답글쓰기 실패");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
