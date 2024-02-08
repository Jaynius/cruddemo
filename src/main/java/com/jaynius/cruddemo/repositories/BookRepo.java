package com.jaynius.cruddemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaynius.cruddemo.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long>{

}
