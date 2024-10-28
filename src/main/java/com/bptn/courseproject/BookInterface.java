package com.bptn.courseproject;

public interface BookInterface {
	public void borrow();

	public void returnBook();

	public String getTitle();

	public String getAuthor();

	public boolean isBorrowed();

}
