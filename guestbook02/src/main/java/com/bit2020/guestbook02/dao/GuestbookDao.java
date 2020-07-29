package com.bit2020.guestbook02.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2020.guestbook02.vo.GuestbookVo;

public class GuestbookDao {

	public boolean insert(GuestbookVo vo) {

		boolean result = false;

		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt= null;
		// 1. jdbc 라이브러리 로딩 Driver loading -> mariaDB
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3307/webdb?characterEncoding=utf8";
			// 2. db 연결하기
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			System.out.println("연결 성공");
			// 3. statement 객체 생성

			stmt = connection.createStatement();
			// sql 문준비
			String sql = "Insert into guestbook values(null,?,?,?,now())";
			
			pstmt = connection.prepareStatement(sql);
			
			//4. 바인딩
			pstmt.setString(0, vo.getName());
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getMessage());
			
			//5. sql 실행
			
			int count = pstmt.executeUpdate();

			result = (count == 1);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<GuestbookVo> findAll() {
		// TODO Auto-generated method stub

		List<GuestbookVo> result = new ArrayList<>();

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		// 1. jdbc 라이브러리 로딩 Driver loading -> mariaDB
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3307/webdb?characterEncoding=utf8";
			// 2. db 연결하기
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			System.out.println("연결 성공");
			// 3. statement 객체 생성

			stmt = connection.createStatement();
			// sql 문 작성
			String sql = "select no, name, message, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from guestbook order by reg_date desc";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String message = rs.getString(4);
				String reg_date = rs.getString(5);

				GuestbookVo vo = new GuestbookVo();

				vo.setNo(no);
				vo.setName(name);
				vo.setPassword(password);
				vo.setMessage(message);
				vo.setReg_date(reg_date);

				result.add(vo);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}
}
