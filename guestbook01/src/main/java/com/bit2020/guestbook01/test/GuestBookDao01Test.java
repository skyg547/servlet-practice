package com.bit2020.guestbook01.test;

import java.util.List;

import com.bit2020.guestbook01.dao.Guestbook01Dao;
import com.bit2020.guestbook01.vo.GuestBook01Vo;

public class GuestBookDao01Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testInsert();
		testSelectList();
	}

	public static void testSelectList() {
		
		List<GuestBook01Vo> list = new Guestbook01Dao().findAll();
		
		if(list.size() == 2) {
			System.out.println("성공");
			
		} else {
			
			System.out.println("실패");
		}
	}
	
	public static void testInsert() {
		
		GuestBook01Vo vo = new GuestBook01Vo();
		
		vo.setName("ha");
		vo.setPassword("ha");
		vo.setMessage("h1");
		vo.setReg_date("1104");
		
		if (new Guestbook01Dao().insert(vo)) {
			 System.out.println("성공");
			
		} else {
			
			System.out.println("실패");		}
		
		
	}

}