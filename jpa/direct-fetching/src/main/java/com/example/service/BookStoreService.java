package com.example.service;

import java.util.Optional;

import com.example.dao.AuthorDao;
import com.example.entity.Author;
import com.example.repository.AuthorRepository;

import org.springframework.stereotype.Service;

@Service
public class BookStoreService {
  
  private final AuthorRepository authorRepository;

  private final AuthorDao authorDao;

  public BookStoreService(AuthorRepository authorRepository, AuthorDao authorDao) {
    this.authorRepository = authorRepository;
    this.authorDao = authorDao;
  }

  public void directFetching() {
    Optional<Author> resultSD = authorRepository.findById(1L);
    System.out.println("Direct fetching via Spring Data result: " + resultSD.get());

    Optional<Author> resultEM = authorDao.find(Author.class, 1L);
    System.out.println("Direct fetching via EntityManager result: " + resultEM.get());

    Optional<Author> resultHS = authorDao.findViaSession(Author.class, 1L);
    System.out.println("Direct fetching via Session result: " + resultHS.get());
  }
  
}
