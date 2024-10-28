package com.bptn.courseproject;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(false);
//        assertTrue( true );
	}

	public void testReturn() {
		Library library = new Library();
		library.addBook("Wimbledon", "Divine Eyo");
		library.borrowBook("Wimbledon"); // Borrow the book
		library.returnBook("Wimbledon"); // Return the book

		// Check if the book is not borrowed anymore
		for (BookInterface book : library.getBooks()) {
			if (book.getTitle().equals("Wimbledon")) {
				assertFalse("Book should not be borrowed after return.", book.isBorrowed());
			}
		}
	}

	public void testBorrow() {
		Library library = new Library();
		library.addBook("Wimbledon", "Divine Eyo");
		library.borrowBook("Wimbledon"); // Borrow the book

		// Check if the book is borrowed
		for (BookInterface book : library.getBooks()) {
			if (book.getTitle().equals("Wimbledon")) {
				assertTrue("Book should be marked as borrowed.", book.isBorrowed());
			}
		}
	}
}
