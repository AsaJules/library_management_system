package com.bptn.courseproject;

import java.util.ArrayList;
import java.util.List;

class Library { // class to manage library (books list and operations)

// Implementation of Polymorphism as book object can be used in BookInterface Class and Book Class	
	private List<BookInterface> books;

	// constructor initializes the list of books
	public Library() {
		books = new ArrayList<BookInterface>();

	}

	// view all available books in the library
	public void viewBooks() {
		if (books.isEmpty()) {
			System.out.println("No books in the library.");
		} else {
			for (BookInterface book : books) {
				System.out.println(book);
			}
		}
	}

	// Add a new book to the library
	public void addBook(String title, String author) {
		books.add(new Book(title, author));
		System.out.println("Book added: " + title + "," + author);

	}

	// Search for books by title or author
	public void searchBook(String keyword) {
		boolean found = false;
		for (BookInterface book : books) {
			if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
					|| book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
				System.out.println(book);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No books found with the keyword: " + keyword);
		}
	}

	// Borrow a book by title
	public void borrowBook(String title) {
		for (BookInterface book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				if (!book.isBorrowed()) {
					book.borrow();
					System.out.println("You borrowed: " + title);
				} else {
					System.out.println("Book is already borrowed.");
				}
				return;
			}
		}
		System.out.println("Book not found.");
	}

	// Return a borrowed book by title
	public void returnBook(String title) {
		for (BookInterface book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				if (book.isBorrowed()) { // Check if the book is borrowed
					book.returnBook();
					System.out.println("You returned: " + title);
				} else {
					System.out.println("This book was not borrowed.");
				}
				return;
			}
		}
		System.out.println("Book not found.");
	}

	// Get the list of books needed for saving data
	public List<BookInterface> getBooks() {
		return books;

	}

	// Set the books list (needed for loading data)
	public void setBooks(List<BookInterface> books) {
		this.books = books;
	}
}
