package com.one.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.example.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long>{
	   List<Todo> findAllByOrderByDueDateAsc();
	    List<Todo> findByCompleted(boolean completed);
	    List<Todo> findByTitleContainingIgnoreCase(String title);
}
