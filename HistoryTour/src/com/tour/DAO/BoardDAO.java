package com.tour.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tour.VO.BoardVO;

public class BoardDAO {
	private static BoardDAO dao = new BoardDAO();
	public static BoardDAO getInstance() {
		return dao;
	}
	
	public void addContent(BoardVO vo) {	
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			String sql = "insert into tourboard"
					+ "(title, "
					+ "writer, "
					+ "content, "
					+ "wrtdate, "
					+ "hit, "
					+ "fileName, "
					+ "replyRef, "
					+ "replyLevel, "
					+ "replySeq)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			con = JDBCUtils.getConnection();
			
			System.out.println(sql);
			
			st = con.prepareStatement(sql);
			st.setString(1, vo.getTitle());
			st.setString(2, vo.getWriter());
			st.setString(3, vo.getContent());
			st.setTimestamp(4, vo.getWrtDate());
			st.setInt(5, vo.getHit());
			st.setString(6, vo.getFilename());
			st.setInt(7, vo.getReplyRef());
			st.setInt(8, vo.getReplyLevel());
			st.setInt(9, vo.getReplySeq());
			
			st.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.DAOClose(st, con);
		}
	}
	
	// 전체, 검색 겸용
	public List<BoardVO> getList(int startPage, int pageSize, String field, String word) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<>();
		try {
			String sql = "select * from tourboard "
						+ "where "+field+" like "+"'%"+word+"%' "
						+ "order by replyRef desc, replySeq asc limit ?, ? ";
			System.out.println(sql);
			con = JDBCUtils.getConnection();
			
			st = con.prepareStatement(sql);
			st.setInt(1, startPage);	// 쿼리 결과 인덱스가 0부터 시작하므로
			st.setInt(2, pageSize);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setWrtDate(rs.getTimestamp("wrtDate"));
				vo.setHit(rs.getInt("hit"));
				vo.setReplyLevel(rs.getInt("ReplyLevel"));
				vo.setReplyRef(rs.getInt("ReplyRef"));
				vo.setReplySeq(rs.getInt("ReplySeq"));
				
				list.add(vo);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.DAOClose(rs, st, con);
		}
		return list;
	}

	public BoardVO getContent(String num) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		try {
			String sql = "select * from tourboard where num="+num;
			con = JDBCUtils.getConnection();
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			if(rs.next()) {
				vo = BoardVO.getInstance();
				vo.setNum(rs.getInt("num"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWrtDate(rs.getTimestamp("wrtDate"));
				vo.setHit(rs.getInt("hit"));
				vo.setFilename(rs.getString("filename"));
				vo.setReplyLevel(rs.getInt("ReplyLevel"));
				vo.setReplyRef(rs.getInt("ReplyRef"));
				vo.setReplySeq(rs.getInt("ReplySeq"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.DAOClose(rs, st, con);
		}
		return vo;
	}

	public int getCount(String field, String word) {	// 전체, 검색 겸용

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(*) from tourboard where "+field+" like "+"'%"+word+"%' ";
			con = JDBCUtils.getConnection();
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			if(rs.next())
				count = rs.getInt(1);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.DAOClose(rs, st, con);
		}
		return count;
	}

	public void delete(int num) {	
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			String sql = "delete from tourboard where num = "+num; 
			
			con = JDBCUtils.getConnection();
			st =  con.prepareStatement(sql);
			st.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.DAOClose(st, con);
		}
	}

	public void increaseHit(String num) {

		Connection con = null;
		PreparedStatement st = null;
		
		try {
			String sql = "update tourboard set hit = hit + 1 where num = "+num; 
			
			con = JDBCUtils.getConnection();
			st =  con.prepareStatement(sql);
			st.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.DAOClose(st, con);
		}
	}
	
	public void updateContent(BoardVO vo) {

		Connection con = null;
		PreparedStatement st = null;
		
		try {
			String sql = "update tourboard set "
					+ " content = ?, title = ?, filename = ?" 
					+ " where num = ?"; 
			
			con = JDBCUtils.getConnection();
			
			st =  con.prepareStatement(sql);
			st.setString(1, vo.getContent());
			st.setString(2, vo.getTitle());
			st.setString(3, vo.getFilename());
			st.setInt(4, vo.getNum());
			
			st.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.DAOClose(st, con);
		}
	}

	public int getReplyRef() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int reRef = 0;
		try {
			String sql = "select max(num)+1 from tourboard";
			con = JDBCUtils.getConnection();
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			if(rs.next())
				reRef = rs.getInt(1);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.DAOClose(rs, st, con);
		}
		return reRef;
		
	}

	public void defineReplySeq(int replyRef, int replySeq) {
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			String sql = "update tourboard set replySeq = replySeq + 1"
						+ " where replyRef = "+replyRef
						+ " and replySeq > "+replySeq; 
			
			con = JDBCUtils.getConnection();
			st =  con.prepareStatement(sql);
			System.out.println("seq updated : "+st.executeUpdate());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.DAOClose(st, con);
		}
		
	}
}
