package com.tour.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCUtils {

	
	
	public static Connection  getConnection() throws Exception {
		
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/jspdb");
		Connection con = ds.getConnection();
		
		return con;
	}
	
	
	
	
	
	public static void DAOClose(PreparedStatement st, Connection con) {
		 DAOClose(null, st, con);
	}
	
	
	public static void DAOClose(ResultSet rs, PreparedStatement st, Connection con){
		try {
			if(rs != null)
				rs.close();
			if(st != null)
				st.close();
			if(con != null)
				con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
