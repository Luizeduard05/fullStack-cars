package com.example.apicar.services;

import com.example.apicar.models.Cor;
import com.example.apicar.repositories.CorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CorService {

    @Autowired
    private CorRepository repository;

    public ResponseEntity<List<Cor>> getAllColor() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Cor> addCor(Cor cor) {
        return new ResponseEntity<>(repository.save(cor), HttpStatus.CREATED);
    }

    public ResponseEntity<Cor> editColor(Integer id, Cor cor) {
        if (repository.existsById(id)) {
            Cor corAtualizada = new Cor();
            corAtualizada.setId(id);
            corAtualizada.setCor(cor.getCor());
            corAtualizada.setCarros(cor.getCarros());

            return new ResponseEntity<>(repository.save(corAtualizada), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Optional<Cor>> deleteCor(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
