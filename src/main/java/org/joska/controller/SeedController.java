package org.joska.controller;

import lombok.RequiredArgsConstructor;
import org.joska.model.user.domain.UserDomain;
import org.joska.service.SeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seed")
@RequiredArgsConstructor
public class SeedController {
    private final SeedService service;

    @GetMapping
    public ResponseEntity<List<UserDomain>> seedFromPlaceholder(){
        List<UserDomain> response = service.seedFromPlaceholder();
        return ResponseEntity.ok(response);
    }
}
