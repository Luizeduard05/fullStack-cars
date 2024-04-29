package com.example.apicar.controllers;


import com.example.apicar.models.Carro;
import com.example.apicar.services.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/carro")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<Carro>> getAllCars() {
        return service.getAllCars();
    }

    @PostMapping
    public ResponseEntity<Carro> addCar(@Valid @RequestBody Carro carro) {
        return service.addCar(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> editCar(@Valid @PathVariable Integer id, @RequestBody Carro carro) {
        return service.editCar(id, carro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Carro>> deleteCar(@PathVariable Integer id) {
        return service.deleteCar(id);
    }
}
