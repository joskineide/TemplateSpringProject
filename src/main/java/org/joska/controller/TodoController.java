package org.joska.controller;

import lombok.RequiredArgsConstructor;
import org.joska.model.todo.TodoRequest;
import org.joska.model.todo.TodoResponse;
import org.joska.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getById(@PathVariable Long id){
        TodoResponse response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> listAll(){
        List<TodoResponse> response = service.listAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request){
        TodoResponse response = service.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoRequest request){
        TodoResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
