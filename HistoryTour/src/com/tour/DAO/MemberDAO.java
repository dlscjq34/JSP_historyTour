package com.tour.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tour.VO.MemberVO;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}

	public void addMember(MemberVO vo) {
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			String sql = "insert into tourmember(id, pswd, name, birth, gender, tel, address, regdate)"
					   + "values(?, ?, ?, ?, ?, ?, ?, ?)";
			con = JDBCUtils.getConnection();
			
			st = con.prepareStatement(sql);
			st.setString(1, vo.getId());
			st.setString(2, vo.getPswd());
			st.setString(3, vo.getName());
			st.setString(4, vo.getBirth());
			st.setInt(5, vo.getGender());
			st.setString(6, vo.getTel());
			st.setString(7, vo.getAddress());
			st.setTimestamp(8, vo.getRegDate());
			
			st.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.DAOClose(st, con);
		}
	}
	
	public MemberVO searchMember(String id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		MemberVO vo = null;
		
		try {
			String sql = "select * from tourmember where id = "+id;
			con = JDBCUtils.getConnection();
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				vo.setAddress(rs.getString("address"));
				vo.setBirth(rs.getString("birth"));
				vo.setGender(rs.getInt("gender"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPswd(rs.getString("pswd"));
				vo.setRegDate(rs.getTimestamp("regDate"));
				vo.setTel(rs.getString("tel"));
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
	
	
	public int checkJoinedMember(String id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			String sql = "select count(*) from tourmember where id = "+"'"+id+"'";
			con = JDBCUtils.getConnection();
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.DAOClose(rs, st, con);
		}
		return count;
	}
}
