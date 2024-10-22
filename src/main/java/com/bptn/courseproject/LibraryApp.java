package com.bptn.courseproject;

import java.util.Scanner;

public class LibraryApp { // Main application class to interact with the user

	public static void main(String[] args) {
		
		private Library library; // Library instance to manage books
		private FileHandler fileHandler; // FileHandler instance to manage file operations
		private Scanner scanner; // Scanner for user input
		
		// Create a scanner object for user input
		Scanner scanner = new Scanner(System.in);

		// Create the library and file handler objects
		Library library = new Library();
		FileHandler fileHandler = new FileHandler();
		
		// Load any saved library data from the file
		library.setBooks(fileHandler.loadLibraryData());
		
		// loop to present menu options until they choose to exit
		boolean exit = false;
		
		while(!exit) {
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
			
			// Read the user's choic using scanner.next
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume the left over newline character
			
			// Handle user's choice
			switch(choice) {
			case 1: // View all books
				library.viewBooks();
				break;
			case 2: // Add a new book
				addNewBook(scanner, library);
				break;
			case 3: // Search for a book
				searchBook(scanner, library);
				break;
			case 4: // Borrow a book
				borrowBook(scanner, library);
				break;
			case 5: // Return a book
				returnBook(scanner, library);
				break;
			case 6: // Exit the system
				System.out.println("Exiting the system. Goodbye!");
				break;	
			default: // Invalid input
				System.out.println("Invalid option. Please try again.");
			}
			
		} while (choice!= 6); // Loop until the user chooses to exit
		
		scanner.close(); // Close the scanner to prevent resource leaks
			
		}

	private static void addNewBook(Scanner scanner, Library library) {
		// TODO Auto-generated method stub
		
	}
		

	}


