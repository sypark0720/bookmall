package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.BookDao;
import com.estsoft.bookmall.vo.BookVo;


public class BookDaoTest {

		public static void main(String[] args) {
			//1. insert test
			insertTest();
			
			//2. getList Test
			getListTest();
		}

		public static void getListTest(){
			BookDao bookDao = new BookDao();
			List<BookVo> list = bookDao.getList();
			
			for( BookVo vo : list ) {
				System.out.println( vo );
			}
		}
		
		public static void insertTest(){
			BookVo bookVo = new BookVo();
			BookDao bookDao = new BookDao();
			
			bookVo.setBook_no(1);
			bookVo.setTitle("Harry Potter");
			bookVo.setBook_price(10000);
			bookVo.setCategory_no(1);
			
			bookDao.insert(bookVo);
			
	}

}
