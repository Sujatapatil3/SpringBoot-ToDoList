package com.one.example.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotBlank(message = "Title is required")
	    @Size(max = 100, message = "Title must be less than 100 characters")
	    private String title;
	    
	    @Size(max = 500, message = "Description must be less than 500 characters")
	    private String description;
	    
	    @FutureOrPresent(message = "Due date must be today or in the future")
	    private LocalDate dueDate;
	    
	    private boolean completed;
	    
	    // Constructors
	    public Todo() {}
	    
	    public Todo(String title, String description, LocalDate dueDate) {
	        this.title = title;
	        this.description = description;
	        this.dueDate = dueDate;
	        this.completed = false;
	    }
	    
	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }
	    public String getTitle() { return title; }
	    public void setTitle(String title) { this.title = title; }
	    public String getDescription() { return description; }
	    public void setDescription(String description) { this.description = description; }
	    public LocalDate getDueDate() { return dueDate; }
	    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
	    public boolean isCompleted() { return completed; }
	    public void setCompleted(boolean completed) { this.completed = completed; 
	    }
	}