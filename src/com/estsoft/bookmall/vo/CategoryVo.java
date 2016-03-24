package com.estsoft.bookmall.vo;

public class CategoryVo {
	private long category_no;
	private String category_name;
	
	//getter&setter
	public long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(long category_no) {
		this.category_no = category_no;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	@Override
	public String toString() {
		return "CategoryVo [category_no=" + category_no + ", category_name="
				+ category_name + "]";
	}

}
