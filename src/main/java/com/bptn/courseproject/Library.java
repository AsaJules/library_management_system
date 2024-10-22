package com.bptn.courseproject;

import java.util.ArrayList;
import java.util.List;

class Library {  // class to manage library (books list and operations)
	 private List<Book> books;
	 
	 // constructor initializes the list of books
	 public Library() {
		 books = new ArrayList<>();
		 
	 }
	 
	// view all available books in the library
	 public void viewBooks() {
		 if (books.isEmpty()) {
			 System.out.println("No books in the library.");
		 } else {
			 for (Book book : books) {
				 System.out.println(book);
			 }
		 }
	 }
	 // Add a new book to the library
	 public void addBook(String title, String author) {
		 books.add(new Book(title, author));
		 System.out.println("Book added: " + title);
		 
	 }
	 // Search for books by title or author
	 public void searchBook(String keyword) {
		 boolean found = false;
		 for (Book book : books) {
			 if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
				book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
				 System.out.println(book);
				 found = true;
			 }
		 }
		 if (!found) {
			 System.out.println("No books foud with the keyword: " + keyword);
		 }
	 }
	 
	 // Borrow a book by title
	 public void borrowBook(String title) {
		 for (Book book : books) {
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
		 for (Book book : books) {
			 if (book.getTitle().equalsIgnoreCase(title)) {
				 if (!book.isBorrowed()) {
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
	 public List<Book> getBooks() {
		 return books;
		 
	 }
	 
	 // Set the books list (needed for loading data)
	 public void setBooks(List<Book> books) {
		 this.books = books;
	 }
}
