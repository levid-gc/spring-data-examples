package com.example.service;

import javax.transaction.Transactional;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.repository.AuthorRepository;

import org.springframework.stereotype.Service;

@Service
public class BookStoreService {

  private final AuthorRepository authorRepository;

  public BookStoreService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public void insertAuthorWithBooks() {

    Author author = new Author();
    author.setName("Alicia Tom");
    author.setAge(38);
    author.setGenre("Anthology");

    Book book = new Book();
    book.setIsbn("001-AT");
    book.setTitle("The book of swords");

    author.addBook(book); // use addBook() helper

    authorRepository.save(author);
  }

  @Transactional
  public void deleteBookOfAuthor() {

    Author author = authorRepository.fetchByName("Alicia Tom");
    Book book = author.getBooks().get(0);

    author.removeBook(book); // use removeBook() helper
  }

  @Transactional
  public void deleteAllBooksOfAuthor() {
    Author author = authorRepository.fetchByName("Joana Nimar");
    author.removeBooks(); // use removeBooks() helper
  }
  
}
