package com.bptn.courseproject;

import java.util.Scanner;

public class LibraryApp { // Main application class to interact with the user

	public static void main(String[] args) {
		// One object can be used in the family of more than two classes
		Library library; // Library instance to manage books
		FileHandler fileHandler; // FileHandler instance to manage file operations
		Scanner scanner; // Scanner for user input

		// Create a scanner object for user input
		scanner = new Scanner(System.in);

		// Create the library and file handler objects
		library = new Library();
		fileHandler = new FileHandler();

		// Load any saved library data from the file
		library.setBooks(fileHandler.loadLibraryData());

		// loop to present menu options until they choose to exit
		boolean exit = false;

		while (!exit) {
			// Display the main menu
			System.out.println("\nLibrary Management System");
			System.out.println("1. View Books");
			System.out.println("2. Add Book");
			System.out.println("3. Search Book");
			System.out.println("4. Borrow Book");
			System.out.println("5. Return Book");
			System.out.println("6. Exit");
			System.out.println("Choose an option");

			// Ask for user's choice and process it
			System.out.print("Enter your choice: ");

			// Read the user's choice using scanner.next
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume the left over newline character

			// Handle user's choice
			switch (choice) {

			case 1: // View all books
				library.viewBooks();
				break;
			case 2: // Add a new book
				System.out.println("Choose the Name of the Book");
				String name = scanner.nextLine();

				System.out.println("Choose the Author of the Book");
				String author = scanner.nextLine();
				library.addBook(name, author);
				break;
			case 3: // Search for a book
				System.out.println("Enter the title or author to search:");
				String choiceStr = scanner.nextLine();
				library.searchBook(choiceStr);
				break;
			case 4: // Borrow a book
				System.out.println("Enter the title to borrow:");
				String choiceBorrow = scanner.nextLine();
				library.borrowBook(choiceBorrow);
				break;
			case 5: // Return a book
				System.out.println("Enter the title to return:");
				String choiceReturn = scanner.nextLine();
				library.returnBook(choiceReturn);
				break;
			case 6: // Exit the system
				System.out.println("Exiting the system. Goodbye!");
				exit = true;
				break;
			default: // Invalid input
				System.out.println("Invalid option. Please try again.");
			}

		}

		scanner.close(); // Close the scanner to prevent resource leaks

	}
}
