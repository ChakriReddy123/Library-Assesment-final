package com.libraryexample;
import java.util.List;
import java.util.*;

public class LibraryHack {

	public static void main(String[] args) {

		 List<Book> books=new ArrayList<>();
		 books.add(new Book(101, "ironman", "marvel", 300f));
	     books.add(new Book(102, "superman", "DC", 150f));
	     books.add(new Book(103, "captain America", "Avengers", 450f));
	     books.add(new Book(104, "groot", "marvel", 250f));
	     books.add(new Book(105, "flash", "DC", 500f));
	     
	     LibraryService service =new LibraryService("Pusthak","Hyderabad",books);
	     Scanner sc=new Scanner(System.in);
	     System.out.println("Enter user type (admin/customer): ");
	        String userType = sc.nextLine().toLowerCase();

	        if (userType.equals("admin")) {
	            while (true) {
	                System.out.println("1. View all books");
	                System.out.println("2. Add new book");
	                System.out.println("3. Delete book");
	                System.out.println("4. Get the costly book based on publisher");
	                System.out.println("5. Exit");
	                int choice = Integer.parseInt(sc.nextLine());

	                switch (choice) {
	                    case 1:
	                        System.out.println("Books in the library:");
	                        service.getBooks().stream().forEach((e)->{ System.out.println(e);});
	                        break;
	                    case 2:
	                        System.out.println("Enter ISBN, Author, Publisher, Price:");
	                        int isbn = Integer.parseInt(sc.nextLine());
	                        String author = sc.nextLine();
	                        String publisher = sc.nextLine();
	                        float price = Float.parseFloat(sc.nextLine());
	                        service.addBook(new Book(isbn, author, publisher, price));
	                        break;
	                    case 3:
	                        System.out.println("Enter ISBN of the book to delete:");
	                        int deleteIsbn = Integer.parseInt(sc.nextLine());
	                        service.removeBook(deleteIsbn);
	                        break;
	                    case 4:
	                        System.out.println("Enter publisher name:");
	                        String publisherName = sc.nextLine();
	                        float maxPrice = service.findMaxPrice(publisherName);
	                        if(maxPrice!=0.0f) {
	                        	System.out.println("The max price is "+maxPrice);
	                        }
	                        else {
	                        System.out.println("No books found for publisher: " + publisherName);
	                        }
	                        break;
	                    case 5:
	                        return;
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            }
	        } else if ("customer".equals(userType)) {
	            while (true) {
	                System.out.println("1. View all books");
	                System.out.println("2. Get the costly book based on publisher");
	                System.out.println("3. Exit");
	                int choice = Integer.parseInt(sc.nextLine());

	                switch (choice) {
	                    case 1:
	                        System.out.println("Books in the library:");
	                        service.getBooks().stream().forEach((e)->{System.out.println(e);});
	                        break;
	                    case 2:
	                        System.out.println("Enter publisher name:");
	                        String publisherName = sc.nextLine();
	                        float maxPrice = service.findMaxPrice(publisherName);
	                        if(maxPrice!=0.0f) {
	                        	System.out.println("The max price is "+maxPrice);
	                        }
	                        else {
	                        System.out.println("No books found for publisher: " + publisherName);
	                        }
	                        break;
	                    case 3:
	                        return;
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            }
	        } else {
	            System.out.println("Invalid user type.");
	        }
	     
		
	}

}
