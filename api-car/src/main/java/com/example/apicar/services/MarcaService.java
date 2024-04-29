package com.example.apicar.services;

import com.example.apicar.models.Marca;
import com.example.apicar.repositories.MarcaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MarcaService {

    @Autowired
    private MarcaRepository repository;

    public ResponseEntity<List<Marca>> getAllMarca() {
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Marca> addMarca(Marca marca) {
        return new ResponseEntity<>(repository.save(marca), HttpStatus.CREATED);
    }

    public ResponseEntity<Marca> editMarca(Integer id, Marca marca) {
        if (repository.existsById(id)) {
            Marca marcaAtualizada = new Marca();
            marcaAtualizada.setId(id);
            marcaAtualizada.setNome(marca.getNome());

            return new ResponseEntity<>(repository.save(marcaAtualizada), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Optional<Marca>> deleteMarca(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
