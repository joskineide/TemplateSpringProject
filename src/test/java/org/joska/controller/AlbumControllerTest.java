package org.joska.controller;

import org.joska.service.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AlbumController.class)
public class AlbumControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AlbumService service;

    private Long id;

    @BeforeEach
    public void init(){
        id = 1L;
    }


//    @Test
//    public void shouldGetById() throws Exception{
//        mockMvc.perform(get("/album/1")
//                .accept(MediaType.ALL)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        verify(service).getById(id);
//    }


//      @GetMapping("/{id}")
//    public ResponseEntity<AlbumResponse> getById(@PathVariable Long id){
//        AlbumResponse response = service.getById(id);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<AlbumResponse>> listAll(){
//        List<AlbumResponse> response = service.listAll();
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping
//    public ResponseEntity<AlbumResponse> create(@RequestBody AlbumRequest request){
//        AlbumResponse response = service.create(request);
//        return ResponseEntity.ok(response);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<AlbumResponse> update(@PathVariable Long id, @RequestBody AlbumRequest request){
//        AlbumResponse response = service.update(id, request);
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
