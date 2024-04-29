package com.example.apicar.controllers;

import com.example.apicar.models.Marca;
import com.example.apicar.services.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/marca")
public class MarcaController {

    @Autowired
    private MarcaService service;

    @GetMapping
    public ResponseEntity<List<Marca>> getAllMarca() {
        return service.getAllMarca();
    }

    @PostMapping
    public ResponseEntity<Marca> addMarca(@Valid @RequestBody Marca marca) {
        return service.addMarca(marca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> editMarca(@Valid @PathVariable Integer id, @RequestBody Marca marca) {
        return service.editMarca(id, marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Marca>> deleteMarca(@PathVariable Integer id) {
        return service.deleteMarca(id);
    }

}
