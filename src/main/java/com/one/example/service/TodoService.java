package com.one.example.service;

import java.util.List;

import com.one.example.entities.Todo;

public interface TodoService {
	    List<Todo> getAllTodos();
	    Todo getTodoById(Long id);
	    Todo saveTodo(Todo todo);
	    Todo updateTodo(Todo todo);
	    void deleteTodo(Long id);
	    void toggleTodoStatus(Long id);
	    List<Todo> getCompletedTodos();
	    List<Todo> getPendingTodos();
	    List<Todo> searchTodos(String query);
}
