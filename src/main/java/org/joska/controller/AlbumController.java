package org.joska.controller;

import lombok.RequiredArgsConstructor;
import org.joska.model.album.AlbumRequest;
import org.joska.model.album.AlbumResponse;
import org.joska.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService service;

    @GetMapping("/{id}")
    public ResponseEntity<AlbumResponse> getById(@PathVariable Long id){
        AlbumResponse response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AlbumResponse>> listAll(){
        List<AlbumResponse> response = service.listAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<AlbumResponse> create(@RequestBody AlbumRequest request){
        AlbumResponse response = service.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumResponse> update(@PathVariable Long id, @RequestBody AlbumRequest request){
        AlbumResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
