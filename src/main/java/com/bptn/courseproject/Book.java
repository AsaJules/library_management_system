package com.bptn.courseproject;

 class Book { // Class representing a single Book
	
	private String title;
	private String author;
	private boolean isBorrowed;
	
	public Book(String title, String author) { // Constructor for initializing a book object
		this.title = title;
		this.author = author;
		this.isBorrowed = false;   // Initially, the book is not borrowed
		
	}
	// Getter for title
	public String getTitle() {
		return title;
		
	}	
	// Getter for the author
	public String getAuthor() {
		return author;
		
	}
	// check if the book is borrowed
	public boolean isBorrowed() {
		return isBorrowed;
		
	}	
	// Mark book as borrowed
	public void borrow() {
		if (!isBorrowed) {
			this.isBorrowed = true;
		}
	}
	// Mark book as returned
	public void returnBook() {
		if(isBorrowed()) {
			this.isBorrowed = false;
			
		}
	}
	@Override
	public String toString() {
		return title + "by" + author + (isBorrowed ? "(Borrowed)" : "");
	}
}
