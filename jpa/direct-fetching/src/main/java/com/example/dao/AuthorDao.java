package com.example.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.entity.Author;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class AuthorDao implements GenericDao<Author, Long> {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Optional<Author> find(Class<Author> clazz, Long id) {
    if (id == null) {
      throw new IllegalArgumentException("ID can not be null");
    }

    return Optional.ofNullable(entityManager.find(clazz, id));
  }

  @Override
  public Optional<Author> findViaSession(Class<Author> clazz, Long id) {
    if (id == null) {
      throw new IllegalArgumentException("ID can not be null");
    }

    Session session = entityManager.unwrap(Session.class);
    return Optional.ofNullable(session.get(clazz, id));
  }
  
}
