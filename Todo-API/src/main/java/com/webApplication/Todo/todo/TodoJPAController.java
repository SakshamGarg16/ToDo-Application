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

import com.webApplication.Todo.todo.repository.TodoRepository;

@RestController
public class TodoJPAController {

	@Autowired
	private TodoRepository todoo;

	@GetMapping("/users/{UserName}/todos")
	public List<Todo> RetriveTodos(@PathVariable String UserName) {
		return todoo.findByUsername(UserName);

	}

	@GetMapping("/users/{UserName}/todos/{id}")
	public Todo RetriveSpecificTodos(@PathVariable String UserName, @PathVariable int id) {
		return todoo.findById(id).get();

	}

	@DeleteMapping("/users/{UserName}/todos/{id}")
	public ResponseEntity<Void> DeleteSpecificTodos(@PathVariable String UserName, @PathVariable int id) {
		todoo.deleteById(id--);
		
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/{UserName}/todos/{id}")
	public Todo updateTodos(@PathVariable String UserName, @PathVariable int id, @RequestBody Todo todos) {
		todoo.save(todos);
		return todos;
	}

	@PostMapping("/users/{UserName}/todos")
	public Todo addTodos(@PathVariable String UserName, @RequestBody Todo todos) {
		todos.setUsername(UserName);
		todos.setId(null);
		return todoo.save(todos);
	}
}
