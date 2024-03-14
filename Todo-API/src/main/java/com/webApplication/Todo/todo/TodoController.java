package com.webApplication.Todo.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/users/{UserName}/todos")
	public List<Todo> RetriveTodos(@PathVariable String UserName) {
		return todoService.findByUsername(UserName);

	}

	@GetMapping("/users/{UserName}/todos/{id}")
	public Todo RetriveSpecificTodos(@PathVariable String UserName, @PathVariable int id) {
		return todoService.findById(id);

	}

	@DeleteMapping("/users/{UserName}/todos/{id}")
	public ResponseEntity<Void> DeleteSpecificTodos(@PathVariable String UserName, @PathVariable int id) {
		todoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/{UserName}/todos/{id}")
	public Todo updateTodos(@PathVariable String UserName, @PathVariable int id, @RequestBody Todo todos) {
		todoService.updateTodo(todos);
		return todos;
	}

	@PostMapping("/users/{UserName}/todos")
	public Todo addTodos(@PathVariable String UserName, @RequestBody Todo todos) {
		todos.setUsername(UserName);
		Todo created = todoService.addTodo(todos);
		return created;
	}
}
