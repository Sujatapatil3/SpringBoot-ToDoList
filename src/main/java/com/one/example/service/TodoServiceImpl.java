package com.one.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.example.entities.Todo;
import com.one.example.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{
	   private final TodoRepository todoRepository;

	    @Autowired
	    public TodoServiceImpl(TodoRepository todoRepository) {
	        this.todoRepository = todoRepository;
	    }

	    @Override
	    public List<Todo> getAllTodos() {
	        return todoRepository.findAllByOrderByDueDateAsc();
	    }

	    @Override
	    public Todo getTodoById(Long id) {
	        return todoRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
	    }

	    @Override
	    public Todo saveTodo(Todo todo) {
	        return todoRepository.save(todo);
	    }

	    @Override
	    public Todo updateTodo(Todo todo) {
	        Todo existingTodo = getTodoById(todo.getId());
	        existingTodo.setTitle(todo.getTitle());
	        existingTodo.setDescription(todo.getDescription());
	        existingTodo.setDueDate(todo.getDueDate());
	        existingTodo.setCompleted(todo.isCompleted());
	        return todoRepository.save(existingTodo);
	    }

	    @Override
	    public void deleteTodo(Long id) {
	        Todo todo = getTodoById(id);
	        todoRepository.delete(todo);
	    }

	    @Override
	    public void toggleTodoStatus(Long id) {
	        Todo todo = getTodoById(id);
	        todo.setCompleted(!todo.isCompleted());
	        todoRepository.save(todo);
	    }

	    @Override
	    public List<Todo> getCompletedTodos() {
	        return todoRepository.findByCompleted(true);
	    }

	    @Override
	    public List<Todo> getPendingTodos() {
	        return todoRepository.findByCompleted(false);
	    }

	    @Override
	    public List<Todo> searchTodos(String query) {
	        return todoRepository.findByTitleContainingIgnoreCase(query);
	    }
}
