package com.bptn.courseproject;

// Use of Abstraction
/* Abstraction from BookInterface using "implements" - The book has to implement every law
 *  in the bookInterface or else there will be an error */

class Book implements BookInterface { // Class representing a single Book

	private String title;
	private String author;
	private boolean isBorrowed;

	public Book(String title, String author) { // Constructor for initializing a book object
		this.title = title;
		this.author = author;
		this.isBorrowed = false; // Initially, the book is not borrowed

	}

// Use of encapsulation through the use of its getter functions	
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
		if (isBorrowed()) {
			System.out.println("Book is returned.");
			this.isBorrowed = false;

		}
	}

// Use of Inheritance as I am overriding the toString function that is in the super class (object)	
	@Override
	public String toString() {
		return title + " By " + author + (isBorrowed ? "(Borrowed)" : "");
	}
}
