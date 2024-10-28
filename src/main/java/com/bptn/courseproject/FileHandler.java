package com.bptn.courseproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileHandler { // Class for file handling (saving and loading books)

	private static final String FILE_NAME = "library.txt";

	// Save the current state of the library to a file
	public void saveLibraryData(List<Book> books) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
			for (BookInterface book : books) {
				writer.println(book.getTitle() + "," + book.getAuthor() + "," + book.isBorrowed());
			}
			System.out.println("Library data saved.");
		} catch (IOException e) {
			System.out.println("Error saving library data.");
		}
	}

	// Load the library data from file
	public List<BookInterface> loadLibraryData() {
		List<BookInterface> books = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length >= 3) {
					Book book = new Book(parts[0], parts[1]);
					if (Boolean.parseBoolean(parts[2])) {
						book.borrow(); // If the book was borrowed, mark it as borrowed
					}
					books.add(book);
				} else {
					System.out.println("Invalid line format in library data file.");
				}
			}
			System.out.println("Library data loaded.");
		} catch (IOException e) {
			System.out.println("No previous data found. Starting with an empty library.");
		}
		return books;
	}
}
