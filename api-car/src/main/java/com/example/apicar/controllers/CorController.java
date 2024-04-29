package com.example.apicar.controllers;

import com.example.apicar.models.Cor;
import com.example.apicar.services.CorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cor")
public class CorController {

    @Autowired
    private CorService service;

    @GetMapping
    public ResponseEntity<List<Cor>> getAllColor() {
        return service.getAllColor();
    }

    @PostMapping
    public ResponseEntity<Cor> addCor(@Valid @RequestBody Cor cor) {
        return service.addCor(cor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cor> editColor(@Valid @PathVariable Integer id, @RequestBody Cor cor) {
        return service.editColor(id, cor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Cor>> deleteCor(@PathVariable Integer id) {
        return service.deleteCor(id);
    }

}
