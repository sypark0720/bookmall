package com.estsoft.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.estsoft.bookmall.vo.BookVo;


public class BookDao {
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//1. 드라이버 로드
			Class.forName( "com.mysql.jdbc.Driver" );

			//2. Connection 얻기
			String url = "jdbc:mysql://localhost/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
			
		} catch (ClassNotFoundException ex) {
			System.out.println( "드라이버를 찾을 수 없습니다:" + ex );
		} 
		
		return conn;
	}
	
	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<BookVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql = "select * from book";
			rs = stmt.executeQuery( sql );
			
			// 5. 데이터 받아오기 
			while( rs.next() ) {
				Long book_no = rs.getLong( 1 );
				String title = rs.getString( 2 );
				Long book_price = rs.getLong( 3 );
				Long category_no = rs.getLong( 4 );
				
				BookVo bookVo = new BookVo();
				bookVo.setBook_no(book_no);
				bookVo.setTitle(title);
				bookVo.setBook_price(book_price);
				bookVo.setCategory_no(category_no);
								
				list.add( bookVo );
			}
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류:" + ex );
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( stmt != null ) {
					stmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}
		return list;
	}
	
	public void insert( BookVo bookVo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			//3. Statement 준비
			String sql = "insert into book values( ? , ? , ? , ? )";
			pstmt = conn.prepareStatement(sql);
			
			//4. bind
			pstmt.setLong( 1, bookVo.getBook_no() );
			pstmt.setString( 2, bookVo.getTitle());
			pstmt.setLong( 3, bookVo.getBook_price() );
			pstmt.setLong(4, bookVo.getCategory_no() );
			
			//5. SQL 실행
			pstmt.executeUpdate();
			
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류:" + ex );
		} finally {
			//6. 자원정리(clean-up)
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}		
	}

}
