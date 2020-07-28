package com.bit2020.guestbook01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2020.guestbook01.vo.GuestBook01Vo;

public class Guestbook01Dao {

	public boolean insert(GuestBook01Vo vo) {
		
		boolean result =false;
		
		Connection connection =null;
		Statement stmt = null;
			// 1. jdbc 라이브러리 로딩 Driver loading -> mariaDB
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3307/webdb?characterEncoding=utf8";
			//2. db 연결하기
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			System.out.println("연결 성공");
			//3. statement 객체 생성
			
			stmt = connection.createStatement();
			// sql 문 작성
			String sql = "Insert into guestbook values(null,'"+vo.getName()+"','"+vo.getPassword()+"', '"+vo.getMessage()+"', '"+vo.getReg_date()+"')";
			int count = stmt.executeUpdate(sql);
		
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
				if(stmt != null) {
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

	public List<GuestBook01Vo> findAll() {
		// TODO Auto-generated method stub

		List<GuestBook01Vo> result = new ArrayList<>();

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
			String sql = "select no, name, password, message, reg_date from guestbook";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String message = rs.getString(4);
				String reg_date = rs.getString(4);

				GuestBook01Vo vo = new GuestBook01Vo();
				
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
