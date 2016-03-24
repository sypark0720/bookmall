package com.estsoft.bookmall.vo;

public class BookVo {
	private long book_no;
	private String title;
	private long book_price;
	private long category_no;
	
	//G&S
	public long getBook_no() {
		return book_no;
	}
	public void setBook_no(long book_no) {
		this.book_no = book_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getBook_price() {
		return book_price;
	}
	public void setBook_price(long book_price) {
		this.book_price = book_price;
	}
	public long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(long category_no) {
		this.category_no = category_no;
	}
	@Override
	public String toString() {
		return "BookVo [book_no=" + book_no + ", title=" + title
				+ ", book_price=" + book_price + ", category_no=" + category_no
				+ "]";
	}

}
