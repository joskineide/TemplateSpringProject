package org.joska.controller;

import lombok.RequiredArgsConstructor;
import org.joska.model.comment.CommentRequest;
import org.joska.model.comment.CommentResponse;
import org.joska.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> getById(@PathVariable Long id){
        CommentResponse response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponse>> listAll(){
        List<CommentResponse> response = service.listAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CommentResponse> create(@RequestBody CommentRequest request){
        CommentResponse response = service.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponse> update(@PathVariable Long id, @RequestBody CommentRequest request){
        CommentResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
