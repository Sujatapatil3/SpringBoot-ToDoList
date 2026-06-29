package com.one.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.one.example.entities.Todo;
import com.one.example.service.TodoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "todolist";
    }
    
   

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "addtodo";
    }

    @PostMapping("/save")
    public String saveTodo(@Valid @ModelAttribute("todo") Todo todo, 
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "addtodo";
        }
        todoService.saveTodo(todo);
        redirectAttributes.addFlashAttribute("successMessage", "Todo added successfully!");
        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("todo", todoService.getTodoById(id));
        return "edittodo";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id,
                           @Valid@ModelAttribute("todo") Todo todo,
                           BindingResult result,
                           RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "edittodo";
        }
        todo.setId(id);
        todoService.updateTodo(todo);
        redirectAttributes.addFlashAttribute("successMessage", "Todo updated successfully!");
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        todoService.deleteTodo(id);
        redirectAttributes.addFlashAttribute("successMessage", "Todo deleted successfully!");
        return "redirect:/todos";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTodoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        todoService.toggleTodoStatus(id);
        redirectAttributes.addFlashAttribute("successMessage", "Todo status updated!");
        return "redirect:/todos";
    }

    @GetMapping("/completed")
    public String getCompletedTodos(Model model) {
        model.addAttribute("todos", todoService.getCompletedTodos());
        return "todolist";
    }

    @GetMapping("/pending")
    public String getPendingTodos(Model model) {
        model.addAttribute("todos", todoService.getPendingTodos());
        return "todolist";
    }

    @GetMapping("/search")
    public String searchTodos(@RequestParam String query, Model model) {
        model.addAttribute("todos", todoService.searchTodos(query));
        return "todolist";
    }

    
}
