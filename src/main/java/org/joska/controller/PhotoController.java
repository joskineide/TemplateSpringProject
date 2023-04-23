package org.joska.controller;

import lombok.RequiredArgsConstructor;
import org.joska.model.photo.PhotoRequest;
import org.joska.model.photo.PhotoResponse;
import org.joska.service.PhotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photo")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService service;

    @GetMapping("/{id}")
    public ResponseEntity<PhotoResponse> getById(@PathVariable Long id){
        PhotoResponse response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PhotoResponse>> listAll(){
        List<PhotoResponse> response = service.listAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<PhotoResponse> create(@RequestBody PhotoRequest request){
        PhotoResponse response = service.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhotoResponse> update(@PathVariable Long id, @RequestBody PhotoRequest request){
        PhotoResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
