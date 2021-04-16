package com.example;

import com.example.service.BookStoreService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private final BookStoreService service;

	public Application(BookStoreService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			System.out.println("\nInsert author with books  ...");
			service.insertAuthorWithBooks();

			System.out.println("\nDelete a book of an author...");
			service.deleteBookOfAuthor();
			
			System.out.println("\nDelete all book of an author...");
			service.deleteAllBooksOfAuthor();
		};
	}

}
