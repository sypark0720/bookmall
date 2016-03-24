package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.CategoryDao;
import com.estsoft.bookmall.vo.CategoryVo;


public class CategoryDaoTest {

	public static void main(String[] args) {
		//1. insert test
		insertTest();
		
		//2. getList Test
		getListTest();
	}

	public static void getListTest(){
		CategoryDao categoryDao = new CategoryDao();
		List<CategoryVo> list = categoryDao.getList();
		
		for( CategoryVo vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void insertTest(){
		CategoryVo categoryVo = new CategoryVo();
		CategoryDao categoryDao = new CategoryDao();
		
		categoryVo.setCategory_no(1);
		categoryVo.setCategory_name("novel");
		categoryDao.insert(categoryVo);
		
}
	
}
